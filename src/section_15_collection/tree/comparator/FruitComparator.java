package section_15_collection.tree.comparator;

import java.util.Comparator;

public class FruitComparator implements Comparator<Fruit> {
    @Override
    public int compare(Fruit fruit1, Fruit fruit2) {
        if(fruit1.price < fruit2.price) return -1;
        else if(fruit1.price == fruit2.price) return 0;
        else return 1;
    }
}
