package JUnitNotes;

/**
 * Created by JMYE on 6/26/17.
 */
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
public class InstanceOfTest {
    @Test
    public void testInstanceOf() {
        SubClass subClass = new SubClass();
        assertThat(subClass, instanceOf(BaseClass.class));
    }
}
