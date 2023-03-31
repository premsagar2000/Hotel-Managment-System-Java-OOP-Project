/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Prem Sagar
 */





import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;

class CustomerInfo{
    String name ,phoneNo,CNIC,city,country,Days;

    public CustomerInfo(String name ,String phoneNo,String CNIC,String city,String country,String Days ){
        this.name = name;
        this.phoneNo = phoneNo;
        this.CNIC = CNIC;
        this.city = city;
        this.country = country;
        this.Days = Days;
    }

    public String toString(){
        return "Name = "+name+"\nPhone Number = "+phoneNo+"\nCNIC No: = "+CNIC+"\nCity = "+city+"\nCountry = "+country+"\nYou have reserved this room for "+Days+" days";
    }

}



interface  Room{

    public String roomType();
    public int roomPrice(int price,int days , int extraPrice);


}

class StandardRoom implements Room{
    public String roomType(){
        return ("THANKS FOR BOOKING THE STANDARD ROOM");
    }

    public int roomPrice(int price , int days ,int extraPrice){
        return ((price*days)+extraPrice);
    }


}

class DeluxeRoom implements Room{
    public String roomType(){
        return ("THANKS FOR BOOKING THE DELUXE ROOM");
    }

    public int roomPrice(int price ,int days , int extraPrice){
        return ((price*days)+extraPrice);
    }
}

class SuitRoom implements Room{
    public String roomType(){
        return ("THANKS FOR BOOKING THE SUIT ROOM");
    }

    public int roomPrice(int price ,int days , int extraPrice){
        return ((price*days)+extraPrice);
    }
}

class QuadRoom implements Room{
    public String roomType(){
        return ("THANKS FOR BOOKING THE QUAD ROOM");
    }

    public int roomPrice(int price ,int days, int extraPrice){
        return ((price*days)+extraPrice);
    }
}





class NameException extends Exception {
    public String toString() {
        return "NameException! Enter the right name";
    }
}

class PhoneSizeException extends Exception {
    public String toString() {
        return "PhoneSizeException! Phone number must be 11 digits long!";
    }
}

class PhoneException extends Exception {
    public String toString() {
        return "PhoneException! Phone number is invalid";
    }
}

class CNICSizeException extends Exception{
    public String toString() {
        return "CNICSizeExcepion! CNIC size must be 13 digits ";
    }
}
class CNICException extends Exception {
    public String toString() {
        return "CNICExcepion! CNIC No: is invalid";
    }
}

class EmptyFieldsException extends Exception {
    public String toString() {
        return "Please fill all the required fields!";
    }
}

class LastNameException extends Exception{
    public String toString() {
        return "LastNameException! LastName is invalid";
    }
}

class CountryNameException extends Exception{
    public String toString() {
        return "CountryNameException! CountryName is invalid";
    }
}

class CityNameException extends Exception{
    public String toString() {
        return "CityNameException! CityName is invalid ";
    }
}

class DaysSizeException extends Exception{
    public String toString(){
        return "DaysSizeException! Numbere of days are exceeding the range";
    }
}


class DaysException extends Exception{
    public String toString(){
        return "DaysException! Days are invalid, They can not equal to 0";
    }

}

class PasswordSizeException extends Exception{
    public String toString(){
        return "PasswordSizeException! Password must have 8 characters";
    }

}

class PasswordException extends Exception{
    public String toString(){
        return "Incorrect Password! The password you entered is incorrect. Please try again";
    }

}




class showRecord extends JFrame{
   showRecord() throws Exception{

       setSize(400, 400);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JTabbedPane pane = new JTabbedPane();
       pane.add("Show Records", new ShowData());
       add(pane);

       setVisible(true);
   }

}


class UnBookingFrame extends JFrame{

