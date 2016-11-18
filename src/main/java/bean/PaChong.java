package bean;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class PaChong {

    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

        URL url = new URL("http://www.boc.cn/sourcedb/whpj/index.html");
        URLConnection conn = url.openConnection();
        conn.setReadTimeout(10000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
//        Pattern pattern = Pattern.compile("(?<=\\<td\\>)[^<,^>](?=\\</td\\>)");
//        Matcher matcher = pattern.matcher(sb.toString());
//        while (matcher.find()){
//            System.out.println(matcher.group(0));
//        }
        Document doc = Jsoup.parse(sb.toString());
//        Elements links = doc.select("th");
//        String text = links.text();
//        System.out.println(text);
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase db = client.getDatabase("test");
        MongoCollection coll = db.getCollection("ceshi");

        Entity entity = new Entity();
        ArrayList list = new ArrayList();
        Elements element = doc.getElementsByTag("tbody");
        Element el = element.get(1);
        Elements ele = el.getElementsByTag("tr");

        for (int i = 1; i < ele.size(); i++) {
            Element a = ele.get(i);
            Elements b = a.getElementsByTag("td");
            for (int j = 0; j < b.size(); j++) {
                Element c = b.get(j);
                String text = c.text();
                list.add(text);
                //entity.setName(text);
            }
            entity.setName((String) list.get(0));
            entity.setSpotpurchase(list.get(1).equals("") ? null : Double.parseDouble((String) list.get(1)));
            entity.setCashpurchase(list.get(2).equals("") ? null : Double.parseDouble((String) list.get(2)));
            entity.setSpotsellout(list.get(3).equals("") ? null : Double.parseDouble((String) list.get(3)));
            entity.setCashsellout(list.get(4).equals("") ? null : Double.parseDouble((String) list.get(4)));
            entity.setDiscountprice(list.get(5).equals("") ? null : Double.parseDouble((String) list.get(5)));

            entity.setReleasedate(sdfDate.parse((String) list.get(6)));
            entity.setReleasetime(sdfTime.parse((String) list.get(7)));

            list.clear();

            org.bson.Document document = new org.bson.Document();
            document.append("name", entity.getName());
            document.append("spotpurchase", entity.getSpotpurchase());
            document.append("cashpurchase", entity.getCashpurchase());
            document.append("spotsellout", entity.getSpotsellout());
            document.append("cashsellout", entity.getCashsellout());
            document.append("discountprice", entity.getDiscountprice());
            document.append("releasedate", entity.getReleasedate());
            document.append("releasetime", entity.getReleasetime());

            coll.insertOne(document);

        }

//        for (Element elem:ele) {
//            entity.setName(elem.text());
//
//            String text = elem.text();
//           // System.out.println(text);
//        }
    }

}
