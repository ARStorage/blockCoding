import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class blockButton implements ActionListener,MouseMotionListener{
	protected JButton b;
	protected int width = 200;
	protected int height = 20;
	protected int x, y;
	protected String blockName;
	protected codeList code;

	protected JPanel toolPanel,codePanel,objectPanel;

	public blockButton(int x, int y, JPanel toolPanel,JPanel codePanel,String blockName,codeList code, JPanel objectPanel){
		this.toolPanel = toolPanel;
		this.codePanel = codePanel;
		this.blockName=blockName;
		this.x = x;
		this.y = y;
		this.code = code;
		this.objectPanel = objectPanel;

	}
	public blockButton(int x, int y, JPanel toolPanel,JPanel codePanel,String blockName,codeList code){
		this.toolPanel = toolPanel;
		this.codePanel = codePanel;
		this.blockName=blockName;
		this.x = x;
		this.y = y;
		this.code = code;
		
	}
	
	//도구에있는 버튼 만들기
	public void toolSetting() {
		b = new JButton(blockName);
		b.addActionListener(this);
		b.setBounds(x, y, width, height);
		toolPanel.add(b);
	}
	
	//클릭했을때 복사해서 나타나는 버튼 설정
	public void codeSetting() {
		b = new JButton(blockName);//버튼을 만들어서
		b.setBounds(100, 50, width, height);
		b.addMouseMotionListener(this);//dnd설정
		codePanel.add(b);//코드 패널에 넣기
	}
	
	public JButton getButton() {return b;}
	public int getX() {return b.getX();}
	public int getY() {return b.getY();}
	public String getStr() {return blockName;}
	
	public void action(graphic obj) {}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		JButton b = (JButton) e.getSource();//클릭된 버튼 확인
		
		int tem_x = e.getX()-(width/2); // 이벤트 발생 좌표값중 x값 추출
		int tem_y = e.getY()-(height/2); // 이벤트 발생 좌표값중 y값 추출
		
		int x = b.getX();//버튼 위치 추출
		int y = b.getY();
		
		//버튼 위치 재지정
		x= x+tem_x;
		y= y+tem_y;
		b.setBounds(x,y,width,height);
		
		//*****************패널 넘어가지 못하도록 수정해야함
		/*if(x>100){//패널이 넘어가면
			b.setBounds(x,y,width,height);}
		}*/
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

class moveXButton extends blockButton{

   //graphic obj = blockCoding.obj;
   int num = 0;
   
   public moveXButton(JPanel toolPanel, JPanel codePanel,codeList code, String x,int num){
      super(56,84, toolPanel,codePanel,"x를 "+x+"만큼 이동",code);
      this.num = num;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      System.out.println("버튼 클릭됨");
      String number = JOptionPane.showInputDialog("x를 얼마만큼 이동할까요?");
      System.out.println(number+"만큼");      
      //sg.setNum(Integer.parseInt(number));
      int  enternum = Integer.parseInt(number);
      moveXButton n = new moveXButton(toolPanel, codePanel,code, number,enternum);//같은 버튼을 만들어서
      n.codeSetting();//코드패널에 넣고
      code.addCode(n);//사용자 코드에 넣기
   }

   public void action(graphic obj) {
      
      System.out.println("현재 위치 : "+obj.getX()+" "+obj.getY());
      System.out.println("x를 "+num+"만큼 이동");
      obj.update(obj.getX()+num,obj.getY());
      System.out.println("바뀐 위치 : "+obj.getX()+" "+obj.getY());
   }

}

class moveYButton extends blockButton{
	//graphic obj = blockCoding.obj;
	 int num = 0;
	   
	public moveYButton(JPanel toolPanel, JPanel codePanel,codeList code, String y,int num){
		super(56,124, toolPanel,codePanel,"y를 "+y+"만큼 이동",code);
		this.num = num;
	}

    @Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 클릭됨");
		String number = JOptionPane.showInputDialog("y를 얼마만큼 이동할까요?");
		System.out.println(number+"만큼");      
		int  enternum = Integer.parseInt(number);
		moveYButton n = new moveYButton(toolPanel, codePanel,code, number,enternum);//같은 버튼을 만들어서
		n.codeSetting();//코드패널에 넣고
		code.addCode(n);//사용자 코드에 넣기
	}

	public void action(graphic obj) {
	      
	    System.out.println("현재 위치 : "+obj.getX()+" "+obj.getY());
	    System.out.println("y를 "+num+"만큼 이동");
	    obj.update(obj.getX(),obj.getY()+num);
	    System.out.println("바뀐 위치 : "+obj.getX()+" "+obj.getY());
	}
}

class speakButton extends blockButton{
    JLabel speak = new JLabel("");
    blockCoding ok;
    String str, time;
    public speakButton(JPanel toolPanel, JPanel codePanel,codeList code, JPanel objectPanel,String str,String time){
        super(56,164, toolPanel,codePanel,"말하기",code,objectPanel);
        this.str = str;
        this.time = time;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       System.out.println("버튼 클릭됨");
       time = JOptionPane.showInputDialog("초를 입력하세요:");
       str = JOptionPane.showInputDialog("말을 입력하세요:");

       speakButton n = new speakButton(toolPanel, codePanel,code, objectPanel,str,time);//같은 버튼을 만들어서
       n.codeSetting();//코드패널에 넣고
       code.addCode(n);//사용자 코드에 넣기
    } 

    public void action(graphic g) {
 
        speak.setText(str);
        speak.setBounds(10, 10, 100, 20);
        objectPanel.add(speak);
        
       try {
    	  /*Robot tRobot = new Robot();
          System.out.println("멈춤");
          
          tRobot.delay(Integer.parseInt(time)*1000);
          System.out.println("끝");*/

          //System.out.println("멈춤");
          //Thread.sleep(Integer.parseInt(time)*1000);
          //System.out.println("끝");

    	   
    	   Timer timer = new Timer(5000, new ActionListener()
    	   {public void actionPerformed (ActionEvent e){System.out.println("멈춤");} });
    	   timer.start();
    	   Thread.sleep(Integer.parseInt(time)*1000);
    	   timer.stop();
      
   } catch (NumberFormatException | InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
       System.out.println("말하기");
    }
 }

class ObjectHideButton extends blockButton{
	public ObjectHideButton(JPanel toolPanel, JPanel codePanel,codeList code, JPanel objectPanel){
	    super(56,204, toolPanel,codePanel,"오브젝트 숨기기",code,objectPanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 클릭됨");
		ObjectHideButton n = new ObjectHideButton(toolPanel, codePanel,code,objectPanel);//같은 버튼을 만들어서
		n.codeSetting();//코드패널에 넣고
		code.addCode(n);//사용자 코드에 넣기
	}
	
	public void action(graphic g) {
		System.out.println("숨기기");
		g.update(895, g.getY()+300);
	}
}

class ObjectOpenButton extends blockButton{
	
	public ObjectOpenButton(JPanel toolPanel, JPanel codePanel,codeList code, JPanel objectPanel){
	    super(56,244, toolPanel,codePanel,"오브젝트 보이기",code,objectPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 클릭됨");
		ObjectOpenButton n = new ObjectOpenButton(toolPanel, codePanel,code, objectPanel);//같은 버튼을 만들어서
		n.codeSetting();//코드패널에 넣고
		code.addCode(n);//사용자 코드에 넣기
	}
	
	public void action(graphic g) {
		System.out.println("보이기");
		g.update(g.getX()+300, g.getY()+300);
	}
}


