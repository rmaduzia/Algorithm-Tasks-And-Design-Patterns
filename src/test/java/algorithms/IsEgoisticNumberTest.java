package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsEgoisticNumberTest {


    @Test
    public void shouldReturnTrueThatItsEgoisticNumber() {

        assertTrue(IsEgoisticNumber.execute(5));

    }

    @Test
    public void shouldReturnFalseThatItsNotEgoisticNumber() {

        assertFalse(IsEgoisticNumber.execute(4));

    }




}
