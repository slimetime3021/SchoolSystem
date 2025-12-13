package org.derick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Department {
    @Getter private String departmentId;
    @Getter private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("D-%02d",  nextId++);
            this.departmentName = departmentName;
        }
        else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    static boolean isDepartmentNameValid(String departmentName) {
        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);
            if (!Character.isAlphabetic(c) & !(c == ' ')){
                return false;
            }
        }
        return true;
    }

    public void setDepartmentName(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = departmentName;
        }
    }
}
