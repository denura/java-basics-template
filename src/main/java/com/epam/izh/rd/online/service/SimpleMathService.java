package com.epam.izh.rd.online.service;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1 > value2) { // Warning: Can be replaced with 'Integer.compare'
            return 1;
        } else if (value1 < value2) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        if (value1 >= value2) { // Warning: Can be replaced with 'Math.max' call
            return value1;
        } else {
            return value2;
        }
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int result = values[0];
        for (int i = 0; i < values.length; i++) {
            if (values[i] > values[i++]) {
                result = values[i];
            } else {
                result = values[i++];
            }
        }
        return result;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int amount = 0;
        for (int value : values) {
            amount += value;
        }
        return amount;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int resultCount = 0;
        int[] tempArray = new int[values.length];
        for (int value : values) {
            if (value % 2 == 0) {
                tempArray[resultCount] = value;
                resultCount++;
            }
        }
        int[] resultArray = new int[resultCount];
        for (int n = 0; n < resultCount; n++) { // Warning: Manual array copy
            resultArray[n] = tempArray[n];
        }
        return resultArray;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        long factorial = 1;
        if (initialVal == 0) {
            return factorial;
        } else {
            for (int i = 1; i <= initialVal; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        if (number <= 1) {
            return number;
        } else {
            return calcFibonacci(number -1) + calcFibonacci(number - 2);
        }
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            int minValue = values[i];
            int minValue_i = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < minValue) {
                    minValue = values[j];
                    minValue_i = j;
                }
            }
            if (i != minValue_i) {
                int temp = values[i];
                values[i] = values[minValue_i];
                values[minValue_i] = temp;
            }
        }
        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        boolean isPrime = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int temp;
        for (int i = values.length - 1, j = 0; i >= values.length / 2; i--, j++) {
            temp = values[j];
            values[j] = values[i];
            values[i] = temp;
        }
        return values;
    }
}
