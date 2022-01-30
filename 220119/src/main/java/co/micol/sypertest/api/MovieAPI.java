package co.micol.sypertest.api;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MovieAPI {

	public static void main(String[] args) throws Exception {
		
		restMovieList();

		// movieInfo("20201965");
		//
	}

	static String boxOfficeUrl = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220127";

	public static JsonNode restMovieList() throws Exception {
			//
		RestTemplate rest = new RestTemplate();
		JsonNode node = rest.getForObject(boxOfficeUrl, JsonNode.class);

		System.out.println(node.get("boxOfficeResult").get("dailyBoxOfficeList").asText());
		
		return node.get("boxOfficeResult").get("dailyBoxOfficeList");

	}

	public static JsonNode movieList() throws Exception {

		// 요청할 URL 주소

		URL url = new URL(boxOfficeUrl);

		// 서버 연결
		URLConnection urlcon = url.openConnection();

		// response 응답결과 받기
		InputStream in = urlcon.getInputStream();

		// json으로 변환하기
		ObjectMapper mapper = new ObjectMapper();

		// 내부가 복잡하면 readTree로 읽어오기 -->읽어와서 JsonNode로 받음
		JsonNode nodes = mapper.readTree(url);

		JsonNode mList = nodes.get("boxOfficeResult").get("dailyBoxOfficeList");

		for (int i = 0; i < mList.size(); i++) {
			System.out.println((i + 1) + "위 : " + mList.get(i).get("movieNm").asText());
		} 
		// System.out.println(nm); // Java
			// Application으로 실행하기
		return mList;

	}

	public static JsonNode movieInfo(String cd) throws Exception {

		// 요청할 URL 주소
		String urladdr = "https://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd="
				+ cd;

		URL url = new URL(urladdr);

		// 서버 연결
		URLConnection urlcon = url.openConnection();

		// response 응답결과 받기
		InputStream in = urlcon.getInputStream();

		// json으로 변환하기
		ObjectMapper mapper = new ObjectMapper();

		// 내부가 복잡하면 readTree로 읽어오기 -->읽어와서 JsonNode로 받음
		JsonNode nodes = mapper.readTree(url);

		JsonNode actorList = nodes.get("movieInfoResult").get("movieInfo").get("actors");
		System.out.println("===출연진===");
		for (int i = 0; i < actorList.size(); i++) {
			System.out.println(actorList.get(i).get("peopleNm").asText());
		} //
		System.out.println(actorList.asText());
		System.out.println("===감독===");

		JsonNode directorList = nodes.get("movieInfoResult").get("movieInfo").get("directors");
		System.out.println(directorList.get(0).get("peopleNm").asText()); // Java
		// Application으로 실행하기
		
		return nodes;

	}
}
