import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {

    public static void main(String[] args)
    {
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

    public static int color = 0;

    public Color getColor(int i){
        switch (i){
            case 1:
                return new Color(255, 255, 255);
            case 2:
                return new Color(255, 255, 0);
            case 3:
                return new Color(255, 0, 255);
            case 4:
                return new Color(0, 255, 255);
            case 5:
                return new Color(155, 150, 255);
        }

        return new Color(0, 150, 255);
    }

    MyPanel()
    {
        setPreferredSize(new Dimension(400,400));
        JButton button = new JButton("Button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setBackground(getColor(color));
                if(color == 5){
                    color = 0;
                }else{
                    color += 1;
                }
            }
        });
        add(button);
    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

    }
}