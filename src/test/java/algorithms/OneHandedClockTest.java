package algorithms;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class OneHandedClockTest {

    @Test
    public void shouldReturnCorrectTime() {
        assertEquals("03:00", OneHandedClock.execute(90));
    }

    @Test
    public void shouldReturnCorrectTime2() {
        assertEquals("12:00", OneHandedClock.execute(0));
    }

    @Test
    public void shouldNotReturnWrongTime() {
        assertNotEquals("09:00", OneHandedClock.execute(50));
    }

}
