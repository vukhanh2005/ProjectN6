package nhom6;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 *
 * @author tdgia
 */
import org.jsoup.select.Elements;
public class LaptopScrawl {
    public static String getDataFromWeb(String url)
    {
        try{
            String rs = "";
            Document document = Jsoup.connect(url).get();
            Elements laptop = document.select(".product-info");
            
            System.out.println("=====================================");
            for(Element lt: laptop){
                String title = lt.select("h3").text();
                String price = lt.select(".product__price--show").text();
                rs += "NAME: " + title + " ---PRICE: " + price + "\n";
            }
            System.out.println(rs);
            return rs;
        } catch (IOException ex ){
            ex.printStackTrace();
            return null;
        }  
    }
}

