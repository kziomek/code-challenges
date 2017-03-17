package com.krzysztofziomek.frequentphrases.mistragries;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Krzysztof Ziomek
 * @since 15/03/2017.
 *
 * TODO implement Map & Refactoring
 */
public class MistraGriesMap {

    private Map<String, Long> map;
    private long maxCapacity = 0;

    public MistraGriesMap(long maxCapacity) {
        map = new HashMap<>();
        this.maxCapacity = maxCapacity;
    }

    public void put(String key) {
        if (map.containsKey(key)) {
            increaseCounterForElementInMap(key);
        } else if (map.size() < maxCapacity) {
            addNewElementToMap(key);
        } else {
            decreaseCounters(map);
            removeZeroValuedElements(map);
        }
    }

    private void addNewElementToMap(String key) {
        map.put(key, 1L);
    }

    private void increaseCounterForElementInMap(String key) {
        map.put(key, map.get(key) + 1);
    }


    private void decreaseCounters(Map<String, Long> map) {
        for (String key : map.keySet()) {
            map.put(key, map.get(key) - 1);
        }
    }

    public void resetValues(Long resetValue) {
        for (Map.Entry<String, Long> stringLongEntry : map.entrySet()) {
            stringLongEntry.setValue(resetValue);
        }
    }

    private long removeZeroValuedElements(Map<String, Long> map) {
        long removed = 0;
        Iterator<Map.Entry<String, Long>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Long> element = iterator.next();
            if (element.getValue() == 0) {
                iterator.remove();
                removed++;
            }
        }
        return removed;
    }

    public void removeInfrequentElements(long m, long k) {
        Iterator<Map.Entry<String, Long>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Long> element = iterator.next();
            if (element.getValue() <= m / k) {
                iterator.remove();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            builder.append(entry).append(" ");
        }
        return builder.toString().trim();
    }

    public int size() {
        return map.size();
    }

    public Long get(String key) {
        return map.get(key);
    }

    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

}