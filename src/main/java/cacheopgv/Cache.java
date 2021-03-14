package cacheopgv;
import java.util.HashMap;
import java.util.Map;

public class Cache {

    public static Map<Integer, UserData> map = new HashMap<>();

    public static UserData get(int key){
        return map.get(key);
    }

    public static void set(int key, UserData value){
        map.put(key, value);
    }

    public static Boolean has(int key){
        return map.containsKey(key);
    }

    //needs testing
    public static void delete(int key){
        map.remove(key);
    }

}
