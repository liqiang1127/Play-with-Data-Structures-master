package Array;


public class ArrayTest {
    public static void main(String[] args) {
//        int[] scores = new int[]{1,2,3};
//        for (int score:scores)
//            System.out.println(score);

        Array<Integer> arr = new Array<Integer>(1);
        for(int i = 0; i < 10; i++ )
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        for (int i = 0; i < 7; i++) {
            arr.removeFirst();
        }
        System.out.println(arr);
    }
}
