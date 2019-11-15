package gui;

import javax.swing.JFrame;

public abstract class Window
{
	protected JFrame frame;
	
	public abstract JFrame getFrame();
	public abstract void setFrame(JFrame frame); 
	
	public Window() {}
	
}
