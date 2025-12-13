package org.derick;

public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;




    static boolean isDepartmentNameValid(String departmentName) {
        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);
            if (!Character.isAlphabetic(c) & !(c == ' ')){
                return false;
            }
        }
        return true;
    }
}
