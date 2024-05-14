package sources;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userdashboard extends JFrame implements ActionListener {
    private String path = "/home/snowden/java/Metro-Rail/icons/";
    private ImageIcon logo = new ImageIcon(path + "rail.jpeg");
    private JLabel logoLabel = new JLabel(logo);
    private JPanel topPanel = new JPanel();
    private JLabel titleLabel = new JLabel("Dashboard");
    private JPanel mainPanel = new JPanel();
    private JPanel balancePanel = new JPanel();
    private JLabel balanceLabel = new JLabel(); // You can set the balance value dynamically
    private JPanel ticketPanel = new JPanel();
    private JLabel ticketLabel = new JLabel(); // You can set the balance value dynamically
    private JButton rechargeButton = new JButton("Recharge");
    private JButton getTicketButton = new JButton("Get a Ticket");
    private JPanel accountDetailsPanel = new JPanel();
    private JLabel introtext = new JLabel("Account Information ");
    private JLabel usernameshow = new JLabel();
    private JLabel emailshow = new JLabel();
    private JLabel religionshow  = new JLabel();
    private JLabel gendershow= new JLabel();
    private JLabel usernamel = new JLabel("UserName: ");
    private JLabel emaill = new JLabel("Email: ");
    private JLabel religionl = new JLabel("Religion: ");
    private JLabel genderl = new JLabel("Gender:");
    private usercontrol user;
    private JButton userupdate = new JButton("Profile Settings");
    private String userna;


    public userdashboard(String username) {
        user = new usercontrol(username);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 750);
        this.setTitle("User Dashboard");
        this.setLayout(null);
        this.setForeground(Color.LIGHT_GRAY);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - this.getWidth()) / 2;
        int centerY = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(centerX, centerY);
        this.setResizable(false);
        userna = username;

        // Top Panel setup
        topPanel.setBounds(0, 0, 1200, 100);
        topPanel.setBackground(new Color(11,54,82));
        topPanel.setLayout(new BorderLayout());

        // Logo setup
        logoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        topPanel.add(logoLabel, BorderLayout.EAST);

        // Title setup
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Nerd Font", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Main Panel setup
        mainPanel.setBounds(0, 100, 1200, 650);
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(66,125, 164));


        //account details panel
        accountDetailsPanel.setBackground(Color.WHITE);
        accountDetailsPanel.setBounds(700, 00, 500, 700); // Manually set bounds for position
        accountDetailsPanel.setBackground(new Color(17,82,131));
        accountDetailsPanel.setLayout(null);


        introtext.setBackground(new Color(0,0,0,0));
        introtext.setBounds(120,2,300,70);
        introtext.setFont(new Font("Nerd Font", Font.ITALIC, 30));

        usernameshow.setText(username);
        emailshow.setText(user.getemail());
        gendershow.setText(user.getgender());
        religionshow.setText(user.getreligio());


        usernameshow.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        emailshow.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        gendershow.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        religionshow.setFont(new Font("Nerd Font", Font.PLAIN, 20));


        usernameshow.setBounds(160, 100, 100, 50);
       emailshow.setBounds(160, 130, 500, 50);
        gendershow.setBounds(160, 160, 100, 50);
        religionshow.setBounds(160, 190, 100, 50);


        usernamel.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        emaill.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        religionl.setFont(new Font("Nerd Font", Font.PLAIN, 20));
       genderl.setFont(new Font("Nerd Font", Font.PLAIN, 20));

        usernamel.setBounds(50,100,200,50);
        emaill.setBounds(59,130,200,50);
        religionl.setBounds(53,160,200,50);
        genderl.setBounds(55,190,200,50);


        //Buttons

        userupdate.setFont(new Font("Nerd Font", Font.ITALIC, 20));
        userupdate.setBackground(new Color(25,25,138));
        userupdate.setBounds(65,300,300,100);
        userupdate.setFocusable(false);
        userupdate.addActionListener(this);


        //account details add
        accountDetailsPanel.add(userupdate);
        accountDetailsPanel.add(emailshow);
        accountDetailsPanel.add(religionshow);
        accountDetailsPanel.add(gendershow);
        accountDetailsPanel.add(usernameshow);
        accountDetailsPanel.add(religionl);
        accountDetailsPanel.add(genderl);
        accountDetailsPanel.add(emaill);
        accountDetailsPanel.add(usernamel);
        accountDetailsPanel.add(introtext);
        mainPanel.add(accountDetailsPanel);

        // Balance Panel setup
        balancePanel.setBounds(50, 180, 200, 100);
        balancePanel.setBackground(Color.WHITE);
        balancePanel.setLayout(new BorderLayout());
        balancePanel.setBackground(new Color(109,210,163));
        balancePanel.setBackground(new Color(109,210,163));
        balancePanel.setForeground(Color.WHITE);


        // Balance Label setup
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        balanceLabel.setText("Balance: " + user.getamount());
        balanceLabel.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        balancePanel.add(balanceLabel, BorderLayout.CENTER);

        // Balance Panel setup
        ticketPanel.setBounds(400, 180, 200, 100);
        ticketPanel.setBackground(Color.WHITE);
        ticketPanel.setLayout(new BorderLayout());
        ticketPanel.setBackground(new Color(109,210,163));
        ticketPanel.setForeground(Color.WHITE);

        // Balance Label setup
        ticketLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ticketLabel.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        ticketLabel.setText("Your Tickets: " + user.gettickets());
        ticketPanel.add(ticketLabel, BorderLayout.CENTER);
        // Recharge Button setup
        rechargeButton.setBounds(50, 275, 200, 50);
        rechargeButton.setFocusable(false);
        rechargeButton.setBackground(new Color(72,152,115));
        rechargeButton.setFont(new Font("Nerd Font", Font.ITALIC, 22));
        rechargeButton.addActionListener(this);


        // Get Ticket Button setup
        getTicketButton.setBounds(400, 280, 200, 50);
        getTicketButton.setFocusable(false);
        getTicketButton.setBackground(new Color(72,152,115));
        getTicketButton.setFont(new Font("Nerd Font", Font.ITALIC, 22));
        getTicketButton.addActionListener(this);


        // Adding components to main panel
        mainPanel.add(ticketPanel);
        mainPanel.add(balancePanel);
        mainPanel.add(rechargeButton);
        mainPanel.add(getTicketButton);

        // Adding panels to JFrame
        this.add(topPanel);
        this.add(mainPanel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==rechargeButton){
            this.dispose();
            new recharge(userna);
        }
        if (actionEvent.getSource()==getTicketButton){
            new buyticket(userna);
            this.dispose();
        }
        if(actionEvent.getSource()==userupdate){
           new profilesetting(userna);
           this.dispose();
        }

    }
}

