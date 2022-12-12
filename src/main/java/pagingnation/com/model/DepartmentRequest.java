package pagingnation.com.model;

import lombok.Data;

@Data
public class DepartmentRequest {
	private String management;
	private String engineering;
	private String science;
	private String commoerce;

	private Integer page = 0;
	private Integer pageSize = 50;
	private String sortBy = "management";
	private String sortDirection = "DESC";

}
