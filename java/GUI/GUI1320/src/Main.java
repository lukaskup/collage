import java.time.*;
import java.util.Locale;
import java.time.format.TextStyle;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListDataListener;

class Main {

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
        jf.setPreferredSize(new Dimension(250, 300));
        jf.setTitle((LocalDate.now().toString()));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocation(50,50);
        jf.setResizable(true);
        MyPanel p = new MyPanel();

        JList lista = new JList(new DayModel());
        JScrollPane scroll = new JScrollPane(lista);
        jf.add(scroll);

        jf.pack();

        jf.setVisible(true);
    }
}

class MyPanel extends JPanel {

    MyPanel()
    {
        setPreferredSize(new Dimension(400,400));
    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
}

class DayModel implements ListModel<String>
{

    public int getSize() {
        return (YearMonth.of(LocalDate.now().getYear(), LocalDate.now().getMonth())).lengthOfMonth();
    }

    public String getElementAt(int index) {
        return (index+1) + " - " + LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), index+1).getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("PL"));
    }

    public void addListDataListener(ListDataListener l) {

    }

    public void removeListDataListener(ListDataListener l) {

    }
}