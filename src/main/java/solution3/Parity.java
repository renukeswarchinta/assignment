package solution3;

public enum Parity {

    even("even"),odd("odd");
    private String number;

    private Parity(String number) {
        this.number = number;
    }

    public static Parity getParity(int number) {
        return number % 2 == 0 ? even : odd;
    }
}
