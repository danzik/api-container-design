package storage.repository.impl;

import storage.model.File;
import storage.repository.FileStorageRepository;

import java.io.InputStream;

public class FileStorageRepositoryImpl implements FileStorageRepository {
    @Override
    public void uploadFile(String userId, InputStream fileInputStream) {

    }

    @Override
    public File loadByFileName(String fileName) {
        return null;
    }

    @Override
    public File update(String fileId, InputStream updatedFile) {
        return null;
    }

    @Override
    public File findById(String fileId) {
        return null;
    }
}
