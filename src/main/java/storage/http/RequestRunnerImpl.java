package storage.http;

import storage.http.container.RequestWrapper;
import storage.http.container.ResponseWrapper;

public abstract class RequestRunnerImpl implements RequestRunner {
    static final String DEFAULT_ACCEPT_TYPE = "/*";

    private String path;
    private Object delegate;
    private String acceptType;

    protected RequestRunnerImpl(String path, String acceptType) {
        this.path = path;
        this.acceptType = acceptType;
    }

    protected RequestRunnerImpl(String path, String acceptType, Object route) {
        this(path, acceptType);
        this.delegate = route;
    }

    public static RequestRunnerImpl create(final String path, final RequestRunner route) {
        return create(path, DEFAULT_ACCEPT_TYPE, route);
    }

    public static RequestRunnerImpl create(final String path, String acceptType, final RequestRunner runner) {
        if (acceptType == null) {
            acceptType = DEFAULT_ACCEPT_TYPE;
        }
        return new RequestRunnerImpl(path, acceptType, runner) {
            @Override
            public Object run(RequestWrapper request, ResponseWrapper response) throws Exception {
                return runner.run(request, response);
            }
        };
    }

    public static String getDefaultAcceptType() {
        return DEFAULT_ACCEPT_TYPE;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getDelegate() {
        return delegate;
    }

    public void setDelegate(Object delegate) {
        this.delegate = delegate;
    }

    public String getAcceptType() {
        return acceptType;
    }

    public void setAcceptType(String acceptType) {
        this.acceptType = acceptType;
    }
}
