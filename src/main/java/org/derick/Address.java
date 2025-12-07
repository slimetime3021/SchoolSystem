package org.derick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address {
    private String street;
    private String city;
    private Province province;
    String postalCode;


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
