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

public class ujoinUI {

	private JFrame frame;
	private JTextField idText;
	private JPasswordField pwText;
	private JTextField birthText;
	private JTextField nameText;

	public ujoinUI() {
		frame = new JFrame();
		frame.setTitle("\uC0AC\uC6A9\uC790 \uD68C\uC6D0\uAC00\uC785");
		frame.setBounds(100, 100, 450, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("\uC0AC\uC6A9\uC790 \uD68C\uC6D0\uAC00\uC785");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("굴림", Font.BOLD, 24));
		titleLabel.setBounds(0, 33, 428, 46);
		frame.getContentPane().add(titleLabel);
		
		idText = new JTextField();
		idText.setColumns(10);
		idText.setBounds(140, 100, 197, 27);
		frame.getContentPane().add(idText);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(61, 100, 49, 27);
		frame.getContentPane().add(idLabel);
		
		JLabel pwLabel = new JLabel("PW");
		pwLabel.setBounds(61, 176, 49, 27);
		frame.getContentPane().add(pwLabel);
		
		pwText = new JPasswordField();
		pwText.setBounds(140, 176, 197, 27);
		frame.getContentPane().add(pwText);
		
		JButton idcheckButton = new JButton("\uC911\uBCF5\uD655\uC778");
		idcheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if ID 존재O
				JOptionPane.showMessageDialog(null, "존재하는 아이디입니다.\n다시 입력해주세요.","알림",JOptionPane.INFORMATION_MESSAGE);
				//else ID 존재X
				JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.","알림",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		idcheckButton.setBounds(140, 132, 197, 27);
		frame.getContentPane().add(idcheckButton);
		
		JLabel birthLabel = new JLabel("\uC0DD\uB144\uC6D4\uC77C          ex)20000101");
		birthLabel.setBounds(61, 270, 276, 27);
		frame.getContentPane().add(birthLabel);
		
		birthText = new JTextField();
		birthText.setBounds(140, 310, 197, 27);
		frame.getContentPane().add(birthText);
		birthText.setColumns(10);
		
		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setBounds(61, 228, 49, 27);
		frame.getContentPane().add(nameLabel);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(140, 228, 197, 27);
		frame.getContentPane().add(nameText);
		
		JButton joinButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		joinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "회원가입에 성공했습니다.","알림",JOptionPane.INFORMATION_MESSAGE);
				//회원가입 완료 후 로그인 창 뜨게 
				frame.dispose();
				new uloginUI();
			}
		});
		joinButton.setBounds(140, 367, 144, 42);
		frame.getContentPane().add(joinButton);
		frame.setVisible(true);
	}

}
