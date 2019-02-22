package storage.model.files;

public class FilePermission {
    protected final boolean allow;
    protected final FileAction action;

    public FilePermission(FileAction action, boolean allow) {
        this.action = action;
        this.allow = allow;
    }

    public FileAction getAction() {
        return action;
    }

    public boolean isAllow() {
        return allow;
    }
}
