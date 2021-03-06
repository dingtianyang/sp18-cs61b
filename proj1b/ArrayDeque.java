public class ArrayDeque<T> implements Deque<T> {
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

    private void resizeUp() {
        T[] a = (T[]) new Object[size * 2];
        System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
        System.arraycopy(items, 0, a, items.length - nextFirst - 1, nextFirst + 1);
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    private void resizeDown() {
        T[] a = (T[]) new Object[items.length / 2];
        if (nextFirst < nextLast) {
            System.arraycopy(items, nextFirst + 1, a, 0, size);
        } else {
            System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
            System.arraycopy(items, 0, a, items.length - nextFirst - 1, nextLast);
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resizeUp();
        }
        items[nextFirst] = item;
        if (nextFirst >= 1) {
            nextFirst = nextFirst - 1;
        } else {
            nextFirst = items.length - 1;
        }
        size += 1;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resizeUp();
        }
        items[nextLast] = item;
        if (nextLast < items.length - 1) {
            nextLast += 1;
        } else {
            nextLast = 0;
        }
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i));
            System.out.print(' ');
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        T item;
        if (size == 0) {
            return null;
        }

        if (nextFirst + 1 < items.length) {
            item = items[nextFirst + 1];
            items[nextFirst + 1] = null;
            nextFirst = nextFirst + 1;
        } else {
            item = items[0];
            items[0] = null;
            nextFirst = 0;
        }
        size -= 1;

        if (items.length >= 16 && (4 * size) < items.length) {
            resizeDown();
        }

        return item;
    }

    @Override
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

        if (items.length >= 16 && (4 * size) < items.length) {
            resizeDown();
        }

        return item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (nextFirst + index + 1 <= items.length - 1) {
            return items[nextFirst + index + 1];
        }
        return items[index - (items.length - nextFirst - 1)];
    }

    /*
    public static void main(String[] args) {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addLast(0);
        A.addLast(1);

        A.addLast(2);
        A.addLast(3);
        A.addFirst(4);
        A.addLast(5);
        A.addFirst(6);
        A.addLast(7);
        A.addLast(8);
        A.addFirst(9);
        A.addFirst(10);

        A.removeLast();
        A.removeLast();
        A.removeFirst();
        A.removeFirst();
        A.removeFirst();
        A.removeFirst();
        A.removeFirst();
        A.removeFirst();

        System.out.println(A.size());
        System.out.println(A.get(0));
        System.out.println();
        A.printDeque();
        System.out.println(A.isEmpty());
        System.out.println("");
    }*/
}
