package pagingnation.com.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DepartmentResponce {
	
	private List<DepartmentResponce.DepartmentDTO> departmentResponceDTO = new ArrayList<>();

	@JsonProperty("page")
	private Integer Page;
	
	@JsonProperty("pagesize")
	private Integer PageSize;
	
	@JsonProperty("resultcount")
	private Long ResultCount;
	
	@JsonProperty("totalcount")
	private Integer TotalCount;

	@Data
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class DepartmentDTO {
		private String management;
		private String engineering;
		private String science;
		private String commoerce;

	}

}
