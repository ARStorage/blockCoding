import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class mdropUI {

	public mdropUI() {
		JFrame frame = new JFrame();
		frame.setTitle("관리자 탈퇴");
		frame.setBounds(100, 100, 450, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("관리자 탈퇴");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("굴림", Font.BOLD, 24));
		titleLabel.setBounds(0, 33, 428, 46);
		frame.getContentPane().add(titleLabel);
		
		JLabel pwLabel = new JLabel("PW");
		pwLabel.setBounds(31, 147, 49, 27);
		frame.getContentPane().add(pwLabel);
		
		JPasswordField pwText = new JPasswordField();
		pwText.setBounds(110, 147, 197, 27);
		frame.getContentPane().add(pwText);
		
		JButton pwcheckButton = new JButton("확인");
		pwcheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if PW 존재O -> 탈퇴 처리하기
				int result = JOptionPane.showConfirmDialog(null, "비밀번호가 일치합니다.\n정말 탈퇴하시겠습니까?","알림",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					//예, 아니오 선택 없이 다이얼로그 창을 닫았을 경우 탈퇴 진행 X 
				}
				else if(result==JOptionPane.YES_OPTION) { 
					//예를 선택한 경우 탈퇴 진행 O
					JOptionPane.showMessageDialog(null, "탈퇴에 성공했습니다.","알림",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					//아니오를 선택한 경우 탈퇴 진행 X
				}
				
				//else PW 존재X 
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.\n다시 입력해주세요.","알림",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		pwcheckButton.setBounds(324, 147, 71, 27);
		frame.getContentPane().add(pwcheckButton);
		
		JLabel expLabel = new JLabel("올바른 계정 탈퇴를 위해 비밀번호를 입력 후 확인 버튼을 누르세요.");
		expLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expLabel.setBounds(0, 94, 428, 27);
		frame.getContentPane().add(expLabel);
		
		JButton backButton = new JButton("뒤로가기");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//뒤로가기
			}
		});
		backButton.setBounds(17, 210, 135, 27);
		frame.getContentPane().add(backButton);
		
		JButton exitButton = new JButton("종료하기");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(276, 209, 135, 27);
		frame.getContentPane().add(exitButton);
		frame.setVisible(true);
	}
}
