import java.util.ArrayList;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import java.util.Collections;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<String> obj = new ArrayList<>();
        obj.add("rihsabh");
        obj.add("randin");
        obj.add("kumar");
        obj.add("sign");
        obj.add("Card");
        obj.add("new");

        Collections.sort(obj,(a,b)->{
            if(b.length() >a.length())
            {
                return 1;
            }else {
             return -1;
            }

        });

        System.out.println(obj);
    }
}


