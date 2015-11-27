import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by JulianStellaard on 26/11/15.
 */

public class SafeTest {
    private static final String password = Password.INITIAL;
    private static final String wrongPassword = "garbage";

    private Safe safe;

    @Before
    public void setUp(){
        safe = new Safe();
    }

    @Test
    public void testInitial() {
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
        assertTrue(safe.getPassword().testWord(password));
    }

    @Test
    public void testClosing(){
        assertTrue(safe.activate(password));
        assertFalse(safe.isOpen());
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
        safe.close();
        assertFalse(safe.isOpen());
    }

    @Test
    public void testClosingWithWrongPassword(){
        assertFalse(safe.activate(wrongPassword));
        assertFalse(safe.isOpen());
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
        safe.close();
        assertFalse(safe.isOpen());
    }

    @Test
    public void testOpening(){
        assertFalse(safe.open(password));
        assertFalse(safe.open(password));
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testOpeningWithWrongPassword(){
        assertFalse(safe.open(wrongPassword));
        assertFalse(safe.open(wrongPassword));
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

}
