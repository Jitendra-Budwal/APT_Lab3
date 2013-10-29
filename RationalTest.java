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
    
    // Test Accessors
    public void testAccessors() {
    	assertEquals(2 , new Rational(2,3).numerator());
    	assertEquals(3 , new Rational(2,3).denominator());
    }


    // Test reducer
    public void testReducer() {
    	assertEquals(7 , new Rational(56,24).numerator());
    	assertEquals(3 , new Rational(56,24).denominator());
	// try negative numbers
    	assertEquals(7 , new Rational(-56,-24).numerator());
    	assertEquals(3 , new Rational(-56,-24).denominator());
    }

    // Test for equality
    public void testEquality() {
        assertEquals(new Rational(1,3),	new Rational(1,3));
        assertEquals(new Rational(1,3),	new Rational(-1,-3));
        assertEquals(new Rational(1,3),	new Rational(-12,-36));
        assertEquals(new Rational(1,3),	new Rational(2,6));
        assertEquals(new Rational(3,3),	new Rational(1,1));
    }

    // Test for nonequality
    public void testNonEquality() {
        assertFalse(new Rational(2,3).equals(
            new Rational(1,3)));
    }

    // Test addition
    public void testPlus() {
    	assertEquals(new Rational(2,3) , (new Rational(1,3)).plus(new Rational(1,3)));
    	assertEquals(new Rational(1,1) , (new Rational(1,3)).plus(new Rational(2,3)));
    	assertEquals(new Rational(1,1) , (new Rational(2,3)).plus(new Rational(1,3)));
    	assertEquals(new Rational(8,15) , (new Rational(1,3)).plus(new Rational(1,5)));
    	assertEquals(new Rational(4,5) , (new Rational(2,15)).plus(new Rational(4,6)));
	//try negative denominators
    	assertEquals(new Rational(22,15) , (new Rational(4,5)).plus(new Rational(-4,-6)));
    	assertEquals(new Rational(-22,15) , (new Rational(-4,5)).plus(new Rational(-4,6)));
    	assertEquals(new Rational(-22,15) , (new Rational(4,-5)).plus(new Rational(-4,6)));
    	assertEquals(new Rational(-22,15) , (new Rational(4,-5)).plus(new Rational(4,-6)));
    	assertEquals(new Rational(-22,15) , (new Rational(-4,5)).plus(new Rational(4,-6)));
    }
    
    // Test multiplication
    public void testMultiply() {
    	assertEquals(new Rational(7,9) , (new Rational(56,24)).times(new Rational(1,3)));
    	assertEquals(new Rational(2,9) , (new Rational(1,3)).times(new Rational(2,3)));
    	assertEquals(new Rational(2,9) , (new Rational(2,3)).times(new Rational(1,3)));
    	assertEquals(new Rational(1,15) , (new Rational(1,3)).times(new Rational(1,5)));
    	assertEquals(new Rational(8,15) , (new Rational(4,5)).times(new Rational(4,6)));
	//try negative denominators
    	assertEquals(new Rational(7,9) , (new Rational(56,24)).times(new Rational(-1,-3)));
    	assertEquals(new Rational(-2,9) , (new Rational(1,3)).times(new Rational(-2,3)));
    	assertEquals(new Rational(-2,9) , (new Rational(2,3)).times(new Rational(1,-3)));
    	assertEquals(new Rational(1,15) , (new Rational(-1,3)).times(new Rational(-1,5)));
    	assertEquals(new Rational(8,15) , (new Rational(4,-5)).times(new Rational(4,-6)));
    }

    // Test subtraction
    public void testMinus() {
    	assertEquals(new Rational(0,1) , (new Rational(1,3)).minus(new Rational(1,3)));
    	assertEquals(new Rational(-1,3) , (new Rational(1,3)).minus(new Rational(2,3)));
    	assertEquals(new Rational(1,3) , (new Rational(2,3)).minus(new Rational(1,3)));
    	assertEquals(new Rational(2,15) , (new Rational(1,3)).minus(new Rational(1,5)));
    	assertEquals(new Rational(2,15) , (new Rational(4,5)).minus(new Rational(4,6)));
	//try negative denominators
    	assertEquals(new Rational(2,15) , (new Rational(4,5)).minus(new Rational(-4,-6)));
    	assertEquals(new Rational(-2,15) , (new Rational(-4,5)).minus(new Rational(-4,6)));
    	assertEquals(new Rational(-2,15) , (new Rational(4,-5)).minus(new Rational(-4,6)));
    	assertEquals(new Rational(-2,15) , (new Rational(4,-5)).minus(new Rational(4,-6)));
    	assertEquals(new Rational(-2,15) , (new Rational(-4,5)).minus(new Rational(4,-6)));
    }
    
    // Test division
    public void testDivision() {
    	assertEquals(new Rational(7,1) , (new Rational(56,24)).divides(new Rational(1,3)));
    	assertEquals(new Rational(1,2) , (new Rational(1,3)).divides(new Rational(2,3)));
    	assertEquals(new Rational(2,1) , (new Rational(2,3)).divides(new Rational(1,3)));
    	assertEquals(new Rational(5,3) , (new Rational(1,3)).divides(new Rational(1,5)));
    	assertEquals(new Rational(6,5) , (new Rational(4,5)).divides(new Rational(4,6)));
	//try negative denominators
    	assertEquals(new Rational(7,1) , (new Rational(56,24)).divides(new Rational(-1,-3)));
    	assertEquals(new Rational(-1,2) , (new Rational(1,3)).divides(new Rational(-2,3)));
    	assertEquals(new Rational(-2,1) , (new Rational(2,3)).divides(new Rational(1,-3)));
    	assertEquals(new Rational(5,3) , (new Rational(-1,3)).divides(new Rational(-1,5)));
    	assertEquals(new Rational(6,5) , (new Rational(4,-5)).divides(new Rational(4,-6)));
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
