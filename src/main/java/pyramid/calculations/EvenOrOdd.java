package pyramid.calculations;

public enum EvenOrOdd {

        even(0), odd(1);
        private int num;

        EvenOrOdd(int num) {
            this.num = num;
        }

        public static EvenOrOdd getEvenOrOdd(int number) {
            return number % 2 == 0 ? even : odd;
        }


}