    UnBookingFrame CurrentFrame = this;
    JTextField tfN, tfL, tfC;
    JLabel labelN, labelL, labelC;
    JButton bSubmit = new JButton("SUBMIT");
    JButton bBack = new JButton("BACK");
    String name ,CNIC,lastName;
    public UnBookingFrame(){


        //Starting
        //Font
          Font f = new Font("Serif",Font.BOLD,36);

        //heading
        JPanel heading;
        heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));

        heading.setBounds(0,0,1270,100);
        JLabel title = new JLabel("WELCOME TO INDUS HOTEL");
        title.setForeground(Color.WHITE);

        title.setFont(f);
        heading.add(title);

        //Image
        setSize(1280,750);
        setLayout(null);

        ImageIcon background_img = new ImageIcon("C:\\Jar file\\MainFrame\\src\\images\\Unbooking.jpg");
        Image img = background_img.getImage();
        Image  temp_img = img.getScaledInstance(1280,750,Image.SCALE_SMOOTH);
        background_img = new ImageIcon(temp_img);
        JLabel background = new JLabel("",background_img,JLabel.CENTER);
        background.setBounds(0,0,1280,750);
        background.add(heading);
        add(background);
        setVisible(true);


        //This is end



        setLayout(null);
        bBack.addActionListener(new UnBookingFrame.ListenToButton());
        bSubmit.addActionListener(new UnBookingFrame.ListenToButton());

        labelN = new JLabel("NAME");
        labelL = new JLabel("LAST NAME");
        labelC = new JLabel("CNIC NO");
        tfN = new JTextField(20);
        tfL = new JTextField(20);
        tfC = new JTextField(20);




        labelN.setBounds(470, 280, 70, 70);
        labelL.setBounds(470, 350, 120, 120);
        labelC.setBounds(470, 475, 90, 70);
        bSubmit.setBounds(750, 620, 100, 50);
        bSubmit.setBackground(Color.WHITE);
        bBack.setBounds(600, 620, 100, 50);
        bBack.setBackground(Color.WHITE);
        tfN.setBounds(620, 300, 250, 30);
        tfL.setBounds(620, 400, 250, 30);
        tfC.setBounds(620, 500, 250, 30);

        bSubmit.setFont(new Font("Aerial", Font.BOLD, 15));
        bBack.setFont(new Font("Aerial", Font.BOLD, 15));
        labelN.setFont(new Font("Aerial", Font.BOLD, 19));
        labelL.setFont(new Font("Aerial", Font.BOLD, 19));
        labelC.setFont(new Font("Aerial", Font.BOLD, 19));
        tfN.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfL.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfC.setFont(new Font("Aerial", Font.PLAIN, 15));
        background.add(tfN);
        background.add(tfL);
        background.add(tfC);
        background.add(bSubmit);
        background.add(bBack);
        background.add(labelN);
        background.add(labelL);
        background.add(labelC);


        setSize(1280, 950);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //addWindowListener(new MyWindow());


    }

    private class ListenToButton implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==bBack){
                CurrentFrame.setVisible(false);
                new BookingFrame().setVisible(true);
            }

            else{
                try{
                    name = tfN.getText();
                    lastName = tfL.getText();
                    CNIC = tfC.getText();

                    if(name.length()==0 || lastName.length()==0 || CNIC.length()==0){
                        throw new EmptyFieldsException();
                    }

                    for(int i=0 ;i<name.length();i++){
                        if((name.charAt(i)<'A' || name.charAt(i)>'Z') && (name.charAt(i)<'a' || name.charAt(i)>'z')){
                            throw new NameException();
                        }
                    }

                    for(int i=0 ;i<lastName.length();i++){
                        if((lastName.charAt(i)<'A' || lastName.charAt(i)>'Z') && (lastName.charAt(i)<'a' || lastName.charAt(i)>'z')){
                            throw new LastNameException();
                        }
                    }

                    if (CNIC.length() != 13) throw new CNICSizeException();
                    for (int i = 0; i < CNIC.length(); i++)
                        if (CNIC.charAt(i) < '0' || CNIC.charAt(i) > '9')
                            throw new CNICException();





                    try {
                        boolean exists = false;
                        String url = "jdbc:mysql://localhost:3306/hotel?characterEncoding=latin1&useConfigs=maxPerformance";
                        String uname = "root";
                        String pass = "root123";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection(url, uname, pass);
                        Statement statement = con.createStatement();
                        String name = tfN.getText();
                        name =  "\"" + name + "\"";

                        String lname = tfL.getText();
                        lname =  "\"" + lname + "\"";

                        String CNIC = tfC.getText();
                        CNIC =  "\"" + CNIC + "\"";
                        ResultSet rs = statement.executeQuery("select * from customer");

                        while(rs.next())
                            if(tfC.getText().equals(rs.getString("CNIC")) && tfN.getText().equals(rs.getString("name"))
                                    && tfL.getText().equals(rs.getString("lastname"))) {
                            exists = true;
                            break;
                        }

			             if(exists) {
                            String Q = "delete from customer where name="+name+" And lastname="+lname+" And CNIC="+CNIC+";";
                            statement.executeUpdate(Q);
                            con.close();
			             }
			             else
                            JOptionPane.showMessageDialog(null, "Customer doesn't exist");

                    } catch (Exception ee) {
                        System.out.println(ee);
                    }

                }

                catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }

            }

        }
    }

}




