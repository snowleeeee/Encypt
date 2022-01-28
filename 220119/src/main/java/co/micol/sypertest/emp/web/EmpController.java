package co.micol.sypertest.emp.web;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.micol.sypertest.emp.service.Dept;
import co.micol.sypertest.emp.service.Emp;
import co.micol.sypertest.emp.service.EmpMapper;

@Controller
public class EmpController {
	
	@Autowired
	EmpMapper mapper;
	
	@PostMapping("/test1")
	@ResponseBody
	public Map test1() {
		return Collections.singletonMap("result", "success");
	}
	
	@PostMapping("/dept")
	@ResponseBody
	public List<Dept> dept() {
//		Dept dept = Dept.builder()
//				.department_id("10")
//				.department_name("개발")
//				.build();
		return mapper.findDept();
	}
	
	
	@PostMapping("/emp")
	@ResponseBody
	public List<Emp> emp() {
//		Emp emp = Emp.builder()
//				.employee_id("100")
//				.hire_date(new Date())  
//				.build();
		return mapper.findEmp();
	}
	
}
