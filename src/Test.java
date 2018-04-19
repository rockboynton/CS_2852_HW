
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        List<String> as = new ArrayList<>();
        as.add("foo");
        as.add("bar");
        as.add("foo");
//        List<String> bs = new LinkedList<String>(100000000);
        System.out.println(areUnique(as));
//        System.out.println(areUnique(bs));
    }
    public static boolean areUnique(List<String> strings) {
        boolean areUnique = true;
        int size = strings.size();
        for (int i = 0; areUnique && i < size; i++) {
            for (int j = 0; areUnique && j < size; j++) {
                if (i != j && strings.get(i).equals(strings.get(j))) {
                    areUnique = false;
                }
             }
        }
        return areUnique;
    }
}
