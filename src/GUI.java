import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class GUI extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7632908392074124134L;
	protected JButton open, search, parse, save;
	protected JTextArea console;
	
	private GUI(){
		
		open = new JButton("Open Folder");
		open.setVerticalTextPosition(AbstractButton.CENTER);
		open.setHorizontalTextPosition(AbstractButton.LEADING);
		open.setActionCommand("open");
		open.addActionListener(this);
		
		search = new JButton("Search");
		search.setVerticalTextPosition(AbstractButton.CENTER);
		search.setHorizontalTextPosition(AbstractButton.LEADING);
		search.setActionCommand("search");
		search.setEnabled(false);
		search.addActionListener(this);
		
		parse = new JButton("Search");
		parse.setVerticalTextPosition(AbstractButton.CENTER);
		parse.setHorizontalTextPosition(AbstractButton.LEADING);
		parse.setActionCommand("parse");
		parse.setEnabled(false);
		parse.addActionListener(this);
		
		save = new JButton("Save");
		save.setVerticalTextPosition(AbstractButton.CENTER);
		save.setHorizontalTextPosition(AbstractButton.LEADING);
		save.setActionCommand("save");
		save.setEnabled(false);
		save.addActionListener(this);
		
		console = new JTextArea();
		console.setEditable(false);
		console.setWrapStyleWord(true);
		console.setPreferredSize(new Dimension(450,200));
		JScrollPane cscroll = new JScrollPane(console);
		cscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		add(open);
		add(search);
		add(parse);
		add(save);
		add(console);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("open")){
			
		}else if (e.getActionCommand().equals("search")){
			
		}else if (e.getActionCommand().equals("parse")){
			
		}else if (e.getActionCommand().equals("save")){
			
		}
	}
	
	protected void print(String s){
		console.append("[HST Reader] "+s+"\r\n");
	}

	public static void createAndShowGUI() {
		JFrame frame = new JFrame("HST Reader");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			Main.print("The UI could not find the default system look and feel!");
		} catch (InstantiationException e) {
			Main.print("The UI could not create the look and feel.");
		} catch (IllegalAccessException e) {
			Main.print("The UI could not access the look and feel.");
		} catch (UnsupportedLookAndFeelException e) {
			Main.print("The UI look and feel is unsupported.");
		}finally{
			Main.print("The UI will use the default look and feel.");
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GUI gui = new GUI();
		gui.setOpaque(true);
		frame.setContentPane(gui);
		frame.setSize(500, 300);
		
		frame.pack();
		frame.setVisible(true);
		
		gui.print("Reader is ready. Please choose a folder.");
	}
	
	
	
}