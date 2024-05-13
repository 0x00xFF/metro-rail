import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import sources.*;

public class register extends JFrame  implements ActionListener {
    private usercontrol user = new usercontrol();;
    private String path = "/home/snowden/test/Metro-Rail";
    private ImageIcon rp = new ImageIcon(path + "registration.png");
    private JLabel icon = new JLabel();
    private JPanel rightPanel = new JPanel();
    private JLabel reg = new JLabel("Register Your Account");
    private JLabel usernamel = new JLabel("Username:");
    private JLabel passwordl = new JLabel("Password:");
    private JLabel emaill = new JLabel("Email:");
    private JLabel genderl = new JLabel("Gender:");
    private JLabel religionl = new JLabel("Religion:");
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JTextField email = new JTextField();
    private JComboBox<String> gender = new JComboBox<>(new String[]{"Male", "Female", "Other"});
    private JComboBox<String> religion = new JComboBox<>(new String[]{"Islam", "Hindu", "Other"});
   // private JTextField religion = new JTextField();
    private JButton signupButton = new JButton("Sign Up");

    register() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 650);
        this.setTitle("Register");
        this.setLayout(null);
        this.setForeground(Color.LIGHT_GRAY);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - this.getWidth()) / 2;
        int centerY = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(centerX, centerY);
        this.setLayout(new BorderLayout()); // Use BorderLayout to add the top panel
        this.setResizable(false);

        // Left image setup
        icon.setIcon(rp);
        icon.setOpaque(false);
        icon.setBounds(0, 0, 400, 400);

        // Register Your Account - text
        reg.setBounds(170, 5, 400, 100);
        reg.setFont(new Font("Nerd Font", Font.ITALIC, 20));
        rightPanel.add(reg);

        // Username label and text field
        usernamel.setBounds(90, 100, 200, 40);
        usernamel.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        username.setBounds(200, 100, 200, 40);
        username.setBackground(new Color(146,208,243));
        rightPanel.add(usernamel);
        rightPanel.add(username);

        // Password label and text field
        passwordl.setBounds(90, 150, 200, 40);
        passwordl.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        password.setBounds(200, 150, 200, 40);
        password.setBackground(new Color(146,208,243));
        rightPanel.add(passwordl);
        rightPanel.add(password);

        // Email label and text field
        emaill.setBounds(90, 200, 200, 40);
        emaill.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        email.setBackground(new Color(146,208,243));
        email.setBounds(200, 200, 200, 40);
        rightPanel.add(emaill);
        rightPanel.add(email);

        // Gender label and combo box
        genderl.setBounds(90, 250, 200, 40);
        genderl.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        gender.setBounds(200, 250, 200, 40);
        gender.setBackground(new Color(146,208,243));
        rightPanel.add(genderl);
        rightPanel.add(gender);

        // Religion label and text field
        religionl.setBounds(90, 300, 200, 40);
        religionl.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        //religion.setBounds(200, 300, 200, 40);
        //religion.setBackground(new Color(146,208,243));
        religion.setBounds(200, 300, 200, 40);
        religion.setBackground(new Color(146,208,243));
        rightPanel.add(religionl);
        rightPanel.add(religion);

        // Signup button
        signupButton.setBounds(200, 350, 200, 40);
        signupButton.setFocusable(false);
        signupButton.setBackground(new Color(98, 216, 161));
        signupButton.addActionListener(this);
        rightPanel.add(signupButton);

        // Setup right panel
        rightPanel.setBackground(new Color(115, 192, 225));
        rightPanel.setLayout(null);
        rightPanel.setPreferredSize(new Dimension(560, this.getHeight())); // Set preferred width to 200 pixels

        // Add components to the JFrame
        this.add(rightPanel, BorderLayout.EAST);
        this.add(icon);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of the Register class
        new register();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==signupButton){
            int genderbox = gender.getSelectedIndex();
            String gendertext;
            if(genderbox==0){
                gendertext  =  "Male";
            } else if (genderbox==1) {
                gendertext = "Female";

            }else{
               gendertext = "Others";
            }

            int religionbox = religion.getSelectedIndex();
            String religiontext;
            if(religionbox==0){
                religiontext  =  "Islam";
            } else if (religionbox==1) {
                religiontext = "Hindu";

            }else{
                religiontext = "Others";
            }


            char[] passwordChars = password.getPassword();
            String pass = new String(passwordChars);

            verification verify = new verification(username.getText(), pass, email.getText(), religiontext , gendertext);

            if(verify.verify() == true){
                this.dispose();
                new userlogin();
                JOptionPane.showMessageDialog(null, "Account Created. Please Login.", "Account Created ", JOptionPane.PLAIN_MESSAGE);

                System.out.println("Nothing Changes");
            }


        }
    }
}
