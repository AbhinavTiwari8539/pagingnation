package pagingnation.com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pagingnation.com.model.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Long> {
	
	Page<Department> findAll(Pageable pageNo);
	
//	Page<Department> findById(Long id, Pageable pageNo);
	
}
