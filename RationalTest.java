import junit.framework.TestCase;

public class RationalTest extends TestCase {

    protected Rational HALF;

    protected void setUp() {
      HALF = new Rational( 1, 2 );
    }

    // Create new test
    public RationalTest (String name) {
        super(name);
    }

    // Test addition
    public void testPlus() {
    	assertEquals((new Rational(1,3)).plus(new Rational(1,3)), new Rational(2,3));
    	assertEquals((new Rational(1,3)).plus(new Rational(2,3)), new Rational(1,1));
    	assertEquals((new Rational(2,3)).plus(new Rational(1,3)), new Rational(1,1));
    	assertEquals((new Rational(1,3)).plus(new Rational(1,5)), new Rational(8,15));
    	assertEquals((new Rational(2,15)).plus(new Rational(4,6)), new Rational(4,5));
    }
    
    // Test subtraction
    public void testMinus() {
    	assertEquals((new Rational(1,3)).minus(new Rational(1,3)), new Rational(0,0));
    	assertEquals((new Rational(1,3)).minus(new Rational(2,3)), new Rational(-1,3));
    	assertEquals((new Rational(2,3)).minus(new Rational(1,3)), new Rational(1,3));
    	assertEquals((new Rational(1,3)).minus(new Rational(1,5)), new Rational(2,15));
    	assertEquals((new Rational(4,5)).minus(new Rational(4,6)), new Rational(2,15));
    }
    
    // Test for equality
    public void testEquality() {
        assertEquals(new Rational(1,3), new Rational(1,3));
        assertEquals(new Rational(1,3), new Rational(2,6));
        assertEquals(new Rational(3,3), new Rational(1,1));
    }

    // Test for nonequality
    public void testNonEquality() {
        assertFalse(new Rational(2,3).equals(
            new Rational(1,3)));
    }

    public void testAccessors() {
    	assertEquals(new Rational(2,3).numerator(), 2);
    	assertEquals(new Rational(2,3).denominator(), 3);
    }

    public void testRoot() {
        Rational s = new Rational( 1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) ) 
                        && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }

    public static void main(String args[]) {
        String[] testCaseName = 
            { RationalTest.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }
}
