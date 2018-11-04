package com.krzysztofziomek.fb.Q_5709428993556480;

import java.util.*;

/**
 * @author Krzysztof Ziomek
 * @since 03/11/2018.
 * https://www.careercup.com/question?id=5709428993556480
 *
 * ..............6
 * ............/...\
 * ...........9.....4
 * ........../..\....\
 * .........5....1....6
 * ..........\......../
 * ...........0.... .7
 * .............\.......
 * ..............11
 * ................\
 * .................12
 * ...................\
 * ...................13
 * .....................\
 * ......................14
 *
 */
public class Q_5709428993556480 {


    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(9);
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

        Q_5709428993556480 app = new Q_5709428993556480();
        app.printInVerticalOrder(root) ;
    }

    private void printInVerticalOrder(Node root) {
        if (root == null){
            return;
        }
        TreeMap<Integer, List<Integer>> hdToValues = collectHorizontalDistancesToValues(root);
        print(hdToValues);
    }

    private TreeMap<Integer, List<Integer>> collectHorizontalDistancesToValues(Node root) {
        TreeMap<Integer, List<Integer>> hdToValues = new TreeMap<>();

        LinkedList<HDNode> nodes = new LinkedList<>();
        nodes.add(new HDNode(0, root));
        while (!nodes.isEmpty()) {
            HDNode hdNode = nodes.removeFirst();

            hdToValues.putIfAbsent(hdNode.hd, new ArrayList<>());
            hdToValues.get(hdNode.hd).add(hdNode.node.value);

            if(hdNode.node.left != null){
                nodes.add(new HDNode(hdNode.hd - 1, hdNode.node.left));
            }
            if(hdNode.node.right != null){
                nodes.add(new HDNode(hdNode.hd + 1, hdNode.node.right));
            }
        }
        return hdToValues;
    }

    private void print(TreeMap<Integer, List<Integer>> hdToValues) {
        while (!hdToValues.isEmpty()) {
            Map.Entry<Integer, List<Integer>> entry = hdToValues.pollFirstEntry();
            entry.getValue().forEach(v -> System.out.print(v + " "));
            System.out.println("\n");
        }
    }

    private class HDNode {
        int hd;
        Node node;

        HDNode(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

}
