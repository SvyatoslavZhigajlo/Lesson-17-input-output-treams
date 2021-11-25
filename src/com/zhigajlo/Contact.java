package com.zhigajlo;

import java.io.Serializable;

public class Contact implements Serializable, Comparable {


    String firstName;
    String lastName;
    String phoneNumber;
    Integer yearOfBirth;

    public Contact(String firstName, String lastName, String phoneNumber, Integer yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return firstName + "|"+ lastName + "|"+ phoneNumber +"|" + yearOfBirth ;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
