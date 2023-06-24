package Tree;

import java.util.Random;

public class Main {
    /**
     * Максимальное число генерирумое для вставки элемента дерева.
     */
    private final static int MAX_NUMBER = 100;

    /**
     * Максимольное количество элементов, генерируемое для вставки
     * элемента дерева.
     */
    private final static int MAX_ELEMENTS = 20;
    private static Random rand = new Random();

    public static void main(String[] args) {


        final RedBlTree tree = new RedBlTree();

        int testInsertElementsAmount;
        Integer num;
        testInsertElementsAmount = rand.nextInt(MAX_ELEMENTS - 1) + 1;

        System.out.println(" Insertion [" + testInsertElementsAmount + "]:");
        for(int j = 0; j < testInsertElementsAmount; j++) {
            num = new Integer(rand.nextInt(MAX_NUMBER));
            System.out.println("  Insert " + num + " into tree");
            tree.add(num);
        }
    }
}
