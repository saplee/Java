package ee.taltech.iti0202.mysticorbs.storage;

import java.util.LinkedHashMap;
import java.util.Locale;
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
        String newResource = resource.toLowerCase().replaceAll("[^A-Za-z]", "");
        if (amount > 0 && !resource.isEmpty() && !resourceMap.containsKey(resource) && resource.trim().length() > 0) {
            resourceMap.put(newResource, amount);
        } else if (amount > 0 && !resource.isEmpty() && resource.trim().length() > 0) {
            resourceMap.put(newResource, resourceMap.get(newResource) + amount);
        }
    }

    public int getResourceAmount(String resource) {
        String newResource = resource.toLowerCase().replaceAll("[^A-Za-z]", "");
        if (resourceMap.containsKey(newResource)) {
            return resourceMap.get(newResource);
        }
        return 0;
    }

    public boolean hasEnoughResource(String resource, int amount) {
        String newResource = resource.toLowerCase().replaceAll("[^A-Za-z]", "");
        if (amount < 1) {
            return false;
        } else if (resourceMap.get(newResource) >= amount) {
            return true;
        }
        return false;
    }

    public boolean takeResource(String resource, int amount) {
        return false;
    }
}
