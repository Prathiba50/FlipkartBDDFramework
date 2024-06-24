package appmanager;

import java.util.Map;

public class AppicationCache {
    Map<String,Object>objects;

    public Map<String, Object> getObjects(){
        return objects;
    }

    public void setoObjects(Map<String, Object> objects){
        this.objects = objects;
    }
}
