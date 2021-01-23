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

    public List<Set<Character>> findDinnerParties(char[] friends, int tableSize) {
        List<Set<Character>> groups = new ArrayList<>();
        Set<Character> group = new HashSet<>();
        combineFriends(friends, tableSize, 0,   groups, group);
        return groups;

    }

    private void combineFriends(char[] friends, int tableSize, int pos, List<Set<Character>> groups, Set<Character> group) {
        if (group.size() == tableSize) {
            groups.add(new HashSet<>(group));
            return;
        }

        for (int i = pos; i<friends.length; i++) {
            group.add(friends[i]);
            combineFriends(friends, tableSize, i + 1, groups, group);
            group.remove(friends[i]);
        }
    }

    /*
      https://www.youtube.com/watch?v=3teHU4n-czU&ab_channel=JacksonGabbard
    */
//    private void combineFriends(int[] friends, int tableSize, int pos, List<Set<Integer>> groups, Set<Integer> group) {
//        // stop
//        if (group.size() == tableSize) {
//            groups.add(group);
//        } else if (pos < friends.length) {
//            //leave
//            combineFriends(friends, tableSize, pos + 1, groups, group);
//
//            //take
//            group = new HashSet<>(group);
//            group.add(friends[pos]);
//            combineFriends(friends, tableSize, pos + 1, groups, group);
//        }
//    }


    public static void main(String[] args) {
        char[] friends = {'A', 'B', 'C', 'D', 'E' , 'F'};
        int tableSize = 3;

        List<Set<Character>> dinnerParties = new DinnerParty().findDinnerParties(friends, tableSize);

        for (Set<Character> dinnerParty : dinnerParties) {
            System.out.println(dinnerParty);
        }
    }
}