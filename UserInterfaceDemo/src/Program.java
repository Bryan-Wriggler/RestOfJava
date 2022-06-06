import java.awt.Frame;

public class Program {
	
	public static void main(String[] args) {
		System.out.println("Hello Java UI Demo");
		
		//start by creating frame (basic area for UI)
		Frame myFrame = new Frame("Java UI Demo");
		myFrame.setSize(971, 600); //size
		myFrame.setVisible(true); //let it can be see by us
		
		//add listener
		Listener myListener = new Listener();
		myFrame.addWindowListener(myListener);
		
		System.out.println("Goodbye");
		
		//close event
	}
}
