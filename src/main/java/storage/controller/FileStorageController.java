package storage.controller;

import storage.http.SessionContext;
import storage.http.HttpStatusCode;
import storage.http.container.HttpService;
import storage.http.container.RequestWrapper;
import storage.http.container.ResponseWrapper;
import storage.model.File;
import storage.service.FileStorageService;

import java.io.InputStream;

public class FileStorageController {

    private FileStorageService fileStorageService;

    public FileStorageController(FileStorageService fileStorageService, HttpService http) {
        this.fileStorageService = fileStorageService;
        http.post("/drive/files/", this::uploadFile);
        http.put("/drive/files/:fileId", this::updateFile);
        http.delete("/drive/files/:fileId", this::deleteFile);
        http.get("/drive/files/:fileName", this::downloadFile);
    }

    private ResponseWrapper<String> uploadFile(RequestWrapper request, ResponseWrapper<String> response) {
        SessionContext sessionContext = (SessionContext) request.getAttribute("context");
        String userId = sessionContext.getUserId();
        InputStream body = request.getBodyAsStream();
        fileStorageService.uploadFile(userId, body);
        response.body("File uploaded successfully.");
        return response;
    }

    private ResponseWrapper deleteFile(RequestWrapper request, ResponseWrapper response) {
        String fileId = request.getParam(":fileId");
        fileStorageService.findById(fileId);
        return response;
    }

    private ResponseWrapper<File> updateFile(RequestWrapper request, ResponseWrapper<File> response) {
        String fileId = request.getParam("fileId");
        InputStream byteFile = request.getBodyAsStream();
        File file = fileStorageService.update(fileId, byteFile);
        response.setBody(file);
        response.setStatus(HttpStatusCode.CREATED);
        return response;
    }

    private ResponseWrapper<File> downloadFile(RequestWrapper request, ResponseWrapper<File> response) {
        String fileName = request.getParam("fileName");
        File file = fileStorageService.loadByFileName(fileName);
        response.setBody(file);
        return response;
    }
}