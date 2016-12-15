package com.moluram.task4;

/**
 * Created by Moluram on 15.12.2016.
 */
public class RealRoots {
  public static void main(String[] args) {
    try {
      int a = Integer.parseInt(args[0]);
      int b = Integer.parseInt(args[1]);
      int c = Integer.parseInt(args[2]);
      double D = b*b - 4 * a * c;
      if(D < 0){
        System.out.println("Doen't have real roots");
      } else {
        double x1 = ((-1 * b) + Math.sqrt(D)) / (2 * a);
        double x2 = ((-1 * b) - Math.sqrt(D)) / (2 * a);
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
      }
    }catch (ArrayIndexOutOfBoundsException e){
      System.out.println("*.class <a> <b> <c>");
    }catch (NumberFormatException e){
      System.out.println("The number must consist only of digits");
    }
  }
}
