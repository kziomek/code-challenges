package com.krzysztofziomek.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Krzysztof Ziomek
 * @since 18/05/2017.
 */
public class NailingPlanks {


    public int solution(int[] a, int[] b, int[] c) {
        Map<Integer, Integer> idxMap = buildIdxMap(c);
        Arrays.sort(c);

        int maxNailIdx = -1;
        int plankFirstNailIdx;

        for (int i = 0; i < a.length; i++) {

            plankFirstNailIdx = findFirstNailIdx(a[i], b[i], c, idxMap, maxNailIdx);
            if (plankFirstNailIdx == -1) {
                return -1;
            }
            if (plankFirstNailIdx > maxNailIdx) {
                maxNailIdx = plankFirstNailIdx;
            }

        }

        return maxNailIdx + 1;
    }

    private int findFirstNailIdx(int a, int b, int[] c, Map<Integer, Integer> idxMap, int preResult) {
        int lo = 0;
        int hi = c.length - 1;
        int mid;
        int nailIdx = Integer.MAX_VALUE;
        int nail;

        while (lo <= hi) {
            mid = (hi + lo) / 2;
            nail = c[mid];
            if (nail > b) {
                hi = mid - 1;
            } else if (nail < a) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        int pos = lo;
        int idx;
        while (pos < c.length) {
            if (c[pos] > b) {
                break;
            }
            nail = c[pos];
            idx = idxMap.get(nail);
            if (idx < nailIdx) {
                nailIdx = idx;
            }
            pos = pos + 1;
            if (nailIdx < preResult) return nailIdx;
        }

        return nailIdx == Integer.MAX_VALUE ? -1 : nailIdx;
    }

    private Map<Integer, Integer> buildIdxMap(int[] c) {
        Map<Integer, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < c.length; i++) {
            if (idxMap.containsKey(c[i])) {
                if (idxMap.get(c[i]) > i) {
                    idxMap.put(c[i], i);
                }
            } else {
                idxMap.put(c[i], i);
            }
        }
        return idxMap;
    }
}
