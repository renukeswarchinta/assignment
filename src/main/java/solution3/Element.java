package solution3;

public class Element implements Comparable<Element>{

    private int index;
    private Parity parity;
    private Integer number;

    Element(ElemnetBuilder elemnetBuilder) {
        this.number = elemnetBuilder.number;
        this.index = elemnetBuilder.index;
        this.parity = elemnetBuilder.parity;
    }

    public int getIndex() {
        return index;
    }

    public Parity getParity() {
        return parity;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Elemnet{index=" + index + ", parity=" + parity + ", number=" + number + '}';
    }

    @Override
    public int compareTo(Element o) {
        return this.getNumber().compareTo(o.getNumber());
    }

    public static class ElemnetBuilder {
        private int index;
        private Parity parity;
        private int number;

        public ElemnetBuilder(int number) {
            this.number = number;
        }

        public ElemnetBuilder parity(Parity parity) {
            this.parity = parity;
            return this;
        }

        public ElemnetBuilder index(int index) {
            this.index = index;
            return this;
        }

        public Element build() {
            Element element = new Element(this);
            return element;
        }
    }

}
