import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

import static org.junit.Assert.*;

public class HMapTest {
    HMap<Integer, String> map;

    @Before
    public void setUp() throws Exception {
        map = new HMap<Integer, String>();
    }

    @After
    public void tearDown() throws Exception {

    }

    //@Test
    //public void elementIsNotNull() {
    //    assertNotNull(new HMap<Integer, String>.Element<Integer, String>(0, "Zero"));
    //}

    @Test
    public void putMethodPuts() {
        assertEquals("test", map.put(0, "test"));
    }

    @Test
    public void containsValueTrue() {
        map.put(0, "test");
        assertTrue(map.containsValue("test"));
    }

    @Test
    public void containsValueFalse() {
        assertFalse(map.containsValue("test"));
    }

    @Test
    public void containsKeyTrue() {
        map.put(0, "test");
        assertTrue(map.containsKey(0));
    }

    @Test
    public void containsKeyFalse() {
        assertFalse(map.containsKey(0));
    }

    @Test
    public void isEmpty() {
        assertTrue(map.isEmpty());
    }

    @Test
    public void isNotEmpty() {
        map.put(0, "test");
        assertFalse(map.isEmpty());
    }

    @Test
    public void sizeNotZero() {
        map.put(0, "test");
        assertEquals(1, map.size());
    }

    @Test
    public void sizeIsZero() {
        assertEquals(0, map.size());
    }

    @Test
    public void sizeIsExact() {
        map.put(0, "test_0");
        map.put(1, "test_1");
        map.put(2, "test_2");
        map.put(3, "test_3");
        map.put(4, "test_4");
        assertEquals(5, map.size());
    }

    @Test
    public void clearReturnsEmptyMap() {
        map.put(0, "test_0");
        map.clear();
        assertTrue(map.isEmpty());
    }

    @Test
    public void valuesReturnsRightValues() {
        Set<String> check = new HashSet<>(Arrays.asList("test_0", "test_1", "test_2"));
        map.put(0, "test_0");
        map.put(1, "test_1");
        map.put(2, "test_2");
        assertEquals(check, map.values());
    }

    @Test
    public void keySetReturnsRightKeySet() {
        Set<Integer> check = new HashSet<>(Arrays.asList(0, 1, 2));
        map.put(0, "test_0");
        map.put(1, "test_1");
        map.put(2, "test_2");
        assertEquals(check, map.keySet());
    }

    @Test
    public void removeRemovesRightObject() {
        map.put(0, "test_0");
        assertEquals("test_0", map.remove(0));
    }

    @Test
    public void removeReturnsNullOnNotExistedKey() {
        assertNull(map.remove(0));
    }

    @Test
    public void getReturnsRightObject() {
        map.put(0, "test_0");
        assertEquals("test_0", map.get(0));
    }

    @Test
    public void getReturnsNullOnNotExistedKey() {
        assertNull(map.get(0));
    }

    @Test
    public void keySetReturnNullIfMapIsEmpty() {
        assertNull(map.keySet());
    }

    @Test
    public void valuesReturnNullIfMapIsEmpty() {
        assertNull(map.values());
    }

    @Test
    public void putReturnsNullIfEitherOfArgsIsNUll() {
        assertNull(map.put(null, "test"));
    }
}