package com.laba1.laba1;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@Component
public class Cache {
    private Map<String, Greeting> cacheMap;

    public Cache(){this.cacheMap = new HashMap<>();}

    public Set<Map.Entry<String, Greeting>> setCacheMap() {
        return cacheMap.entrySet();
    }
    public void addCacheObject (String key, Greeting object){
        cacheMap.put(key, object);
    }
    public Greeting getValume (String key){
        return cacheMap.get(key);
    }

    public boolean searchKey (String key){
        return cacheMap.containsKey(key);
    }

}