class LoginFrame2 extends JFrame{

            LoginFrame2 currentFrame = this;
            JButton loginButton = new JButton("Click to Login");
            JLabel username = new JLabel("ENTER USERNAME");
            JTextField usernameTF = new JTextField();
            JLabel password = new JLabel("ENTER PASSWORD");
            JPasswordField passwordTF = new JPasswordField(8);

            String name, pass;

        LoginFrame2(){

            //Login Frame
            JPanel login = new JPanel();
            login.setSize(640,475);
            login.setLayout(null);
            login.setBackground(new Color(0,0,0,80));
            login.setBounds(300,175,640,475);


            username.setBounds(70,115,150,40);
            username.setFont(new Font("Serif", Font.BOLD, 15));
            usernameTF.setBounds(240,120,300,30);

            usernameTF.setBackground(Color.LIGHT_GRAY);
            usernameTF.setFont(new Font("Serif", Font.PLAIN, 15));

            password.setBounds(70,200,150,40);

            password.setFont(new Font("Serif", Font.BOLD, 15));
            passwordTF.setBounds(240,200,300,30);

            passwordTF.setBackground(Color.LIGHT_GRAY);

            passwordTF.setFont(new Font("Serif", Font.PLAIN, 15));
            loginButton.setBounds(250,300,140,50);
            loginButton.setBackground(new Color(160,182,45));
            loginButton.setForeground(Color.WHITE);
            loginButton.setFont(new Font("Serif", Font.PLAIN, 15));

            login.add(username);
            login.add(usernameTF);
            login.add(password);
            login.add(passwordTF);
            login.add(loginButton);
            //Starting
            //Font
            Font f = new Font("Serif",Font.BOLD,36);

            //heading
            JPanel heading;
            heading = new JPanel();
            heading.setBackground(new Color(0,0,0,80));

            heading.setBounds(0,0,1270,100);
            JLabel title = new JLabel("WELCOME TO INDUS HOTEL");
            title.setForeground(Color.WHITE);
            title.setFont(f);
            heading.add(title);

            //Image
            setSize(1280,750);
            setLayout(null);

            ImageIcon background_img = new ImageIcon("C:\\Jar file\\MainFrame\\src\\images\\FirstLoginFrame.jpg");
            Image img = background_img.getImage();
            Image  temp_img = img.getScaledInstance(1280,750,Image.SCALE_SMOOTH);
            background_img = new ImageIcon(temp_img);
            JLabel background = new JLabel("",background_img,JLabel.CENTER);
            background.setBounds(0,0,1280,750);
            background.add(heading);

            background.add(login);

            add(background);
            loginButton.addActionListener(new ListenToButton());
            setVisible(true);

            //This is end

            setSize(1280,950);
            setLayout(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);



        }


        private class ListenToButton implements ActionListener{

            public void actionPerformed(ActionEvent e){

                   if(e.getSource() == loginButton){

                        try{
                             name = usernameTF.getText();
                             pass = passwordTF.getText();


                            if(name.length()==0 || pass.length()==0){
                                throw new EmptyFieldsException();
                            }

                            for (int i=0 ; i<name.length() ;i++){
                                if ((name.charAt(i) < 'A' || name.charAt(i) > 'Z') && (name.charAt(i) < 'a' || name.charAt(i) > 'z') && name.charAt(i) != ' ')
                                    throw new NameException();

                                }

                                if(pass.length()==8){
                                        JOptionPane.showMessageDialog(null,"WELCOME TO INDUS HOTEL");
                                        currentFrame.setVisible(false);
                                        new MainFrame().setVisible(true);
                                }
                                else{
                                    throw new PasswordSizeException();
                                }

                            }
                            catch(Exception ee){
                                JOptionPane.showMessageDialog(null , ee);
                            }
                    }

            }
        }
}




