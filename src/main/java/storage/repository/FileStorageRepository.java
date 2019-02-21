package storage.repository;

import storage.model.File;

import java.io.InputStream;

public interface FileStorageRepository {
    void uploadFile(String userId, InputStream fileInputStream);

    File loadByFileName(String fileName);

    File findById(String fileId);

    File update(String fileId, InputStream updatedFile);
}
