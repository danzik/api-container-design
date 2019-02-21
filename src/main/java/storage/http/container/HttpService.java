package storage.http.container;

import storage.http.FilterUtils;
import storage.http.Requests;
import storage.http.RequestRunner;
import storage.http.RequestRunnerImpl;
import storage.exceptions.HttpServiceException;
import storage.filter.Filter;
import storage.filter.FilterImpl;
import storage.http.HttpStatusCode;

public final class HttpService {

    protected Requests requests;

    public HttpService(Requests requests) {
        this.requests = requests;
    }

    public static HttpService getInstance() {
        return new HttpService(new Requests());
    }

    public void get(String path, RequestRunner handler) {
        requests.add(HttpMethod.GET, generateRequestRunner(path, handler));
    }

    public void post(String path, RequestRunner handler) {
        requests.add(HttpMethod.POST, generateRequestRunner(path, handler));
    }

    public void delete(String path, RequestRunner handler) {
        requests.add(HttpMethod.DELETE, generateRequestRunner(path, handler));
    }

    public void put(String path, RequestRunner handler) {
        requests.add(HttpMethod.PUT, generateRequestRunner(path, handler));
    }

    public void filterBefore(Filter... filters) {
        for (Filter filter : filters) {
            filterBefore(filter);
        }
    }

    public void filterBefore(Filter filter) {
        requests.add(HttpMethod.BEFORE, FilterImpl.create(FilterUtils.ALL_MATCHES, filter));
    }

    public void filterBefore(String path, Filter filter) {
        requests.add(HttpMethod.BEFORE, FilterImpl.create(path, filter));
    }

    public void filterBefore(String path, Filter filter, String acceptType) {
        requests.add(HttpMethod.BEFORE, FilterImpl.create(path, filter, acceptType));
    }

    public void filterAfter(String path, Filter filter) {
        requests.add(HttpMethod.AFTER, FilterImpl.create(path, filter));
    }

    private RequestRunnerImpl generateRequestRunner(String path, RequestRunner handler) {
        return RequestRunnerImpl.create(path, handler);
    }

    public static HttpServiceException finish(HttpStatusCode statusCode, String body) {
        throw new HttpServiceException(statusCode, body);
    }

    public Requests getRequests() {
        return requests;
    }
}