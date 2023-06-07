package iterator.monarraylist;

import iterator.monarraylist.interfaces.Iterable;
import iterator.monarraylist.interfaces.Iterator;
import iterator.tuple.Pair;

import java.util.NoSuchElementException;

public class MonArrayList implements Iterable {

    private String[] array = new String[10];
    private int index = 0;

    public String get(int index) {
        return array[index];
    }

    public void add(String elem) {
        if (index >= array.length) {
            doubleTaille();
        }
        array[index] = elem;
        index++;
    }

    private void doubleTaille() {
        String[] array2 = new String[array.length * 2];
        copie(array, array2);
        array = array2;
    }

    private void copie(String[] array, String[] array2) {
        int i = 0;
        for (String s : array) {
            array2[i++] = s;
        }
    }

    public int size() {
        return index;
    }


    @Override
    public Iterator getIterator() {
        return new MonArrayListIterator(this);
    }
}
