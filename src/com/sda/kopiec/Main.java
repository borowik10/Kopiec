package com.sda.kopiec;

public class Main {
    public static void main(String[] args) {

        Kopiec kopiec = new Kopiec();
        kopiec.add(3);
        kopiec.add(9);
        kopiec.add(5);
        kopiec.add(10);
        kopiec.add(2);
        kopiec.add(7);
        kopiec.add(4);
        kopiec.add(8);

        kopiec.show();

        kopiec.pop();
        System.out.println();
        System.out.println("POP");

        kopiec.show();
    }
}
