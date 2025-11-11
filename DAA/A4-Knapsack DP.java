/**
 * No fractional summations done here, the whole item is added
 */
public class BBKnapsack {

    static void findMaxKnapsackValue(int n , int[] weights, int[] values, int capacity){

        if(capacity==0){
            System.out.println("Knapsack value is 0");
            return;
        }

        int[] dp = new int[capacity+1];

        for(int i =0; i<n ; i++){
            for(int cap = capacity ; cap>= weights[i] ; cap--){
                dp[cap] = Math.max(
                        dp[cap],
                        dp[cap-weights[i]] + values[i]
                );
            }
        }

        System.out.println("Knapsack value is "+dp[capacity]);


    }

    public static void main(String[] args) {

        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;

        findMaxKnapsackValue(val.length,wt,val,capacity);

    }

}
