package storage.model.files;

import com.dropbox.core.v2.sharing.FolderPermission;

import java.util.List;

public class Folder extends Metadata {
    private String link;
    private List<File> files;
    private FolderPermission permission;

    public Folder(String name, String pathDisplay, String link) {
        super(name, pathDisplay);
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public List<File> getFiles() {
        return files;
    }

    public FolderPermission getPermission() {
        return permission;
    }
}
