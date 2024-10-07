
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String input = scanner.nextLine();

        try {
            String result = calculate(input);
            System.out.println("\"" + result + "\"");
        } catch (Exception var4) {
            System.err.println("Ошибка: " + var4.getMessage());
        }

        scanner.close();
    }

    public static String calculate(String input) throws Exception {
        String regex = "\"[^\"]{1,10}\"|\\d+|[\\+\\-\\*/]";
        Matcher matcher = Pattern.compile(regex).matcher(input.trim());
        String[] tokens = new String[3];

        int index;
        for(index = 0; matcher.find() && index < 3; tokens[index++] = matcher.group()) {
        }

        if (index != 3) {
            throw new Exception("Неверное количество аргументов");
        } else {
            String str1 = tokens[0];
            String operator = tokens[1];
            String str2 = tokens[2];
            if (str1.matches("\"[^\"]{1,10}\"") && isValidOperator(operator)) {
                str1 = str1.substring(1, str1.length() - 1);
                if (!operator.equals("/") && !operator.equals("*")) {
                    if (!str2.matches("\"[^\"]{1,10}\"")) {
                        throw new Exception("Второй аргумент должен быть строкой");
                    } else {
                        str2 = str2.substring(1, str2.length() - 1);
                        switch (operator) {
                            case "+":
                                return truncate(str1 + str2);
                            case "-":
                                return truncate(subtractStrings(str1, str2));
                            default:
                                throw new Exception("Неподдерживаемая операция");
                        }
                    }
                } else if (!str2.matches("\\d+")) {
                    throw new Exception("Второй аргумент должен быть числом");
                } else {
                    int number = Integer.parseInt(str2);
                    if (number >= 1 && number <= 10) {
                        return operator.equals("*") ? truncate(repeatString(str1, number)) : truncate(divideString(str1, number));
                    } else {
                        throw new Exception("Число должно быть от 1 до 10");
                    }
                }
            } else {
                throw new Exception("Некорректный ввод");
            }
        }
    }

    private static boolean isValidOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    private static String subtractStrings(String str1, String str2) {
        return str1.replace(str2, "");
    }

    private static String repeatString(String str, int n) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < n; ++i) {
            result.append(str);
        }

        return result.toString();
    }

    private static String divideString(String str, int n) {
        int newLength = str.length() / n;
        return newLength == 0 ? "" : str.substring(0, newLength);
    }

    private static String truncate(String result) {
        return result.length() > 40 ? result.substring(0, 40) + "..." : result;
    }
}
