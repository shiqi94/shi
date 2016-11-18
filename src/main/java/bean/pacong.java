package bean;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;



/**
 * Created by Administrator on 2016/11/9 0009.
 */
    public class  pacong{

        public static void main(String[] args) throws Exception {
            // TODO Auto-generated method stub
            String url_str = "http://www.boc.cn/sourcedb/whpj/index.html";
            String charset = "utf-8";
            String filepath = "d:/pachong/yinhang.html";

            HttpClient hc = new DefaultHttpClient();
            HttpGet hg = new HttpGet(url_str);
            HttpResponse response = hc.execute(hg);
            HttpEntity entity = response.getEntity();


            InputStream htm_in = null;

            if(entity != null){
                System.out.println(entity.getContentLength());
                htm_in = entity.getContent();
                String htm_str = InputStream2String(htm_in,charset);
                saveHtml(filepath,htm_str);
            }
        }


        public static void saveHtml(String filepath, String str){

            try {
                OutputStreamWriter outs = new OutputStreamWriter(new FileOutputStream(filepath, true), "utf-8");
                outs.write(str);
                outs.close();
            } catch (IOException e) {
                System.out.println("写入错误.");
                e.printStackTrace();
            }
        }

        public static String InputStream2String(InputStream in_st,String charset) throws IOException{
            BufferedReader buff = new BufferedReader(new InputStreamReader(in_st, charset));
            StringBuffer res = new StringBuffer();
            String line = "";
            while((line = buff.readLine()) != null){
                res.append(line);
            }
            return res.toString();
        }
    }

