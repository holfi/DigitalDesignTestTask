public class Validation {

    public static boolean isValid(String s) {
        if (!checkPattern(s)) {
            System.out.println("Invalid symbols");
            return false;
        }

        if (!checkBrackets(s)) {
            System.out.println("Invalid number of brackets");
            return false;
        }

        return true;
    }

    // Проверка на допустимые символы
    public static boolean checkPattern(String s) {
        return s.matches("[a-zA-Z\\[\\]\\d]+");
    }

    // Проверка на число скобок
    public static boolean checkBrackets(String s) {
        int counter = 0;

        for (char c : s.toCharArray()) {
            if (c == '[')
                counter++;
            else if (c == ']')
                counter--;
            if (counter < 0) {
                return false;
            }
        }

        return counter == 0;
    }

}
