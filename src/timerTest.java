import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class timerTest extends JFrame{
	
	timerTest(){
		
		JButton button = new JButton("Press Me");
		button.addActionListener(new ActionListener(){ 
		 @Override 
		 public void actionPerformed(ActionEvent e) { 

		  Timer timer = new Timer(1000, new ActionListener(){ 
		   @Override 
		   public void actionPerformed(ActionEvent e) { 
		    System.out.println("Print after one second"); 
		   } 
		  }); 
		  timer.setRepeats(false); 
		  timer.start(); 
		 } 
		}); 
		
		add(button);
		
		setVisible(true);
		
	}

	public static void main(String[] args) throws InterruptedException {

 	   /*Timer timer = new Timer(5000, new ActionListener()
 	   {@Override public void actionPerformed (ActionEvent e){System.out.println("∏ÿ√„");} });
 	   timer.setRepeats(false);
 	   timer.start();
 	   Thread.sleep(3000);
 	   timer.stop();*/
		
		//new timerTest();
		
 	   
 	   Timer timer = new Timer(3000, new ActionListener()
 	   {public void actionPerformed (ActionEvent e){System.out.println("∏ÿ√„");} });
 	   timer.start();
 	   Thread.sleep(3000);
 	   timer.stop();
	}
	
	

}
