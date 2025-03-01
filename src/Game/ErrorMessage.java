package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ErrorMessage {
	public static void showErrorDialog(String title, String message) {
        JDialog dialog = new JDialog();
        dialog.setTitle(title);
        
        JPanel error = new JPanel();
        error.setLayout(new GridBagLayout());
        error.setBackground(Utility.backcolor);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        
        ImageIcon imageIcon = new ImageIcon(ErrorMessage.class.getResource("/image/yongyong5.png"));
		Image originalImage = imageIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(scaledImage);
		
		JLabel imageLabel = new JLabel(imageIcon);
        error.add(imageLabel,gbc);

        Font font = Utility.yeongdeok_sea(16);

        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(font);

        gbc.gridx=1;
        error.add(messageLabel,gbc);
        
        JButton closeButton = new RoundedButton("확인");
        
        closeButton.setFont(font);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        gbc.gridy=1;
        error.add(closeButton,gbc);

        dialog.setContentPane(error);
        dialog.setSize(300, 180);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}
