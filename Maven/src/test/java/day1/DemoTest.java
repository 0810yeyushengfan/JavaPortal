package day1;

import org.junit.Assert;
import org.junit.Test;

public class DemoTest {

    @Test
    public void testSay(){
        Demo d=new Demo();
        String ret=d.sayName("maven");
        Assert.assertEquals("hellomaven",ret);

    }
}
