package triangle;
import org.junit.Assert;

public class Triangle {
   
    public enum Type {
        INVALID, SCALENE, EQUILATERAL, ISOSCELES
    };
   
    public static void main(String [] args) {
        Assert.assertEquals (triangle.Triangle.classify(0,1301,1), Type.INVALID);
        Assert.assertEquals (triangle.Triangle.classify(1108,1,1), Type.INVALID);
        Assert.assertEquals (triangle.Triangle.classify(1,0,-665), Type.INVALID);
        Assert.assertEquals (triangle.Triangle.classify(1,1,0), Type.INVALID);
        Assert.assertEquals (triangle.Triangle.classify(582,582,582), Type.EQUILATERAL);
    }

    public static Type classify(int a, int b, int c) {
        int trian;
        if (a <= 0 || b <= 0 || c <= 0)
            return Type.INVALID;
            trian = 0;
        if (a == b)
            trian = trian + 1;
        if (a == c)
            trian = trian + 2;
        if (b == a) //inserted bug: should be b == c
            trian = trian + 3;
        if (trian == 0)
            if (a + b <= c || a + c <= b || b + c <= a)
                return Type.INVALID;
            else
                return Type.SCALENE;
        if (trian > 3)
            return Type.EQUILATERAL;
        if (trian == 1 && a + b > c)
            return Type.ISOSCELES;
        else if (trian == 2 && a + c > b)
            return Type.ISOSCELES;
        else if (trian == 3 && b + c > a)
            return Type.ISOSCELES;
        return Type.INVALID;
    }
}
