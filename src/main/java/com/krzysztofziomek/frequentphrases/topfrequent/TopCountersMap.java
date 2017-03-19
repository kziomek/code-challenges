package com.krzysztofziomek.frequentphrases.topfrequent;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Krzysztof Ziomek
 * @since 18/03/2017.
 */
public class TopCountersMap {

    private TreeMap<Long, Long> map;
    private int maxNumberOfTopCounters;
    private int numberOfCounters;

    public TopCountersMap(int maxNumberOfTopCounters) {
        this.maxNumberOfTopCounters = maxNumberOfTopCounters;
        map = new TreeMap<>();
        numberOfCounters = 0;
    }

    public void add(Long counter) {
        System.out.println("add counter: "+counter);
        if (map.containsKey(counter)) {
            map.put(counter, map.get(counter) + 1);
            numberOfCounters++;
        } else {
            map.put(counter, 1L);
            numberOfCounters++;
        }

        if (numberOfCounters >= maxNumberOfTopCounters + map.firstEntry().getValue()) {
            Map.Entry<Long, Long> entry = map.pollFirstEntry();
            System.out.println("delete " + entry.getKey());
            numberOfCounters -= entry.getValue();
        }

        System.out.println(map);
        System.out.println("numberOfCounters: " + numberOfCounters);
        System.out.println();
    }

    public Long getLowestCounter() {
        return map.firstKey();
    }

    public long getLowestCounterFreeSlots() {
        return (map.firstEntry().getValue() - (numberOfCounters - maxNumberOfTopCounters));
    }


}
