package su.doma_dachi.inno.txt;

import java.io.*;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Main.go(args);
    }

    /**
     *
     * @param args считываем аргументы командной строки и начинаем разбор ресурсов
     */
    public static void go(String[] args){
        Parser.parseResourcesForThread(args);
    }



}