class LoginFrame extends JFrame{
    LoginFrame currentFrame =this;
    JButton bLogin = new JButton("LOGIN");
    JButton bBack = new JButton("BACK");
    JTextField tfName = new JTextField(20);
    final JPasswordField tfPassword = new JPasswordField(20);
    JLabel lName ,lPassword;
    String password = "password",name,pass;
    public LoginFrame() throws Exception{


        //Starting
        //Font
          Font f = new Font("Serif",Font.BOLD,36);

        //heading
        JPanel heading;
        heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));

        heading.setBounds(0,0,1270,100);
        JLabel title = new JLabel("WELCOME TO INDUS HOTEL");
        title.setForeground(Color.WHITE);

        title.setFont(f);
        heading.add(title);

        //Image
        setSize(1280,750);
        setLayout(null);

        ImageIcon background_img = new ImageIcon("C:\\Jar file\\MainFrame\\src\\images\\Login2.jpg");
        Image img = background_img.getImage();
        Image  temp_img = img.getScaledInstance(1280,750,Image.SCALE_SMOOTH);
        background_img = new ImageIcon(temp_img);
        JLabel background = new JLabel("",background_img,JLabel.CENTER);
        background.setBounds(0,0,1280,750);
        background.add(heading);
        add(background);
        setVisible(true);


        //This is end

        setLayout(null);

        lName = new JLabel("NAME");
        lPassword = new JLabel("PASSWORD");
        tfName.setBounds(400, 300, 250, 30);
        tfPassword.setBounds(400, 400, 250, 30);
        tfName.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfPassword.setFont(new Font("Aerial", Font.PLAIN, 15));




        lName.setBounds(280, 278, 90, 70);
        lPassword.setBounds(240, 357, 150, 120);
        lName.setFont(new Font("Aerial", Font.BOLD, 19));
        lPassword.setFont(new Font("Aerial", Font.BOLD, 19));

        bBack.setFont(new Font("Aerial", Font.BOLD, 15));
        bLogin.setFont(new Font("Aerial", Font.BOLD, 15));

        bLogin.setBounds(650, 550, 100, 50);
        bLogin.setBackground(Color.WHITE);
        bBack.setBounds(800, 550, 100, 50);
        bBack.setBackground(Color.WHITE);
        bBack.addActionListener(new ListenToButton());
        bLogin.addActionListener(new ListenToButton());


        background.add(tfName);
        background.add(tfPassword);
        background.add(lName);
        background.add(lPassword);
        background.add(bLogin);
        background.add(bBack);
        setSize(1280, 950);
        setVisible(true);
        setLocationRelativeTo(null);
        //addWindowListener(new MyWindow());
        setDefaultCloseOperation(EXIT_ON_CLOSE);






    }
    private class ListenToButton implements ActionListener{

        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==bBack){
                currentFrame.setVisible(false);
                new MainFrame().setVisible(true);
            }

            else {
                try{
                    name = tfName.getText();
                    pass = tfPassword.getText();
                    String check = tfPassword.getText();
                    if(name.length()==0 || pass.length()==0){
                        throw new EmptyFieldsException();
                    }
                    for (int i=0 ; i<name.length() ;i++){
                        if ((name.charAt(i) < 'A' || name.charAt(i) > 'Z') && (name.charAt(i) < 'a' || name.charAt(i) > 'z') && name.charAt(i) != ' ')
                            throw new NameException();

                    }
                    if(pass.length()==8){
                        if(check.equals(password)){
                            JOptionPane.showMessageDialog(null,"Hello Admin!");
                            currentFrame.setVisible(false);
                            new showRecord().setVisible(true);
                        }

                        else   throw new PasswordException();//JOptionPane.showMessageDialog(null,"SORRY! You don not have authorization "+);
                    }
                    else{
                        throw new PasswordSizeException();

                    }

                   // new showRecord();

                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null , e);
                }

            }

        }

    }
}





class MenuFrame extends JFrame {

    MenuFrame CurrentFrame = this;
    TextField tfN, tfL, tfC, tfP, tfCity, tfCountry,tfDays;
    JLabel labelN, labelL, labelC, labelDays,labelP, labelCity, labelCountry, labelCombo;
    JButton bSubmit = new JButton("SUBMIT");
    JButton bBack = new JButton("BACK");
    JComboBox combo ,combo1;
    String name, lastName, CNIC, Phone, City, Country,Days;
    String items[] = {"StandardRoom", "Deluxe Rooms", "Suit Rooms", "Quad Rooms"};
    int price =0 , number_of_days=0;

