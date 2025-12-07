package org.derick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Address {
    @Setter private String street;
    @Setter private String city;
    @Setter private Province province;
    private String postalCode;


    static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }

        postalCode = postalCode.toUpperCase();
        for (int i = 0; i < postalCode.length(); i++) {
            if (i % 2 == 0) {
                if (!Character.isAlphabetic(postalCode.charAt(i))) {
                    return false;
                }
            }
            if (i % 2 == 1){
                if (!Character.isDigit(postalCode.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public void setPostalCode(String postalCode) {
        if (!isPostalCodeValid(postalCode)) {
            System.out.println("Postal code is invalid");
            return;
        }
        this.postalCode = postalCode;
    }

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
