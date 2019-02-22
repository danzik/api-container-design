package storage;

/*
* Dummy converter
*/
public class GsonConverter {
    public static <T> T fromJson(String currentJson, Class<T> type) {
        return (T) type;
    }
}