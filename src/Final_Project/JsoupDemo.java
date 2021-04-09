package Final_Project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupDemo {
    public static void main(String[] args) {
        try{
            Document documentUrl = Jsoup.connect("https://dining.purdue.edu/menus/").get();
            String title = documentUrl.title();
            Element body = documentUrl.getElementById("app");
            Elements test = body.select("./assets/css/preloadSpinner.css");
            //Elements test = body.select(".MuiPaper-root MuiPaper-elevation8 MuiPaper-rounded");
            System.out.println(body);

            for (Element a: test) {
                System.out.println(a);
            }

            System.out.println(title);

        } catch (IOException e) {
            System.out.println("Error: Suggest URL cannot be opened");
        }

    }
}
