package lab3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import balloon4.Balloon;


public class BalloonTests {
	private static final double EPSILON = 10e-07;
	private Balloon b;
	@Before
	public void setup() { // initializes balloon to 5
		b = new Balloon(5);
	}
	 @Test
	public void testInitial() {			// checks if b is popped or not	
		assertEquals(false, b.isPopped());
	}
	@Test
	public void testInitialRadius() {
		assertEquals(0.0, b.getRadius(), EPSILON); // checks if a new balloon has radius 0
		
	}
	@Test
	public void testDeflate() {		// checks if the balloon is deflated (not popped)
		b.deflate();
		assertEquals(false, b.isPopped());
	}
	@Test
	public void testRadiusAfterDeflation() {
		b.deflate();
		
		assertEquals(0.0, b.getRadius(), EPSILON);
	}
	@Test
	public void testBlow() { // checks if blow method increases radius
		b.blow(5);
		assertEquals(5.0, b.getRadius(), EPSILON);
	}
	@Test
	public void testPop() { // checks if popping balloon marks it as popped
		b.pop();
		assertEquals(true, b.isPopped());
	}
	@Test
	public void testBalloonNegative() { // tests balloon with negative max radius
		b = new Balloon(-2);
		assertEquals(0.0, b.getRadius(), EPSILON);
	}
	@Test
	public void testBlowNegative() {  // blowing negative should not make radius negative
		
		b.blow(-2);
		assertEquals(0.0, b.getRadius(), EPSILON);
	}
	@Test
	public void testBlowBeyondMax() { // should be popped when beyond max
	    b.blow(6); 
	    assertEquals(true, b.isPopped()); 
	    assertEquals(0.0, b.getRadius(), EPSILON); 
	}
	@Test
	public void testBlowMultipleTimes() { // Should not be 2.0! 
	    b.blow(2); 
	    assertEquals(2.0, b.getRadius(), EPSILON); 

	    b.blow(2); 
	    assertEquals(4.0, b.getRadius(), EPSILON); 
	}
	@Test
	public void testBlowAtMaxRadius() { 
	    b.blow(5); 
	    assertEquals(5.0, b.getRadius(), EPSILON); 
	    assertFalse(b.isPopped()); 
	}
	@Test
	public void testDeflateTwice() { // deflate twice should still be 0
	    b.blow(4); 
	    b.deflate(); 
	    assertEquals(0.0, b.getRadius(), EPSILON);

	    b.deflate();
	    assertEquals(false, b.isPopped());
	    assertEquals(0.0, b.getRadius(), EPSILON);
	     
	}
	@Test
	public void testMaxRadiusZero() { // if radius is 0 should not be able to add to it
	    b = new Balloon(0); 
	    b.blow(1); 
	    assertEquals(0.0, b.getRadius(), EPSILON); 
	}
	@Test
	public void testDeflatePoppedBalloon() { // should be 0
	    b.blow(6); 
	    assertEquals(true, b.isPopped()); 

	    b.deflate(); 
	    assertTrue(b.isPopped()); 
	    assertEquals(0.0, b.getRadius(), EPSILON); 
	}
	@Test
	public void testBlowPoppedBalloon() {
	    b.blow(6);  // Pops the balloon
	    assertTrue(b.isPopped());

	    b.blow(2);  // Try blowing again after it's popped
	    assertEquals(0.0, b.getRadius(), EPSILON);  // Radius should remain 0
	    assertTrue(b.isPopped());  // Should still be popped
	}
}