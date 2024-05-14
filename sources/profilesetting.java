package sources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class profilesetting extends JFrame implements ActionListener {
    private String path = "/home/snowden/java/Metro-Rail/icons/";
    private JLabel titleLabel = new JLabel("Profile Settings");
    private JLabel iconLabel = new JLabel();
    private JPanel topPanel = new JPanel();
    private JPanel mainPanel = new JPanel();
    private JLabel usernameLabel = new JLabel("Username:");
    private JLabel emailLabel = new JLabel("Email:");
    private JLabel passwordLabel = new JLabel("Change Password:");
    private JLabel genderLabel = new JLabel("Gender:");
    private JLabel religionLabel = new JLabel("Religion:");
    private JTextField usernameField = new JTextField();
    private JTextField emailField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
    private JComboBox<String> religionComboBox = new JComboBox<>(new String[]{"Islam", "Christanity", "Hinduism", "Buddhism", "Judaism", "Other"});
    private JLabel imagelebel = new JLabel();
    private  ImageIcon settingsimg = new ImageIcon(path + "settings.png");
    private String userna;
    private JButton backButton = new JButton("Back to Dashborad");
    private JButton saveButton = new JButton("Save");
    private JButton deleteaccount = new JButton("Delete My Account");

    public profilesetting(String username) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("User Edit");
        this.setLayout(null);
        this.setForeground(Color.LIGHT_GRAY);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - this.getWidth()) / 2;
        int centerY = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(centerX, centerY);
        this.setResizable(false);
        userna =username;
        usercontrol user = new usercontrol(username);


        // Top Panel setup
        topPanel.setBounds(0, 0, 800, 100);
        topPanel.setLayout(null);
        topPanel.setBackground(new Color(20,137,75));
        imagelebel.setIcon(settingsimg);
        imagelebel.setBounds(10,20,30,30);
        //topPanel.add(imagelebel);

        // Icon Label setup
        ImageIcon icon = new ImageIcon(path + "settings.png");
        iconLabel.setIcon(icon);
        iconLabel.setBounds(20, 10, 80, 80);
        topPanel.add(iconLabel);

        // Title Label setup
        titleLabel.setBounds(250, 10, 200, 80);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(titleLabel);

        // Adding top panel to JFrame
        this.add(topPanel);

        // Main Panel setup
        mainPanel.setBounds(0, 100, 800, 500);
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(95, 243, 179));

        // Username Label and Field setup
        usernameLabel.setBounds(50, 50, 100, 30);
        usernameField.setText(username);
        mainPanel.add(usernameLabel);
        usernameField.setBounds(200, 50, 200, 30);
        usernameField.setEditable(false);
        mainPanel.add(usernameField);

        // Email Label and Field setup
        emailLabel.setBounds(50, 100, 100, 30);
        mainPanel.add(emailLabel);
        emailField.setBounds(200, 100, 200, 30);
        emailField.setText(user.getemail());
        mainPanel.add(emailField);

        // Password Label and Field setup
        passwordLabel.setBounds(50, 150, 150, 30);
        mainPanel.add(passwordLabel);
        passwordField.setBounds(200, 150, 200, 30);
        passwordField.setText(user.getpassword());
        mainPanel.add(passwordField);

        // Gender Label and ComboBox setup
        genderLabel.setBounds(50, 200, 100, 30);
        mainPanel.add(genderLabel);
        genderComboBox.setBounds(200, 200, 200, 30);
        mainPanel.add(genderComboBox);

        // Religion Label and ComboBox setup
        religionLabel.setBounds(50, 250, 100, 30);
        mainPanel.add(religionLabel);
        religionComboBox.setBounds(200, 250, 200, 30);
        mainPanel.add(religionComboBox);


        //Back to Dashboard Button
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setBounds(70,300,150,40);
        mainPanel.add(backButton);


        //Save Button
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);
        saveButton.setBounds(250,300,150,40);
        mainPanel.add(saveButton);


        //Delete Account
        deleteaccount.setFocusable(false);
        deleteaccount.addActionListener(this);
        deleteaccount.setBounds(120,350,200,40);
        mainPanel.add(deleteaccount);

        // Adding main panel to JFrame
        this.add(mainPanel);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of the UserEdit class
        new profilesetting("yeaqub");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==backButton){
            this.dispose();
            new userdashboard(userna);
        }
        if(actionEvent.getSource()==saveButton){
            usercontrol user = new usercontrol(userna);
            int genderbox = genderComboBox.getSelectedIndex();
            String gendertext;
            if(genderbox==0){
                gendertext  =  "Male";
            } else if (genderbox==1) {
                gendertext = "Female";

            }else{
                gendertext = "Others";
            }

            int religionbox = religionComboBox.getSelectedIndex();
            String religiontext;
            if(religionbox==0){
                religiontext  =  "Islam";
            } else if (religionbox==1) {
                religiontext = "Hindu";

            }else{
                religiontext = "Others";
            }
            char[] passwordChars = passwordField.getPassword();
            String pass = new String(passwordChars);
            user.updateUser(usernameField.getText(), emailField.getText(), pass, gendertext, religiontext);
        }
        if (actionEvent.getSource()==deleteaccount){
            usercontrol user = new usercontrol(userna);
            user.deleteAccount(userna);
            this.dispose();
        }

    }
}
