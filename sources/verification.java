package sources;

import javax.swing.JOptionPane;

public class verification {
    private boolean check = true;
    //register
    public verification(String username, String password, String email, String religion, String gender){
        if(username.isEmpty()){
            System.out.println("username empty");
            check= false;
            JOptionPane.showMessageDialog(null, "Username Empty", "Username Empty", JOptionPane.WARNING_MESSAGE);
        }else if(password.isEmpty()){
            System.out.println("password empty");
            check= false;
            JOptionPane.showMessageDialog(null, "Password Empty", "Password Empty", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            System.out.println("email  empty");
            JOptionPane.showMessageDialog(null, "Email Empty", "Email Empty", JOptionPane.WARNING_MESSAGE);
            check= false;
        }

        System.out.println(username + password + email + religion);
        System.out.println("touched");
        System.out.println(gender);

        usercontrol user = new usercontrol();
        if(usercontrol.addUser(username, password, email, gender, religion, "0", "0")==false) {
            JOptionPane.showMessageDialog(null, "User Exists", "Username alocated", JOptionPane.WARNING_MESSAGE);
            check= false;
        }
    }

    public boolean verify(){
        return check;
    }




    //login
    public verification(String username, String password){
        System.out.println(username+"//"+ password);
        usercontrol user = new usercontrol();
         check =  user.check_user(username, password);
    }

}
