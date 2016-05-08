package net.sf.freecol.server.model;

import net.sf.freecol.util.test.FreeColTestCase;

import org.junit.Test;

/**
 * The class <code>FakeTransactionSessionTest</code> contains tests for the
 * class {@link <code>FakeTransactionSession</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 5/7/16 7:23 PM
 *
 */
public class FakeTransactionSessionTest extends FreeColTestCase {	

	/**
	 * Construct fake transaction session with a duplicate session
	 * in the table, so an exception should be thrown
	 *
	 */
	public void testFakeTransactionSession() {
		String fakeKey = "key";
		
		// Create the first session (this should work)
		new FakeTransactionSession(fakeKey);
		
		try{
			// Create the second session (this should throw exc)
			new FakeTransactionSession(fakeKey);
			
			fail(); // should never get here if duplicate key checking works
		}catch(IllegalArgumentException exc){
			assertEquals("Duplicate session: "+ fakeKey, exc.getMessage());
		}
	}
	
	public void testComplete(){
		TransactionSession ts = new FakeTransactionSession("key2");
		
		ts.complete(null);
	}
}
