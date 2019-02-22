package storage.model.files;

public class Metadata {
    protected final String id;
    protected final String name;
    protected final String pathDisplay;

    public Metadata(String name, String pathDisplay) {
        this.name = name;
        this.pathDisplay = pathDisplay;
        this.id = null;
    }

    public String getName() {
        return name;
    }

    public String getPathDisplay() {
        return pathDisplay;
    }
}
