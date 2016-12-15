package com.moluram.task4;

import java.util.ArrayList;

/**
 * Created by Moluram on 15.12.2016.
 */
public class RealRoots {
  public static void main(String[] args) {
    try {
      int a = Integer.parseInt(args[0]);
      int b = Integer.parseInt(args[1]);
      int c = Integer.parseInt(args[2]);
      solveEquation(a,b,c);
    }catch (ArrayIndexOutOfBoundsException e){
      print("*.class <a> <b> <c>");
    }catch (NumberFormatException e){
      print("The number must consist only of digits");
    }catch (DoesNotHaveRealRoots e){
      print("Equation doesn't have real roots");
    }
  }

  private static ArrayList<Double> solveEquation(int a, int b, int c) throws DoesNotHaveRealRoots{
    double D = b*b - 4 * a * c;
    double x1;
    double x2;
    if(D < 0){
      throw  new DoesNotHaveRealRoots();
    } else {
      x1 = ((-1 * b) + Math.sqrt(D)) / (2 * a);
      x2 = ((-1 * b) - Math.sqrt(D)) / (2 * a);
    }
    ArrayList<Double> list = new ArrayList<Double>();
    list.add(x1);
    list.add(x2);
    return list;
  }

  private static void print(String value){
    System.out.println(value);
  }

  private static class DoesNotHaveRealRoots extends Exception{}
}
