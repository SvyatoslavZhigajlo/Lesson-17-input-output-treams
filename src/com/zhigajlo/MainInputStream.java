package com.zhigajlo;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MainInputStream {

    public static void main(String[] args) {
        new MainInputStream().run();
    }

    private void run() {
        try {
            inputData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            inputContactsList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //  ДЗ 20 Задание 3 -  Открыть текстовый файл и прочитать из него максимум 100 целых чисел.
    //  Найти среднее значение прочитанных положительных чисел
    private void inputData() throws FileNotFoundException {

        Collection<Integer> values = new ArrayList<>();
        try (Scanner scanner = new Scanner(
                new FileInputStream("randomNumb.txt"), StandardCharsets.UTF_8)) {
            int i = 0;
            scanner.useDelimiter(",");
            while (scanner.hasNextInt() && i < 100) {
                int value = scanner.nextInt();
                if (value > 0) {
                    values.add(value);
                }
                i++;
            }
        }
        double average = average(values);
        System.out.println("Среднее значение первых 100 элементов с файла = " + average);

    }

    //расчет среднего значения коллекции случайных положительных чисел
    private double average(Collection<Integer> values) {
        double average = 0;
        if (values.size() > 0) {
            double sum = 0;
            for (int j = 0; j < values.size(); j++) {
                sum += values.size();
            }
            average = sum / values.size();
        }
        return average;
    }

    //ДЗ 20 Задание 5 - Прочитать из текстового файла список контактов в заданном формате,
    // сортировать по году рождения и вывести на экран максимум 5 контактов
    private void inputContactsList() throws FileNotFoundException {
        List<Contact> values = new ArrayList<>();
        Collection<String> stringCollection = new ArrayList<>();
        try (Scanner scanner = new Scanner(
                new FileInputStream("contactsList.txt"), StandardCharsets.UTF_8.name())) {
            while (scanner.hasNextLine()) {
                stringCollection.add(scanner.nextLine());
            }
        }
        for (String resultStringCollection : stringCollection) {
            String[] lineString = resultStringCollection.split("[|]");
            values.add(new Contact(lineString[0], lineString[1], lineString[2], Integer.valueOf(lineString[3])));
        }
        values.sort((o1, o2) -> o1.yearOfBirth - o2.yearOfBirth);

        System.out.println("Вывести на экран максимум 5 контактов");
        int i = 0;
        for (Contact show5Contacts : values) {
            if (i < 5) {
                System.out.println(show5Contacts);
                i++;
            }
        }
    }


}
