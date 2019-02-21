package storage.model;

import java.time.LocalDateTime;

public class File {
    private String id;
    private Long size;
    private String name;
    private String description;
    private String originalFileName;
    private LocalDateTime createdTime;
    private String lastModifyingUserId;

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
