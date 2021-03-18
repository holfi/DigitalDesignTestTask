import java.util.Scanner;

public class Main {
    /*
    Написать на Java программу распаковывания строки. На вход поступает строка вида число[строка], на выход - строка, содержащая повторяющиеся подстроки.

    Пример:
    Вход: 3[xyz]4[xy]z
    Выход: xyzxyzxyzxyxyxyxyz

    Ограничения:
    - одно повторение может содержать другое. Например: 2[3[x]y]  = xxxyxxxy
    - допустимые символы на вход: латинские буквы, числа и скобки []
    - числа означают только число повторений
    - скобки только для обозначения повторяющихся подстрок
    - входная строка всегда валидна.

    Дополнительное задание:
    Проверить входную строку на валидность.

    */
    public static void main(String[] args) {

        // Ввод строки
        System.out.print("Enter string: ");
        String s = new Scanner(System.in).nextLine();

        // Проверка валидности строки
        if (Validation.isValid(s)) {
            StringBuilder sb = new StringBuilder(s);

            // Пока строка содержит "["
            while (sb.toString().contains("[")) {
                String substr = "";

                // Получение последней "["
                int startBracket = sb.lastIndexOf("[");

                // Получение "]" от последней "["
                int endBracket = sb.indexOf("]", startBracket);

                // Получение индекса цифры до "["
                int digit = startBracket - 1;

                // Парсинг цифры
                int count = Integer.parseInt(sb.substring(digit, startBracket));

                // Замена цифр со скобками на строку
                for (int i = 0; i < count; i++) {
                    substr += sb.substring(startBracket + 1, endBracket);
                }
                sb.replace(digit, endBracket + 1, substr);

            }

            System.out.println("Output: " + sb.toString());
        }

    }

}
