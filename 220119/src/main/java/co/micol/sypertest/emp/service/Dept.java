package co.micol.sypertest.emp.service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
	String department_id;
	String department_name;
	@JsonIgnore String manager_id;
	@JsonIgnore String location_id;
}
