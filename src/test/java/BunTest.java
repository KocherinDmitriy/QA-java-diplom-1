import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


public class BunTest {
    private Bun bun = new Bun("delicious", 0.77f);

    @Test
    public void returnBunNameTest() {

        assertEquals("delicious", bun.getName());
    }

    @Test
    public void returnBunPriceTest() {
        assertEquals(0.77f, bun.getPrice(), 0);
    }
}
