/*
 * �ۼ��� : ��ƶ�
 * ���� ���� ��¥ : 20201101
 * ��� : ��ư�� �ٸ� panel�� �ű��, ��ư dnd
 * ����
 * panelSetting() : �г� �ʱ�ȭ
 * blockSetting() : ��� �ڵ� �ʱ�ȭ
 * objectSetting() : ������Ʈ �ʱ�ȭ
 * ectSetting() : ��Ÿ ��ư �ʱ�ȭ
 * mouseDragged() : ��ư  dnd
 * 
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class blockCoding extends JFrame{
	private JPanel toolPanel;//��� �г�
	private JLabel toolLabel;//��� ���� ��
	private JPanel codePanel;//��� �ڵ� ���� �г�
	private JPanel objectPanel;//������Ʈ �г�
	private JPanel ectPanel;//��Ÿ ���(����, �����ư ��)�� �� �г�
	private JLabel quizLabel;//��� �����ִ� ��
	private JButton submitButton;
	private JButton startButton;
	private int width = 200;
	private int height = 20;
	
	private moveXButton moveX;
	private moveYButton moveY;
	private speakButton speak;
	private ObjectHideButton hide;
	private ObjectOpenButton open;
	
	private graphic obj = new graphic("ball.png");
	   
	private codeList code = new codeList(obj);//codeList��ü : ����ڰ� ���� �ڵ���� �����ϴ� ��ü
	
	String init = "~";

    public blockCoding() {
    	
    	panelSetting();//�г� �ʱ�ȭ
    	blockSetting();//��� �ʱ�ȭ
    	objectSetting();//������Ʈ �ʱ�ȭ
    	ectSetting();
    	this.setVisible(true);
    	
   }
    
    //panel�ʱ�ȭ
	private void panelSetting()
	{
		setSize(1055,550);
    	getContentPane().setBackground(new Color(211, 211, 211));
    	getContentPane().setLayout(null);
    	
    	toolPanel = new JPanel();
    	toolPanel.setBackground(new Color(135, 206, 235));
    	toolPanel.setBounds(12, 10, 310, 493);
    	getContentPane().add(toolPanel);
    	toolPanel.setLayout(null);
    	
    	toolLabel = new JLabel("����");
    	toolLabel.setFont(new Font("����ü", Font.BOLD, 16));
    	toolLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	toolLabel.setBackground(new Color(255, 255, 255));
    	toolLabel.setBounds(12, 10, 286, 29);
    	toolPanel.add(toolLabel);
    	
    	codePanel = new JPanel();
    	codePanel.setBackground(Color.WHITE);
    	codePanel.setBounds(334, 10, 450, 493);
    	getContentPane().add(codePanel);
    	codePanel.setLayout(null);
    	
    	objectPanel = new JPanel();
    	objectPanel.setBackground(new Color(255, 250, 250));
    	objectPanel.setBounds(796, 10, 228, 244);
    	getContentPane().add(objectPanel);
    	objectPanel.setLayout(null);
    	
    	ectPanel = new JPanel();
    	ectPanel.setBackground(new Color(135, 206, 235));
    	ectPanel.setBounds(796, 264, 228, 239);
    	getContentPane().add(ectPanel);
    	ectPanel.setLayout(null);
  
	}
	
	//��ư�ʱ�ȭ
	private void blockSetting() {
		moveX = new moveXButton(toolPanel,codePanel,code,init,0);
		moveX.toolSetting();
    	moveY = new moveYButton(toolPanel,codePanel,code,init,0);
		moveY.toolSetting();

		speak = new speakButton(toolPanel, codePanel, code,objectPanel,"","");
		speak.toolSetting();
		hide = new ObjectHideButton(toolPanel, codePanel, code,objectPanel);
		hide.toolSetting();
		open = new ObjectOpenButton(toolPanel, codePanel, code,objectPanel);
		open.toolSetting();

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		obj.draw(g);
	}
	private void objectSetting() {
		//obj = new graphic("ball.png");		
		obj.update(895, 130);
	      
	}
	
	private void ectSetting()
	{
    	submitButton = new JButton("����");
    	submitButton.setBounds(121, 206, 95, 23);
    	ectPanel.add(submitButton);
    	
    	startButton = new JButton("����");
    	startButton.setBounds(65, 62, 95, 23);
    	ectPanel.add(startButton);
    	startButton.addActionListener(event -> {code.codeSort();
        Thread t = new MyThread();
        t.start();});

	}
	

	private void execute() {
	}
	
	
	
	public static void main(String[] args)
	{
		new blockCoding();
	}

	 class MyThread extends Thread{
	      public void run() {
	         while(true)
	         {
	            repaint();
	         }
	      }
	   }
	

}


