package storage;

/*
* Dummy converter
*/
public class GsonConverter {

    public static <T> T fromJson(String json, Class<T> classOfT) {
        Object object = (T) new Object();
        return (T) object;
    }
}