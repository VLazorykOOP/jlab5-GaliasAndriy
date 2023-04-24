import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task2 {
    public static Set<Integer> findIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    public static Set<Integer> combineSets(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set1 = new HashSet<>();
        set1.add(3);
        set1.add(5);
        set1.add(7);
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(3);
        set2.add(3);
        set2.add(10);
        set2.add(-5);
        set2.add(7);
        set2.add(5);
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        Set<Integer> intersection = findIntersection(set1, set2);
        System.out.println("Intersection: " + intersection);
        Set<Integer> union = combineSets(set1, set2);
        System.out.println("Union: " + union);
    }
}