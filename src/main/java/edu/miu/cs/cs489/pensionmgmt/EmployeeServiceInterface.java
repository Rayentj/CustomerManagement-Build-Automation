package edu.miu.cs.cs489.pensionmgmt;

import edu.miu.cs.cs489.pensionmgmt.model.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    void addNewEmployee(String firstName, String lastName, String employmentDate, String yearlySalary, String planRefenceNumber, String enrollmentDate, String monthlyContribution);

    void deleteEmployee(Long employeeId);

    void getEmployeeById(Long employeeId);

    List<Employee> getAllEmployees();

    List<Employee> getUpcomingEnrolleesForNextQuarter();
}
