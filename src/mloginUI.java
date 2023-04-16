import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class mloginUI {

	public mloginUI() {
		JFrame frame = new JFrame();
		frame.setTitle("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 24));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(0, 31, 428, 46);
		frame.getContentPane().add(titleLabel);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(54, 92, 49, 27);
		frame.getContentPane().add(idLabel);
		
		JLabel pwLabel = new JLabel("PW");
		pwLabel.setBounds(54, 133, 49, 27);
		frame.getContentPane().add(pwLabel);

		JTextField idText = new JTextField();
		idText.setBounds(106, 92, 197, 27);
		frame.getContentPane().add(idText);
		idText.setColumns(10);
		
		JButton loginButton = new JButton("\uB85C\uADF8\uC778");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.","알림",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		loginButton.setBounds(320, 92, 81, 69);
		frame.getContentPane().add(loginButton);
		
		JPasswordField pwText = new JPasswordField();
		pwText.setBounds(106, 134, 197, 27);
		frame.getContentPane().add(pwText);
		
		JButton joinButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		joinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new mjoinUI();
				System.out.println("회원가입");
			}
		});
		joinButton.setBounds(106, 189, 197, 29);
		frame.getContentPane().add(joinButton);
		frame.setVisible(true);
	}
}
