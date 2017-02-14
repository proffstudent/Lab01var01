package su.doma_dachi.inno.txt;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by User on 13.02.2017.
 */
public class Utils {
    
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
            System.out.println("Cтрока не содержит URL");
            return false;
        }
    }

    /**
     *
     * @param line
     * @return true если строка содержит только валидные символы, иначе false
     * hashSet - содержит все валидные символы
     * @throws IOException
     */
    public static boolean filter(String line) throws IOException{
        HashSet<Character> hashSet = new HashSet<Character>();
        hashSet.add((char)13);hashSet.add((char)10);
        hashSet.add((char)32);hashSet.add((char)33);hashSet.add((char)34);hashSet.add((char)44);
        hashSet.add((char)45);hashSet.add((char)46);hashSet.add((char)48);hashSet.add((char)49);hashSet.add((char)50);
        hashSet.add((char)51);hashSet.add((char)52);hashSet.add((char)53);hashSet.add((char)54);hashSet.add((char)55);
        hashSet.add((char)56);hashSet.add((char)57);hashSet.add((char)58);hashSet.add((char)59);hashSet.add((char)63);
        hashSet.add((char)1040);hashSet.add((char)1041); hashSet.add((char)1042); hashSet.add((char)1043);
        hashSet.add((char)1044);hashSet.add((char)1045); hashSet.add((char)1046); hashSet.add((char)1047);
        hashSet.add((char)1048);hashSet.add((char)1049); hashSet.add((char)1050); hashSet.add((char)1051);
        hashSet.add((char)1052); hashSet.add((char)1053); hashSet.add((char)1054); hashSet.add((char)1055);
        hashSet.add((char)1056); hashSet.add((char)1057); hashSet.add((char)1058); hashSet.add((char)1059);
        hashSet.add((char)1060);
        hashSet.add((char)1061); hashSet.add((char)1062); hashSet.add((char)1063); hashSet.add((char)1064);
        hashSet.add((char)1065); hashSet.add((char)1066); hashSet.add((char)1067); hashSet.add((char)1068);
        hashSet.add((char)1069); hashSet.add((char)1070); hashSet.add((char)1071); hashSet.add((char)1072);
        hashSet.add((char)1073); hashSet.add((char)1074); hashSet.add((char)1075); hashSet.add((char)1076);
        hashSet.add((char)1077); hashSet.add((char)1078); hashSet.add((char)1079); hashSet.add((char)1080);
        hashSet.add((char)1081); hashSet.add((char)1082); hashSet.add((char)1083); hashSet.add((char)1084);
        hashSet.add((char)1085); hashSet.add((char)1086); hashSet.add((char)1087); hashSet.add((char)1088);
        hashSet.add((char)1089); hashSet.add((char)1090); hashSet.add((char)1091); hashSet.add((char)1092);
        hashSet.add((char)1093);hashSet.add((char)1094); hashSet.add((char)1095); hashSet.add((char)1096);
        hashSet.add((char)1097);hashSet.add((char)1098);hashSet.add((char)1099);
        hashSet.add((char)1100);hashSet.add((char)1101);hashSet.add((char)1102);
        hashSet.add((char)1103);
        int i = 0;
        char[] charLine = line.toCharArray();
        while (i < charLine.length) {
            if (!hashSet.contains(charLine[i])) {
                System.out.println("Не валидный символ: " + charLine[i]);
                return false;
            }
            i++;
        }
        System.out.println("Валидная строка");
        return true;
    }

    /**
     *
     * @param line разбиваем строку на ресурсы
     *             words - HashMap - содержит ресурсы и количество вхождений
     *
     */
    public static void addToHashMap(String line) {
        synchronized (Parser.words) {
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter("[\\s\\p{Punct}0-9]+");
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (Parser.words.containsKey(word)) {
                    Parser.words.put(word, Parser.words.get(word) + 1);
                    System.out.println(word + " " + Parser.words.get(word));
                } else {
                    Parser.words.put(word, 1);
                    System.out.println(word + " " + Parser.words.get(word));
                }
            }
        }
    }
}
