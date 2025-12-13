import org.derick.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    @DisplayName("a1b2c3 -> True")
    void testIsPostalCodeValid1() {
        String postalCode = "a1b2c3";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("a1b2c -> False")
    void testIsPostalCodeValid2() {
        String postalCode = "a1b2c";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("a1b2c3d -> False")
    void testIsPostalCodeValid3() {
        String postalCode = "a1b2c3d";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("aab2c -> False")
    void testIsPostalCodeValid4() {
        String postalCode = "aab2c";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("11b2c3 -> False")
    void testIsPostalCodeValid5() {
        String postalCode = "11b2c";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    @DisplayName("null -> False")
    void testIsPostalCodeValid6() {
        String postalCode = null;
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }
}
