package benchmarks;

import java.util.*;

public class Benchmarks {

    Random rand = new Random();

    public static void main(String[] args) {
        long primeTime = primeFinder(500000);
        System.out.println(primeTime + "nanoseconds");
    }
    
    public static long primeFinder(int numLimit){
        ArrayList<Integer> primeList = new ArrayList<>();
        long startingTime = System.nanoTime();
        for (int num = 1; num < numLimit; num++) {
            if ((num % 5000) == 0){
                System.out.println("Progress: " + (num / 5000) + "%");
            }
            int half_num = num / 2;
            int i = 2;
            ArrayList<Integer> factors = new ArrayList<>();
            while(i <= half_num){
                if ((num % i) == 0){
                    factors.add(i);
                }
                i++;
            }
            if (factors.isEmpty()){
                primeList.add(num);
            }
        }
        long elapsedTime = System.nanoTime() - startingTime;
        return elapsedTime;
    }
}
