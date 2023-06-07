package iterator.monarraylist;

import iterator.monarraylist.interfaces.Iterator;

public class Main {
    public static void main(String[] args) {
        MonArrayList monArrayList = new MonArrayList();

        System.out.println("Size au début " + monArrayList.size());

        monArrayList.add("0");
        monArrayList.add("1");
        monArrayList.add("2");
        monArrayList.add("3");
        monArrayList.add("4");
        monArrayList.add("5");
        monArrayList.add("6");
        monArrayList.add("7");
        monArrayList.add("8");
        monArrayList.add("9");
        monArrayList.add("10");

        System.out.println("Element à l'index 9 : " + monArrayList.get(9));
        System.out.println("Element à l'index 10 : " + monArrayList.get(10));
        System.out.println("Size à la fin " + monArrayList.size());

        Iterator iterator = monArrayList.getIterator();
        while (iterator.hasNext()){
            //Iterator.next() return String
            System.out.println(iterator.next());
        }
    }
}
