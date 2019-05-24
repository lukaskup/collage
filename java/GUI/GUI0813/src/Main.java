import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static int randInt(int min, int max) {

        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        List fileLines = ReadFile.getFileContent("C:/Users/lukasz/Desktop/collage/java/GUI/GUI0813/src/plik.txt", false);

        for(int i = 0; i < fileLines.size(); i++) {

            String[] values = fileLines.get(i).toString().split(" ");
            if(values.length < 5){
                int[] drawValues = new int[values.length];
                Boolean isValid = true;
                for(int i2 = 0; i2 < values.length; i2++){
                    if(isInteger(values[i2])){
                        drawValues[i2] = Integer.parseInt(values[i2]);
                    }else{
                        isValid = false;
                    }
                }

                if(isValid){
                    g.setColor(new Color(this.randInt(0, 255), this.randInt(0, 255), this.randInt(0, 255)));

                    if(drawValues.length == 3){
                        g.drawOval(drawValues[0],drawValues[1],drawValues[2],drawValues[2]);
                    }else if(drawValues.length == 4){
                        g.drawLine(drawValues[0], drawValues[1], drawValues[2], drawValues[1]);
                        g.drawLine(drawValues[2], drawValues[1], drawValues[2], drawValues[3]);
                        g.drawLine(drawValues[2], drawValues[3], drawValues[0], drawValues[3]);
                        g.drawLine(drawValues[0], drawValues[3], drawValues[0], drawValues[1]);
                    }
                }
            }
        }
    }
}