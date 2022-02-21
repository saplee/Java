package ee.taltech.iti0202.mysticorbs.storage;

import java.util.LinkedHashMap;
import java.util.Set;

public class ResourceStorage {
    private LinkedHashMap<String, Integer> resourceMap = new LinkedHashMap<>();
    public boolean isEmpty() {
        Set<String> keys = resourceMap.keySet();
        for (String key:keys){
            if (resourceMap.get(key) > 0){
                return true;
            }
        }return false;
    }

    public void addResource(String resource, int amount) {
        if (amount>0 && !resource.isEmpty() && !resource.isBlank()){
            resourceMap.put(resource, resourceMap.getOrDefault(resource, amount) + amount);
        }
    }

    public int getResourceAmount(String resource) {
        if (resourceMap.containsKey(resource)){
            return resourceMap.get(resource);
        }
        return 0;
    }

    public boolean hasEnoughResource(String resource, int amount) {
        return false;
    }

    public boolean takeResource(String resource, int amount) {
        return false;
    }
}
