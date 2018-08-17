import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //git
        String clientId = "gwJ6botxDf881iXfg4tv";
        String clientSecret = "sx9FqJ4r_v";

        int cnt = 1; // 출력 갯수

//        String clientId = "안알랴줌";
//        String clientSecret = "안알랴줌";

        String temp_json;
        String json = "";
        String search_word;

        ShopInformDTO inform;

        BufferedReader br;

        Scanner scan = new Scanner(System.in);
        URLConnection urlConn;
        URL url;

        try {
            search_word = URLEncoder.encode(scan.nextLine(), "UTF-8"); // 검색어
            url = new URL("https://openapi.naver.com/v1/search/local.json?query=" + search_word + "&display=" + 100); //API 기본정보의 요청 url을 복사해오고 필수인 query를 적어줍니당!
            urlConn = url.openConnection(); //openConnection 해당 요청에 대해서 쓸 수 있는 connection 객체

            urlConn.setRequestProperty("X-Naver-Client-ID", clientId);
            urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret); // do not setting,

            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            while ((temp_json = br.readLine()) != null) {
                json += temp_json;
            }
            json = json.trim();


        } catch (Exception e) {
            System.out.println("ERROR");

            e.printStackTrace();
        }

        inform = new Gson().fromJson(json, ShopInformDTO.class);

        System.out.println(inform.display);
        System.out.println(inform.lastBuildDate);
        System.out.println(inform.total);


        for (int i = 0; i < inform.items.length; i++) {
            if (inform.items[i].title.trim().length() > 0) {
                System.out.println("title=" + inform.items[i].title.trim().replace("<b>", "").replace("</b>", ""));
            } else {
                System.out.println("title=" + "정보 없음");
            }

            if (inform.items[i].link.trim().length() > 0) {
                System.out.println("link=" + inform.items[i].link.trim().replace("<b>", "").replace("</b>", ""));
            } else {
                System.out.println("link=" + "정보 없음");
            }

            if (inform.items[i].category.trim().length() > 0) {
                System.out.println("category=" + inform.items[i].category.trim().replace("<b>", "").replace("</b>", ""));
            } else {
                System.out.println("category=" + "정보 없음");
            }

            if (inform.items[i].description.trim().length() > 0) {
                System.out.println("description=" + inform.items[i].description.trim().replace("<b>", "").replace("</b>", ""));
            } else {
                System.out.println("description=" + "정보 없음");
            }

            if (inform.items[i].telephone.trim().length() > 0) {
                System.out.println("telephone=" + inform.items[i].telephone.trim().replace("<b>", "").replace("</b>", ""));
            } else {
                System.out.println("telephone=" + "정보 없음");
            }

            if (inform.items[i].address.trim().length() > 0) {
                System.out.println("address=" + inform.items[i].address.trim().replace("<b>", "").replace("</b>", ""));
            } else {
                System.out.println("address=" + "정보 없음");
            }

            if (inform.items[i].roadAddress.trim().length() > 0) {
                System.out.println("roadAddress=" + inform.items[i].roadAddress.trim().replace("<b>", "").replace("</b>", ""));
            } else {
                System.out.println("roadAddress=" + "정보 없음");
            }

            if (inform.items[i].mapx.trim().length() > 0) {
                System.out.println("mapx=" + inform.items[i].mapx.trim().replace("<b>", "").replace("</b>", ""));
            } else {
                System.out.println("mapx=" + "정보 없음");
            }

            if (inform.items[i].mapy.trim().length() > 0) {
                System.out.println("mapy=" + inform.items[i].mapy.trim().replace("<b>", "").replace("</b>", ""));
            } else {
                System.out.println("mapy=" + "정보 없음");
            }
            System.out.println(cnt++);

            System.out.println("**************************");
        }

    }

}
