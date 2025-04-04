package edu.miu.cs.cs489.pensionmgmt.util;

import java.time.LocalDate;

public record Quarter(QuarterNumber quarterNumber,
                      LocalDate startDate,
                      LocalDate endDate) {
}
