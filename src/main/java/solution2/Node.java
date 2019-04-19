package solution2;

import pyramid.calculations.EvenOrOdd;

public class Node {

    private int value;
    private Node left;
    private Node right;
    private EvenOrOdd evenOrOdd;
    private String direction;
    private int index;
    private long updatedSum;

    Node(int value, EvenOrOdd evenOrOdd,int index,String direction) {
        this.value = value;
        this.right = null;
        this.left = null;
        this.evenOrOdd = evenOrOdd;
        this.index = index;
        this.direction =direction;

    }


    public long getUpdatedSum() {
        return updatedSum;
    }

    public void setUpdatedSum(long updatedSum) {
        this.updatedSum = updatedSum;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public EvenOrOdd getEvenOrOdd() {
        return evenOrOdd;
    }
}
