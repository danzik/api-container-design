package storage.filter;

import storage.http.container.RequestWrapper;
import storage.http.container.ResponseWrapper;

public abstract class FilterImpl<T> implements Filter<T> {
    private String path;
    private String acceptType;

    static final String DEFAULT_PATH = "/*";

    protected FilterImpl(String path, String acceptType) {
        this.path = path;
        this.acceptType = acceptType;
    }

    protected FilterImpl(String path, String acceptType, Filter filter) {
        this(path, acceptType);
    }

    public static <T> FilterImpl<T> create(final String path, final Filter<T> filter) {
        return create(path, filter, DEFAULT_PATH);
    }

    public static <T> FilterImpl<T> create(final String path, final Filter<T> filter, String acceptType) {
        if (acceptType == null) {
            acceptType = DEFAULT_PATH;
        }

        return new FilterImpl<T>(path, acceptType, filter) {
            @Override
            public void handle(RequestWrapper request, ResponseWrapper<T> response) throws Exception {
                filter.handle(request, response);
            }
        };
    }

    public String getPath() {
        return path;
    }

    public String getAcceptType() {
        return acceptType;
    }

}
