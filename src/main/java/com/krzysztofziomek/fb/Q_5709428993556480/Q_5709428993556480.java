package com.krzysztofziomek.fb.Q_5709428993556480;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * @author Krzysztof Ziomek
 * @since 03/11/2018.
 * https://www.careercup.com/question?id=5709428993556480
 */
public class Q_5709428993556480 {


    public static void main(String[] args){

/*
..............6
............/....\
...........9......4
........../..\.....\
.........5....1.....3
..........\......../
...........0......7

        Node root = new Node(6);
        root.left = new Node(9);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(1);
        root.left.left.right = new Node(0);
        root.right.right = new Node(3);
        root.right.right.left = new Node(7);
*/

/*
..............6
............/...\
...........9.....4
........../..\....\
.........5....1....6
..........\......../
...........0.... .7
.............\.......
..............11
................\
.................12
...................\
...................13
.....................\
......................14

*/
        Node root = new Node(6);
        root.left= new Node(9);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(1);
        root.right.right = new Node(6);
        root.left.left.right = new Node(0);
        root.right.right.left = new Node(7);
        root.left.left.right.right = new Node(11);
        root.left.left.right.right.right = new Node(12);
        root.left.left.right.right.right.right = new Node(13);
        root.left.left.right.right.right.right.right = new Node(14);

        printInVerticalOrder(root);
    }

    // TODO implement breadth-first order traversal so simplify
    public static void printInVerticalOrder(Node root){
        // map of horizontal distance to set of pairs of node level and value
        TreeMap<Integer, TreeSet<Pair<Integer,Integer>>> horizontalDistances = new TreeMap<>();
        collectDistances(root, horizontalDistances, 0,0);

        while (!horizontalDistances.isEmpty()) {
            TreeSet<Pair<Integer,Integer>> integerListEntry = horizontalDistances.pollFirstEntry().getValue();
            integerListEntry.forEach(i -> System.out.print(i.getValue() + " "));
            System.out.println("\n");
        }
    }

    public static void collectDistances(Node node, Map<Integer, TreeSet<Pair<Integer,Integer>>> horizontalDistances, int nodeHD, int nodeLevel) {
        if (node == null) {
            return;
        }
        TreeSet<Pair<Integer,Integer>> valuesInDistance = horizontalDistances.computeIfAbsent(nodeHD, k -> new TreeSet<>(Comparator.comparingInt(Pair::getLeft)));
        valuesInDistance.add(new ImmutablePair<>(nodeLevel, node.value));
        collectDistances(node.left, horizontalDistances, nodeHD - 1, nodeLevel + 1);
        collectDistances(node.right, horizontalDistances, nodeHD + 1, nodeLevel + 1);
    }
}
