package edu.miu.cs.cs489.pensionmgmt.model;

import java.time.LocalDate;
import org.json.JSONObject;
public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private Money monthlyContribution;

    public PensionPlan(String planReferenceNumber, LocalDate enrollmentDate, Money monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }


    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(String planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Money getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(Money monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }

    public JSONObject toJSONObject() {
        var pensionPlanJSONObject = new JSONObject();
        pensionPlanJSONObject.put("planRefenceNumber", planReferenceNumber);
        pensionPlanJSONObject.put("enrollmentDate", enrollmentDate);
        pensionPlanJSONObject.put("monthlyContribution", monthlyContribution.toJSONObject());
        return pensionPlanJSONObject;
    }
}
