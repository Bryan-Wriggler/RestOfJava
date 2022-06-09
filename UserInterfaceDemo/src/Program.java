import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.TextArea;

public class Program {
	
	//constants
	private static final int _padding = 10;
	private static Button button = new Button("This is Button1");
	private static TextArea myTextArea = new TextArea();
	private static Listener myListener = new Listener(myTextArea); //need to be at the last, so the code will work
	
	//fields
	public static Frame myFrame = new Frame("Java UI Demo");
	
	public static void main(String[] args) {
		System.out.println("Hello Java UI Demo");
		
		//start by creating frame (basic area for UI)
		myFrame.setSize(971, 600); //size
		myFrame.setVisible(true); //let it can be see by us
		
		//add listener
		myFrame.addWindowListener(myListener); //add window listener interface
		myFrame.setLayout(null);
		
		Dimension d = myFrame.getSize();
		System.out.println(d);
		
		Insets i = myFrame.getInsets();
		System.out.println(i);
		
		//create a new button
		button.setBounds(i.left + _padding, i.top + _padding, 100, 40); //(x, y, length, width)
		myFrame.add(button); //add it to the frame
		button.setBackground(Color.lightGray);
		//listen event
		button.addActionListener(myListener); //add action listener interface
		
		//create test area
		int xAnchor = button.getX(); //top left coordinate of button
		int yAnchor = button.getY() + button.getHeight() + _padding; //top coordinate of button + its hight + padding
		myTextArea.setBounds(xAnchor, yAnchor, 
				myFrame.getWidth() - i.left - i.right - 2 * _padding, //width wanted for text area
				myFrame.getHeight() - yAnchor - i.bottom - _padding);
		myFrame.add(myTextArea);
		myTextArea.setBackground(Color.pink);
		myTextArea.setEditable(false); //meaning read only
		
		System.out.println("Goodbye");
		
		//close event
	}
}

/*
 * The (0, 0) will be at the top left extreme "of the entire window" (not only the white space)
 * 
 * though the visible space are just positive (and limited by dimension), but it can appear in
 * negative space (not visible, but exist), even outside the dimension (not visible, but also exist)
 */
