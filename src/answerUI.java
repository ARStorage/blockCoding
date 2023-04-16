import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;

public class answerUI {

	public answerUI() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("\uC815\uB2F5 \uD655\uC778");
		frame.setBounds(100, 100, 1007, 706);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel qanswerPanel = new JPanel();
		qanswerPanel.setBackground(SystemColor.controlHighlight);
		qanswerPanel.setBounds(17, 115, 384, 503);
		frame.getContentPane().add(qanswerPanel);
		qanswerPanel.setLayout(null);
		
		JPanel qtitlePanel = new JPanel();
		qtitlePanel.setBackground(new Color(100, 149, 237));
		qtitlePanel.setBounds(0, 0, 384, 76);
		qanswerPanel.add(qtitlePanel);
		qtitlePanel.setLayout(null);
		
		JLabel qtitleLabel = new JLabel("\uD034\uC988 \uC815\uB2F5");
		qtitleLabel.setBounds(0, 0, 384, 73);
		qtitlePanel.add(qtitleLabel);
		qtitleLabel.setBackground(Color.WHITE);
		qtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		qtitleLabel.setFont(new Font("±¼¸²", Font.BOLD, 32));
		
		JButton q1Button = new JButton("\uC815\uB2F5 \uBE14\uB85D1");
		q1Button.setBounds(27, 103, 340, 29);
		qanswerPanel.add(q1Button);
		
		JButton q2Button = new JButton("\uC815\uB2F5 \uBE14\uB85D2");
		q2Button.setBounds(27, 156, 340, 29);
		qanswerPanel.add(q2Button);
		
		JButton q3Button = new JButton("\uC815\uB2F5 \uBE14\uB85D3");
		q3Button.setBounds(27, 207, 340, 29);
		qanswerPanel.add(q3Button);
		
		JButton q4Button = new JButton("\uC815\uB2F5 \uBE14\uB85D4");
		q4Button.setBounds(27, 258, 340, 29);
		qanswerPanel.add(q4Button);
		
		JButton q5Button = new JButton("\uC815\uB2F5 \uBE14\uB85D5");
		q5Button.setBounds(27, 311, 340, 29);
		qanswerPanel.add(q5Button);
		
		JButton q6Button = new JButton("\uC815\uB2F5 \uBE14\uB85D6");
		q6Button.setBounds(27, 362, 340, 29);
		qanswerPanel.add(q6Button);
		
		JButton q7Button = new JButton("\uC815\uB2F5 \uBE14\uB85D7");
		q7Button.setBounds(27, 414, 340, 29);
		qanswerPanel.add(q7Button);
		
		JButton q8Button = new JButton("\uC815\uB2F5 \uBE14\uB85D8");
		q8Button.setBounds(27, 467, 340, 29);
		qanswerPanel.add(q8Button);
		
		JPanel userPanel = new JPanel();
		userPanel.setBounds(410, 115, 558, 503);
		frame.getContentPane().add(userPanel);
		userPanel.setLayout(null);
		
		JPanel utitlePanel = new JPanel();
		utitlePanel.setLayout(null);
		utitlePanel.setBackground(new Color(245, 222, 179));
		utitlePanel.setBounds(0, 0, 558, 74);
		userPanel.add(utitlePanel);
		
		JLabel utitleLabel = new JLabel("\uC0AC\uC6A9\uC790 \uC815\uB2F5");
		utitleLabel.setBounds(0, 0, 558, 74);
		utitlePanel.add(utitleLabel);
		utitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		utitleLabel.setFont(new Font("±¼¸²", Font.BOLD, 32));
		utitleLabel.setBackground(Color.WHITE);
		
		JButton button = new JButton("\uB2E4\uC74C \uD034\uC988");
		button.setBounds(413, 459, 145, 44);
		userPanel.add(button);
		
		JPanel objectPanel = new JPanel();
		objectPanel.setBackground(Color.WHITE);
		objectPanel.setBounds(326, 118, 203, 196);
		userPanel.add(objectPanel);
		
		JLabel checkLabel = new JLabel("\uC544\uC27D\uB124\uC694! 1\uBD84 \uB4A4\uC5D0 \uB2E4\uC2DC \uD569\uC2DC\uB2E4.");
		checkLabel.setHorizontalAlignment(SwingConstants.CENTER);
		checkLabel.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		checkLabel.setBounds(28, 365, 500, 68);
		userPanel.add(checkLabel);
		
		JPanel quizPanel = new JPanel();
		quizPanel.setBackground(SystemColor.text);
		quizPanel.setBounds(17, 15, 951, 88);
		frame.getContentPane().add(quizPanel);
		quizPanel.setLayout(null);
		
		JLabel quizLabel = new JLabel("\uD034\uC988 : ");
		quizLabel.setFont(new Font("±¼¸²", Font.BOLD, 24));
		quizLabel.setBounds(17, 15, 917, 58);
		quizPanel.add(quizLabel);
	}

}
