package solution2;

import pyramid.calculations.EvenOrOdd;
/*
* Binary Tree
* */
public class BinaryTree {
	
	//Comments are for brach mergin in dev
    Node root;

    /**
     * Will set left Node and right Nodes with even or odd values in each level
     * @param nextRowNumbers
     * @param node
     * @param rootNode
     * @return
     */
    public Node add(String[] nextRowNumbers, Node node,Node rootNode) {
        MaxValueWithIndex maxValueWithIndex = getMaximumNumberfromSiblingsIfBothAreEvenOrOdd(nextRowNumbers, node);
        if (maxValueWithIndex.getMaximumValue() != 0) {
            if (maxValueWithIndex.getMaximumValue() == Integer.parseInt(nextRowNumbers[node.getIndex()])) {

                node.setLeft(new Node(maxValueWithIndex.getMaximumValue(),
                        EvenOrOdd.getEvenOrOdd(maxValueWithIndex.getIndex()),
                        maxValueWithIndex.getIndex(),
                        "left"));
                rootNode.setUpdatedSum(rootNode.getUpdatedSum()+maxValueWithIndex.getMaximumValue());
            } else {
                node.setRight(new Node(maxValueWithIndex.getMaximumValue(),
                        EvenOrOdd.getEvenOrOdd(maxValueWithIndex.getIndex()),
                        maxValueWithIndex.getIndex(),
                        "right"));
                rootNode.setUpdatedSum(rootNode.getUpdatedSum()+maxValueWithIndex.getMaximumValue());
            }
            return node;
        }
        for (int index = node.getIndex(); index < node.getIndex() + 2; index++) {
            if (!EvenOrOdd.getEvenOrOdd(Integer.parseInt(nextRowNumbers[index])).equals(node.getEvenOrOdd())) {

                node.setLeft(new Node(Integer.parseInt(nextRowNumbers[node.getIndex()]),
                        EvenOrOdd.getEvenOrOdd(Integer.parseInt(nextRowNumbers[node.getIndex()])),
                        node.getIndex(),"left"));
                rootNode.setUpdatedSum(rootNode.getUpdatedSum()+Integer.parseInt(nextRowNumbers[node.getIndex()]));
                break;

            } else {
                node.setRight(new Node(Integer.parseInt(nextRowNumbers[node.getIndex() + 1]),
                                        EvenOrOdd.getEvenOrOdd(Integer.parseInt(nextRowNumbers[node.getIndex() + 1])),
                                        node.getIndex() + 1,"right"));
                rootNode.setUpdatedSum(rootNode.getUpdatedSum()+Integer.parseInt(nextRowNumbers[node.getIndex()+1]));
                break;
            }
        }
        return node;

    }

    private MaxValueWithIndex getMaximumNumberfromSiblingsIfBothAreEvenOrOdd(String[] nextRowNumbers, Node node) {
        if (EvenOrOdd.getEvenOrOdd(Integer.parseInt(nextRowNumbers[node.getIndex()])).equals(EvenOrOdd.getEvenOrOdd(Integer.parseInt(nextRowNumbers[node.getIndex() + 1])))) {
            if (Integer.parseInt(nextRowNumbers[node.getIndex()]) > Integer.parseInt(nextRowNumbers[node.getIndex() + 1])) {
                return new MaxValueWithIndex(Integer.parseInt(nextRowNumbers[node.getIndex()]), node.getIndex());
            } else {
                return new MaxValueWithIndex(Integer.parseInt(nextRowNumbers[node.getIndex() + 1]), node.getIndex() + 1);
            }
        }
        return new MaxValueWithIndex(0, 0);
    }

    static class MaxValueWithIndex {
        private int maximumValue;
        private int index;

        public MaxValueWithIndex(int maximumValue, int index) {
            this.maximumValue = maximumValue;
            this.index = index;
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
