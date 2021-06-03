public class MyLinkedList<T> implements MyList<T> {
    Node<T> first;
    Node<T> last;
    int size;

    @Override
    public void add(T obj) {
        Node<T> node = new Node<>(obj);
        if (size == 0) {
            first = node;
            last = node;
            size++;
        } else if (size == 1) {
            last.next = node;
            last = node;
            last.previous = first;
            size++;
            last.next = first;
            first.previous = last;
        } else {
            last.next = node;
            node.previous = last;
            last = node;
            size++;
            last.next = first;
            first.previous = last;
        }
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        if (index * 2 >= size) {
            Node<T> current = last;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
            return current.value;

        } else {
            Node<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;

        }
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            first = first.next;
            size--;
        }
        if (index == size - 1) {
            last = last.previous;
            size--;
        }
        if (index * 2 >= size) {
            Node<T> current = last;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
            current.next.previous = current.previous;
            current.previous.next = current.next;
            size--;
        } else {
            Node<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.next.previous = current.previous;
            current.previous.next = current.next;
            size--;
        }
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            str.append(current.value);
            current = current.next;
            if (i < size - 1) {
                str.append(",");
            }
        }
        str.append("]");
        return str.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Your index is out of bounds");
    }
}
