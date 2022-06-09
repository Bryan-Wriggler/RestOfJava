import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.*;

public class Listener implements WindowListener, ActionListener {
	//field
	private TextArea textArea;
	
	//a constructor to get all components needed in this class 
	public Listener(TextArea textArea) {
		this.textArea = textArea;
	}

	//window listener
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Activated");
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Closed");
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Closing");
		((Frame) arg0.getSource()).dispose();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Deactivated");
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Deiconified");
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Iconified");
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Opened");
		
	}

	
	//action listener
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Button button = (Button) arg0.getSource(); //source of this event
		
		//if we want to print in text area, we need to get text area
		//we put text area as a component needed by constructor, so we can access it
		printToTextArea(button.getLabel());
	}

	
	//other methods
	private void printToTextArea(String text) {
		String current = textArea.getText(); //get the current text
		String newText = current + "\n" + text;
		textArea.setText(newText);
		textArea.setCaretPosition(newText.length());
	}
}
