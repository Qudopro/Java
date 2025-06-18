package com.qudopro.ch05;

public class OperadoresLogicos {
    public static void main(String[] args){
        System.out.printf("%s%n%s\s%b%n", "AND Condicional", "True && True:", true && true);
        System.out.printf("%s%n%s\s%b%n", "AND Condicional", "True && False:", true && false);
        System.out.printf("%s%n%s\s%b%n", "AND Condicional", "False && True:", false && true);
        System.out.printf("%s%n%s\s%b%n", "AND Condicional", "False && False:", false && false);

        System.out.printf("%s%n%s\s%b%n", "OR Condicional", "True || True:", true || true);
        System.out.printf("%s%n%s\s%b%n", "OR Condicional", "True || False:", true || false);
        System.out.printf("%s%n%s\s%b%n", "OR Condicional", "False || True:", false || true);
        System.out.printf("%s%n%s\s%b%n", "OR Condicional", "False || False:", false || false);

        System.out.printf("%s%n%s\s%b%n", "AND Logico Booleano", "True & True:", true & true);
        System.out.printf("%s%n%s\s%b%n", "AND Logico Booleano", "True & False:", true & false);
        System.out.printf("%s%n%s\s%b%n", "AND Logico Booleano", "False & True:", false & true);
        System.out.printf("%s%n%s\s%b%n", "AND Logico Booleano", "False & False:", false & false);

        System.out.printf("%s%n%s\s%b%n", "OR Logico Booleano", "True | True:", true | true);
        System.out.printf("%s%n%s\s%b%n", "OR Logico Booleano", "True | False:", true | false);
        System.out.printf("%s%n%s\s%b%n", "OR Logico Booleano", "False | True:", false | true);
        System.out.printf("%s%n%s\s%b%n", "OR Logico Booleano", "False | False:", false | false);

        System.out.printf("%s%n%s\s%b%n", "OR Exclusivo", "True ^ True:", true ^ true);
        System.out.printf("%s%n%s\s%b%n", "OR Exclusivo", "True ^ False:", true ^ false);
        System.out.printf("%s%n%s\s%b%n", "OR Exclusivo", "False ^ True:", false ^ true);
        System.out.printf("%s%n%s\s%b%n", "OR Exclusivo", "False ^ False:", false ^ false);

        System.out.printf("%s%n%s\s%b%n", "Not", "!True:", !true);
        System.out.printf("%s%n%s\s%b%n", "Not", "!False:", !false);
    }
}
