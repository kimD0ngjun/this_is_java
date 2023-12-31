package section_15_collection.tree;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> scores = new TreeSet<>();

        scores.add(13);
        scores.add(53);
        scores.add(39);
        scores.add(41);
        scores.add(87);
        scores.add(7);
        scores.add(100);

        for(Integer score: scores) {
            System.out.println(score);
        }
        System.out.println("\n");

        System.out.println("가장 낮은 점수 : " + scores.first());
        System.out.println("가장 높은 점수 : " + scores.last());
        System.out.println("80점 아래 점수 : " + scores.lower(80));
        System.out.println("80점 위 점수 : " + scores.higher(80));
        System.out.println("87점이거나 87점 바로 위 점수 : " + scores.ceiling(87));
        System.out.println("87점이거나 87점 바로 아래 점수 : " + scores.floor(87));
        System.out.println("80점이거나 80점 바로 아래 점수 : " + scores.floor(80));

        System.out.println("\n");

        NavigableSet<Integer> descendingScores = scores.descendingSet(); // 내림차순 재배열

        Iterator<Integer> iterator1 = descendingScores.iterator();
        while(iterator1.hasNext()) {
            Integer element = iterator1.next();
            System.out.println(element);
        }
        System.out.println();

        // 50점 초과인 애들 뽑아내기
        NavigableSet<Integer> rangeSet = scores.tailSet(50, false);

        Iterator<Integer> iterator2 = rangeSet.iterator();
        while(iterator2.hasNext()) {
            Integer element = iterator2.next();
            System.out.println(element);
        }
        System.out.println();

        // 50점 초과 87점 이하
        rangeSet = scores.subSet(50, false, 87, true);

        Iterator<Integer> iterator3 = rangeSet.iterator();
        while(iterator3.hasNext()) {
            Integer element = iterator3.next();
            System.out.println(element);
        }
        System.out.println();
    }
}
