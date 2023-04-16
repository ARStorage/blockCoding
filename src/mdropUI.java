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
		frame.setTitle("������ Ż��");
		frame.setBounds(100, 100, 450, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("������ Ż��");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("����", Font.BOLD, 24));
		titleLabel.setBounds(0, 33, 428, 46);
		frame.getContentPane().add(titleLabel);
		
		JLabel pwLabel = new JLabel("PW");
		pwLabel.setBounds(31, 147, 49, 27);
		frame.getContentPane().add(pwLabel);
		
		JPasswordField pwText = new JPasswordField();
		pwText.setBounds(110, 147, 197, 27);
		frame.getContentPane().add(pwText);
		
		JButton pwcheckButton = new JButton("Ȯ��");
		pwcheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if PW ����O -> Ż�� ó���ϱ�
				int result = JOptionPane.showConfirmDialog(null, "��й�ȣ�� ��ġ�մϴ�.\n���� Ż���Ͻðڽ��ϱ�?","�˸�",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					//��, �ƴϿ� ���� ���� ���̾�α� â�� �ݾ��� ��� Ż�� ���� X 
				}
				else if(result==JOptionPane.YES_OPTION) { 
					//���� ������ ��� Ż�� ���� O
					JOptionPane.showMessageDialog(null, "Ż�� �����߽��ϴ�.","�˸�",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					//�ƴϿ��� ������ ��� Ż�� ���� X
				}
				
				//else PW ����X 
				JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.\n�ٽ� �Է����ּ���.","�˸�",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		pwcheckButton.setBounds(324, 147, 71, 27);
		frame.getContentPane().add(pwcheckButton);
		
		JLabel expLabel = new JLabel("�ùٸ� ���� Ż�� ���� ��й�ȣ�� �Է� �� Ȯ�� ��ư�� ��������.");
		expLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expLabel.setBounds(0, 94, 428, 27);
		frame.getContentPane().add(expLabel);
		
		JButton backButton = new JButton("�ڷΰ���");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ڷΰ���
			}
		});
		backButton.setBounds(17, 210, 135, 27);
		frame.getContentPane().add(backButton);
		
		JButton exitButton = new JButton("�����ϱ�");
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
