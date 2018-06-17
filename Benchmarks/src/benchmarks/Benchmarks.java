package benchmarks;

import java.util.*;

public class Benchmarks {

    Random rand = new Random();

    public static void main(String[] args) {
        long primeTime = primeFinder(250000);
        System.out.println(primeTime + " nanoseconds");
        long floatTime = floatCalc(0.001);
        System.out.println(floatTime + " nanoseconds");
        
    }
    
    public static long primeFinder(int numLimit){
        ArrayList<Integer> primeList = new ArrayList<>();
        long startingTime = System.nanoTime(); // nanoTime() used for greater precision
        for (int num = 1; num < numLimit; num++) {
            if ((num % (numLimit / 100)) == 0){
                System.out.println("Progress: " + (num / (numLimit / 100)) + "%");
            }
            int half_num = num / 2; // Can't have a factor greater than half number so testing up to half only
            int i = 2; // Every number has 1 as factor so no point testing 1, starting from 2 instead
            ArrayList<Integer> factors = new ArrayList<>();
            while(i <= half_num){
                if ((num % i) == 0){
                    factors.add(i);
                }
                i++;
            }
            if (factors.isEmpty()){ // Number is prime if no factors found
                primeList.add(num);
            }
        }
        long elapsedTime = System.nanoTime() - startingTime;
        return elapsedTime;
    }
    
    public static long floatCalc(double startingValue){
        double a;
        double b;
        double c;
        long startingTime = System.nanoTime();
        int cycles = 0;
        for (a = startingValue; a < 1; a += startingValue){
            for (b = startingValue; b < 1; b += startingValue){
                for (c = startingValue; c < 1; c += startingValue){
                    if ((cycles % 10000000) == 0){
                        System.out.println("Progress: " + (cycles / 10000000) + "%");
                    }
                    double x1 = 0;
                    double x2 = 0;
                    double discriminant = (Math.pow(b, 2)) - (4 * a * c);
                    if (discriminant >= 0){
                        x1 = (0 - b + Math.pow(discriminant, 0.5)) / (2 * a);
                        x2 = (0 - b - Math.pow(discriminant, 0.5)) / (2 * a);
                    }
                    cycles++;
                }
            }    
        }
        long elapsedTime = System.nanoTime() - startingTime;
        return elapsedTime;
    }
    
    public static long stringSort(){
        long startingTime = System.nanoTime();
        
        long elapsedTime = System.nanoTime() - startingTime;
        return elapsedTime;
    }
}
