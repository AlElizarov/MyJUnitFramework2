package myJUnit;

class TestMyAssert extends MyTestCase {

	public void testAssertEquals() {
		MyAssert.assertEquals(7, 6);
	}

	public void testAssertNotEquals() {
		MyAssert.assertNotEquals(5, 6);
		throw new NullPointerException();
	}

	public void testAssertTrue() {
		MyAssert.assertTrue("test".equals("test"));
	}

	public void testAssertFalse() {
		MyAssert.assertFalse(5 == 7);
	}

	public void testException() {
		try {
			if (true)
				// throw new Exception();
				MyAssert.fail();
		} catch (Exception e) {

		}
	}

}
