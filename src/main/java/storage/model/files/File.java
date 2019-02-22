package storage.model.files;

import java.time.LocalDateTime;

public class File extends Metadata {
    private Long size;
    private String description;
    private String originalFileName;
    private FilePermission permission;
    private LocalDateTime createdTime;
    private String lastModifyingUserId;

    public File(String name, String pathDisplay) {
        super(name, pathDisplay);
    }

    public String getId() {
        return id;
    }

    public Long getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLastModifyingUser() {
        return lastModifyingUserId;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}
