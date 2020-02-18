/*
  Name: functionPlot.java
  Purpose: plotting functions in ASCII
  Author: Leo Liberti
  Source: Java
  History: 120615 work started
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class functionPlot {
    static int steps;    // number of function evaluations
    static double [] x;  // x coordinate values
    static double xL;    // lower bound for x coordinate values
    static double xU;    // upper bound for x coordinate values
    static double [] y;  // y coordinate values
    static double yL;    // lower bound for y coordinate values
    static double yU;    // upper bound for y coordinate values
    static int rows;     // number of text rows taken by plot
    static int columns;  // number of text columns taken by plot
    static int[][] screen;

    // this defines the function to be plotted
    public static double theFunction(double z) {
	// user: change the mathematical function here at leisure
	return 0.25*z + Math.sin(z); 
    }

    // initialize some values
    public static void initialize() {
	// user: set values for steps, x range, rows/columns for plot
	steps = 150;  
	xL = -10;
	xU = 10;
        columns = 75;
	rows = 20;

	// user: do not change anything beyond this point
	x = new double[steps];
	y = new double[steps];
    }

    // compute the x-y table
    public static void functionTable() {
	double theStep = (xU - xL) / steps;
	x[0] = xL;
	for(int k = 1; k < steps; k++) {
	    x[k] = x[k-1] + theStep;
	    y[k] = theFunction(x[k]);
	}	
    }

    // compute the minimum value of the y range
    public static double yMin() {
	double theMin = 1e30; // infinity
	for(int k = 0; k < steps; k++) {
	    if (y[k] < theMin) {
		theMin = y[k];
	    }
	}
	return theMin;
    }

    // compute the maximum value of the y range
    public static double yMax() {
	double theMax = -1e30; // -infinity
	for(int k = 0; k < steps; k++) {
	    if (y[k] > theMax) {
		theMax = y[k];
	    }
	}
	return theMax;
    }

    // fill the screen array cells corresponding to x/y pairs with 1's
    public static void tableScreen() {
	int i;
	int j;
	screen = new int [rows][columns];
	for(i = 0; i < rows; i++) {
	    for(j = 0; j < columns; j++) {
		screen[i][j] = 0;
	    }
	}
	yL = yMin();
	yU = yMax();
	for(int k = 0; k < steps; k++) {
	    j = (int) Math.rint(((x[k] - xL) / (xU - xL)) * columns);
	    i = (int) Math.rint(((y[k] - yL) / (yU - yL)) * rows);
	    if (i < rows && j < columns) {
		screen[rows - (i + 1)][j] = 1;
	    }
	}
    }

    // loop over the screen array and either print a '*' (1) or a space (0)
    public static void printScreen() {
	for(int i = 0; i < rows; i++) {
	    for(int j = 0; j < columns; j++) {
		if (screen[i][j] == 1) {
		    System.out.print("*");
		} else {
		    System.out.print(" ");
		}
	    }
	    System.out.print("\n");
	}
    }

    // this is the program's point of entry
    public static void main(String [] args) {
	initialize();
	functionTable();
	tableScreen();
	printScreen();
    }
}
