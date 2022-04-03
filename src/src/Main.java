package src;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;




class calc {
    static Scanner scanner = new Scanner(System.in);
    static int num1, num2;
    static char operation;
    static int result;
    //Решение должно содержать данный метод

    public static void main (String[] args)  throws IOException {
        System.out.println("Введите выражение 2+2 или V+V, введите Enter: ");
//      Считываем строку Input которую ввёл пользователь
        String Input = scanner.nextLine();
//      Создаём пустой символьный массив длиной 10 символов:  under_char
        char[] under_char = new char[10];

//      Ловим знак операции и заполняем массивы
        for (int i = 0; i < Input.length(); i++) {
            under_char[i] = Input.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        num1 = romToNumb(stable00);
        num2 = romToNumb(string03);
        if (num1 < 0 && num2 < 0) {
            result = 0;
        } else {
            result = calculated(num1, num2, operation);
            String resultRoman = convertNumToRom(result);
            System.out.println("Результат :"+stable00 + " " + operation + " " + string03 + " = " + resultRoman);
        }
        num1 = Integer.parseInt(stable00);
        num2 = Integer.parseInt(string03);
        if (num1 > 10 || num1 < 1) { // исключение
            throw new IOException();
        }
        result = calculated(num1, num2, operation);
        System.out.println("Результат: " +num1 + " " + operation + " " + num2 + " = " + result);

    }

    private static String convertNumToRom (int numArabian) { //метод конвертации из арабских в римские
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X","XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        final String s = roman[numArabian];
        return s;
    }


    private static int romToNumb (String roman) { //метод конвертации римских в арабские
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    static int calculated (int num1, int num2, char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}



