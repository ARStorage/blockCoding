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
	
	//�������ִ� ��ư �����
	public void toolSetting() {
		b = new JButton(blockName);
		b.addActionListener(this);
		b.setBounds(x, y, width, height);
		toolPanel.add(b);
	}
	
	//Ŭ�������� �����ؼ� ��Ÿ���� ��ư ����
	public void codeSetting() {
		b = new JButton(blockName);//��ư�� ����
		b.setBounds(100, 50, width, height);
		b.addMouseMotionListener(this);//dnd����
		codePanel.add(b);//�ڵ� �гο� �ֱ�
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
		JButton b = (JButton) e.getSource();//Ŭ���� ��ư Ȯ��
		
		int tem_x = e.getX()-(width/2); // �̺�Ʈ �߻� ��ǥ���� x�� ����
		int tem_y = e.getY()-(height/2); // �̺�Ʈ �߻� ��ǥ���� y�� ����
		
		int x = b.getX();//��ư ��ġ ����
		int y = b.getY();
		
		//��ư ��ġ ������
		x= x+tem_x;
		y= y+tem_y;
		b.setBounds(x,y,width,height);
		
		//*****************�г� �Ѿ�� ���ϵ��� �����ؾ���
		/*if(x>100){//�г��� �Ѿ��
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
      super(56,84, toolPanel,codePanel,"x�� "+x+"��ŭ �̵�",code);
      this.num = num;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      System.out.println("��ư Ŭ����");
      String number = JOptionPane.showInputDialog("x�� �󸶸�ŭ �̵��ұ��?");
      System.out.println(number+"��ŭ");      
      //sg.setNum(Integer.parseInt(number));
      int  enternum = Integer.parseInt(number);
      moveXButton n = new moveXButton(toolPanel, codePanel,code, number,enternum);//���� ��ư�� ����
      n.codeSetting();//�ڵ��гο� �ְ�
      code.addCode(n);//����� �ڵ忡 �ֱ�
   }

   public void action(graphic obj) {
      
      System.out.println("���� ��ġ : "+obj.getX()+" "+obj.getY());
      System.out.println("x�� "+num+"��ŭ �̵�");
      obj.update(obj.getX()+num,obj.getY());
      System.out.println("�ٲ� ��ġ : "+obj.getX()+" "+obj.getY());
   }

}

class moveYButton extends blockButton{
	//graphic obj = blockCoding.obj;
	 int num = 0;
	   
	public moveYButton(JPanel toolPanel, JPanel codePanel,codeList code, String y,int num){
		super(56,124, toolPanel,codePanel,"y�� "+y+"��ŭ �̵�",code);
		this.num = num;
	}

    @Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ư Ŭ����");
		String number = JOptionPane.showInputDialog("y�� �󸶸�ŭ �̵��ұ��?");
		System.out.println(number+"��ŭ");      
		int  enternum = Integer.parseInt(number);
		moveYButton n = new moveYButton(toolPanel, codePanel,code, number,enternum);//���� ��ư�� ����
		n.codeSetting();//�ڵ��гο� �ְ�
		code.addCode(n);//����� �ڵ忡 �ֱ�
	}

	public void action(graphic obj) {
	      
	    System.out.println("���� ��ġ : "+obj.getX()+" "+obj.getY());
	    System.out.println("y�� "+num+"��ŭ �̵�");
	    obj.update(obj.getX(),obj.getY()+num);
	    System.out.println("�ٲ� ��ġ : "+obj.getX()+" "+obj.getY());
	}
}

class speakButton extends blockButton{
    JLabel speak = new JLabel("");
    blockCoding ok;
    String str, time;
    public speakButton(JPanel toolPanel, JPanel codePanel,codeList code, JPanel objectPanel,String str,String time){
        super(56,164, toolPanel,codePanel,"���ϱ�",code,objectPanel);
        this.str = str;
        this.time = time;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       System.out.println("��ư Ŭ����");
       time = JOptionPane.showInputDialog("�ʸ� �Է��ϼ���:");
       str = JOptionPane.showInputDialog("���� �Է��ϼ���:");

       speakButton n = new speakButton(toolPanel, codePanel,code, objectPanel,str,time);//���� ��ư�� ����
       n.codeSetting();//�ڵ��гο� �ְ�
       code.addCode(n);//����� �ڵ忡 �ֱ�
    } 

    public void action(graphic g) {
 
        speak.setText(str);
        speak.setBounds(10, 10, 100, 20);
        objectPanel.add(speak);
        
       try {
    	  /*Robot tRobot = new Robot();
          System.out.println("����");
          
          tRobot.delay(Integer.parseInt(time)*1000);
          System.out.println("��");*/

          //System.out.println("����");
          //Thread.sleep(Integer.parseInt(time)*1000);
          //System.out.println("��");

    	   
    	   Timer timer = new Timer(5000, new ActionListener()
    	   {public void actionPerformed (ActionEvent e){System.out.println("����");} });
    	   timer.start();
    	   Thread.sleep(Integer.parseInt(time)*1000);
    	   timer.stop();
      
   } catch (NumberFormatException | InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
       System.out.println("���ϱ�");
    }
 }

class ObjectHideButton extends blockButton{
	public ObjectHideButton(JPanel toolPanel, JPanel codePanel,codeList code, JPanel objectPanel){
	    super(56,204, toolPanel,codePanel,"������Ʈ �����",code,objectPanel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ư Ŭ����");
		ObjectHideButton n = new ObjectHideButton(toolPanel, codePanel,code,objectPanel);//���� ��ư�� ����
		n.codeSetting();//�ڵ��гο� �ְ�
		code.addCode(n);//����� �ڵ忡 �ֱ�
	}
	
	public void action(graphic g) {
		System.out.println("�����");
		g.update(895, g.getY()+300);
	}
}

class ObjectOpenButton extends blockButton{
	
	public ObjectOpenButton(JPanel toolPanel, JPanel codePanel,codeList code, JPanel objectPanel){
	    super(56,244, toolPanel,codePanel,"������Ʈ ���̱�",code,objectPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ư Ŭ����");
		ObjectOpenButton n = new ObjectOpenButton(toolPanel, codePanel,code, objectPanel);//���� ��ư�� ����
		n.codeSetting();//�ڵ��гο� �ְ�
		code.addCode(n);//����� �ڵ忡 �ֱ�
	}
	
	public void action(graphic g) {
		System.out.println("���̱�");
		g.update(g.getX()+300, g.getY()+300);
	}
}


