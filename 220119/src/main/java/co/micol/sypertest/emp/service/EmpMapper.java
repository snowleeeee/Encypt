package co.micol.sypertest.emp.service;

import java.util.List;

public interface EmpMapper {
	List<Emp> findEmp();

	List<Dept> findDept();

	int insertDept(Dept dept);

	int updateDept(Dept dept);

	int deleteDept(String id);

	Dept findDeptById (String id);

}
