import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WebCrawlerTest {

    WebCrawler crawler = new WebCrawler();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void crawlerNotNull() {
        assertTrue(crawler != null);
    }
}