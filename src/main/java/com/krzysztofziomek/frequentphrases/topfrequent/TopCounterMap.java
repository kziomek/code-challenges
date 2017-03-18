package com.krzysztofziomek.frequentphrases.topfrequent;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Krzysztof Ziomek
 * @since 18/03/2017.
 *
 * k - sum of
 */
public class TopCounterMap {
    private TreeMap<Long,Long> map;
    private int k;
    private int valueSum;

    public TopCounterMap(int k) {
        this.k = k;
        map = new TreeMap<>();
        valueSum = 0;
    }

    public void add(Long counter) {
        if (map.containsKey(counter)) {
            map.put(counter, map.get(counter) + 1);
            valueSum++;
        } else {
            map.put(counter, 1L);
            valueSum++;
        }

        if (valueSum >= k + map.firstEntry().getValue()) {
            Map.Entry<Long, Long> entry = map.pollFirstEntry();
            System.out.println("delete "+ entry.getKey());
            valueSum -= entry.getValue();
        }
        System.out.println("valueSum " + valueSum);
        System.out.println(map);
    }

    public Long getLowestCounter(){
        return map.firstKey();
    }

    public int getSurplusValue(){
        return valueSum -k ;
    }
}
