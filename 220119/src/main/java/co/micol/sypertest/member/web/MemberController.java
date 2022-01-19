package co.micol.sypertest.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.micol.sypertest.member.service.MemberService;
import co.micol.sypertest.member.service.MemberVO;
import co.micol.sypertest.util.Aria;
import co.micol.sypertest.util.ShaEncypt;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberDao;

	private final static String ENC_TO_DEC = "123456789dlkvnlhuynkj";

	@RequestMapping("/login.do")
	public String login(MemberVO vo, Model model) {

		// vo 객체 암호화하기
		ShaEncypt sha = new ShaEncypt(); // 일방향 암호화 객체를 생성
		vo.setPassword(sha.encryptSHA256(vo.getPassword())); // 패스워드 암호화
		System.out.println("(MemberController)비번확인 ======= " + vo.getPassword());

		model.addAttribute("member", memberDao.memberSelect(vo));

		return "member/loginResult";
	}

	@PostMapping("/encryption.do")
	public String encryption(@RequestParam("str") String str, Model model) {
		Aria aria = new Aria(ENC_TO_DEC);
		str = aria.Encrypt(str);// 넘어온 String을 암호화해서 변수에 담기
		model.addAttribute("encStr", str);

		return "member/encryption";

	}

	@PostMapping("/decryption.do")
	public String decryption(@RequestParam("str") String str, Model model) {

		Aria aria = new Aria(ENC_TO_DEC);
		str = aria.Decrypt(str);// 넘어온 String을 암호화해서 변수에 담기
		model.addAttribute("decrytStr", str);

		return "member/decryption";
	}
}
