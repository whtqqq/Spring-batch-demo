package jp.co.misumi.Spring_Batch;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private static Logger logger = LoggerFactory.getLogger(AppTest.class);

    /**
     * Create the test case
     *
     * @param testName name of the test case
     * 
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        TestSuite suite = new TestSuite("Running all tests.");
        suite.addTestSuite(AppTest.class);
        suite.addTestSuite(ItemProcessorTest.class);
        return suite;
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        logger.info("<----test app begin------>");
    }
}
