package collectons;


/**
 * @Author: KangJieyu
 * @DATE: 2022/3/8 上午11:35
 */
public class Main {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        System.out.println("size " + list.size());
        Integer remove = list.remove(0);
        System.out.println("remove " + remove);
        list.add(10);
        list.add(11, 1);
        System.out.println("size " + list.size());
        System.out.println(list.get(1));
        Integer setNum = list.set(1, 22);
        System.out.println("set " + setNum);
        System.out.println(list.get(1));
        System.out.println(list.contains(11));
        System.out.println(list.contains(22));



//        list.add(200);
////        list.set(2, 10);
//        System.out.println(list.get(0));
//        System.out.println(list.contains(new Integer(20)));
//        System.out.println(list.size());
//        System.out.println(list.toString());


        System.out.println("#####################################");

        java.util.ArrayList list1 = new java.util.ArrayList();
//        System.out.println(list1.contains(1));

//        list1.remove(1);

//        list.add(10);
//        list1.set(2, 10);
//        System.out.println(list1.size());
//        System.out.println(list1.toString());
    }
}
