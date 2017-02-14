package su.doma_dachi.inno.txt;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by User on 13.02.2017.
 */
public class Parser {
    public static AtomicBoolean flag = new AtomicBoolean(true);
    public static Map<String,Integer> words = new HashMap<>();

    /**
     *
     * @param resources разбиваем ресурсы между потоками
     */
    public static void parseResourcesForThread(String[] resources){
        for (String resource: resources){
            if(flag.get()){
                Thread thread = new Thread(new ThreadForRecource(resource));
                thread.start();
            } else {
                break;
            }
        }
    }

    /**
     *
     * @param path проверка пути на соответвие виду ресурса URL или файл на диске
     *        обращение к фунции создающей list - строк,
     *             затем добавление и подсчет ресурса в HashMap
     */
    public static void choiceResource (String path){
        if(Utils.isUrl(path)){
            for(String line: parseLinesFromURL(path)){
                Utils.addToHashMap(line);
            }
        }else{
            for (String line: parseLinesFromFile(path)) {
                Utils.addToHashMap(line);
            }
        }
    }

    /**
     *
     * @param path разбиваем файл с диска на строки и складываем в list
     * @return
     */
    private static List<String> parseLinesFromFile(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (Utils.filter(line)) {
                    list.add(line);
                } else {
                    flag.getAndSet(false);
                    throw new IOException("Ошибка в содержимом файла "+path);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    private static List<String> parseLinesFromURL(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(path).openStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (Utils.filter(line)) {
                    list.add(line);
                } else {
                    throw new IOException("Ошибка в содержимом файла "+path);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
