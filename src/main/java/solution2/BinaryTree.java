package solution2;

import pyramid.calculations.EvenOrOdd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;



    public Node add(int value) {
        return new Node(value, EvenOrOdd.getEvenOrOdd(value), 0,"main");
    }


    public Node add(String[] nextRowNumbers, Node node) {


        MaxValueWithIndex maxValueWithIndex = getMaximumNumberfromSiblingsIfBothAreEvenOrOdd(nextRowNumbers, node);
        if (maxValueWithIndex.getMaximumValue() != 0) {
            if (maxValueWithIndex.getMaximumValue() == Integer.parseInt(nextRowNumbers[node.getIndex()])) {

                node.setLeft(new Node(maxValueWithIndex.getMaximumValue(),
                        EvenOrOdd.getEvenOrOdd(maxValueWithIndex.getIndex()),
                        maxValueWithIndex.getIndex(),
                        "left"));
                node.setUpdatedSum(node.getUpdatedSum()+maxValueWithIndex.getMaximumValue());
            } else {
                node.setRight(new Node(maxValueWithIndex.getMaximumValue(),
                        EvenOrOdd.getEvenOrOdd(maxValueWithIndex.getIndex()),
                        maxValueWithIndex.getIndex(),
                        "right"));
                node.setUpdatedSum(node.getUpdatedSum()+maxValueWithIndex.getMaximumValue());
            }
            return node;
        }
        for (int index = node.getIndex(); index < node.getIndex() + 2; index++) {
            if (!EvenOrOdd.getEvenOrOdd(Integer.parseInt(nextRowNumbers[index])).equals(node.getEvenOrOdd())) {

                node.setLeft(new Node(Integer.parseInt(nextRowNumbers[node.getIndex()]),
                        EvenOrOdd.getEvenOrOdd(Integer.parseInt(nextRowNumbers[node.getIndex()])),
                        node.getIndex(),"left"));
                node.setUpdatedSum(node.getUpdatedSum()+Integer.parseInt(nextRowNumbers[node.getIndex()]));
                break;

            } else {
                node.setRight(new Node(Integer.parseInt(nextRowNumbers[node.getIndex() + 1]),
                                        EvenOrOdd.getEvenOrOdd(Integer.parseInt(nextRowNumbers[node.getIndex() + 1])),
                                        node.getIndex() + 1,"right"));
                node.setUpdatedSum(node.getUpdatedSum()+Integer.parseInt(nextRowNumbers[node.getIndex()+1]));
                break;
            }
        }
        return node;

    }

    private MaxValueWithIndex getMaximumNumberfromSiblingsIfBothAreEvenOrOdd(String[] nextRowNumbers, Node node) {
        MaxValueWithIndex maxValueWithIndex = new MaxValueWithIndex();
        if (EvenOrOdd.getEvenOrOdd(Integer.parseInt(nextRowNumbers[node.getIndex()])).equals(EvenOrOdd.getEvenOrOdd(Integer.parseInt(nextRowNumbers[node.getIndex() + 1])))) {
            if (Integer.parseInt(nextRowNumbers[node.getIndex()]) > Integer.parseInt(nextRowNumbers[node.getIndex() + 1])) {
                return new MaxValueWithIndex(Integer.parseInt(nextRowNumbers[node.getIndex()]), node.getIndex());
            } else {
                return new MaxValueWithIndex(Integer.parseInt(nextRowNumbers[node.getIndex() + 1]), node.getIndex() + 1);
            }
            //Arrays.asList(nextRowNumbers).stream().max(Comparator::comparing)

        }
        return new MaxValueWithIndex(0, 0);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.getLeft()) + 1 + getSizeRecursive(current.getRight());
    }

    /* public boolean containsNode(int value) {
         return containsNodeRecursive(root, value);
     }

     private boolean containsNodeRecursive(Node current, int value) {
         if (current == null) {
             return false;
         }

         if (value == current.getValue()) {
             return true;
         }

         return value < current.getValue
                 ? containsNodeRecursive(current.left, value)
                 : containsNodeRecursive(current.right, value);
     }

     public void delete(int value) {
         root = deleteRecursive(root, value);
     }

     private Node deleteRecursive(Node current, int value) {
         if (current == null) {
             return null;
         }

         if (value == current.value) {
             // Case 1: no children
             if (current.left == null && current.right == null) {
                 return null;
             }

             // Case 2: only 1 child
             if (current.right == null) {
                 return current.left;
             }

             if (current.left == null) {
                 return current.right;
             }

             // Case 3: 2 children
             int smallestValue = findSmallestValue(current.right);
             current.value = smallestValue;
             current.right = deleteRecursive(current.right, smallestValue);
             return current;
         }
         if (value < current.value) {
             current.left = deleteRecursive(current.left, value);
             return current;
         }

         current.right = deleteRecursive(current.right, value);
         return current;
     }

     private int findSmallestValue(Node root) {
         return root.left == null ? root.value : findSmallestValue(root.left);
     }
 */
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.print(" " + node.getValue());
            traverseInOrder(node.getRight());
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.getValue());
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.getLeft());
            traversePostOrder(node.getRight());
            System.out.print(" " + node.getValue());
        }
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.getValue());

            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
            }

            if (node.getLeft() != null) {
                nodes.add(node.getRight());
            }
        }
    }


    static class MaxValueWithIndex {
        private int maximumValue;
        private int index;

        public MaxValueWithIndex(int maximumValue, int index) {
            this.maximumValue = maximumValue;
            this.index = index;
        }

        public MaxValueWithIndex() {

        }

        public int getMaximumValue() {
            return maximumValue;
        }

        public void setMaximumValue(int maximumValue) {
            this.maximumValue = maximumValue;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
