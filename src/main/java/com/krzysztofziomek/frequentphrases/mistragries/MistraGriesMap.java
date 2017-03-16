package com.krzysztofziomek.frequentphrases.mistragries;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Krzysztof Ziomek
 * @since 15/03/2017.
 * <p>
 * <p>
 * <p>
 * http://cs.stackexchange.com/questions/7291/finding-the-element-that-occurs-the-most-in-a-very-large-file
 * http://www.cs.dartmouth.edu/~ac/Teach/CS49-Fall11/Notes/lecnotes.pdf
 * http://www.cs.rug.nl/~wim/pub/whh348.pdf
 * <p>
 * https://github.com/marcosbarbero/code-challenge
 * https://github.com/marcosbarbero/code-challenge/blob/master/src/main/java/com/marcosbarbero/demo/LargeFile.java
 * <p>
 * http://stackoverflow.com/questions/19621993/efficient-algorithm-to-find-most-common-phrases-in-a-large-volume-of-text
 */
public class MistraGriesMap{

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
            long removed = removeZeroValuedElements(map);
//            if (removed > 0) {
//                addNewElementToMap(key);
//            }
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
            map.put(key, map.get(key) - 1); // decrease counter
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


    public int size(){
        return map.size();
    }

    public Long get(String key){
        return map.get(key);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            builder.append(entry).append(" ");
        }
        return builder.toString().trim();
    }
}