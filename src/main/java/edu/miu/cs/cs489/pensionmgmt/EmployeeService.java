package edu.miu.cs.cs489.pensionmgmt;

import edu.miu.cs.cs489.pensionmgmt.dao.EmployeeDao;
import edu.miu.cs.cs489.pensionmgmt.model.Employee;

import java.util.Comparator;
import java.util.List;

public class EmployeeService implements EmployeeServiceInterface {
    private EmployeeDao employeeDAO;

    public EmployeeService() {
        this.employeeDAO = EmployeeDao.getInstance();
    }

    @Override
    public void addNewEmployee(String firstName, String lastName, String employmentDate, String yearlySalary, String planRefenceNumber, String enrollmentDate, String monthlyContribution) {
        // TODO Implementation here
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        // TODO Implementation here
    }

    @Override
    public void getEmployeeById(Long employeeId) {
        // TODO Implementation here
    }

    @Override
    public List<Employee> getAllEmployees() {
        var employees = employeeDAO.getAllEmployees();
        employees.sort(Comparator.
                comparing((Employee employee) ->
                                employee.getYearlySalary().amount(),
                        Comparator.reverseOrder())
                .thenComparing(Employee::getLastName));
        return employees;
    }

    @Override
    public List<Employee> getUpcomingEnrolleesForNextQuarter() {
        return employeeDAO.getAllEmployees()
                .stream()
                .filter(employee -> employee.isUpcomingEnrolleeForNextQuarter())
                .sorted(Comparator.comparing(Employee::getEmploymentDate, Comparator.reverseOrder()))
                .toList();
    }

}

