import businessLogic.Operations;
import dataModels.Polynomial;
import org.junit.Assert;
import org.junit.Test;

public class TestOperations {
    public TestOperations() {

    }

    @Test
    public void testAdunare() {
        Polynomial polinom1 = Polynomial.parsePolynomial("2X^3+X^2+3X^1");
        Polynomial polinom2 = Polynomial.parsePolynomial("5X^4+2X^2+X^1");
        Polynomial result = Operations.add(polinom1, polinom2);
        Assert.assertTrue(result.toString().equals("+5.0X^4+2.0X^3+3.0X^2+4.0X"));
    }

    @Test
    public void testScadere() {
        Polynomial polinom1 = Polynomial.parsePolynomial("5X^3+10X^1+3X^0");
        Polynomial polinom2 = Polynomial.parsePolynomial("6X^3-2X^2-2X^1+X^0");
        Polynomial result = Operations.decrease(polinom1, polinom2);
        Assert.assertTrue(result.toString().equals("-X^3+2.0X^2+12.0X+2.0"));
    }

    @Test
    public void testInmultire() {
        Polynomial polinom1 = Polynomial.parsePolynomial("5X^3+2X^1");
        Polynomial polinom2 = Polynomial.parsePolynomial("2X^1+X^0");
        Polynomial result = Operations.multiply(polinom1, polinom2);
        Assert.assertTrue(result.toString().equals("+10.0X^4+5.0X^3+4.0X^2+2.0X"));
    }

    @Test
    public void testImpartire() {
        Polynomial polinom1 = Polynomial.parsePolynomial("6X^5-17X^3-X^2+3X^0");
        Polynomial polinom2 = Polynomial.parsePolynomial("3X^2-6X^1+2X^0");
        Polynomial q = new Polynomial();
        Polynomial result = Operations.divide(polinom1, polinom2, q);
        Assert.assertTrue(result.toString().equals("-8.0X+5.0"));
        Assert.assertTrue(q.toString().equals("+2.0X^3+4.0X^2+X-1.0"));
    }

    @Test
    public void testDerivare() {
        Polynomial polinom = Polynomial.parsePolynomial("5X^2+4X^1-2X^0");
        Polynomial result = Operations.derivative(polinom);
        Assert.assertTrue(result.toString().equals("+10.0X+4.0"));
    }

    @Test
    public void testIntegrare() {
        Polynomial polinom = Polynomial.parsePolynomial("2X^3+4X^1+11X^0");
        Polynomial result = Operations.integral(polinom);
        Assert.assertTrue(result.toString().equals("+0.5X^4+2.0X^2+11.0X"));
    }

}