    MenuFrame() {



        //Starting
        //Font
          Font f = new Font("Serif",Font.BOLD,36);

        //heading
        JPanel heading;
        heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));

        heading.setBounds(0,0,1270,100);
        JLabel title = new JLabel("WELCOME TO INDUS HOTEL");
        title.setForeground(Color.WHITE);

        title.setFont(f);
        heading.add(title);

        //Image
        setSize(1280,750);
        setLayout(null);

        ImageIcon background_img = new ImageIcon("C:\\Jar file\\MainFrame\\src\\images\\Info3.jpg");
        Image img = background_img.getImage();
        Image  temp_img = img.getScaledInstance(1280,750,Image.SCALE_SMOOTH);
        background_img = new ImageIcon(temp_img);
        JLabel background = new JLabel("",background_img,JLabel.CENTER);
        background.setBounds(0,0,1280,750);
        background.add(heading);
        add(background);
        setVisible(true);


        //This is end









        setLayout(null);
        bBack.addActionListener(new ListenToButton());
        bSubmit.addActionListener(new ListenToButton());

        labelN = new JLabel("NAME");
        labelL = new JLabel("LAST NAME");
        labelC = new JLabel("CNIC No");
        labelP = new JLabel("PHONE NO");
        labelCity = new JLabel("CITY");
        labelCountry = new JLabel("COUNTRY");
        labelCombo = new JLabel("Room Option");
        labelDays = new JLabel("Days");


        labelN.setBounds(150, 175, 90, 70);
        labelL.setBounds(650, 150, 150, 120);
        labelC.setBounds(150, 280, 90, 70);
        labelP.setBounds(650, 260, 110, 110);
        labelCity.setBounds(150, 380, 70, 70);
        labelCombo.setBounds(150, 455, 130, 130);
        labelCountry.setBounds(650, 360, 120, 120);
        labelDays.setBounds(660,485,70,70);

        labelN.setFont(new Font("Aerial", Font.BOLD, 19));
        labelL.setFont(new Font("Aerial", Font.BOLD, 19));
        labelC.setFont(new Font("Aerial", Font.BOLD, 19));
        labelP.setFont(new Font("Aerial", Font.BOLD, 19));
        labelCity.setFont(new Font("Aerial", Font.BOLD, 19));
        labelCombo.setFont(new Font("Aerial", Font.BOLD, 19));
        labelCountry.setFont(new Font("Aerial", Font.BOLD, 19));
        labelDays.setFont(new Font("Aerial", Font.BOLD, 19));

        bSubmit.setBounds(800, 620, 100, 50);
        bSubmit.setBackground(Color.WHITE);
        bBack.setBounds(650, 620, 100, 50);
        bBack.setBackground(Color.WHITE);
        bSubmit.setFont(new Font("Aerial", Font.BOLD, 15));
        bBack.setFont(new Font("Aerial", Font.BOLD, 15));

        tfN = new TextField(20);
        tfL = new TextField(20);
        tfC = new TextField(20);
        tfP = new TextField(20);
        tfCity = new TextField(20);
        tfCountry = new TextField(20);
        tfDays = new TextField(20);

        tfN.setBounds(300, 200, 250, 30);
        tfL.setBounds(850, 200, 250, 30);
        tfC.setBounds(300, 300, 250, 30);
        tfP.setBounds(850, 300, 250, 30);
        tfCity.setBounds(300, 400, 250, 30);
        tfCountry.setBounds(850, 400, 250, 30);
        tfDays.setBounds(850,500,250,30);

        tfN.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfL.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfC.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfP.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfCity.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfCountry.setFont(new Font("Aerial", Font.PLAIN, 15));
        tfDays.setFont(new Font("Aerial", Font.PLAIN, 15));

        background.add(tfN);
        background.add(tfL);
        background.add(tfC);
        background.add(tfP);
        background.add(tfCity);
        background.add(tfCountry);
        background.add(tfDays);
        background.add(labelN);
        background.add(labelL);
        background.add(labelC);
        background.add(labelP);
        background.add(labelCity);
        background.add(labelCountry);
        background.add(labelCombo);
        background.add(labelDays);
        combo = new JComboBox();
        background.add(combo);
        combo.addItem("Choose Rooms");
        combo.addItem("Standard Room");
        combo.addItem("Deluxe Room");
        combo.addItem("Suit Room");
        combo.addItem("Quad Room");

        combo.setLayout(null);
        combo.setBounds(300, 500, 250, 30);
        combo.addItemListener(new RoomOption());

        background.add(bSubmit);
        background.add(bBack);
        setSize(1280, 950);
        setVisible(true);
        setLocationRelativeTo(null);


        bSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private class ListenToButton implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == bBack) {
                CurrentFrame.setVisible(false);
                new BookingFrame().setVisible(true);

            }
            else if(ae.getSource() == bSubmit) {
                try {
                    name = tfN.getText();
                    lastName = tfL.getText();
                    CNIC = tfC.getText();
                    Phone = tfP.getText();
                    City = tfCity.getText();
                    Country = tfCountry.getText();
                    Days = tfDays.getText();
                    if (name.length() == 0 || lastName.length() == 0 || CNIC.length() == 0 || Phone.length() == 0 || City.length() == 0 || Country.length() == 0 || Days.length()== 0)
                        throw new EmptyFieldsException();

                    for (int i = 0; i < name.length(); i++)
                        if ((name.charAt(i) < 'A' || name.charAt(i) > 'Z') && (name.charAt(i) < 'a' || name.charAt(i) > 'z'))
                            throw new NameException();

                    for (int i = 0; i < lastName.length(); i++)
                        if ((lastName.charAt(i) < 'A' || lastName.charAt(i) > 'Z') && (lastName.charAt(i) < 'a' || lastName.charAt(i) > 'z'))
                            throw new LastNameException(); // throw LastName exception here.

                    if (CNIC.length() != 13) throw new CNICSizeException();
                    for (int i = 0; i < CNIC.length(); i++)
                        if (CNIC.charAt(i) < '0' || CNIC.charAt(i) > '9')
                            throw new CNICException();

                    if (Phone.length() != 11) throw new PhoneSizeException();
                    for (int i = 0; i < Phone.length(); i++)
                        if (Phone.charAt(i) < '0' || Phone.charAt(i) > '9')
                            throw new PhoneException();

                    for (int i = 0; i < City.length(); i++)
                        if ((City.charAt(i) < 'A' || City.charAt(i) > 'Z') && (City.charAt(i) < 'a' || City.charAt(i) > 'z') && City.charAt(i) != ' ')
                            throw new CityNameException(); // throw CityName exception here

                    for (int i = 0; i < Country.length(); i++)
                        if ((Country.charAt(i) < 'A' || Country.charAt(i) > 'Z') && (Country.charAt(i) < 'a' || Country.charAt(i) > 'z'))
                            throw new CountryNameException(); // throw CountryName exception here

                    for (int i=0 ;i<Days.length() ;i++){
                        if(Days.charAt(i)<'0' || Days.charAt(i)>'9' || Days.charAt(0)=='0')
                            throw new DaysException();

                    }

                    number_of_days = Integer.parseInt(tfDays.getText());

                    if(number_of_days>365) throw new DaysSizeException();

                    if(combo.getSelectedItem().toString().equals("Standard Room")){
                        JOptionPane.showMessageDialog(null,new CustomerInfo(name,Phone,CNIC,City,Country,Days)+ "\n"+""+new StandardRoom().roomType()+"\nTotal price of room for "+number_of_days+" days is = "+new StandardRoom().roomPrice(price,number_of_days,0));
                    }

                    else if(combo.getSelectedItem().toString().equals("Deluxe Room")){
                        JOptionPane.showMessageDialog(null,new CustomerInfo(name,Phone,CNIC,City,Country,Days)+ "\n"+""+new DeluxeRoom().roomType()+"\nTotal price of room for "+number_of_days+" days is = "+new DeluxeRoom().roomPrice(price,number_of_days,0));
                    }

                    else if(combo.getSelectedItem().toString().equals("Suit Room")){
                        JOptionPane.showMessageDialog(null,new CustomerInfo(name,Phone,CNIC,City,Country,Days)+ "\n"+""+new SuitRoom().roomType()+"\nTotal price of room for "+number_of_days+" days is = "+new SuitRoom().roomPrice(price,number_of_days,0));
                    }

                    else if(combo.getSelectedItem().toString().equals("Quad Room")){
                        JOptionPane.showMessageDialog(null,new CustomerInfo(name,Phone,CNIC,City,Country,Days)+ "\n"+""+new QuadRoom().roomType()+"\nTotal price of room for "+number_of_days+" days is = "+new QuadRoom().roomPrice(price,number_of_days,0));
                    }

                    else{
                        JOptionPane.showMessageDialog(null,"SORRY! you did not choose any room");
                    }





                    try {
                        String url = "jdbc:mysql://localhost:3306/hotel?characterEncoding=latin1&useConfigs=maxPerformance";
                        String uname = "root";
                        String pass = "root123";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection(url, uname, pass);

                        String query1 = "insert into customer values (?,?,?,?,?,?,?)";
                        PreparedStatement statement1 = con.prepareStatement(query1);


                        statement1.setString(1, tfN.getText());
                        statement1.setString(2, tfL.getText());
                        statement1.setString(3, tfC.getText());
                        statement1.setString(4, tfP.getText());
                        statement1.setString(5, tfCity.getText());
                        statement1.setString(6, tfCountry.getText());
                        statement1.setInt(7, Integer.parseInt(tfDays.getText()));
                        int i = statement1.executeUpdate();
                        if (i > 0) {
                            System.out.println("Record Added");

                        }

                        con.close();
                    } catch (Exception ee) {
                        System.out.println(ee);
                    }


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }
        }
    }
    private class RoomOption implements ItemListener {

        public void itemStateChanged(ItemEvent ie) {
            if(ie.getStateChange()==ItemEvent.SELECTED){
                if (combo.getSelectedItem().toString().equals("Standard Room")) {
                    price =1500;
                    JOptionPane.showMessageDialog(null, "1...419 sq feet\n2...Cheapest Room \n3...Breakfast for 1 person\n4...No AirConditioner\n5...Twins Bed\n6...Price for one day is 1500");
                } else if (combo.getSelectedItem().toString().equals("Deluxe Room")) {
                    price = 2500;
                    JOptionPane.showMessageDialog(null, "1...900 sq feet with Balcony\n2...Breakfast for all person\n3...Juice and Gift packs\n4...Built in Netflix account\n5...Twins Bed\n6...1 AirConditioner\n7...Price for one day is 2500");
                } else if (combo.getSelectedItem().toString().equals("Suit Room")) {
                    price  = 3500;
                    JOptionPane.showMessageDialog(null, "1...900 sq feet with balcony and Living Room\n2...Gifts and Juices\n3...Built in Netflix\n4...2 AirConditioner\n5...Price for one day is 3500");
                } else if (combo.getSelectedItem().toString().equals("Quad Room")){
                    price = 4500;
                    JOptionPane.showMessageDialog(null, "1...1500sq feet\n2...A single Bed\n3...all facilities available\n4...2 AirConditioner\n5...Price for one day is 4500");
                }

            }
        }

    }
}

