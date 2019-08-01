public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            T[] a = (T[]) new Object[size * 2];
            System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
            System.arraycopy(items, 0, a, items.length - nextFirst -1, nextFirst + 1);
            items = a;
            nextFirst = items.length - 1;
            nextLast = size;
        }
        items[nextFirst] = item;
        if (nextFirst >= 1) {
            nextFirst = nextFirst - 1;
        } else {
            nextFirst = items.length - 1;
        }
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            T[] a = (T[]) new Object[size * 2];
            System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
            System.arraycopy(items, 0, a, items.length - nextFirst - 1, nextFirst + 1);
            items = a;
            nextFirst = items.length - 1;
            nextLast = size;
        }
        items[nextLast] = item;
        if (nextLast < items.length -1) {
            nextLast += 1;
        } else {
            nextLast = 0;
        }
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i ++) {
            System.out.print(get(i));
            System.out.print(' ');
        }
        System.out.println();
    }

    public T removeFirst() {
        T item;
        if (size == 0) {
            return null;
        }

        if (nextFirst < items.length - 1)
        {
            item = items[nextFirst + 1];
            items[nextFirst + 1] = null;
            nextFirst = nextFirst + 1;
        } else {
            item = items[0];
            items[0] = null;
            nextFirst = 0;
        }
        size -= 1;

        if (items.length >= 16 && (double) (size / items.length) < 0.25 ) {
            T[] a = (T[]) new Object[items.length / 2];

            if (nextFirst < nextLast) {
                System.arraycopy(items, nextFirst + 1, a, 0, size);
            } else {
                System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
                System.arraycopy(items, 0, a, items.length - nextFirst -1, nextLast);
            }
            items = a;
            nextFirst = items.length - 1;
            nextLast = size;
        }

        return item;
    }

    public T removeLast() {
        T item;
        if (size == 0) {
            return null;
        }

        if (nextLast == 0) {
            item = items[items.length - 1];
            items[items.length - 1] = null;
            nextLast = items.length - 1;
        } else {
            item = items[nextLast - 1];
            items[nextLast - 1] = null;
            nextLast = nextLast - 1;
        }
        size -= 1;

        if (items.length >= 16 && (double) (size / items.length) < 0.25 ) {
            T[] a = (T[]) new Object[items.length / 2];

            if (nextFirst < nextLast) {
                System.arraycopy(items, nextFirst + 1, a, 0, size);
            } else {
                System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
                System.arraycopy(items, 0, a, items.length - nextFirst -1, nextLast);
            }
            items = a;
            nextFirst = items.length - 1;
            nextLast = size;
        }

        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (nextFirst + index + 1 <= items.length) {
            return items[nextFirst + index + 1];
        }
        return items[index - (items.length - nextFirst - 1)];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addLast(0);
        A.addLast(1);
        A.addLast(2);
        A.addLast(3);
        A.addLast(4);
        A.addLast(5);
        A.addLast(6);
        A.addLast(7);
        A.addLast(8);
        A.addLast(9);
        A.addLast(10);
        A.addLast(11);
        A.addLast(12);
        A.addLast(13);
        A.addLast(14);
        A.addLast(15);
        A.addLast(16);

        System.out.println("");
    }
}