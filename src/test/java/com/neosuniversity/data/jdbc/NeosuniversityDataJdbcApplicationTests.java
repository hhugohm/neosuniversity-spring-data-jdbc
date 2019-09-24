package com.neosuniversity.data.jdbc;


import com.neosuniversity.data.jdbc.domain.Chair;
import com.neosuniversity.data.jdbc.domain.Department;
import com.neosuniversity.data.jdbc.repositpory.DepartmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NeosuniversityDataJdbcApplicationTests {
	private static final Logger LOGGER = LoggerFactory.getLogger(NeosuniversityDataJdbcApplicationTests.class);


	@Autowired
	private DepartmentRepository departmentRepository;
	/**
	 * Queries to Relational Database with Spring Data JDBC.
	 *
	 * Chair and Departments persisted to H2 in-Memory database at startup.
	 * @see NeosuniversityDataJdbcApplicationTests
	 */
	@Test
	public void queryMethods() {
		//Chairs
		Chair deanJones = new Chair("Dean Jones");
		Chair deanMartin = new Chair("Dean Martin");
		Chair deanCain = new Chair("Dean Cain");

		//Departments
		printBanner("SQL to Create Humanities");
		departmentRepository.save(new Department("Humanities", deanJones));

		printBanner("SQL to Create Natural Sciences");
		departmentRepository.save(new Department("Natural Sciences", deanMartin));

		printBanner("SQL to Create Social Sciences");
		departmentRepository.save(new Department("Social Sciences", deanJones));

		printBanner("SQL to Fetch all Departments");
		departmentRepository.findAll().forEach(System.out::println);

		printBanner("SQL to Lookup Department by Name");
		departmentRepository.findByName("Humanities").ifPresent(department -> {
			//Modify Department, change chair from Dean Jones to Dean Cain
			department.setChair(deanCain);
			printBanner("SQL to Update a Department, Deparment id = " + department.getId());
			departmentRepository.save(department);
		});
	}

	public void printBanner(String message) {
		System.out.println("\n****************************************************************************************************************************  " + message + "\n");
	}

	@Test
	public void contextLoads() {
	}

}
