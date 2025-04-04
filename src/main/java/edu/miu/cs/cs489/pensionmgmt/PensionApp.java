package edu.miu.cs.cs489.pensionmgmt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.miu.cs.cs489.pensionmgmt.model.Employee;
import edu.miu.cs.cs489.pensionmgmt.model.PensionPlan;
import edu.miu.cs.cs489.pensionmgmt.util.JSONConverterUtil;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class PensionApp {
    public static void main(String[] args) throws Exception{

            System.out.println("Hello! Welcome to the Employee Pension Plan Management App!");
            System.out.println("Starting the application tasks...");
            System.out.println("Task B1: JSON Array of All Employees");
            EmployeeService employeeService = new EmployeeService();
            var allEmployees = employeeService.getAllEmployees();
            var allEmployeesJson = JSONConverterUtil.employeeListToJSON(allEmployees);
            System.out.println(allEmployeesJson);
            System.out.println("____________________________________________________________________");
            System.out.println("Task B2: JSON Array of Employees with Upcoming Pension Plan Enrollment Dates in the Next Quarter");
            var upcomingEnrollees = employeeService.getUpcomingEnrolleesForNextQuarter();
            var upcomingEnrolleesJson = JSONConverterUtil.employeeListToJSON(upcomingEnrollees);
            System.out.println(upcomingEnrolleesJson);
            System.out.println("____________________________________________________________________");

            System.out.println("Application tasks completed successfully!");
            System.out.println("Exiting the application...Goodbye!");
        }
}
