import java.awt.*;
import javax.swing.*;
import java.util.Calendar;
import java.time.LocalDate;
import java.util.Locale;
import java.time.format.TextStyle;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        SwingUtilities.invokeLater(() -> createGUI());
    }

    protected void createGUI() {
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
    MyPanel() {
        setPreferredSize(new Dimension(400,400));
        JList monthList = new JList(new MonthListModel());
        monthList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(monthList);

        add(scrollPane);
    }

    class MonthListModel extends AbstractListModel {
        private String[] days;

        public MonthListModel() {
            Calendar cal = Calendar.getInstance();

            days = new String[2];
            days[0] = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("PL"));
            days[1] = "gang";
        }

        public int getSize() {
            return days.length;
        }

        public Object getElementAt(int index) {
            return days[index];
        }
    }
}