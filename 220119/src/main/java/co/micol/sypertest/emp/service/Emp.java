package co.micol.sypertest.emp.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Emp {
	String employee_id;
	String last_name;
	@JsonIgnore
	String email;
	@JsonFormat(pattern = "yyyy-mm-dd")
	Date hire_date; 
	
	String job_id;                                 
}
