package storage.service.impl;

import storage.model.files.File;
import storage.repository.FileStorageRepository;
import storage.service.FileStorageService;

import java.io.InputStream;

public class FileStorageServiceImpl implements FileStorageService {
    private FileStorageRepository fileStorageRepository;

    public FileStorageServiceImpl(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
    }

    @Override
    public void uploadFile(String userId, InputStream fileInputStream) {
        fileStorageRepository.uploadFile(userId, fileInputStream);
    }

    @Override
    public File loadByFileName(String fileName) {
        return fileStorageRepository.loadByFileName(fileName);
    }

    @Override
    public File update(String fileId, InputStream updatedFile) {
        return fileStorageRepository.update(fileId, updatedFile);
    }

    @Override
    public File findById(String fileId) {
        return fileStorageRepository.findById(fileId);
    }
}
