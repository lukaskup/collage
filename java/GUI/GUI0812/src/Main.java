import java.awt.*;
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

class MyPanel
        extends JPanel {

    MyPanel()
    {
        setPreferredSize(new Dimension(600,600));
    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        g.setColor(new Color(255, 0 ,0));
        g.fillOval(150, 150, 300, 300);

        g.setColor(new Color(255, 255 ,255));

        g.fillArc(170, 170, 260, 260, 0, 180);

    }
}