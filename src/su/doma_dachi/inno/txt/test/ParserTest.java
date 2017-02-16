package su.doma_dachi.inno.txt.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import su.doma_dachi.inno.txt.main.utils.Parser;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by User on 16.02.2017.
 */
class ParserTest {
    private String str1;
    private String str2;
    private String str3;

    private String url1;
    private String url2;
    private String url3;
    private String path1;
    private String path2;
    private String path3;

    @BeforeEach
    void setUp() {
        url1 = "http://doma-dachi.su/test.txt";
        url2 = "https://vk.com/doc9128441_442342059?hash=2814e97fc088373812&dl=3ab644878ff08ab446";
        url3 = "https://vk.com/doc9128441_442341986?hash=81625d7c7bf5292498&dl=ac2f85557c818debe6";
        path1 = "3.txt";
        path2 = "zadanie.txt";
        path3 = "zadanie2.txt";

    }

    @Disabled
    void parseResourcesForThread() {
        String[] args = {url1,url2,url3, path1,path2, path3};
    }

    @Test
    void choiceResource() {

    }

}