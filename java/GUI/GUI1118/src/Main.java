import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

import static java.lang.Math.sqrt;

public class Main{

    public static void main(String[] args){
        new Main();
    }

    public Main()
    {
        SwingUtilities.invokeLater(() -> createGUI());
    }

    protected void createGUI()
    {
        JFrame jf = new JFrame();

        jf.setTitle("Rysowanie");

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setLocation(50,50);

        jf.setResizable(false);

        MyPanel p = new MyPanel();

        jf.setContentPane(p);

        jf.pack( );

        jf.setVisible(true);
    }

}

class MyPanel extends JPanel {
    MyPanel()
    {
        setPreferredSize(new Dimension(400, 110));
        setLayout(new GridBagLayout());

        GridBagConstraints cons_label = new GridBagConstraints();
        GridBagConstraints cons_input1 = new GridBagConstraints();
        GridBagConstraints cons_input2 = new GridBagConstraints();
        GridBagConstraints cons_input3 = new GridBagConstraints();
        GridBagConstraints cons_clear = new GridBagConstraints();
        GridBagConstraints cons_solve = new GridBagConstraints();

        cons_label.fill = GridBagConstraints.HORIZONTAL;
        cons_label.ipady = 20;
        cons_label.gridwidth = 6;
        cons_label.weightx = 0.0;
        cons_label.gridx = 0;
        cons_label.gridy = 0;

        JLabel label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField input1 = new JTextField();
        cons_input1.ipady = 0;
        cons_input1.gridwidth = 1;
        cons_input1.fill = GridBagConstraints.HORIZONTAL;
        cons_input1.weightx = 0.5;
        cons_input1.gridx = 1;
        cons_input1.gridy = 1;
        input1.setToolTipText("Enter A");
        input1.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField input2 = new JTextField();
        cons_input2.fill = GridBagConstraints.HORIZONTAL;
        cons_input2.weightx = 0.5;
        cons_input1.gridwidth = 1;
        cons_input2.gridx = 2;
        cons_input2.gridy = 1;
        input2.setToolTipText("Enter B");
        input2.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField input3 = new JTextField();
        cons_input3.fill = GridBagConstraints.HORIZONTAL;
        cons_input3.weightx = 0.5;
        cons_input1.gridwidth = 1;
        cons_input3.gridx = 3;
        cons_input3.gridy = 1;
        input3.setToolTipText("Enter C");
        input3.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btn1 = new JButton("SOLVE");
        cons_solve.fill = GridBagConstraints.HORIZONTAL;
        cons_solve.weightx = 0.0;
        cons_solve.gridwidth = 6;
        cons_solve.gridx = 0;
        cons_solve.gridy = 2;
        btn1.setMnemonic(KeyEvent.VK_S);

        JButton btn2 = new JButton("CLEAR");
        cons_clear.fill = GridBagConstraints.HORIZONTAL;
        cons_clear.weightx = 0.0;
        cons_clear.gridwidth = 6;
        cons_clear.gridx = 0;
        cons_clear.gridy = 3;
        btn2.setMnemonic(KeyEvent.VK_C);

        add(label, cons_label);
        add(input1, cons_input1);
        add(input2, cons_input2);
        add(input3, cons_input3);
        add(btn1, cons_solve);
        add(btn2, cons_clear);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String labelText = solve(input1.getText(), input2.getText(), input3.getText());
                label.setText(labelText);

                if(labelText == "Not a quadratic equation!"){
                    label.setOpaque(true);
                    label.setBackground(Color.RED);
                    System.out.println("true");
                }else{
                    label.setForeground(Color.BLACK);
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input1.setText("");
                input2.setText("");
                input3.setText("");
                label.setText("");
                label.setOpaque(false);
                label.setForeground(Color.BLACK);
            }
        });
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

    public String solve(String A, String B, String C){

        if(!isInteger(A) || !isInteger(B) || !isInteger(C)) return "Number format error!";

        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        int c = Integer.parseInt(C);

        if(a==0) return "Not a quadratic equation!";

        double delta = (b*b) - (4*a*c);

        System.out.println(delta);

        if(delta<0) return "no results";

        if(delta == 0){
            double x = (-1*b)/(2*a);
            return "x = " + x;
        }else{
            double x1 = (((-1)*b) - sqrt(delta))/(2*a);
            double x2 = (((-1)*b) + sqrt(delta))/(2*a);

            return "x1 = " + x1 + ", x2 = " + x2;
        }
    }
}