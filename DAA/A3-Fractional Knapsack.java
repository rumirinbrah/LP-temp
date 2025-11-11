import java.util.Arrays;
import java.util.Comparator;

public class FKnapsack {

    static class SackItemComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            float a1 = (a[0] * 1f) / a[1];
            float b1 = (b[0] * 1f) / b[1];
            return Float.compare(b1, a1);
        }
    }

    /**
     * Solve fractional knapsack prblm
     *
     * @param values
     * @param weights
     * @param capacity
     */
    static void solveFKnapsack(
            int[] values,
            int[] weights,
            int capacity
    ) {

        int size = values.length;
        // value : weight
        int[][] items = new int[size][2];

        for (int i = 0; i < size; i++) {
            items[i][0] = values[i];
            items[i][1] = weights[i];
        }

        Arrays.sort(items, new SackItemComparator());

        int remCapacity;

        remCapacity = capacity;
        float value = 0f;

        for(int i =0 ; i<size ; i++){
            if(items[i][1]<remCapacity){
                value += items[i][0];
                remCapacity -= items[i][1];
            }else{
                value += (1f*items[i][0]/items[i][1])*remCapacity;
                System.out.println("Total value fit into sack "+value);
                return;
            }
        }
        System.out.println("Total value fit into sack "+value);

    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;

        solveFKnapsack(val, wt, capacity);


    }

}
