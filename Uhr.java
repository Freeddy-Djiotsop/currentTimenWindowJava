import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Uhr extends JFrame implements Runnable
{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel label;
	public Uhr()
	{
		super("");
		label = new JLabel();
		label.setPreferredSize(new Dimension(80,20));
		add(label);
		
		new Thread(this).start();
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		pack();
	}
	
	@Override public void run() 
	{
		DateTimeFormatter currentTime = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		while(true)
		{
			label.setText("UHR: "+currentTime.format(LocalDateTime.now()));
			
			try {Thread.sleep(1000);} 
			catch (InterruptedException e) {JOptionPane.showMessageDialog(this, "Error Message", "ERROR", JOptionPane.ERROR_MESSAGE);}
		}
		
	}

	public static void main(String[] args) {SwingUtilities.invokeLater(Uhr::new);}

}







