package edu.miu.cs.cs489.pensionmgmt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.miu.cs.cs489.pensionmgmt.model.Employee;
import edu.miu.cs.cs489.pensionmgmt.model.PensionPlan;

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
        List<Employee> employees = loadEmployees();

        System.out.println("=== All Employees (Sorted) in JSON ===");
        printAllEmployeesJson(employees);

        System.out.println("\n=== Quarterly Upcoming Enrollees in JSON ===");
        printQuarterlyUpcomingEnrollees(employees);

    }
    private static List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Daniel", "Agar",
                LocalDate.of(2018, 1, 17), 105_945.50,
                new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), 100.00)));

        employees.add(new Employee(2, "Benard", "Shaw",
                LocalDate.of(2018, 10, 3), 197_750.00, null));

        employees.add(new Employee(3, "Carly", "Agar",
                LocalDate.of(2014, 5, 16), 842_000.75,
                new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), 1555.50)));

        employees.add(new Employee(4, "Wesley", "Schneider",
                LocalDate.of(2018, 11, 2), 74_500.00, null));

        return employees;
    }

    private static void printAllEmployeesJson(List<Employee> employees) throws Exception {
        List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparing(Employee::getYearlySalary).reversed()
                        .thenComparing(Employee::getLastName))
                .collect(Collectors.toList());

        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .enable(SerializationFeature.INDENT_OUTPUT);
        String json = mapper.writeValueAsString(sorted);
        System.out.println(json);
    }

    private static void printQuarterlyUpcomingEnrollees(List<Employee> employees) throws Exception {
        LocalDate now = LocalDate.now();
        int currentQuarter = (now.getMonthValue() - 1) / 3 + 1;
        int nextQuarterStartMonth = (currentQuarter * 3 % 12) + 1;
        int nextQuarterYear = currentQuarter == 4 ? now.getYear() + 1 : now.getYear();

        LocalDate nextQuarterStart = LocalDate.of(nextQuarterYear, Month.of(nextQuarterStartMonth), 1);
        LocalDate nextQuarterEnd = nextQuarterStart.plusMonths(2).withDayOfMonth(nextQuarterStart.plusMonths(2).lengthOfMonth());

        List<Employee> upcomingEnrollees = employees.stream()
                .filter(e -> e.getPensionPlan() == null)
                .filter(e -> e.getEmploymentDate().plusYears(3).compareTo(nextQuarterStart) >= 0 &&
                        e.getEmploymentDate().plusYears(3).compareTo(nextQuarterEnd) <= 0)
                .sorted(Comparator.comparing(Employee::getEmploymentDate).reversed())
                .collect(Collectors.toList());

        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String json = mapper.writeValueAsString(upcomingEnrollees);
        System.out.println(json);
    }
}
