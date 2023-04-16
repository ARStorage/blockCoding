/*
 * 작성자 : 배아란
 * 최종 수정 날짜 : 20201101
 * 기능 : 버튼을 다른 panel로 옮기기, 버튼 dnd
 * 설명
 * panelSetting() : 패널 초기화
 * blockSetting() : 블록 코드 초기화
 * objectSetting() : 오브젝트 초기화
 * ectSetting() : 기타 버튼 초기화
 * mouseDragged() : 버튼  dnd
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
	private JPanel toolPanel;//블록 패널
	private JLabel toolLabel;//블록 설명 라벨
	private JPanel codePanel;//블록 코딩 공간 패널
	private JPanel objectPanel;//오브젝트 패널
	private JPanel ectPanel;//기타 기능(종료, 제출버튼 등)이 들어갈 패널
	private JLabel quizLabel;//퀴즈를 보여주는 라벨
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
	   
	private codeList code = new codeList(obj);//codeList객체 : 사용자가 놓은 코드들을 저장하는 객체
	
	String init = "~";

    public blockCoding() {
    	
    	panelSetting();//패널 초기화
    	blockSetting();//블록 초기화
    	objectSetting();//오브젝트 초기화
    	ectSetting();
    	this.setVisible(true);
    	
   }
    
    //panel초기화
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
    	
    	toolLabel = new JLabel("도구");
    	toolLabel.setFont(new Font("돋움체", Font.BOLD, 16));
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
	
	//버튼초기화
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
    	submitButton = new JButton("제출");
    	submitButton.setBounds(121, 206, 95, 23);
    	ectPanel.add(submitButton);
    	
    	startButton = new JButton("시작");
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


