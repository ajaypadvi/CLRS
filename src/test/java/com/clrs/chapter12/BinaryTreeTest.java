package com.clrs.chapter12;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    private BinaryTree bt;

    @Before
    public void before() {
        bt = new BinaryTree();
        bt.insert(12);
        bt.insert(5);
        bt.insert(18);
        bt.insert(2);
        bt.insert(9);
        bt.insert(15);
        bt.insert(19);
        bt.insert(1);
        bt.insert(13);
        bt.insert(17);
        bt.insert(21);

        //Binary tree pretty print
        bt.prettyPrint();
    }


    @Test
    public void testSearch() {
        BinaryTree.TreeNode node = bt.iterativeSearch(18);
        assertEquals(18, node.getKey());

        node = bt.recursiveSearch(17, bt.getRoot());
        assertEquals(17, node);
    }

    @Test
    public void delete() {
        System.out.println("Deleting nodes from binary tree");
        bt.inorderTreeWalk(bt.getRoot());
        System.out.println();
        bt.prettyPrint();

        //Case 1: Delete a treenode with no children 17
        bt.delete(17);
        System.out.println("After deleting 17");
        bt.prettyPrint();

        //Case 2: Delete a node which has only right child 19
        bt.delete(19);
        System.out.println("After deleting 19");
        bt.prettyPrint();

        //Case 3:Delete a node which has only left child 2
        bt.delete(2);
        System.out.println("After deleting 2");
        bt.prettyPrint();

        //Case 4: Delete a node which has both the child but its successor is right of the node to be deleted (5)->9
        bt.delete(5);
        System.out.println("After deleting 5");
        bt.prettyPrint();

        //Case 5: Delete a node which has both the child but its successor is somewhere inside right subtree of the node to be deleted (12)->13
        bt.delete(12);
        System.out.println("After deleting 12");
        bt.prettyPrint();
    }

}
