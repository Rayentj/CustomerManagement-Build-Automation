package edu.miu.cs.cs489.pensionmgmt.dao;

import edu.miu.cs.cs489.pensionmgmt.model.Employee;
import edu.miu.cs.cs489.pensionmgmt.model.Money;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private final List<Employee> employees = new ArrayList<>();
    // This list will be used to store Employee objects in memory for demonstration purposes.

    private static EmployeeDao instance;

    // Private constructor to prevent instantiation
    private EmployeeDao() {
    }

    // Public method to provide access to the single instance
    public static synchronized EmployeeDao getInstance() {
        if (instance == null) {
            // Lazy initialization of the singleton instance
            // This ensures that the instance is created only when it is needed.
            instance = new EmployeeDao();
        }
        return instance;
    }

    private void loadData() {
        this.employees.addAll(
                List.of(
                        new Employee(1L, "Daniel", "Agar",
                                LocalDate.of(2018, 1, 17), new Money(105_945.50, "USD", "$"),
                                "EX1089", LocalDate.of(2023, 1, 17),
                                new Money(100.00, "USD", "$")),
                        new Employee(2L, "Benard", "Shaw",
                                LocalDate.of(2022, 9, 3), new Money(197_750.00, "USD", "$"),
                                null, null, null),
                        new Employee(3L, "Carly", "DeFiori",
                                LocalDate.of(2014, 5, 16), new Money(842_000.75, "USD", "$"),
                                "SM2307", LocalDate.of(2019, 11, 4),
                                new Money(1555.50, "USD", "$")),
                        new Employee(4L, "Wesley", "Schneider",
                                LocalDate.of(2022, 7, 21), new Money(74_500.00, "USD", "$"),
                                null, null, null),
                        new Employee(5L, "Anna", "Wiltord",
                                LocalDate.of(2022, 6, 15), new Money(85_750.00, "USD", "$"),
                                null, null, null),
                        new Employee(6L, "Yosef", "Tesfalem",
                                LocalDate.of(2022, 10, 31), new Money(100_000.00, "USD", "$"),
                                null, null, null)
                ));
    }

    /**
     * Fetches all employees from the data source.
     * If the list is empty, it loads the data first.
     * @return employees the list of Employees
     */
    public List<Employee> getAllEmployees() {
        if (employees.isEmpty()) {
            loadData();
        }
        return employees;
    }

}

