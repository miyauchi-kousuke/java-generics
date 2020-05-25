import java.util.List;

public class Hoge {
    public static void main(String[] args) {
        System.out.println(F1Constructor.FERRARI.getCode());
        System.out.println(F1Constructor.FERRARI.getName());

        System.out.println(F1Constructor2.FERRARI.getCode());
        System.out.println(F1Constructor2.FERRARI.getName());
        System.out.println(F1Constructor2.FERRARI.equalsByCode("01"));

        List<F1Constructor2> sortedList = CodeEnum2.getOrderedList(F1Constructor2.class);
        sortedList.forEach(e -> System.out.println("code:" + e.getCode() + ",name:" + e.getName()));

        System.out.println("-----------");

        CodeEnum2.getMap(F1Constructor2.class)
                .entrySet()
                .forEach(e -> System.out.println("code:" + e.getKey() + ",Enum:" + e.getValue()));

        System.out.println(CodeEnum2.hasCode(F1Constructor2.class, "10"));
        System.out.println(CodeEnum2.hasCode(F1Constructor2.class, "21"));

        F1Constructor2 hoge = CodeEnum2.getEnum(F1Constructor2.class,"hoge");
        if (hoge != null){
            System.out.println(hoge.getCode());
        }else {
            System.out.println("hoge is null");
        }
    }
}
