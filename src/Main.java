public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(4);
        list.add(5);
        System.out.println(list);
        list.add(6);
        list.add(7);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.get(2);

    }
}
