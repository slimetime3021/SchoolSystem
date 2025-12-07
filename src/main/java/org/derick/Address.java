package org.derick;

public class Address {
    private String street;
    private String city;
    private Province province;
    String postalCode;




    public enum Province {
        AB,
        MB,
        ON,
        QC,
        SK,
        BC,
        NB,
        NS,
        PEI,
        NL
    }
}
