package com.moluram.tasks13;

public class CommandLineParams {

  public static void main(String[] args) {
    for(int i = args.length - 1; i >= 0; i--) {
      System.out.println("The argument " + i + " = " + args[i]);
    }
  }

}
