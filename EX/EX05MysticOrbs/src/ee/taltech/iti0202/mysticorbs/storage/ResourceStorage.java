package ee.taltech.iti0202.mysticorbs.storage;

import java.util.LinkedHashMap;

import java.util.Set;

public class ResourceStorage {
    private LinkedHashMap<String, Integer> resourceMap = new LinkedHashMap<>();

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        Set<String> keys = resourceMap.keySet();
        for (String key : keys) {
            if (resourceMap.get(key) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param resource
     * @param amount
     */
    public void addResource(String resource, int amount) {
        String newResource = resource.toLowerCase().replaceAll("[^A-Za-z]", "");
        if (amount > 0 && !resource.isEmpty() && !resourceMap.containsKey(newResource)
                && resource.trim().length() > 0) {
            resourceMap.put(newResource, amount);
        } else if (amount > 0 && !resource.isEmpty() && resource.trim().length() > 0) {
            resourceMap.put(newResource, resourceMap.get(newResource) + amount);
        }
    }

    /**
     *
     * @param resource
     * @return
     */
    public int getResourceAmount(String resource) {
        String newResource = resource.toLowerCase().replaceAll("[^A-Za-z]", "");
        if (resourceMap.containsKey(newResource)) {
            return resourceMap.get(newResource);
        }
        return 0;
    }

    /**
     *
     * @param resource
     * @param amount
     * @return
     */
    public boolean hasEnoughResource(String resource, int amount) {
        String newResource = resource.toLowerCase().replaceAll("[^A-Za-z]", "");
        if (amount < 1) {
            return false;
        } else if (resourceMap.get(newResource) >= amount) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param resource
     * @param amount
     * @return
     */
    public boolean takeResource(String resource, int amount) {
        String newResource = resource.toLowerCase().replaceAll("[^A-Za-z]", "");
        if (resourceMap.get(newResource) < amount) {
            return false;
        } else {
            resourceMap.replace(newResource, resourceMap.get(newResource),
                    resourceMap.get(newResource) - amount);
            return true;
        }
    }
}
