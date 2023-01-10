package com.ugar.springtest.repository;

import com.ugar.springtest.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setup(){
        System.out.println("@BeforeEach");
    }

    //junit for save employee
    @DisplayName("Junit test for save employee")
    @Test
    public void givenEmployee_whenSave_thenReturnSavedEmployee() {
        Employee employee = Employee.builder()
                .firstName("Suneel")
                .lastName("Suneel")
                .email("sssss@gmail.com")
                .build();
        Employee savedEmployee = employeeRepository.save(employee);
        //  Assertions.assertThat(savedEmployee).isNotNull();
        // Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);

        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    @DisplayName("Junit test for Get all employee")
    @Test
    public void givenEmployees_whenFindAll_thenEmployeeList() {
        Employee employee = Employee.builder()
                .firstName("Suneel1")
                .lastName("Suneel")
                .email("sssss1@gmail.com")
                .build();
        Employee employee1 = Employee.builder()
                .firstName("Suneel")
                .lastName("Suneel")
                .email("sssss@gmail.com")
                .build();

        employeeRepository.save(employee);
        employeeRepository.save(employee1);

        List<Employee> employeeList = employeeRepository.findAll();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }

    @Test
    public void givenEmployee_whenSave_thenGetByID() {
        Employee employee1 = Employee.builder()
                .firstName("Suneel")
                .lastName("Suneel")
                .email("sssss@gmail.com")
                .build();

        Employee employee = employeeRepository.save(employee1);
        Employee retrivedEmployee = employeeRepository.findById(employee.getId()).get();
        assertThat(retrivedEmployee).isNotNull();
    }

    //Junit test for get Employee by email id
    @DisplayName("Junit test for Get employee by email")
    @Test
    public void givenEmployee_whenSaveEmployee_thenGetByEmail() {
        Employee employee1 = Employee.builder()
                .firstName("Suneel")
                .lastName("Suneel")
                .email("sssss@gmail.com")
                .build();

        Employee employee = employeeRepository.save(employee1);
        Employee retrivedEmployee = employeeRepository.findByEmail(employee.getEmail()).get();
        assertThat(retrivedEmployee).isNotNull();
    }

    //Junit test for update Employee
    @DisplayName("Junit test for update employee")
    @Test
    public void givenEmployee_whenUpdate_thenReturnUpdatedEmployee() {
        Employee employee1 = Employee.builder()
                .firstName("Suneel")
                .lastName("Suneel")
                .email("sssss@gmail.com")
                .build();

        Employee savedEmployee = employeeRepository.save(employee1);
        savedEmployee.setEmail("update@gmail.com");
        Employee updatedEmployee = employeeRepository.save(savedEmployee);

        assertThat(savedEmployee.getEmail()).isEqualTo(updatedEmployee.getEmail());
    }

    //Junit test for update Employee
    @DisplayName("Junit test for dete employee")
    @Test
    public void givenEmployee_whenDelete_thenEmployeeDeleted() {
        Employee employee1 = Employee.builder()
                .firstName("Suneel")
                .lastName("Suneel")
                .email("sssss@gmail.com")
                .build();

        Employee savedEmployee = employeeRepository.save(employee1);
        employeeRepository.delete(savedEmployee);
        Optional<Employee> deleedEmployee = employeeRepository.findById(savedEmployee.getId());
        assertThat(deleedEmployee).isEmpty();
    }

    //Index Parameters
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQl_thenReturnEmployee() {
        Employee employee1 = Employee.builder()
                .firstName("Suneel")
                .lastName("Suneel")
                .email("sssss@gmail.com")
                .build();

        Employee savedEmployee = employeeRepository.save(employee1);
        String FirstName = "Suneel";
        String LastName = "Suneel";
        Employee jpqlEmployee = employeeRepository.findByJPQL(FirstName, LastName);
        assertThat(jpqlEmployee).isNotNull();
    }

    //Named Parameters
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQlNamedParam_thenReturnEmployee() {
        Employee employee1 = Employee.builder()
                .firstName("Suneel")
                .lastName("Suneel")
                .email("sssss@gmail.com")
                .build();

        Employee savedEmployee = employeeRepository.save(employee1);
        String FirstName = "Suneel";
        String LastName = "Suneel";
        Employee jpqlEmployee = employeeRepository.findByJPQLNamedParams(FirstName, LastName);
        assertThat(jpqlEmployee).isNotNull();
    }

    //Index Parameters Native SQL Query
    @Test
    public void givenFirstNameAndLastName_whenFindByNativeSQL_thenReturnEmployee() {
        Employee employee1 = Employee.builder()
                .firstName("Suneel")
                .lastName("Suneel")
                .email("sssss@gmail.com")
                .build();

        Employee savedEmployee = employeeRepository.save(employee1);
        String FirstName = "Suneel";
        String LastName = "Suneel";
        Employee jpqlEmployee = employeeRepository.findByNativeSQL(FirstName, LastName);
        assertThat(jpqlEmployee).isNotNull();
    }

    //Named Parameters Native SQL Query
    @Test
    public void givenFirstNameAndLastName_whenFindByNativeSqlNamedParam_thenReturnEmployee() {
        Employee employee1 = Employee.builder()
                .firstName("Suneel")
                .lastName("Suneel")
                .email("sssss@gmail.com")
                .build();

        Employee savedEmployee = employeeRepository.save(employee1);
        String FirstName = "Suneel";
        String LastName = "Suneel";
        Employee jpqlEmployee = employeeRepository.findByNativeSQLNamed(FirstName, LastName);
        assertThat(jpqlEmployee).isNotNull();
    }
}
