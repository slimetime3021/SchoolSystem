import org.derick.Assignment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignmentTest {

    @Test
    @DisplayName("scores:{80,90,70} -> 80.0")
    void calculateAssignmentAvgTest1() {
        Assignment assignment = new Assignment("quiz", 10.0);

        assignment.getScores().add(80);
        assignment.getScores().add(90);
        assignment.getScores().add(70);

        double avg = assignment.calculateAssignmentAvg();
        double expected = (80 + 90 + 70)/3.0;

        assertEquals(expected, avg);
    }

    @Test
    @DisplayName("scores:{} -> 0.0")
    void calculateAssignmentAvgTest2() {
        Assignment assignment = new Assignment("quiz", 10.0);

        double avg = assignment.calculateAssignmentAvg();
        double expected = 0.0;

        assertEquals(expected, avg);
    }
}
