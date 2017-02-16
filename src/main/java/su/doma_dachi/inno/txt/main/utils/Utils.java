package su.doma_dachi.inno.txt.main.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by User on 13.02.2017.
 */
public class Utils {
    private static final Logger logger = Logger.getLogger(Utils.class);

    static {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }
    /**
     * @param line
     * @return true если верный URL, иначе false
     * Метод позволяет определить доступен ли ресурс по URL
     */
    public static boolean isUrl(String line){
        try{
            URL url = new URL(line);
            return true;
        } catch (MalformedURLException e) {
            logger.info("Cтрока не содержит URL");
            return false;
        }
    }

    /**
     *
     * @param line
     * @return true если строка содержит только валидные символы, иначе false     *
     */
    public static boolean filter(String line){
        return !line.matches("^.*[a-zA-Z]+.*$");
    }

    /**
     *
     * @param line разбиваем строку на ресурсы
     *             words - HashMap - содержит ресурсы и количество вхождений
     *
     */
    public static void addToHashMap(String line) {
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter("[\\s\\p{Punct}0-9]+");
            while (scanner.hasNext()) {
                String word = scanner.next();
                synchronized (Parser.flag) {
                    if(Parser.flag.get()) {
                        if (Parser.words.containsKey(word)) {
                            Parser.words.put(word, Parser.words.get(word) + 1);
                            logger.info(word + " " + Parser.words.get(word));
                        } else {
                            Parser.words.put(word, 1);
                            logger.info(word + " " + Parser.words.get(word));
                        }
                    }
                }
            }

    }
}
