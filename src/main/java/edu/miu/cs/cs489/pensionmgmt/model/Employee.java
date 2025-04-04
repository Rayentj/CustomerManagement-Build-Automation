package edu.miu.cs.cs489.pensionmgmt.model;

import edu.miu.cs.cs489.pensionmgmt.util.DateUtil;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private Money yearlySalary;
    private PensionPlan pensionPlan;


    public Employee(Long employeeId, String firstName, String lastName,
                    LocalDate employmentDate, Money yearlySalary,
                    String planRefenceNumber, LocalDate enrollmentDate,
                    Money monthlyContribution) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        if(planRefenceNumber != null) {
            this.pensionPlan = new PensionPlan(
                    planRefenceNumber, enrollmentDate, monthlyContribution
            );
        }
    }
    public Employee() {
        this(null, null, null,
                null, null, null,
                null, null);
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Money getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(Money yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }
    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("employeeId=" + employeeId)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("employmentDate=" + employmentDate)
                .add("yearlySalary=" + yearlySalary)
                .add("pensionPlan=" + pensionPlan)
                .toString();
    }

    public JSONObject toJSON() {
        JSONObject employeeJSONObject = new JSONObject();
        employeeJSONObject.put("employeeId", employeeId);
        employeeJSONObject.put("firstName", firstName);
        employeeJSONObject.put("lastName", lastName);
        employeeJSONObject.put("employmentDate", employmentDate.toString());
        employeeJSONObject.put("yearlySalary", yearlySalary.toJSONObject());
        if (pensionPlan != null) {
            employeeJSONObject.put("pensionPlan", pensionPlan.toJSONObject());
        } else {
            employeeJSONObject.put("pensionPlan", (Object) null);
        }
        return employeeJSONObject;
    }

    public boolean isUpcomingEnrolleeForNextQuarter() {
        return (!isEnrolledForPensionPlan() &&
                attainsThreeYearsEmploymentInNextQuarter());
    }

    public boolean isEnrolledForPensionPlan() {
        return (this.pensionPlan != null);
    }

    public boolean attainsThreeYearsEmploymentInNextQuarter() {
        var dateOfAttainmentOfThreeYearsEmployment = employmentDate.plusYears(3L);
        var nextQuarter = DateUtil.getNextQuarter(LocalDate.now());
        return dateOfAttainmentOfThreeYearsEmployment
                .isAfter(nextQuarter.startDate().minusDays(1L)) &&
                dateOfAttainmentOfThreeYearsEmployment
                        .isBefore(nextQuarter.endDate().plusDays(1L));
    }
}
