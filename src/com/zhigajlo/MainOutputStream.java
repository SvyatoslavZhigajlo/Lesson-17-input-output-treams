package com.zhigajlo;

import java.io.*;
import java.util.*;

public class MainOutputStream {

    public static void main(String[] args) {
        new MainOutputStream().run();
    }

    private void run() {
        Collection<Contact> contactsList = creatingContacts();
        try {
            outputData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            outputIntRandom();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            outputContactsList(contactsList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //ДЗ20 Задание 1 - Создать текстовый файл и записать в него “Hello, world!”
    private void outputData() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(
                new FileOutputStream("text.txt"))) {
            writer.println("Hello, world");
        }
    }

    //ДЗ 20 Задание 2 -Создать текстовый файл и записать в него 1000 случайных целых чисел в
    // диапазоне от -500 до 650, разделенных пробелами.
    private void outputIntRandom() throws FileNotFoundException {
        try (PrintWriter writerRandomNumb = new PrintWriter(new FileOutputStream("randomNumb.txt"))) {
            for (int i = 0; i <= 1000; i++) {
                writerRandomNumb.print(-500 + (int) (Math.random() * 650));
                writerRandomNumb.print(",");
            }
        }
    }

    //Создание листа контактов
    private Collection<Contact> creatingContacts() {
        Collection<Contact> contactsList = new ArrayList<>();
        Contact contact1 = new Contact("Святослав1", "Жигайло",
                "(066)111-11-11", 1988);
        Contact contact2 = new Contact("Святослав2", "Жигайло",
                "(066)222-22-22", 1988);
        Contact contact3 = new Contact("Святослав3", "Жигайло",
                "(066)333-33-33", 1981);
        Contact contact4 = new Contact("Святослав4", "Жигайло",
                "(066)444-44-44", 1985);
        Contact contact5 = new Contact("Святослав5", "Жигайло",
                "(066)555-55-55", 1956);
        Contact contact6 = new Contact("Святослав6", "Жигайло",
                "(066)666-66-66", 1958);
        Contact contact7 = new Contact("Святослав7", "Жигайло",
                "(066)777-77-77", 1983);
        Contact contact8 = new Contact("Святослав8", "Жигайло",
                "(066)888-88-88", 1962);
        Contact contact9 = new Contact("Святослав9", "Жигайло",
                "(066)999-99-99", 1990);
        Contact contact10 = new Contact("Святослав10", "Жигайло",
                "(066)123-45-67", 1988);

        contactsList.add(contact1);
        contactsList.add(contact2);
        contactsList.add(contact3);
        contactsList.add(contact4);
        contactsList.add(contact5);
        contactsList.add(contact6);
        contactsList.add(contact7);
        contactsList.add(contact8);
        contactsList.add(contact9);
        contactsList.add(contact10);
        return contactsList;
    }

    //ДЗ 20 Задание 4 - Сохранить в текстовый файл список контактов (минимум 10, каждый с новой строки)
    // в заданном формате: Имя | Фамилия | Телефон | Год рождения
    private void outputContactsList(Collection<Contact> contactsList) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("contactsList.txt"))) {
            for (Contact allContacts : contactsList) {
                writer.println(allContacts);
            }
        }
    }

}
