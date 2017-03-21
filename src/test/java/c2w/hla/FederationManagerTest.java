package c2w.hla;

import org.junit.BeforeClass;
import org.junit.Test;

public class FederationManagerTest {

	FederationManager sut;
	
	@BeforeClass
	public void beforeClass() {
		try {
			sut = null;
			sut = new FederationManager(null, null, null, null, null, false, null, 0, 0, false, 0, 0,
					false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetFederationId() {
		String id = sut.getFederationId();	
	}

	@Test
	public void testGetFederateId() {
//		fail("Not yet implemented");
	}

}
