package kovteba.collectionframework.iterable.collection.set.sortedset.navigableset.treeset;

import java.util.TreeSet;

// tag::TreeSetExample1[]
public class TreeSetExample1 {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(30);
        treeSet.add(40);
        treeSet.add(50);
        System.out.println(treeSet);
        System.out.println("First element: " + treeSet.first());
        System.out.println("Last element: " + treeSet.last());
        System.out.println("Ceiling element: " + treeSet.ceiling(25));
        System.out.println("Floor element: " + treeSet.floor(25));
        System.out.println("Higher element: " + treeSet.higher(25));
        System.out.println("Lower element: " + treeSet.lower(25));
        System.out.println("Poll first element: " + treeSet.pollFirst());
        System.out.println("Poll last element: " + treeSet.pollLast());
        System.out.println("SubSet: " + treeSet.subSet(20, true, 40, true));
        System.out.println("HeadSet: " + treeSet.headSet(30, true));
        System.out.println("TailSet: " + treeSet.tailSet(30, true));
        System.out.println(treeSet);
    }
}
// end::TreeSetExample1[]

// tag::TreeSetExample1Result[]
//[10, 20, 30, 40, 50]
//First element: 10
//Last element: 50
//Ceiling element: 30
//Floor element: 20
//Higher element: 30
//Lower element: 20
//Poll first element: 10
//Poll last element: 50
//SubSet: [20, 30, 40]
//HeadSet: [20, 30]
//TailSet: [30, 40]
//[20, 30, 40]
// end::TreeSetExample1Result[]
