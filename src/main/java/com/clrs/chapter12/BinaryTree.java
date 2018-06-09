package com.clrs.chapter12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree {

    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    /**
     * Inroder tree walk method
     *
     * @param root
     */
    public void inorderTreeWalk(TreeNode root) {
        TreeNode x = root;
        if (x != null) {
            inorderTreeWalk(x.left);
            System.out.print(x.key + " ");
            inorderTreeWalk(x.right);
        }
    }

    /**
     * Search given value in binary tree using recursive procedure
     *
     * @param k
     * @param x
     * @return
     */
    public TreeNode recursiveSearch(int k, TreeNode x) {
        if (k == x.key || x == null) {
            return x;
        }
        if (k < x.key) {
            return recursiveSearch(k, x.left);
        } else {
            return recursiveSearch(k, x.right);
        }
    }

    /**
     * Search given value in binary tree using iterative search
     *
     * @param k
     * @return
     */
    public TreeNode iterativeSearch(int k) {
        TreeNode x = root;
        while (x != null && x.key != k) {
            if (k < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    /**
     * Find minimum using iterative approach
     *
     * @param x
     * @return
     */
    public TreeNode minimum(TreeNode x) {
        while (x != null && x.left != null) {
            x = x.left;
        }
        return x;
    }

    /**
     * Find minimum using recursive approach
     *
     * @param x
     * @return
     */
    public TreeNode recursiveMinimum(TreeNode x) {
        if (x != null && x.left != null) {
            return recursiveMinimum(x.left);
        }
        return x;
    }


    /**
     * Find minimum using iterative approach
     *
     * @param x
     * @return
     */
    public TreeNode maximum(TreeNode x) {
        while (x != null) {
            x = x.right;
        }
        return x;
    }

    /**
     * Find maximum using recursive approach
     *
     * @param x
     * @return
     */
    public TreeNode recursiveMaximum(TreeNode x) {
        if (x != null) {
            return recursiveMaximum(x.right);
        }
        return x;
    }

    /**
     * Find the successor of the given node value in binary tree
     *
     * @param k
     * @return
     */
    public TreeNode successor(int k) {
        TreeNode x = recursiveSearch(k, root);
        if (x != null && x.right != null) {
            return minimum(x);
        }

        TreeNode y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * Find predecessor of the given node in the binary tree
     *
     * @param k
     * @return
     */
    public TreeNode predecessor(int k) {
        TreeNode x = recursiveSearch(k, root);
        if (x != null && x.left != null) {
            return maximum(x);
        }

        TreeNode y = x.parent;
        while (y != null && x == y.left) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * Inserts node with value given in binary tree
     *
     * @param k
     */
    public void insert(int k) {
        TreeNode x = root;
        TreeNode y = x;
        while (x != null) {
            y = x;
            if (k < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        TreeNode z = new TreeNode(k);//Node to insert
        z.parent = y;
        if (y == null) {
            root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    /**
     * Delete node with value given from binary tree
     *
     * @param k
     */
    public void delete(int k) {
        TreeNode z = recursiveSearch(k, root);//Node to be deleted

        if (z.left == null) {
            transplant(z, z.right);
        } else if (z.right == null) {
            transplant(z, z.left);
        } else {
            TreeNode y = recursiveMinimum(z.right);
            if (y.parent != z) {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    }

    /**
     * This method transport v treenode to the position of u treenode
     * It only sorts out the parent linkages
     *
     * @param u
     * @param v
     */
    public void transplant(TreeNode u, TreeNode v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else if (u == u.parent.right) {
            u.parent.right = v;
        }

        if (v != null) {
            v.parent = u.parent;
        }
    }

    public void prettyPrint() {
        BTreePrinter.printNode(root);
    }

    public static class TreeNode<T> {
        private int key;
        private TreeNode parent;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public TreeNode getParent() {
            return parent;
        }

        public int getKey() {
            return key;
        }
    }

    public static class BTreePrinter {

        public static <T extends Comparable<?>> void printNode(TreeNode<T> root) {
            int maxLevel = BTreePrinter.maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }

        private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode<T>> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
                return;

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            BTreePrinter.printWhitespaces(firstSpaces);

            List<TreeNode<T>> newNodes = new ArrayList<TreeNode<T>>();
            for (TreeNode<T> node : nodes) {
                if (node != null) {
                    System.out.print(node.key);
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                BTreePrinter.printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    BTreePrinter.printWhitespaces(firstSpaces - i);
                    if (nodes.get(j) == null) {
                        BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).left != null)
                        System.out.print("/");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null)
                        System.out.print("\\");
                    else
                        BTreePrinter.printWhitespaces(1);

                    BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
                }

                System.out.println("");
            }

            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++)
                System.out.print(" ");
        }

        private static <T extends Comparable<?>> int maxLevel(TreeNode<T> node) {
            if (node == null)
                return 0;

            return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
        }

        private static <T> boolean isAllElementsNull(List<T> list) {
            for (Object object : list) {
                if (object != null)
                    return false;
            }

            return true;
        }

    }
}
