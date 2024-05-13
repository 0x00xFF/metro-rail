package sources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buyticket extends JFrame implements ActionListener {
    private String path = "/home/snowden/test/Metro-Rail/icons/";
    private JLabel titleLabel = new JLabel("Buy Ticket");
    private JLabel iconLabel = new JLabel();
    private JPanel mainPanel = new JPanel();
    private JLabel locationLabel = new JLabel("Select Location:");
    private JComboBox<String> locationComboBox = new JComboBox<>(new String[]{"Komolapur", "Mothijgil", "Socibaloy", "Dhaka University", "Shahbag", "Karoyan Bazar", "Framegate", "Bijoy Shoroni", "Agargaon", "Shewrapara", "Kaji Para", "Mirpur 10", "Mirpur 11", "Pollobi", "Uttor Dokkhin", "Uttor Center", "Uttora Uttor"});
    private JLabel ageLabel = new JLabel("Age:");
    private JTextField ageField = new JTextField();
    private JLabel baggageLabel = new JLabel("Baggage:");
    private JTextField baggageField = new JTextField();
    private JLabel priceLabel = new JLabel("Ticket Price: 100 taka");
    private JButton backButton = new JButton("Back to Dashboard");
    private JButton buyButton = new JButton("Buy Tickets");
    private JPanel toppanel = new JPanel();
    private JLabel amountLabel = new JLabel("Number of Ticket:");
    private JTextField amountfield = new JTextField();
    private  String users;

    public buyticket(String username) {
        users = username;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550, 650);
        this.setTitle("Buy Ticket");
        this.setLayout(null);
        this.setForeground(Color.LIGHT_GRAY);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - this.getWidth()) / 2;
        int centerY = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(centerX, centerY);


        toppanel.setBounds(0,0,700,150);
        toppanel.setBackground(new Color(20,137,75));
        //toppanel.setBackground(new Color(121,206,164));
        toppanel.setLayout(null);
        this.add(toppanel);


        // Title Label setup
        titleLabel.setBounds(210, 40, 350, 70);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setBackground(Color.RED);
        titleLabel.setForeground(new Color(41,203,215));
        toppanel.add(titleLabel);

        // Icon Label setup
        ImageIcon icon = new ImageIcon(path  + "icon.png");
        iconLabel.setIcon(icon);
        iconLabel.setBackground(new Color(121, 206, 164));
        iconLabel.setBounds(50, 30, 100, 100);
        toppanel.add(iconLabel);

        // Main Panel setup
        mainPanel.setBounds(0, 150, 1200, 600);
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(121,206,164));

        // Location Label and ComboBox setup
        locationLabel.setBounds(50, 50, 150, 30);
        mainPanel.add(locationLabel);
        locationComboBox.setBounds(200, 50, 200, 30);
        mainPanel.add(locationComboBox);

        // Age Label and Field setup
        ageLabel.setBounds(50, 100, 150, 30);
        mainPanel.add(ageLabel);
        ageField.setBounds(200, 100, 200, 30);
        mainPanel.add(ageField);

        // Baggage Label and Field setup
        baggageLabel.setBounds(50, 150, 150, 30);
        mainPanel.add(baggageLabel);
        baggageField.setBounds(200, 150, 200, 30);
        mainPanel.add(baggageField);


        //Amount of Ticket
        amountLabel.setBounds(50, 200, 150, 30);
        mainPanel.add(amountLabel);
        amountfield.setBounds(200, 200, 200, 30);
        mainPanel.add(amountfield);

        // Price Label setup
        priceLabel.setBounds(50, 250, 200, 30);
        mainPanel.add(priceLabel);

        // Back Button setup
        backButton.setBounds(50, 300, 150, 30);
        mainPanel.add(backButton);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        // Back Button setup
        buyButton.setBounds(240, 300, 150, 30);
        buyButton.setFocusable(false);
        mainPanel.add(buyButton);
        buyButton.addActionListener(this);

        // Adding main panel to JFrame
        this.add(mainPanel);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of the buyticket class
        new buyticket("yeaqub");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==backButton){
            this.dispose();
            new userdashboard(users);
        }
        if(actionEvent.getSource()==buyButton){
            usercontrol user = new usercontrol(users);
            String text = amountfield.getText();

            if(text.isEmpty()){
                System.out.println("error");
            }else {
                int tamount = Integer.parseInt(text);
                System.out.println("no error");
                user.buyticket(users, tamount);
            }
        }

    }
}