class BookingFrame extends JFrame {

    private JButton bR = new JButton("Booking Room");
    private JButton bD = new JButton("Cancel Booking");
    private JButton goToMain = new JButton("<Back");
    private BookingFrame currentFrame = this;

    BookingFrame() {

        //Starting
        //Font
          Font f = new Font("Serif",Font.BOLD,36);

        //heading
        JPanel heading;
        heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));

        heading.setBounds(0,0,1270,100);
        JLabel title = new JLabel("WELCOME TO INDUS HOTEL");
        title.setForeground(Color.WHITE);
        title.setFont(f);
        heading.add(title);

        //Image
        setSize(1280,750);
        setLayout(null);

        ImageIcon background_img = new ImageIcon("C:\\Jar file\\MainFrame\\src\\images\\MainFrame.jpg");
        Image img = background_img.getImage();
        Image  temp_img = img.getScaledInstance(1280,750,Image.SCALE_SMOOTH);
        background_img = new ImageIcon(temp_img);
        JLabel background = new JLabel("",background_img,JLabel.CENTER);
        background.setBounds(0,0,1280,750);
        background.add(heading);
        add(background);
        setVisible(true);


        //This is end


        setLayout(null);
        bD.addActionListener(new ListenToButton());
        bR.addActionListener(new ListenToButton());
        goToMain.addActionListener(new ListenToButton());
        //addWindowListener(new MyWindow());

        bR.setFont(new Font("Aerial", Font.BOLD, 18));
        bR.setBackground(Color.WHITE);
        bD.setFont(new Font("Aerial", Font.BOLD, 18));
        bD.setBackground(Color.WHITE);
        goToMain.setFont(new Font("Aerial", Font.ITALIC, 16));
        goToMain.setBackground(Color.WHITE);
        bD.setBounds(660, 350, 180, 80);
        background.add(bD);
        bR.setBounds(440, 350, 180, 80);
        background.add(bR);
        goToMain.setBounds(60, 600, 100, 20);
        background.add(goToMain);

        setSize(1280, 850);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private class ListenToButton implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == goToMain) {
                currentFrame.setVisible(false);
                new MainFrame().setVisible(true);
            } else if (ae.getSource() == bR) {
                new MenuFrame();
            } else {
                new UnBookingFrame();
            }
        }
    }

}

