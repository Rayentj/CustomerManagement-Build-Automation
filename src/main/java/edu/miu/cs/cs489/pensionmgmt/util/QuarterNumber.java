package edu.miu.cs.cs489.pensionmgmt.util;

public enum QuarterNumber { Q1(1),
    Q2(2),
    Q3(3),
    Q4(4);

    private final int quarterNumber;

    QuarterNumber(int quarterNumber) {
        this.quarterNumber = quarterNumber;
    }

    public int getQuarterNumber() {
        return quarterNumber;
    }
}
