import java.util.function.Predicate;

public class RishabhJava8 {

    public static void main(String[] args) {
        Predicate<Integer> obj = (a)-> a/2==0;

        Predicate<String> obj1 = (String x )-> x.startsWith("A");
        System.out.println(obj1.test(" rishabh"));
    }

}
