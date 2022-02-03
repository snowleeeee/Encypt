package co.micol.sypertest.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BankAPI {

	public static void main(String[] args) {
		// Map<String, Object> map = BankAPI.getBalanceInfo();
		// Map<String, Object> map = BankAPI.getTransactionInfo();
		// Map<String, Object> map = getInquiryInfo();
		// System.out.println(map);
		// System.out.println("이름 === " + map.get("account_holder_name"));

		BankVO vo = new BankVO();
		vo.setAccessToken(
				"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDYzIiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTE2MjQ1MDksImp0aSI6IjJlZjU1NjM3LTQxZWEtNDRmOS1hY2U1LWFjNWMyOTk0NDk4ZSJ9.oyyXjJLrBnSwdP-057tdR2_lETh2nFe_UkG-QWR2fhE");
		vo.setFintechUseNum("120220018288941081450580");
		Map<String, Object> map = new BankAPI().getBalanceInfo(vo);
		System.out.println(map);

	}

	static String use_org_code = "M202200182";

	public String getSequence() {

		long t1 = System.currentTimeMillis();
		String result = String.valueOf(t1);
		result = result.substring(result.length() - 9);

		return result;

	}

	// 실시간으로 날짜를 받아오기
	public String getDate() {

		String result = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");

		Date date = new Date();
		result = sdf.format(date);

		return result;
	}

	// get 등록 계좌 조회
	public Map<String, Object> getAccountInfo(BankVO vo) {

		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/list";

		// MultiValueMap<String, String> param = new LinkedMultiValueMap<String,
		// String>();
		String param = "user_seq_no=" + vo.getUserSeqNo();
			param += "&include_cancel_yn=" + "Y";
			param += "&sort_order=" + "A";

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + vo.getAccessToken());

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(null,
				headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> map = restTemplate.exchange(reqURL + "?" + param, HttpMethod.GET, request, Map.class);

		return map.getBody();// getBody() = 맵 결과 읽어냄
	}

	// get 잔액조회
	public Map<String, Object> getBalanceInfo(BankVO vo) {

		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/balance/fin_num";

		String param = "bank_tran_id=" + use_org_code + "U" + getSequence();
		param += "&tran_dtime=" + getDate();
		param += "&fintech_use_num=" + vo.getFintechUseNum();

		HttpHeaders headers = new HttpHeaders();
		String org_access_token = vo.getAccessToken();
		headers.set("Authorization", "Bearer " + org_access_token);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(null,
				headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> map = restTemplate.exchange(reqURL + "?" + param, HttpMethod.GET, request, Map.class);

		return map.getBody();// getBody() = 맵 결과 읽어냄
	}

	// post 계좌실명확인
	public Map<String, Object> getInquiryInfo() {

		String reqURL = "https://testapi.openbanking.or.kr/v2.0/inquiry/real_name";
		Map<String, String> param = new HashMap<String, String>();
		param.put("bank_tran_id", "M202200182" + "U" + "000000014");
		param.put("bank_code_std", "002");
		param.put("account_num", "123456789");
		param.put("account_holder_info_type", " ");
		param.put("account_holder_info", "880101");
		param.put("tran_dtime", getDate());

		ObjectMapper mapper = new ObjectMapper();
		String jsonParam = "";

		try {
			jsonParam = mapper.writeValueAsString(param); // multimap을 못읽어서 파라미터 값을 objectMapper로 변환함
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpHeaders headers = new HttpHeaders();
		String org_access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJNMjAyMjAwMTgyIiwic2NvcGUiOlsib29iIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjUxNjMwMzM5LCJqdGkiOiJhNzFiZTI3ZS1lZGE5LTQ0MjUtODY4OC1hYWUyNGFiNzNlY2EifQ.oohrv6bXLXD5jkLeK-ePPtF4UyZzV2AHhDi_30hCJsI";
		headers.set("Content-Type", "application/json; charset=UTF-8");
		headers.set("Authorization", "Bearer " + org_access_token);

		HttpEntity<String> request = new HttpEntity<String>(jsonParam, headers);

		RestTemplate restTemplate = new RestTemplate();
		Map map = restTemplate.postForObject(reqURL, request, Map.class);
		// Map map = restTemplate.postForObject(접근 URL, 파라미터, 반환타입);

		return map;// getBody() = 맵 결과 읽어냄
	}

	// get 거래내역 조회
	public Map<String, Object> getTransactionInfo() {

		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/transaction_list/fin_num";

		String param = "bank_tran_id=" + use_org_code + "U" + "000000033";
		param += "&fintech_use_num=" + "120220018288941081450580";
		param += "&inquiry_type=" + "A";
		param += "&inquiry_base=" + "D";
		param += "&from_date=" + "20220101";
		param += "&from_time=" + "100000";
		param += "&to_date=" + "20220203";
		param += "&to_time=" + "230000";
		param += "&sort_order=" + "A";
		param += "&tran_dtime=" + getDate();
		param += "&befor_inquiry_trace_info=";

		HttpHeaders headers = new HttpHeaders();
		String org_access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDYzIiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTE2MjQ1MDksImp0aSI6IjJlZjU1NjM3LTQxZWEtNDRmOS1hY2U1LWFjNWMyOTk0NDk4ZSJ9.oyyXjJLrBnSwdP-057tdR2_lETh2nFe_UkG-QWR2fhE";
		headers.set("Authorization", "Bearer " + org_access_token);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(null,
				headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> map = restTemplate.exchange(reqURL + "?" + param, HttpMethod.GET, request, Map.class);
		// Map map = restTemplate.postForObject(접근 URL, 파라미터, 반환타입);

		return map.getBody();// getBody() = 맵 결과 읽어냄

	}

}
