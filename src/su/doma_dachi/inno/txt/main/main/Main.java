package su.doma_dachi.inno.txt.main.main;

import su.doma_dachi.inno.txt.main.utils.Parser;

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
