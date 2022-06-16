package main.java;

import java.util.Objects;

public class MyStack<T> {
    private Node<T> head;
    private int size;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = head;
        while (node != null) {
            sb.append(node.element).append(" ");
            node = node.next;
        }
        return sb.toString();
    }

    // добавляет элемент в конец
    public void push(Object value) {
        Node<T> node = new Node<>((T) value);
        node.next = head;
        head = node;
        size++;
    }

    //удаляет элемент под индексом
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement;
        if (index == 0) {
            removedElement = head.element;
            head = head.next;
            if (head == null) {
                head.next = null;
            }
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            removedElement = prev.element;
            prev.next = prev.next.next;
        }
        size--;
        return removedElement;

    }

    private Node<T> getNodeByIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Элементов с таким индексом нет");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    //очищает коллекцию
    public void clear() {
        head = null;
        size = 0;
    }

    //возвращает размер коллекции
    public int size() {
        return size;
    }

    //возвращает первый элемент в стеке (LIFO)
    public T peek() {
        return head.element;
    }

    // возвращает первый элемент в стеке и удаляет его из коллекции
    public T pop() {
        T element = head.element;
        head = head.next;
        size--;
        return element;

    }

    private static class Node<T> {
        T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
        }

    }
}