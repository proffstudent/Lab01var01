package su.doma_dachi.inno.txt.test;

import org.junit.jupiter.api.Disabled;
import su.doma_dachi.inno.txt.main.utils.Parser;
import su.doma_dachi.inno.txt.main.utils.Utils;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by User on 16.02.2017.
 */
class UtilsTest {
    private String str1;
    private String str2;
    private String str3;

    private String url1;
    private String url2;
    private String url3;
    private String path1;
    private String path2;
    private String url6;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        str1 = new String("Правильная, для - разбора строка: со знаками припинания!?");
        str2 = new String("Правильная для - разбора строка1 с459цифрами 89ва!?");
        str3 = new String("123, .343 . 45 !?");

        url1 = "http://doma-dachi.su/test.txt";
        url2 = "https://vk.com/doc9128441_442342059?hash=2814e97fc088373812&dl=3ab644878ff08ab446";
        url3 = "https://vk.com/doc9128441_442341986?hash=81625d7c7bf5292498&dl=ac2f85557c818debe6";
        path1 = "3.txt";
        path2 = "zadanie.txt";
        url6 = "zadanie2.txt";
    }

    @org.junit.jupiter.api.Test
    void isUrl() {
        assertTrue(Utils.isUrl(url1));
        assertTrue(Utils.isUrl(url2));
        assertTrue(Utils.isUrl(url3));

        assertFalse(Utils.isUrl(path1));
        assertFalse(Utils.isUrl(path2));
        assertFalse(Utils.isUrl(url6));
    }

    @org.junit.jupiter.api.Test
    void filter() {
        assertTrue(Utils.filter(str1));
        assertTrue(Utils.filter(str2));
        assertTrue(Utils.filter(str3));

        assertFalse(Utils.filter(path1));
        assertFalse(Utils.filter(path2));
        assertFalse(Utils.filter(url6));
    }

    @org.junit.jupiter.api.Test
    void addToHashMap() {
        Utils.addToHashMap(str1);
        assertTrue(Parser.words.size()==7);
        Parser.words.clear();
        Utils.addToHashMap(str2);
        assertTrue(Parser.words.size()==7);
        Parser.words.clear();
        Utils.addToHashMap(str3);
        assertTrue(Parser.words.size()==0);
    }

}