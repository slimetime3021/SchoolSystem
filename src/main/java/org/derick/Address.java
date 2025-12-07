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

    public Address(String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode;
        } else {
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }

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
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode;
        } else {
            System.out.println("Postal code is invalid");
        }
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
