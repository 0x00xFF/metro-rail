package sources;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class recharge extends JFrame implements ActionListener {
    private String path = "./icons/";

    private JLabel titleLabel = new JLabel("Recharge your account");
    private JPanel mainPanel = new JPanel();
    private JLabel cardNumberLabel = new JLabel("Card Number:");
    private JLabel expiryDateLabel = new JLabel("Expiry Date:");
    private JLabel cvvLabel = new JLabel("CVV:");
    private JLabel amountLabel = new JLabel("Amount:");
    private JTextField cardNumberField = new JTextField();
    private JTextField expiryDateField = new JTextField();
    private JTextField cvvField = new JTextField();
    private JTextField amountField = new JTextField();
    private JButton rechargeButton = new JButton("Recharge");
    private JButton backButton = new JButton("Back to Dashboard");
    private ImageIcon image = new ImageIcon(path + "paymentback.jpg");
    private JLabel background = new JLabel();
    private String user;

    public recharge(String username) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setTitle("Recharge");
        this.setLayout(null);
        this.setForeground(Color.LIGHT_GRAY);
        this.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - this.getWidth()) / 2;
        int centerY = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(centerX, centerY);
        user= username;

        // Main Panel setup
        mainPanel.setBounds(0, 0, 1000, 600);
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(135, 206, 235)); // Sky Blue background


        background.setIcon(image);
        background.setOpaque(false);

        // Title Label setup
        titleLabel.setBounds(300, 50, 400, 50);
        titleLabel.setFont(new Font("Nerd Font", Font.BOLD, 24));
        mainPanel.add(titleLabel);

        // Card Number Label and Field setup
        cardNumberLabel.setBounds(150, 150, 150, 30);
        cardNumberLabel.setFont(new Font("Nerd Font", Font.PLAIN, 16));
        mainPanel.add(cardNumberLabel);
        cardNumberField.setBounds(300, 150, 300, 30);
        mainPanel.add(cardNumberField);

        // Expiry Date Label and Field setup
        expiryDateLabel.setBounds(150, 200, 150, 30);
        expiryDateLabel.setFont(new Font("Nerd Font", Font.PLAIN, 16));
        mainPanel.add(expiryDateLabel);
        expiryDateField.setBounds(300, 200, 300, 30);
        mainPanel.add(expiryDateField);

        // CVV Label and Field setup
        cvvLabel.setBounds(150, 250, 150, 30);
        cvvLabel.setFont(new Font("Nerd Font", Font.PLAIN, 16));
        mainPanel.add(cvvLabel);
        cvvField.setBounds(300, 250, 100, 30);
        mainPanel.add(cvvField);

        // Amount Label and Field setup
        amountLabel.setBounds(420, 250, 150, 30);
        amountLabel.setFont(new Font("Nerd Font", Font.PLAIN, 16));
        mainPanel.add(amountLabel);
        amountField.setBounds(500, 250, 100, 30);
        mainPanel.add(amountField);

        // Recharge Button setup
        rechargeButton.setBounds(200, 320, 150, 50);
        mainPanel.add(rechargeButton);
        rechargeButton.addActionListener(this);
        rechargeButton.setFocusable(false);

        // Back Button setup
        backButton.setBounds(370, 320, 200, 50);
        mainPanel.add(backButton);
        backButton.addActionListener(this);
        backButton.setFocusable(false);

        // Adding main panel to JFrame
        this.add(mainPanel);
        this.add(background);


        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of the Recharge class
        new recharge("yeaqub");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource()==backButton){
            this.dispose();
            new userdashboard(user);
        }
        if(actionEvent.getSource()==rechargeButton){
            usercontrol userco = new usercontrol(user);
            //String stramount = amountField.get
            userco.addAmount(user, amountField.getText());
            JOptionPane.showMessageDialog(null, amountField.getText() + " recharged Successfully. Your Current Balance" + userco.getamount());

        }
    }
}
