package self.codingTest.dkTechIn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args){
        File file = new File("C:\\Users\\qiiop\\OneDrive\\Desktop\\personal\\코딩테스트\\디케이테크인_코딩테스트_java\\input2.log");
        try (
            FileInputStream inputStream = new FileInputStream(file);
            BufferedReader inFiles = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            ){

            String line = "";
            String regex = "[\\[](.*?)[\\]]";
            List<String[]> list = new ArrayList();

            while((line = inFiles.readLine()) != null) {
                if(line.trim().length() > 0) {
                    // ☞  바로 위쪽 라인만 직접 작성
                    //   : 한 라인 읽을 때마다 a에 더하는 로직
                    String[] strArr = line.split(regex);
                    list.add(strArr);
                    //System.out.println(line);
                }
            }

            System.out.println(getApikey("http://apis.daum.net/search/vclip?apikey=2jdc&q=daum"));

        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getApikey(String strUrl) {
        URL url;
        String apikey = "";
        try {
            url = new URL(strUrl);

            String pattern = "^[A-Za-z[0-9]]{4}$"; // 영문, 숫자
            Matcher match;
            boolean chk = false;


            Map<String, String> query_pairs = new LinkedHashMap<String, String>();
            String query = url.getQuery();

            //System.out.println(url.getContent());
            System.out.println(url.getPath());

            String[] pairs = query.split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
            }
            apikey = query_pairs.get("apikey");

            // 영문자/숫자 4자리 문자열 확인
            match = Pattern.compile(pattern).matcher(apikey);
            if(match.find()) {
                chk = true;
            }

            System.out.println(" chk : " + chk);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return apikey;
    }
}

