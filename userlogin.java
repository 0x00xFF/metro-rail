import sources.userdashboard;
import sources.verification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userlogin extends JFrame implements ActionListener {
    private  String path = "/home/snowden/test/Metro-Rail";
    private ImageIcon icon = new ImageIcon(path + "icon.png");
    private ImageIcon backgroundimg = new ImageIcon(path + "userloginback.png");
    private ImageIcon adminI = new ImageIcon(path + "userbig.png");
    private JLabel background = new JLabel();
    private JLabel usertext = new JLabel("UserName: ");
   private  JLabel passwordtext = new JLabel("Password: ");
    private JLabel intro = new JLabel(" USER");
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JButton login = new JButton("Login");
    private JButton register = new JButton("Register");

    userlogin() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 750);
        this.setTitle("Metro Rail Management System");
        this.setIconImage(icon.getImage());
        this.setLayout(null);
        this.setForeground(Color.LIGHT_GRAY);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - this.getWidth()) / 2;
        int centerY = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(centerX, centerY);
        this.setResizable(false);

        //background
        background.setIcon(backgroundimg);
        background.setBounds(0,0,1200,750);
        background.setOpaque(true);



        //Intro Admin Logo
        intro.setIcon(adminI);
        intro.setBounds(340, 70, 500, 300);
        intro.setOpaque(true);
        intro.setBackground(new Color(0,0,0,0));
        intro.setFont(new Font("Nerd Font", Font.ROMAN_BASELINE,  100));
        intro.setForeground(Color.WHITE);
        intro.setForeground(new Color(215,58,199));


        //usertext
        usertext.setBounds(270,355,400,50);
        usertext.setBackground(new Color(0,0,0,0));
        usertext.setForeground(new Color(215,58,199));
        usertext.setFont(new Font("Nerd Font", Font.TRUETYPE_FONT, 40));



        //username text field
        username.setBounds(500,350,320,55);
        username.setBackground(new Color(214,214,253));
        username.setForeground(Color.GREEN);

        //passwordtext
        passwordtext.setBounds(280,433,400,50);
        passwordtext.setBackground(new Color(0,0,0,0));
        passwordtext.setForeground(new Color(215,58,199));
        passwordtext.setFont(new Font("Nerd Font", Font.TRUETYPE_FONT, 40));



        //passwordname text field
        password.setBounds(500,430,320,55);
        password.setBackground(new Color(214,214,253));
        password.setForeground(Color.GREEN);


        //login Button

        login.setBounds(620,510,190,50);
        login.setBackground(new Color(215,58,199));
        login.setFont(new Font("Nerd Font", Font.TRUETYPE_FONT, 30));
        login.setFocusable(false);
        login.addActionListener(this);


        //login as user button

        register.setBounds(300, 510, 250, 50);
        register.setBackground(new Color(215, 94, 114));
        register.setFont(new Font("Nerd Font", Font.TRUETYPE_FONT, 30));
        register.setFocusable(false);
        register.addActionListener(this);




        this.add(login);
        this.add(register);
        this.add(passwordtext);
        this.add(password);
        this.add(usertext);
        this.add(username);
        this.add(intro);
        this.add(background);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == register){
           this.dispose();
           new register();
        }
        if(actionEvent.getSource()==login){
            char[] passwordChars = password.getPassword();
            String pass = new String(passwordChars);
            verification verify = new verification(username.getText(), pass);
            if(verify.verify()==true)  {
                System.out.println("true");
                new userdashboard(username.getText());
                this.dispose();
            }else {
                System.out.println("flase");
            }
        }
    }
}