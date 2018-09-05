package triangle;

import junit.framework.TestCase;
import org.junit.Assert;
import static triangle.Triangle.Type.*;

public class TestSuite extends TestCase {

   public void test1() {
        Assert.assertEquals (triangle.Triangle.classify(0,1301,1), INVALID);
   }
   public void test2() {
        Assert.assertEquals (triangle.Triangle.classify(1108,1,1), INVALID);
   }
   public void test3() {
        Assert.assertEquals (triangle.Triangle.classify(1,0,-665), INVALID);
   }
   public void test4() {
        Assert.assertEquals (triangle.Triangle.classify(1,1,0), INVALID);
   }
   public void test5() {
        Assert.assertEquals (triangle.Triangle.classify(582,582,582), EQUILATERAL);
   }
   public void test6() {
        Assert.assertEquals (triangle.Triangle.classify(1,1088,15), INVALID);
   }
   public void test7() {
        Assert.assertEquals (triangle.Triangle.classify(1,2,450), INVALID);
   }
   public void test8() {
        Assert.assertEquals (triangle.Triangle.classify(1663,1088,823), SCALENE);
   }
   public void test9() {
        Assert.assertEquals (triangle.Triangle.classify(1187,1146,1), INVALID);
   }
   public void test10() {
        Assert.assertEquals (triangle.Triangle.classify(1640,1640,1956), ISOSCELES);
   }
   public void test11() {
        Assert.assertEquals (triangle.Triangle.classify(784,784,1956), INVALID);
   }
   public void test12() {
        Assert.assertEquals (triangle.Triangle.classify(1,450,1), INVALID);
   }
   public void test13() {
        Assert.assertEquals (triangle.Triangle.classify(1146,1,1146), ISOSCELES);
   }
   public void test14() {
        Assert.assertEquals (triangle.Triangle.classify(1640,1956,1956), ISOSCELES);
   }
   public void test15() {
        Assert.assertEquals (triangle.Triangle.classify(-1,1,1), INVALID);
   }
   public void test16() {
        Assert.assertEquals (triangle.Triangle.classify(1,-1,1), INVALID);
   }
   public void test17() {
        Assert.assertEquals (triangle.Triangle.classify(1,2,3), INVALID);
   }
   public void test18() {
        Assert.assertEquals (triangle.Triangle.classify(2,3,1), INVALID);
   }
   public void test19() {
        Assert.assertEquals (triangle.Triangle.classify(3,1,2), INVALID);
   }
   public void test20() {
        Assert.assertEquals (triangle.Triangle.classify(1,1,2), INVALID);
   }
   public void test21() {
        Assert.assertEquals (triangle.Triangle.classify(1,2,1), INVALID);
   }
   public void test22() {
        Assert.assertEquals (triangle.Triangle.classify(2,1,1), INVALID);
   }
   public void test23() {
        Assert.assertEquals (triangle.Triangle.classify(1,1,1), EQUILATERAL);
   }
   public void test24() {
        Assert.assertEquals (triangle.Triangle.classify(0,1,1), INVALID);
   }
   public void test25() {
        Assert.assertEquals (triangle.Triangle.classify(1,0,1), INVALID);
   }
   public void test26() {
        Assert.assertEquals (triangle.Triangle.classify(1,2,-1), INVALID);
   }
   public void test27() {
        Assert.assertEquals (triangle.Triangle.classify(1,1,-1), INVALID);
   }
   public void test28() {
        Assert.assertEquals (triangle.Triangle.classify(0,0,0), INVALID);
   }
   public void test29() {
        Assert.assertEquals (triangle.Triangle.classify(3,2,5), INVALID);
   }
   public void test30() {
        Assert.assertEquals (triangle.Triangle.classify(5,9,2), INVALID);
   }
   public void test31() {
        Assert.assertEquals (triangle.Triangle.classify(7,4,3), INVALID);
   }
   public void test32() {
        Assert.assertEquals (triangle.Triangle.classify(3,8,3), INVALID);
   }
   public void test33() {
        Assert.assertEquals (triangle.Triangle.classify(7,3,3), INVALID);
   }
}
