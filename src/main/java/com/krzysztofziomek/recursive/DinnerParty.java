package com.krzysztofziomek.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Krzysztof Ziomek
 * @since 30/04/2017.
 */
public class DinnerParty {

    public List<Set<Integer>> findDinnerParties(int[] friends, int tableSize) {

        List<Set<Integer>> groups = new ArrayList<>();
        Set<Integer> group = new HashSet<>();
        combineFriends(friends, tableSize, 0, groups, group);
        return groups;

    }

    private void combineFriends(int[] friends, int tableSize, int pos, List<Set<Integer>> groups, Set<Integer> group) {
        // stop
        if (group.size() == tableSize) {
            groups.add(group);
        } else if (pos < friends.length) {
            //leave
            combineFriends(friends, tableSize, pos + 1, groups, group);

            //take
            group = new HashSet<>(group);
            group.add(friends[pos]);
            combineFriends(friends, tableSize, pos + 1, groups, group);
        }
    }


    public static void main(String[] args) {
        int[] friends = {1, 2, 3, 4};
        int tableSize = 3;

        List<Set<Integer>> dinnerParties = new DinnerParty().findDinnerParties(friends, tableSize);

        for (Set<Integer> dinnerParty : dinnerParties) {
            System.out.println(dinnerParty);
        }

    }

}
