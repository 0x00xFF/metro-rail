import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class initial extends JFrame implements ActionListener {
    private JLabel centericon = new JLabel();
    private  JLabel background = new JLabel();
    private  String path = "/home/snowden/test/Metro-Rail";
    private  JButton adminB = new JButton("Admin");
    private JButton userB = new JButton("User");
    ImageIcon icon = new ImageIcon(path + "icon.png");
    ImageIcon backgroundimage = new ImageIcon(path + "background.jpg");
    ImageIcon adminicon = new ImageIcon(path+ "admin.png");
    ImageIcon usericon = new ImageIcon(path + "user.png");
    initial(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,750);
        this.setTitle("Metro Rail Management System");
        this.setIconImage(icon.getImage());
        this.setLayout(null);
        this.setForeground(Color.LIGHT_GRAY);

        //make the screen center
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - this.getWidth()) / 2;
        int centerY = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(centerX, centerY);


        //Backgroudn Label
        background.setBounds(0,0,1200,700);
        background.setIcon(backgroundimage);


        //Butoon -- Admin
       adminB.setBounds(230, 450, 300, 150);
       adminB.setIcon(adminicon);
       adminB.setFocusable(false);
       adminB.setBackground(new Color(169,218,121));
       adminB.setFont(new Font("Nerd Font", Font.ITALIC, 20));
       adminB.addActionListener(this);


        //Butoon -- User
        userB.setBounds(700, 450, 300, 150);
        userB.setIcon(usericon);
        userB.setFocusable(false);
        userB.setBackground(new Color(169,218,121));
        userB.setFont(new Font("Nerd Font", Font.ITALIC, 20));
        userB.addActionListener(this);



        //center icon
       centericon.setBounds(400, 150, 500, 200);
       centericon.setLayout(new BorderLayout());
       centericon.setText("Welcome to Java Metro Rail Management System");
       centericon.setHorizontalTextPosition(JLabel.CENTER);
       centericon.setVerticalTextPosition(JLabel.BOTTOM);
       centericon.setFont(new Font("Nerd Font", Font.ITALIC, 25));
       centericon.setIcon(icon);
       centericon.setOpaque(true);
       centericon.setBackground(new Color(0,0,0,0));
       centericon.setForeground(Color.BLUE);


        this.add(centericon);
        this.add(adminB);
        this.add(userB);

        this.add(background);




        this.setResizable(false);


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource()==adminB){
            adminlogin page = new adminlogin();
            this.dispose();
            System.out.println("hello");
        }
        else if(actionEvent.getSource()==userB){
            userlogin page = new userlogin();
            this.dispose();
            System.out.println("hello");
        }

    }
}