class MainFrame extends JFrame {

    private JButton bC = new JButton("CUSTOMER");
    private JButton bA = new JButton("ADMINISTRATOR");
    private MainFrame currentFrame = this;

    public MainFrame() {


        //Starting
        //Font
          Font f = new Font("Serif",Font.BOLD,36);

        //heading
        JPanel heading;
        heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));

        heading.setBounds(0,0,1270,100);
        JLabel title = new JLabel("WELCOME TO INDUS HOTEL");
        title.setForeground(Color.WHITE);

        title.setFont(f);
        heading.add(title);

        //Image
        setSize(1280,750);
        setLayout(null);

        ImageIcon background_img = new ImageIcon("C:\\Jar file\\MainFrame\\src\\images\\MainFrame2.jpg");
        Image img = background_img.getImage();
        Image  temp_img = img.getScaledInstance(1280,750,Image.SCALE_SMOOTH);
        background_img = new ImageIcon(temp_img);
        JLabel background = new JLabel("",background_img,JLabel.CENTER);
        background.setBounds(0,0,1280,750);
        background.add(heading);
        add(background);
        setVisible(true);


        //This is end




        setLayout(null);
        bC.addActionListener(new ListenToButton());
        bA.addActionListener(new ListenToButton());
        addWindowListener(new MyWindow());

        bA.setFont(new Font("Aerial", Font.BOLD, 18));
        bA.setBackground(Color.WHITE);
        bC.setFont(new Font("Aerial", Font.BOLD, 18));
        bC.setBackground(Color.WHITE);
        bA.setBounds(670, 350, 200, 80);
        background.add(bA); //Changing
        bC.setBounds(440, 350, 200, 80);
        background.add(bC);//Changing

        setSize(1280, 850);
        setLocationRelativeTo(null);


    }

    private class ListenToButton implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == bC) {
                currentFrame.setVisible(false);
                new BookingFrame();

            } else {
                currentFrame.setVisible(false);
                try {
                    new LoginFrame();
                }
                catch (Exception e){
                    System.out.println(e);
                }

            }

        }

    }

    public static void main(String arg[]) {
        //new MainFrame().setVisible(true);
         new LoginFrame2().setVisible(true);
    }

}

class MyWindow extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }

}

class ShowData extends JPanel{
    ShowData() throws Exception{
        this.setLayout(new FlowLayout());
        String[] cols= {"Name","Last Name","CNIC","Phone # ","City","Country","Date"};
        int dim = 0;
        //JButton refresh = new JButton("Refresh");
        String url = "jdbc:mysql://localhost:3306/hotel?characterEncoding=latin1&useConfigs=maxPerformance";
        String uname = "root";
        String pass = "root123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement statement = con.createStatement();
        ResultSet query = statement.executeQuery("Select * from customer");

        while (query.next()){
            ++dim;
        }
        String rec [][] = new String[dim][7];

        query = statement.executeQuery("Select * from customer");

        int index = 0;
        while (query.next()){
            rec[index][0]= query.getString(1);
            rec[index][1]= query.getString(2);
            rec[index][2]= query.getString(3);
            rec[index][3]= query.getString(4);
            rec[index][4]= query.getString(5);
            rec[index][5]= query.getString(6);

            rec[index][6]= Integer.toString(query.getInt(7));

            ++index;
        }
        JTable table = new JTable(rec , cols);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
        con.close();

    }
}



