package utils;

public class Utility {

    public static boolean isNumberic(String line){
        return line.matches("-?\\d+(.\\d+)?");
    }

    public static boolean isEvenOrOdd(int firstLineNumber) {
        return firstLineNumber % 2 == 0 ? true   : false;
    }
}
