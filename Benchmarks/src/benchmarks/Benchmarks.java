package benchmarks;

import java.util.*;

public class Benchmarks {

    Random rand = new Random();

    public static void main(String[] args) {
        //long primeTime = primeFinder(500000);
        //System.out.println(primeTime + " nanoseconds");
        long floatTime = floatCalc();
        System.out.println(floatTime + " nanoseconds");
        
    }
    
    public static long primeFinder(int numLimit){
        ArrayList<Integer> primeList = new ArrayList<>();
        long startingTime = System.nanoTime(); // nanoTime() used for greater precision
        for (int num = 1; num < numLimit; num++) {
            if ((num % 5000) == 0){
                System.out.println("Progress: " + (num / 5000) + "%");
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
    
    public static long floatCalc(){
        double startingValue = 0.01;
        double a;
        double b;
        double c;
        ArrayList<Double> solutions = new ArrayList<>();
        long startingTime = System.nanoTime();
        for (a = startingValue; a < 1; a += startingValue){
            for (b = startingValue; b < 1; b += startingValue){
                for (c = startingValue; c < 1; c += startingValue){
                    double x1 = 0;
                    double x2 = 0;
                    double discriminant = (Math.pow(b, 2)) - (4 * a * c);
                    if (discriminant >= 0){
                        x1 = (0 - b + Math.pow(discriminant, 0.5)) / (2 * a);
                        x2 = (0 - b - Math.pow(discriminant, 0.5)) / (2 * a);
                    }
                    if(x1 != x2){
                        solutions.add(x1);
                        solutions.add(x2);
                        System.out.println("x1 = " + x1);
                        System.out.println("x2 = " + x2);
                    }
                    else if((x1 == x2) && (discriminant > 0)){
                        solutions.add(x1);
                        System.out.println("x = " + x1);
                    }
                }
            }    
        }
        long elapsedTime = System.nanoTime() - startingTime;
        System.out.println(solutions);
        return elapsedTime;
    }
    
    public static long stringSort(){
        long startingTime = System.nanoTime();
        long elapsedTime = System.nanoTime() - startingTime;
        return elapsedTime;
    }
}
