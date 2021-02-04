package com.krzysztofziomek.tree;

import com.krzysztofziomek.tree.LowestCommonAncestor.Node;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Krzysztof Ziomek
 * @since 30/01/2021.
 */
public class LowestCommonAncestorTest {

    @Test
    public void testLCA() {
        Node root = buildTree();

        Assert.assertEquals("B", new LowestCommonAncestor().lca(root, "C", "D").getValue());
        Assert.assertEquals("A", new LowestCommonAncestor().lca(root, "C", "F").getValue());
        Assert.assertEquals("A", new LowestCommonAncestor().lca(root, "E", "C").getValue());
        Assert.assertEquals("B", new LowestCommonAncestor().lca(root, "B", "C").getValue());
        Assert.assertEquals("A", new LowestCommonAncestor().lca(root, "A", "C").getValue());
    }

    @Test
    public void testLCADeepFirstSearch() {
        Node root = buildTree();

        Assert.assertEquals("B", new LowestCommonAncestor().lcaDFS(root, "C", "D").getValue());
        Assert.assertEquals("A", new LowestCommonAncestor().lcaDFS(root, "C", "F").getValue());
        Assert.assertEquals("A", new LowestCommonAncestor().lcaDFS(root, "E", "C").getValue());
        Assert.assertEquals("B", new LowestCommonAncestor().lcaDFS(root, "B", "C").getValue());
        Assert.assertEquals("A", new LowestCommonAncestor().lcaDFS(root, "A", "C").getValue());
        Assert.assertNull(new LowestCommonAncestor().lcaDFS(root, "A", "NonExists"));
    }

    /*
                 A
              /     \
			 B       E
			/ \     / \
		   C   D   F   G
     */
    private Node buildTree() {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");

        A.add(B);
        A.add(E);
        B.add(C);
        B.add(D);
        E.add(F);
        E.add(G);
        return A;
    }
}