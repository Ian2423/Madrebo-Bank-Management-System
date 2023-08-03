package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
        JLabel additionalDetails, name, dob, email, cemail, marital, address, city, state, pin;
        JTextField pan, aadhar;
        JRadioButton syes, sno, eyes, eno;
        JButton next;
        JComboBox religion, category, income, occupation, education;
        String formno;
        

    SignupTwo(String formno) { 
        this.formno = formno;
        setLayout (null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        additionalDetails = new JLabel("Page 2: Additional details");
        additionalDetails.setBounds(270, 80, 400, 30);
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add (additionalDetails);

        name = new JLabel("Religion");
        name.setBounds(70, 140, 100, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        add (name);

        String valReligion[] = {"Chrisitan", "Hindu", "Sikh", "Muslim","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        dob = new JLabel("Income:");
        dob.setBounds(70, 190, 200, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        add (dob);
        
        String incomecategory[] = {"Null", "<1,500,000", "<2,500,000", "<5,000,000", "Upto 10,000,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        email = new JLabel("Qualification:");
        email.setBounds(100, 315, 100, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        add (email);
        
        String educationValues[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        marital = new JLabel("Occupation:");
        marital.setBounds(70, 340, 200, 30);
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        add (marital);
        
        String occupationValues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        address = new JLabel("PAN Number:");
        address.setBounds(70, 390, 200, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        add (address);

        pan = new JTextField();
        pan.setFont (new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300,390,400,30);
        add(pan);



        city = new JLabel("Aadhar Number:");
        city.setBounds(100, 490, 200, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        add (city);

        aadhar = new JTextField();
        aadhar.setFont (new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        state = new JLabel("Senior Citizen:");
        state.setBounds(70, 490, 400, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        add (state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);

        pin = new JLabel("Existing Account:");
        pin.setBounds(70, 540, 400, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        add (pin);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(300, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,600,80,30);
        next.addActionListener(this);
        add(next);  
         


        getContentPane().setBackground(Color.WHITE);

        setSize (850,800);
        setLocation(350,0);
        setVisible(true);

    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected())
        {
            seniorcitizen = "Yes";
        }
        else if (sno.isSelected())
        {
            seniorcitizen = "No";
        }
        
        String existingaccount = null;
        if (eyes.isSelected())
        {
            existingaccount = "Yes";
        }
        else if (eno.isSelected())
        {
            existingaccount = "No";
        }
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
                c.s.executeUpdate(query);
                
                //Signup3 Object
            } catch (Exception e) {
            System.out.println(e);     
        }
        
    }





    public static void main (String [] args)
    {
        new SignupTwo("");

    }



}


