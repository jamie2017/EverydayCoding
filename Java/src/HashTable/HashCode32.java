package HashTable;
import java.util.Arrays;
import java.util.Collection;
import java.util.zip.CRC32;
/**
 * Created by JMYE on 11/23/16.
 */
public class HashCode32 {
    private Collection<String> strings;

    public HashCode32(Collection<String> strings) {
        this.strings = strings;
    }

    public int hashCode() {
        CRC32 crc = new CRC32();
        for(String string : strings) {
            crc.update(string.getBytes());
        }

        return (int)( crc.getValue() );
    }
    public static void main(String[] args) { // similar hashcode for similar input
        Collection<String> list1 = Arrays.asList("YYYYji,anmei".split(","));
        HashCode32 test1 = new HashCode32(list1);
        System.out.println(test1.hashCode());
        Collection<String> list2 = Arrays.asList("jia,nmei".split(","));
        HashCode32 test2 = new HashCode32(list2);
        System.out.println(test2.hashCode());
    }
}
