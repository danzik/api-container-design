package storage.http;

import storage.PatchEntry;
import storage.filter.FilterImpl;
import storage.http.container.PatchMatcher;
import storage.http.container.HttpMethod;

import java.util.ArrayList;
import java.util.List;

public class Requests {

    private List<PatchEntry> patches;

    public Requests() {
        this.patches = new ArrayList<>();
    }

    public void add(HttpMethod httpMethod, RequestRunnerImpl path) {
        add(httpMethod, path.getPath(), path.getAcceptType(), path);
    }

    public void add(HttpMethod httpMethod, FilterImpl filter) {
        add(httpMethod, filter.getPath(), filter.getAcceptType(), filter);
    }

    public PatchMatcher find(HttpMethod httpMethod, String path) {
        List<PatchEntry> routeEntries = this.findTargetsForRequestedPath(httpMethod, path);
        PatchEntry entry = findPatchWithAcceptType(routeEntries);
        return entry != null ? new PatchMatcher(entry.getTarget(), entry.getPath(), path) : null;
    }

    private void add(HttpMethod method, String url, String acceptType, Object target) {
        PatchEntry patchEntry = new PatchEntry();
        patchEntry.setPath(url);
        patchEntry.setTarget(target);
        patchEntry.setHttpMethod(method);
        patchEntry.acceptType(acceptType);

        patches.add(patchEntry);
    }

    private List<PatchEntry> findTargetsForRequestedPath(HttpMethod httpMethod, String path) {
        List<PatchEntry> matchers = new ArrayList<>();
        for (PatchEntry entry : patches) {
            if (entry.matches(httpMethod, path)) {
                matchers.add(entry);
            }
        }
        return matchers;
    }

    private PatchEntry findPatchWithAcceptType(List<PatchEntry> routeEntries) {
        return routeEntries.size() == 0 ? new PatchEntry() : routeEntries.get(0);
    }

    public List<PatchMatcher> findFilters(HttpMethod httpMethod, String uri) {
        List<PatchMatcher> matches = new ArrayList<>();
        List<PatchEntry> targetsForRequestedPath = findTargetsForRequestedPath(httpMethod, uri);
        for (PatchEntry patchEntry : targetsForRequestedPath) {
            matches.add(new PatchMatcher(patchEntry.getTarget(), patchEntry.getPath(), uri));
        }
        return matches;
    }
}