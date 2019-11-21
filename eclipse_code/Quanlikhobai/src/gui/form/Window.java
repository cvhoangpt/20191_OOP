package gui.form;

import javax.swing.JFrame;

import gui.can.Erasable;

/**
 * Lớp trừu tưởng về mọi cửa sổ giao diện chương trình
 * @author hoangcv
 *
 */
public abstract class Window implements Erasable
{
	protected JFrame frame;
	/**
	 * Phương thức trừu tượng getFrame
	 * @return nothing
	 */
	public abstract JFrame getFrame();
	/**
	 * Phương thức trừu tượng setFrame
	 * @param frame
	 */
	public abstract void setFrame(JFrame frame);
}

