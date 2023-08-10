package news;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
/* @RequestMapping("proxy") */
public class NaverNewsProxyController {
    private static final String NAVER_API_CLIENT_ID = "H2KQ2riVaHgMmEmjVdxS";
    private static final String NAVER_API_CLIENT_SECRET = "VibbPrRbi1";

    @GetMapping
    public ResponseEntity<String> naverNewsProxy(@RequestParam("query") String query,
                                                 @RequestParam("display") int display,
                                                 @RequestParam("start") int start) {
        String response = "";
        try {
            String encodedQuery = URLEncoder.encode(query, "UTF-8");
            String urlString = "https://openapi.naver.com/v1/search/news.json?query=" + encodedQuery +
                    "&display=" + display + "&start=" + start;
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("X-Naver-Client-Id", NAVER_API_CLIENT_ID);
            httpURLConnection.setRequestProperty("X-Naver-Client-Secret", NAVER_API_CLIENT_SECRET);

            int responseCode = httpURLConnection.getResponseCode();
            BufferedReader bufferedReader;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            }

            response = bufferedReader.lines().reduce("", (accumulator, line) -> accumulator + line);
            bufferedReader.close();
            httpURLConnection.disconnect();
        } catch (Exception e) {
            response = "{\"message\": \"Error occurred: " + e.getMessage() + "\"}";
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(response);

    }
}
