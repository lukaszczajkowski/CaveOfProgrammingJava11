package gui;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel = new MainPanel();
	
	public MainFrame(){
		super("Game of Life");
		
		setLayout(new BorderLayout());
		add(mainPanel, BorderLayout.CENTER);
		
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				switch(code) {
				case 32:
					mainPanel.next();
					break;
				case 8:
					mainPanel.clear();
					break;
				case 10: 
					mainPanel.randomize();
					break;
				}
			}
		});
		
		setSize(800, 600);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
