import java.awt.Color;

public interface MathFunction { 
	public int function(int x);
	
	public Color getColor();
}

/*
 * if it has only 1 method, it is functional interface
 * -> MathFunction name = (parameter) -> { return returnType;};
 * 
 * if it has 2 methods, it is a class
 * -> need new
 * -> MathFunction sin = new MathFunction() {
 * 		public int function(int x) { return returnType1;}
 * 
 * 		public Color getColor() { return returnType2;}
 * 	  }
 */