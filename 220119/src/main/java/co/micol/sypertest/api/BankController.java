package co.micol.sypertest.api;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody ==> 메소드마다 @ResponseBody안적어도 됨
public class BankController {

	//계좌번호 조회
	@RequestMapping("/balance")
	public Map balance(BankVO vo) {
		// 로그인 한 유저의 토큰을 DB에서 조회하기
		vo.setAccessToken(
				"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDYzIiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTE2MjQ1MDksImp0aSI6IjJlZjU1NjM3LTQxZWEtNDRmOS1hY2U1LWFjNWMyOTk0NDk4ZSJ9.oyyXjJLrBnSwdP-057tdR2_lETh2nFe_UkG-QWR2fhE");

		return new BankAPI().getBalanceInfo(vo);

	}
	
	//계좌번호 조회
		@RequestMapping("/account")
		public Map account(BankVO vo) {
			// 로그인 한 유저의 토큰을 DB에서 조회하기
			vo.setAccessToken(
					"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDYzIiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTE2MjQ1MDksImp0aSI6IjJlZjU1NjM3LTQxZWEtNDRmOS1hY2U1LWFjNWMyOTk0NDk4ZSJ9.oyyXjJLrBnSwdP-057tdR2_lETh2nFe_UkG-QWR2fhE");
			vo.setUserSeqNo("1101003063");
			return new BankAPI().getAccountInfo(vo);

		}

}
