package iterator.monarraylist;

import iterator.monarraylist.interfaces.Iterator;

import java.util.NoSuchElementException;

public class MonArrayListIterator implements Iterator {
    private int currentIndex = 0;

    private final MonArrayList monArrayList;

    public MonArrayListIterator(MonArrayList monArrayList) {
        this.monArrayList = monArrayList;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < monArrayList.size();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return monArrayList.get(currentIndex++);
    }
}
