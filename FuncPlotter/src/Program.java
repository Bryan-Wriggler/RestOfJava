import java.awt.Color;

import graphics.Canvas;

public class Program {
    // Canvas GUI instance providing the drawing area on which to plot the functions
    private static Canvas canvas;

    public static void main(String[] args) {
        
        // Create the canvas instance, set its range to x:[-360, 360] and y:[-240, 240] then 
        // open it on the screen. Use canvas.plot(pX, pY) to plot a point at the (pX, pY) coords
        canvas = new Canvas();
        canvas.setRange(-720, -480, 720, 480);
        canvas.open();

        // Draw a short red diagonal on the canvas
        canvas.pause();
        canvas.setColor(Color.red);
        
        //sin function
        MathFunction sin = new MathFunction() { 
        	public int function(int x) {
        		return (int) (240 * Math.sin(Math.PI * x / 360));
        	}
        	
        	public Color getColor() {
        		return Color.blue;
        	}
        };
        
        //circle function
        MathFunction circle = new MathFunction() { 
        	public int function(int x) {
        		return (int) (Math.sqrt(120 * 120 - x * x));
        	}
        	
        	public Color getColor() {
        		return Color.MAGENTA;
        	}
        };
        
        //absolute value function
        MathFunction absolute = new MathFunction() { 
        	public int function(int x) {
        		return Math.abs(x);
        	}
        	
        	public Color getColor() {
        		return Color.green;
        	}
        };
        
        //using arcsin and cos to make circle
        MathFunction circle2 = new MathFunction() { 
        	public int function(int x) {
        		return (int) (240 * Math.cos(Math.asin((double) x/240)));
        	}
        	
        	public Color getColor() {
        		return Color.red;
        	}
        };
        
        //quadratic equation
        MathFunction quadratic = new MathFunction() { 
        	public int function(int x) {
        		return (int) (((double) x * x - 200 * 200) / 250);
        	}
        	
        	public Color getColor() {
        		return Color.blue;
        	}
        };
        
        //logarithm with base 2
        MathFunction log2 = new MathFunction() { 
        	public int function(int x) {
        		return (int) (20 * Math.log(Math.abs(x)));
        	}
        	
        	public Color getColor() {
        		return Color.blue;
        	}
        };
        
        //cubic equation
        MathFunction cubic = new MathFunction() { 
        	public int function(int x) {
        		return (int) (Math.pow(x, 3) / 2000);
        	}
        	
        	public Color getColor() {
        		return Color.blue;
        	}
        };
        
        //hyperbola with y-intersect
        MathFunction hyperbolaV = new MathFunction() { 
        	public int function(int x) {
        		return (int) Math.sqrt(40 * 40 + x * x);
        	}
        	
        	public Color getColor() {
        		return Color.cyan;
        	}
        };
        
        //hyperbola with x-intersect
        MathFunction hyperbolaH = new MathFunction() { 
        	public int function(int x) {
        		return (int) Math.sqrt(x * x - 40 * 40);
        	}
        	
        	public Color getColor() {
        		return Color.cyan;
        	}
        };
        
        //arrays of functions
        MathFunction[] functions = {sin, quadratic, log2, cubic};
        
        plotFunction(circle, circle2,hyperbolaV, hyperbolaH);
        //plotFunction(functions);
        
        //plotFunction(functions, sin); -> this is invalid

        // Pause and close the canvas then terminate the program.
        canvas.pause();
        canvas.close();
    }
    
    /**
     * @param function -> the function that plugged into the graph
     * 
     * plots a given function
     */
    public static void plotFunction(MathFunction... function) { 
    	//if using ..., it is either throwing multiple object with same types
    	//... can also throw arrays into it, but never throwing arrays "and" object
    	//another characteristic: can throw nothing as parameter (which is an array of 0 length)
    	
    	for (int i=0; i < function.length; i++) {
    		for (int x = -480; x <= 480; x++) {
    			canvas.setColor(function[i].getColor());
        		canvas.plot(x,  function[i].function(x));
        		canvas.plot(x,  -function[i].function(x));
        	}
    	}
    }
}
