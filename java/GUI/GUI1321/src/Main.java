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

        Model model = new Model();
        jf.setLocation(50, 50);
        jf.setSize(new Dimension(250, 300));

        JList capitals = new JList(model);
        JTextField input = new JTextField();
        input.setSize(new Dimension(250, 30));
        jf.add(input, BorderLayout.PAGE_START);
        jf.add(new JScrollPane(capitals), BorderLayout.CENTER);
        jf.setVisible(true);

        capitals.addMouseListener(
                new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        System.out.println(model.getElementAt(capitals.locationToIndex(e.getPoint())));
                        if (e.getClickCount() == 2) {
                            model.delete(capitals.locationToIndex(e.getPoint()));
                        }
                    }
                }
        );

        input.addActionListener(
                (ActionEvent e) -> {
                    String value = input.getText();
                    System.out.println(capitals.getNextMatch(value, 0, javax.swing.text.Position.Bias.Forward));
                    if(capitals.getNextMatch(value, 0, javax.swing.text.Position.Bias.Forward) == -1){
                        model.add(value);
                        input.setText("");
                    }else{
                        input.setText("value already exists!");
                    }

                }
        );
    }
}

class Model extends AbstractListModel<String>
{

    public ArrayList<String> list = new ArrayList<>();

    public void add(String s){
        list.add(s);
        fireContentsChanged(this, 0, list.size());
        list.sort(String::compareTo);
    }

    public int getSize() {
        return list.size();
    }

    public String getElementAt(int index) {
        return list.get(index);
    }

    public void delete(int s)
    {
        list.remove(s);
        fireContentsChanged(this, 0, list.size());
        list.sort(String::compareTo);
    }
}