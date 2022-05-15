import java.util.List;
import java.util.Objects;

public class TestClass {

    public static void main(String[] args) {
        System.out.println("Data structure and Algorithms.!!");
        List<Integer> list = null;

        if(Objects.nonNull(list)) {
            for (Integer i : list) {
                System.out.println("reading the elements.");
            }
        }else {
            System.out.println("Please add new elements to the list.");
        }

    }
}
