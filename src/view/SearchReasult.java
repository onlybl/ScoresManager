package view;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class SearchReasult extends JDialog {
	JTextArea jta = new JTextArea();
	public SearchReasult(){
		setSize(320, 130);
		add(jta);
		setVisible(true);
	}
}
