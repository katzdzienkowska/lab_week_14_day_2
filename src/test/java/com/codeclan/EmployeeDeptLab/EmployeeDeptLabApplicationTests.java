package com.codeclan.EmployeeDeptLab;

import com.codeclan.EmployeeDeptLab.models.Department;
import com.codeclan.EmployeeDeptLab.models.Employee;
import com.codeclan.EmployeeDeptLab.models.Project;
import com.codeclan.EmployeeDeptLab.repositories.DepartmentRepository;
import com.codeclan.EmployeeDeptLab.repositories.EmployeeRepository;
import com.codeclan.EmployeeDeptLab.repositories.ProjectRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDeptLabApplicationTests {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testing(){
		Department department1 = new Department("Marketing");
		departmentRepository.save(department1);

		Employee employee1 = new Employee("Kat", "Zdzienkowska", 1234, department1);
		employeeRepository.save(employee1);

		Project project1 = new Project("Spring Campaign", 30);
		projectRepository.save(project1);

		department1.addEmployee(employee1);
		departmentRepository.save(department1);

		Project project2 = new Project("Summer Campaign", 45);

		project1.addEmployee(employee1);
		project2.addEmployee(employee1);
		projectRepository.save(project1);
		projectRepository.save(project2);
	}
}
