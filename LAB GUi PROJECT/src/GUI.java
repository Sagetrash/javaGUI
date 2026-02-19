import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import database.Database;

public class GUI{
    public static void main(String[]args)
    {
        Database db = new Database();
        JFrame frame=new JFrame("Java GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5,2,10,10));

        JTextField idfield=new JTextField();
        JTextField namefield=new JTextField();
        JTextField statefield=new JTextField();
        JTextField contactfield=new JTextField();
        JButton insertBtn=new JButton("Insert");
        JButton Display=new JButton("Display");
        JPanel panel = new JPanel();
        frame.add(new JLabel("Roll No."));
        frame.add(idfield);

        frame.add(new JLabel("First Name"));
        frame.add(namefield);

        frame.add(new JLabel("Address"));
        frame.add(statefield);

        frame.add(new JLabel("Contact"));
        frame.add(contactfield);

        frame.add(new JLabel(""));
        panel.add(Display);
        panel.add(insertBtn);
        frame.add(panel);
        
        Display.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String output= db.Printtable();
                JOptionPane.showMessageDialog(frame,"Employee info entered \n "+ output);
                // System.out.println(output);
            }
        });
        insertBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                db.insert(Integer.parseInt(idfield.getText()), namefield.getText(), statefield.getText(),Integer.parseInt(contactfield.getText()));
            }
        });
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(400,200);
        frame.setVisible(true);
    }
}