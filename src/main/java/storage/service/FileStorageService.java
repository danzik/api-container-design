package storage.service;

import storage.model.files.File;

import java.io.InputStream;

public interface FileStorageService {

    File loadByFileName(String fileName);

    File update(String fileId, InputStream fileCandidate);

    File findById(String fileId);

    void uploadFile(String userId, InputStream fileInputStream);
}
