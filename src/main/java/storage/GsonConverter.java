package storage;

/*
* Dummy converter
*/
public final class GsonConverter {
    public <T> T fromJson(String currentJson, Class<T> type) {
        return (T) type;
    }
}
