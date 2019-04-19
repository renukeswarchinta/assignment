package pyramid.calculations;


public class NodeElementInPyramid {

    private int[] siblings;
    private long sum;
    private int currentIndex;
    private int lastIndexInPyramid;
    private EvenOrOdd isEvenOrOdd;

    public NodeElementInPyramid(long sum, int lastIndexInPyramid, EvenOrOdd evenOrOdd) {
        this.sum = sum;
        this.lastIndexInPyramid = lastIndexInPyramid;
        this.isEvenOrOdd = evenOrOdd;
    }


    public NodeElementInPyramid(int firstLineNumber) {
        sum = firstLineNumber;
        lastIndexInPyramid = 0;
        siblings = new int[2];
        isEvenOrOdd = EvenOrOdd.getEvenOrOdd(firstLineNumber);
    }


    public int[] getSiblings() {
        return siblings;
    }

    public long getSum() {
        return sum;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getLastIndexInPyramid() {
        return lastIndexInPyramid;
    }

    public EvenOrOdd getIsEvenOrOdd() {
        return isEvenOrOdd;
    }


}
