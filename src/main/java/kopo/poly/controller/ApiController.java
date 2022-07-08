package kopo.poly.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Slf4j
@RestController
public class ApiController {
    @GetMapping("/api")
    public String callApi() throws IOException {
        log.info(this.getClass().getName() + ".callApi Starts !!");

        StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/civillCurriculumService/v1/getCivillCurriculumSearch");
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + "B6Y3pUWG%2BBARTjyIt1k3p1H%2FnU92RaprJsdetRpsmx3H0%2BQXvcum%2BHpUUaiT7W3CyQFLwKjkrcj%2BJotZx3r%2F8w%3D%3D");
        urlBuilder.append("&" + URLEncoder.encode("page", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("perPage", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("cond[guBun::EQ]", "UTF-8") + "=" + URLEncoder.encode("-", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("cond[curriProgram::EQ]", "UTF-8") + "=" + URLEncoder.encode("-", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("apiType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        log.info(this.getClass().getName() + ".callApi Ends !!");
        log.info(sb.toString());

        return sb.toString();
    }
}
