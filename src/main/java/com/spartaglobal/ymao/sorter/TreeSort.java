package com.spartaglobal.ymao.sorter;

public class TreeSort extends Sort {

    @Override
    protected void sortHelper(int[] array, int length) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(array);
        binaryTree.traverseInOrder(binaryTree.root, array, 0);
    }

    private class BinaryTree {
        Node root;

        private void insert(int[] array) {
            for (int index = 0; index < array.length; index++) {
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
            if (key < node.key) {
                node.left = insert(node.left, key);
            } else if (key > node.key) {
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

        private class Node {
            int key;
            Node left;
            Node right;

            private Node(int key) {
                this.key = key;
            }
        }
    }

}
