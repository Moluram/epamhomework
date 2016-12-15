package com.moluram.task5;

/**
 * Created by Moluram on 15.12.2016.
 */
public class Triangle {
  public static void main(String[] args) {
    try {
      int a = Integer.parseInt(args[0]);
      int b = Integer.parseInt(args[1]);
      int c = Integer.parseInt(args[2]);
      print(whatIsThisTriangle(a,b,c));
    } catch (ArrayIndexOutOfBoundsException e) {
      print("*.class <a> <b> <c>");
    } catch (NumberFormatException e) {
      print("The number must consist only of digits");
    }
  }

  private static String whatIsThisTriangle(int a, int b, int c){
    if(a == b && b == c) {
      return "Equilateral";
    }
    if((a == b) || (b == c) || (a == c)){
      return "Isosceles";
    }
    return "Normal";
  }

  private static void print(String value){
    System.out.println(value);
  }
}

