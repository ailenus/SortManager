package com.spartaglobal.ymao.model.sorters;

import com.spartaglobal.ymao.model.Sort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TreeSort extends Sort {

    private static final Logger LOGGER = LogManager.getLogger(TreeSort.class);

    private static final TreeSort TREE_SORT = new TreeSort();

    private TreeSort() {}

    public static TreeSort getInstance() {
        return TREE_SORT;
    }

    @Override
    protected void sortHelper(int[] array, int length) {
        LOGGER.info("Inside TreeSort.sortHelper.");
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(array, length);
        binaryTree.traverseInOrder(binaryTree.root, array, 0);
    }

    private static class BinaryTree {
        private Node root;

        private void insert(int[] array, int length) {
            for (int index = 0; index < length; index++) {
                insert(array[index]);
            }
        }

        private void insert(int key) {
            root = insert(root, key);
        }

        private Node insert(Node node, int key) {
            if (node == null) {
                node = new Node(key);
                return node;
            }
            if (key <= node.key) {
                node.left = insert(node.left, key);
            } else {
                node.right = insert(node.right, key);
            }
            return node;
        }

        private int traverseInOrder(Node node, int[] array, int index) {
            if (node != null) {
                if (node.left != null) {
                    index = traverseInOrder(node.left, array, index);
                }
                array[index] = node.key;
                index++;
                if (node.right != null) {
                    index = traverseInOrder(node.right, array, index);
                }
            }
            return index;
        }

        private static class Node {
            private final int key;
            private Node left;
            private Node right;

            private Node(int key) {
                this.key = key;
            }
        }
    }

}
