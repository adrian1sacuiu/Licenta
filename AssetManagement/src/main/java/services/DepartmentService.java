package services;

import domain.Department;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import services.DAO.DepartmentDao;

import java.util.List;

@Transactional
@Service
public class DepartmentService {
	private static final Logger logger = Logger.getLogger(DepartmentService.class);

	@Autowired
	DepartmentDao departmentDao;

	public boolean addDepartment(Department department) throws Exception {
		logger.info("in addDepartment method.");

		return departmentDao.addDepartment(department);
	}

	public boolean updateDepartment(Department department) throws Exception {
		logger.info("in updateDepartment method.");

		return departmentDao.updateDepartment(department);
	}

	public boolean deleteDepartment(Department department) throws Exception {
		logger.info("in deleteDepartment method.");

		return departmentDao.deleteDepartment(department);
	}

	@Transactional(readOnly = true)
	public List<Department> getAllDepartments() {
		logger.info("in getAllDepartments method.");

		return departmentDao.getAllDepartments();
	}

	@Transactional(readOnly = true)
	public Department getDepartmentById(Long id) {
		logger.info("in getDepartmentById method.");

		return departmentDao.getDepartmentById(id);
	}
}
