package storage.http;

// Dummy implementations
public class FilterUtils {
    public static final String ALL_MATCHES = "/*";

    // Must be additional checks FI "/users/:userId/documents"
    public static String findKeyParam(String uri) {
        int paramIndex = uri.indexOf(":");
        return uri.substring(paramIndex);
    }

    // Must be additional checks
    public static String findParamValue(String requestURI) {
        int lastSlashIndex = requestURI.lastIndexOf("/") + 1;
        return requestURI.substring(lastSlashIndex);
    }
}
