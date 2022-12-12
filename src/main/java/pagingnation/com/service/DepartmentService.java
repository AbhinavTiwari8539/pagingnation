package pagingnation.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pagingnation.com.Repository.DepartmentRepo;
import pagingnation.com.model.Department;
import pagingnation.com.model.DepartmentRequest;
import pagingnation.com.model.DepartmentResponce;
@Service
public class DepartmentService {
	
	private final DepartmentRepo departmentRepository;
	public DepartmentService(DepartmentRepo departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
//	WIthout RequestParam
	
	/* public DepartmentResponce getAllDataFromDepartment(DepartmentRequest request) {
		
		DepartmentResponce responce = new DepartmentResponce();
		List<DepartmentResponce.DepartmentDTO> departmentList = new ArrayList<>();
//		Page<Department> dePage = null;
		Page<DepartmentResponce.DepartmentDTO> departmentPage = null;
		
		if (request.getPage() > 0) {
            request.setPage(request.getPage() - 1);
        }
		
//		Pageable page = PageRequest.of(request.getPage(), request.getPageSize());
		
		Pageable page = PageRequest.of(request.getPage(), request.getPageSize(), Sort.Direction.valueOf(request.getSortDirection().toUpperCase()), request.getSortBy());
		
		Page<Department> departmentData = departmentRepository.findAll(page);
		//dePage = new PageImpl<>(departmentData,page);
		
		for (Department department :  departmentData.getContent()) {
			DepartmentResponce.DepartmentDTO departmentResponce = new DepartmentResponce.DepartmentDTO();
			departmentResponce.setManagement(department.getManagement());
			departmentResponce.setEngineering(department.getEngineering());
			departmentResponce.setScience(department.getScience());
			departmentResponce.setCommoerce(department.getCommoerce());
			departmentList.add(departmentResponce);
		}
		
		final int start = (int) page.getOffset(); 
        final int end = Math.min((start + page.getPageSize()), departmentList.size());
        departmentPage = new PageImpl<>(departmentList.subList(start, end), PageRequest.of(request.getPage(), request.getPageSize()), departmentList.size());

		
		responce.setPage(departmentPage.getNumber());
		responce.setPageSize(departmentPage.getSize());
		responce.setResultCount(departmentPage.getTotalElements());
		responce.setTotalCount(departmentPage.getTotalPages());
		responce.setDepartmentResponceDTO(departmentList);
		
		return responce;
	} */
	
	
//	With RequestParam
	
	public DepartmentResponce getAllDataFromDepartment(Integer page, Integer pageSize, String sortBy, String sortDirection) {

		DepartmentResponce responce = new DepartmentResponce();
		List<DepartmentResponce.DepartmentDTO> departmentList = new ArrayList<>();
		Page<DepartmentResponce.DepartmentDTO> departmentPage = null;
		
		if (page > 0) {
			page = page - 1;
		}

		Pageable pageNo = PageRequest.of(page, pageSize,
				Sort.Direction.valueOf(sortDirection.toUpperCase()), sortBy);

		Page<Department> departmentData = departmentRepository.findAll(pageNo);

		for (Department department : departmentData.getContent()) {
			DepartmentResponce.DepartmentDTO departmentResponce = new DepartmentResponce.DepartmentDTO();
			departmentResponce.setManagement(department.getManagement());
			departmentResponce.setEngineering(department.getEngineering());
			departmentResponce.setScience(department.getScience());
			departmentResponce.setCommoerce(department.getCommoerce());
			departmentList.add(departmentResponce);
		}

		final int start = (int) pageNo.getOffset();
		final int end = Math.min((start + pageNo.getPageSize()), departmentList.size());
		departmentPage = new PageImpl<>(departmentList.subList(start, end),
				PageRequest.of(page, pageSize), departmentList.size());

		responce.setPage(departmentPage.getNumber());
		responce.setPageSize(departmentPage.getSize());
		responce.setResultCount(departmentPage.getTotalElements());
		responce.setTotalCount(departmentPage.getTotalPages());
		responce.setDepartmentResponceDTO(departmentList);

		return responce;
	}
	
	public Department addDeparmentData(DepartmentRequest request) {
		Department departmentData = new Department();
		
		departmentData.setManagement(request.getManagement());
		departmentData.setEngineering(request.getEngineering());
		departmentData.setScience(request.getScience());
		departmentData.setCommoerce(request.getCommoerce());
		return departmentRepository.save(departmentData);
		
	}

}
