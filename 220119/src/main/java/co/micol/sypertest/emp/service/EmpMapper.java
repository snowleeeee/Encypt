package co.micol.sypertest.emp.service;

import java.util.List;

import co.micol.sypertest.emp.service.Dept;
import co.micol.sypertest.emp.service.Emp;

public interface EmpMapper {
	public List<Emp> findEmp();
	public List<Dept> findDept();

}
