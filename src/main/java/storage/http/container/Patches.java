package storage.http.container;

import storage.http.RequestRunnerImpl;
import storage.http.FilterUtils;

public class Patches {

    public static void execute(RequestContext requestContext) throws Exception {
        Object content = requestContext.getBody();
        PatchMatcher matcher = requestContext.getRequests().find(requestContext.getHttpMethod(), requestContext.getUri());

        Object handler = null;
        if (matcher != null) {
            handler = matcher.getTarget();
        }

        if (handler != null) {
            Object result;
            if (handler instanceof RequestRunnerImpl) {
                RequestRunnerImpl requestHandler = ((RequestRunnerImpl) handler);
                String matchUri = matcher.getMatchUri();

                if (matchUri.contains(":")) {
                    String keyParam = FilterUtils.findKeyParam(matcher.getMatchUri());
                    String valueParam = FilterUtils.findParamValue(matcher.getRequestURI());
                    requestContext.getRequestWrapper().setParam(keyParam, valueParam);
                }

                result = requestHandler.run(requestContext.getRequestWrapper(), requestContext.getResponseWrapper());

                if (result != null) {
                    content = result;
                }
            }
        }

        requestContext.getBody().setContent(content);
    }
}