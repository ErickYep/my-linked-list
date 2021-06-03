public class Node<T> {
    Node<T> next;
    Node<T> previous;
    T value;

    public Node(T value) {
        this.value = value;
    }
}
