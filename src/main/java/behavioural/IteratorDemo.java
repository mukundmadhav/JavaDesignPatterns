package behavioural;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorDemo {
    public static void main(String[] args) {
        MyCollection collection = new MyCollection(new int[]{1, 2, 3, 4, 5});
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class MyCollection implements Iterable<Integer> {
    private final int[] array;

    public MyCollection(int[] array) {
        this.array = array;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Integer> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[index++];
        }
    }
}