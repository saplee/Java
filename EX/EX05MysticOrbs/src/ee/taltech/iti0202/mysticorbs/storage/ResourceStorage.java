package ee.taltech.iti0202.mysticorbs.storage;

import java.util.LinkedHashMap;
import java.util.Set;

public class ResourceStorage {
    private LinkedHashMap<String, Integer> resourceMap = new LinkedHashMap<>();

    public boolean isEmpty() {
        Set<String> keys = resourceMap.keySet();
        for (String key : keys) {
            if (resourceMap.get(key) > 0) {
                return true;
            }
        }
        return false;
    }

    public void addResource(String resource, int amount) {
        if (amount > 0 && !resource.isEmpty() && !resourceMap.containsKey(resource)) {
            resourceMap.put(resource, amount);
        } else if (amount > 0 && !resource.isEmpty()) {
            resourceMap.put(resource, resourceMap.get(resource) + amount);
        }
    }

    public int getResourceAmount(String resource) {
        if (resourceMap.containsKey(resource)) {
            return resourceMap.get(resource);
        }
        return 0;
    }

    public boolean hasEnoughResource(String resource, int amount) {
        if (amount < 1) {
            return false;
        } else if (resourceMap.get(resource) >= amount) {
            return true;
        }return false;
    }

    public boolean takeResource(String resource, int amount) {
        return false;
    }
}
