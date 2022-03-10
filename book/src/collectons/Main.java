package collectons;


/**
 * @Author: KangJieyu
 * @DATE: 2022/3/8 上午11:35
 */
public class Main {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list);
        list.add(10);
        System.out.println("size = " + list.size()+ "\t" + list);
        list.add(11, 0);
        System.out.println("size = " + list.size()+ "\t" + list);
        list.add(12,2);
        System.out.println("size = " + list.size()+ "\t" + list);
        list.set(0, 100);
        System.out.println("size = " + list.size()+ "\t" + list);
        System.out.println(list.contains(100));
        list.remove(0);
        System.out.println("size = " + list.size()+ "\t" + list);
        System.out.println(list.contains(100));
        list.remove(2);
        System.out.println("size = " + list.size()+ "\t" + list);
        list.set(0, 100);
        System.out.println("size = " + list.size()+ "\t" + list);
        System.out.println(list.get(0));



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
