package com.mock;

import java.util.Scanner;

public class Authentication{

    static private String[][] users = {
            {"george",  "juan",         "maynez", "miguel", "sammy", "daniel", "paulina","kenneth"},
            {"georgie", "juantwothree", "minus",  "migg",   "Tinev", "villa2", "Pau",    "kennY"},
            {"0",       "1",            "2",      "3",      "0",     "1",      "2",      "3"}};

    static public int login(String user, String password){

        for(int i = 0; i < users[0].length; i++){

            if(users[0][i].equals(user.toLowerCase())){return Integer.parseInt(users[2][i]);}
        }
        return -1;
    }

    /*
    public static void main(String[] args){

        for(int i = 0; i < users[0].length; i++){System.out.println(users[0][i]);}
        System.out.println("Enter username");
        Scanner scnr = new Scanner(System.in);
        String user = scnr.nextLine();
        System.out.println("Enter password");
        String pw = scnr.nextLine();
        System.out.println(login(user, pw));

    }
    */
}
