import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JButton;

public class codeList {
	private ArrayList<blockButton> code = new ArrayList<blockButton>();//사용자가 놓은 블록들
	
	private graphic obj;

	public codeList(graphic obj) {
		this.obj = obj;
	}

	public ArrayList getcode() {return code;}
	public void addCode(blockButton b) {code.add(b);}
	public void delCode(blockButton b) {//수정
		}
	
	//블록 순서 감지,정렬(y좌표순으로)
	public void codeSort()
	{
		code.sort(new Comparator<blockButton>() {
		       @Override
		       public int compare(blockButton a, blockButton b) {
		              // TODO Auto-generated method stub
		              int x = a.getY();
		              int y = b.getY();
		              
		              if(x == y) return 0;
		              else if(x > y) return 1;
		              else return -1;
		       }
		});
		
		
		for(blockButton i : code)
		{
			//System.out.println(i.getStr());
			
			i.action(obj); 
		}
	}
}
