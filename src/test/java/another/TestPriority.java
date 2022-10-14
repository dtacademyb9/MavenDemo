package another;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Test // Annotations can be applied to the class which will apply it to all the methods in the class
public class TestPriority {



//    @Ignore
    @Test (priority = -34)
    public void aTest(){
        System.out.println("A");
    }


//    @Test (priority = 0, enabled = false)
    @Test (priority = 0)
    public void bTest(){
        System.out.println("B");
    }


    @Test (priority = 0)
    public void cTest(){
        System.out.println("C");
    }

    @Test (priority = 21)
    public void dTest(){
        System.out.println("D");
    }

    @Test (priority = 1000)
    public void eTest(){
        System.out.println("E");
    }

    @Test
    public void fTest(){
        System.out.println("F");
    }


}
