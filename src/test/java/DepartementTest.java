import org.derick.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DepartementTest {

    @Test
    @DisplayName("Math -> True")
    void testIsDepartmentNameValid1() {
        String name = "Math";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(name);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Computer Science -> True")
    void testIsDepartmentNameValid2() {
        String name = "Math";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(name);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Math101 -> True")
    void testIsDepartmentNameValid3() {
        String name = "Math101";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(name);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Computer-Science -> True")
    void testIsDepartmentNameValid4() {
        String name = "Math";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(name);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(" -> False")
    void testIsDepartmentNameValid5() {
        String name = "";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(name);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("null -> False")
    void testIsDepartmentNameValid6() {
        String name = null;
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(name);
        Assertions.assertEquals(expected, actual);
    }
}
