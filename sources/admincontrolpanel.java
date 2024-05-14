package sources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admincontrolpanel extends JFrame {
    private String path = "/home/snowden/java/icons/";
   // private String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"};
    admincontrol  admin;
    String[] items = admincontrol.getAllUsernames();
    private JRadioButton[] radioButtons;
    private JPanel toppanel = new JPanel();
    private JPanel itempanel = new JPanel();
    private JLabel userlabel = new JLabel();
    private ImageIcon adminlogo = new ImageIcon(path + "adminpanel.png");
    private JLabel adminlogopanel = new JLabel();
    private JLabel uppertext = new JLabel("Admin Panel");
    private JLabel ticketsold = new JLabel();
    private JLabel earned = new JLabel();
    private  JLabel devlebel = new JLabel();
    private  ImageIcon devs = new ImageIcon(path + "devs.png");



    public admincontrolpanel() {
        admin = new admincontrol();

        this.setTitle("Admin Control Panel");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - this.getWidth()) / 2;
        int centerY = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(centerX, centerY);
        this.setResizable(false);

        //top panel

        toppanel.setBackground(new Color(122,183,117));
        toppanel.setBounds(0,0, 1000, 120);
        toppanel.setLayout(null);


        //admin logo//
        adminlogopanel.setIcon(adminlogo);
        adminlogopanel.setBounds(50,15, 90, 90);
        toppanel.add(adminlogopanel);


        //upper text
        uppertext.setBounds(400,35,400,50);
        uppertext.setFont(new Font("Nerd Font", Font.ITALIC, 45));
        toppanel.add(uppertext);

        this.add(toppanel);





        //item panel config
        itempanel.setBounds(0,120,1000,800);
        itempanel.setBackground(new Color(194,253,190));
        itempanel.setLayout(null);


        //item panel items

        //total earning
        earned.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        earned.setText("   Total Earned: " + admin.netbalance());
        earned.setBounds(350,60,200,70);
        earned.setOpaque(true);
        earned.setBackground(new Color(119,212,95));
        itempanel.add(earned);

        //total ticket sold
        ticketsold.setFont(new Font("Nerd Font", Font.PLAIN, 20));
        ticketsold.setText("   Total Ticket Sold: " + admin.toalticket());
        //  ticketsold.setBounds();
        ticketsold.setBounds(650,60,210,70);
        ticketsold.setOpaque(true);
        ticketsold.setBackground(new Color(119,212,95));
        itempanel.add(ticketsold);


        //devs

        devlebel.setIcon(devs);
        devlebel.setBounds(500,150,400,400);
        itempanel.add(devlebel);


        //users label
        userlabel.setBounds(45,50,200,30);
        userlabel.setText("  Users("+ admin.usercount()+ ")");
        userlabel.setBackground(new Color(79,189,71));
        userlabel.setFont(new Font("Nerd Font", Font.BOLD, 20));
        userlabel.setForeground(Color.WHITE);
        userlabel.setOpaque(true);
        itempanel.add(userlabel);


        JPanel radioButtonPanel = new JPanel();
        radioButtonPanel.setLayout(new GridLayout(items.length, 1));

        radioButtons = new JRadioButton[items.length];

        ButtonGroup group = new ButtonGroup();

        // Add radio buttons to the panel
        for (int i = 0; i < items.length; i++) {
            radioButtons[i] = new JRadioButton(items[i]);
            radioButtonPanel.add(radioButtons[i]);
            group.add(radioButtons[i]); // Add radio button to the group
        }

        // Create a scroll pane and add the radio button panel to it
        JScrollPane scrollPane = new JScrollPane(radioButtonPanel);
        scrollPane.setBounds(45, 80, 200, 400);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);




        // Add the scroll pane to the frame
        itempanel.add(scrollPane);

        // Create a button to perform selection
        JButton selectButton = new JButton("Select");

        selectButton.setBounds(60, 490, 150, 40);
        selectButton.setBackground(new Color(245,253,243));
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = "";
                for (int i = 0; i < radioButtons.length; i++) {
                    if (radioButtons[i].isSelected()) {
                        selectedItem = radioButtons[i].getText();
                        break; // Once an item is selected, break the loop
                    }
                }
                if(selectedItem.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No User Selected.");
                }else{
                   new profilesetting(selectedItem);
                }


            }
        });

        // Add the button to the frame
        this.add(itempanel);
        itempanel.add(selectButton);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new admincontrolpanel();
    }
}
