package test;
import MyMath.Monom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.*;

public class MonomTest {
    private Monom monom=new Monom(2,3);

    @Test
    public void add() throws Exception {
        monom.add(new Monom(4,3));
        assertEquals(new Monom(6,3),monom);
    }

    @Test
    public void equals() throws Exception {

        assertEquals(new Monom(2,3),monom);
        assertNotSame(new Monom(2,3),monom);
    }

    @Test
    public void derivative() throws Exception {
        assertEquals(new Monom(2*3,2),monom.derivative());
        assertNotSame(new Monom(2*3,2),monom.derivative());
    }

    @Test
    public void get_coefficient() throws Exception {
        if(monom.get_coefficient()!=2)
            fail();
    }

    @Test
    public void get_power() throws Exception {
        assertEquals(3,monom.get_power());
    }

    @Test
    public void f() throws Exception {
        Monom m=new Monom(monom);
        assertEquals((Double) (2*Math.pow(2,3)),(Double) monom.f(2));

    }



}