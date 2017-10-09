package practice.arrayList;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Iterator;

public class MyListTests {
@Test
    public void testInsertionWillGrow() {
        final MyArrayList<String> ml = new MyArrayList<>();
        ml.add("");
        ml.add("");
        MyArrayList<String> al = new MyArrayList<>();
        al.addAll();
        for (int i = 0; i < 10; i++) {
            Assertions.assertTrue(ml.add(0, 10));
        }
    }
@Test
    public void testClassicIteration() {
        final MyArrayList<String> ml = new MyArrayList<String>();
        ml.add("");
        ml.add("");
        final Iterator<String> iter = ml.iterator();
        int items = 0;
        while (iter.hasNext()) {
            iter.next();
            items++;
        }
        Assertions.assertEquals(2, items);
    }
@Test
    public void testAddingAfterRemoval() {
        final MyArrayList<String> ml = new MyArrayList<>();
        ml.add("a");
        ml.add("b");
        ml.remove(1);
        ml.remove(0);
        ml.add("c");
        Assertions.assertEquals("c", ml.get(0));
    }
    @Test
    public void testSizeList() {
        final MyArrayList<String> ml = new MyArrayList<>();
        ml.add("a");
        ml.add("b");
        ml.remove(1);
        ml.remove(0);
        ml.add("c");
        Assertions.assertEquals(1, ml.size());
    }
    @Test
    public void testRemoveAll() {
        MyArrayList<Integer> ml1 = new MyArrayList<>();
        MyArrayList<Integer> ml2 = new MyArrayList<>();
        for (int i = 0; i < 4; i++) {
            ml1.add(i);
            if(i != 1){
                ml2.add(i);
            }
        }
        ml1.removeAll(ml2);
        Assertions.assertEquals(1, (int) ml1.findFirst());
    }
    @Test
    public void testFindLast(){
    MyArrayList<Integer> ml = new MyArrayList<>();
    int i = 0;
        for (; i < 10; i++) {
            ml.add(i);
        }
    Assertions.assertEquals(i, (int) ml.findLast());
    }

    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<>();
        System.out.println("size before add: " + list.size());
        //list.findFirst();
        //list.findLast();
        for (int i = 0; i < 20; i++){
            list.add(i);
        }

        System.out.println("First element: " + list.findFirst());
        System.out.println("Last element: " + list.findLast());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("size after add: " + list.size());

        list.addAll(list,list);
        for (int i = 0;i < list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("value: " + list.get(6));
        list.remove(14);
        list.remove(12);
        list.remove(2);
        System.out.println("size after remove (3 elements): " + list.size());
        list.set(0, 179);
        System.out.println("replacement index 0: " + list.get(0));          // replacement - замена
        System.out.println("which index the new element: " + list.indexOf(179));
        System.out.println("what value for this index: " + list.get(4));
        System.out.println("index: " + list.indexOf(5));
        System.out.println("add new element with shift: " + list.add(11, 95712));
        System.out.println("what value: " + list.get(11));
        list.add(150);
        System.out.println("final size: " + list.size());
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
