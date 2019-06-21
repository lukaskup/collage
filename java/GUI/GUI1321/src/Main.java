import java.time.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Main {

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

        jf.setLocation(50, 50);

        jf.setResizable(true);

        jf.setLayout(new BorderLayout());

        model mod = new model();
        jf.setTitle("Capitals");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocation(1000, 400);
        jf.setSize(new Dimension(400, 400));

        JList lista = new JList(mod);
        JTextField pole = new JTextField();
        pole.setSize(new Dimension(400, 30));
        jf.add(pole, BorderLayout.PAGE_START);
        jf.add(new JScrollPane(lista), BorderLayout.CENTER);
        jf.setVisible(true);


        lista.addMouseListener(
                new MouseAdapter() {

                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if (e.getClickCount() == 2)
                            mod.delete_element(lista.locationToIndex(e.getPoint()));
                    }
                }
        );


        pole.addActionListener(
                (ActionEvent e) ->
                {
                    mod.add_element(pole.getText());
                    pole.setText("");

                }
        );
    }
}

class model extends AbstractListModel<String>
{

    public ArrayList<String> lista = new ArrayList<>();

    public void add_element(String s)
    {
        lista.add(s);
        fireContentsChanged(this, 0, lista.size());
        lista.sort(String::compareTo);
    }

    public int getSize() {
        return lista.size();
    }

    public String getElementAt(int index) {
        return lista.get(index);
    }

    public void delete_element(int s)
    {
        lista.remove(s);
        fireContentsChanged(this, 0, lista.size());
        lista.sort(String::compareTo);
    }
}