import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminlogin extends JFrame implements ActionListener {
    private  String path = "/home/snowden/test/Metro-Rail/";
    private ImageIcon icon = new ImageIcon(path + "icon.png");
    private ImageIcon backgroundimg = new ImageIcon(path + "adminloginback.jpg");
    private ImageIcon adminI = new ImageIcon(path + "adminbig.png");
    private JLabel background = new JLabel();
    private JLabel usertext = new JLabel("UserName: ");
   private  JLabel passwordtext = new JLabel("Password: ");

    private JLabel intro = new JLabel(" Admin");
    private JTextField username = new JTextField("username");
    private JTextField password = new JPasswordField("password");
    private JButton login = new JButton("Login");
    private JButton userlogin = new JButton("Login As User");

    adminlogin() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 750);
        this.setTitle("Gui Password Manager");
        this.setIconImage(icon.getImage());
        this.setLayout(null);
        this.setForeground(Color.LIGHT_GRAY);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - this.getWidth()) / 2;
        int centerY = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(centerX, centerY);

        //background
        background.setIcon(backgroundimg);
        background.setBounds(0,0,1200,750);
        background.setOpaque(true);



        //Intro Admin Logo
        intro.setIcon(adminI);
        intro.setBounds(320, 70, 500, 300);
        intro.setOpaque(true);
        intro.setBackground(new Color(0,0,0,0));
        intro.setFont(new Font("Nerd Font", Font.ROMAN_BASELINE,  100));
        intro.setForeground(Color.WHITE);


        //usertext
        usertext.setBounds(270,355,400,50);
        usertext.setBackground(new Color(0,0,0,0));
        usertext.setForeground(new Color(75,199,150));
        usertext.setFont(new Font("Nerd Font", Font.TRUETYPE_FONT, 40));



        //username text field
        username.setBounds(500,350,320,55);
        username.setBackground(new Color(0,0,0,0));
        username.setForeground(Color.GREEN);
        username.setText("hello");

        //passwordtext
        passwordtext.setBounds(280,433,400,50);
        passwordtext.setBackground(new Color(0,0,0,0));
        passwordtext.setForeground(new Color(75,199,150));
        passwordtext.setFont(new Font("Nerd Font", Font.TRUETYPE_FONT, 40));



        //passwordname text field
        password.setBounds(500,430,320,55);
        password.setBackground(new Color(0,0,0,0));
        password.setForeground(Color.GREEN);
        password.setText("hello");


        //login Button

        login.setBounds(620,510,190,50);
        login.setBackground(new Color(71,190,150));
        login.setFont(new Font("Nerd Font", Font.TRUETYPE_FONT, 30));
        login.setFocusable(false);


        //login as user button

        userlogin.setBounds(300, 510, 250, 50);
        userlogin.setBackground(new Color(215, 94, 114));
        userlogin.setFont(new Font("Nerd Font", Font.TRUETYPE_FONT, 30));
        userlogin.setFocusable(false);
        userlogin.addActionListener(this);




        this.add(login);
        this.add(userlogin);
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
        if(actionEvent.getSource()==userlogin){
            new userlogin();
        }

    }
}
