import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class firstUI{

	public firstUI() {
		JFrame frame = new JFrame();
		frame.setTitle("\uBE14\uB85D \uCF54\uB529 \uAD50\uC721 \uD504\uB85C\uADF8\uB7A8");
		frame.setBounds(100, 100, 692, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton exitButton = new JButton("\uC885\uB8CC");
		exitButton.setBounds(524, 15, 129, 29);
		frame.getContentPane().add(exitButton);
		
		JButton userButton = new JButton("\uC0AC\uC6A9\uC790 \uBAA8\uB4DC");
		userButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new uloginUI();
				System.out.println("사용자 로그인");
			}
		});
		
		userButton.setBounds(219, 144, 231, 49);
		frame.getContentPane().add(userButton);
		
		JButton managerButton = new JButton("\uAD00\uB9AC\uC790 \uBAA8\uB4DC");
		managerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new mloginUI();
				System.out.println("관리자 로그인");
			}
		});
		managerButton.setBounds(219, 223, 231, 49);
		frame.getContentPane().add(managerButton);
		
		JLabel titleLabel = new JLabel("\uBE14\uB85D \uCF54\uB529 \uAD50\uC721 \uD504\uB85C\uADF8\uB7A8");
		titleLabel.setFont(new Font("굴림", Font.BOLD, 24));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(0, 72, 670, 42);
		frame.getContentPane().add(titleLabel);
		frame.setVisible(true);
	}
}
