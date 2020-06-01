package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		List<Department> list = new ArrayList<>();
		
		System.out.println("=== TEST 1: Department findById ===");
		Department dep = departmentDao.findById(2);
		
		System.out.println(dep);
		
		
		System.out.println("=== TEST 2: Department findAll ===");
		list = departmentDao.findAll();		
		for (Department obj : list) {
			System.out.println(obj);
		}

		
		System.out.println("=== TEST 3: Department insert ===");
		Department newDep = new Department(null, "TI");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		
		System.out.println("=== TEST 4: Department update ===");
		newDep = departmentDao.findById(7);
		newDep.setName("Teste");
		departmentDao.update(newDep);
		System.out.println("Update completed");
		
		
		System.out.println("=== TEST 5: Department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
		
	}

}
