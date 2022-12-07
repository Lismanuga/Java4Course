import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exit_window extends Component {

    JButton buttonClose, buttonConfirm;

    public void run() {
        JFrame window = createWindow();
        window.setVisible(true);
    }

    private JFrame createWindow() {
        JFrame frame = new JFrame("Exit Window");
        frame.getContentPane().add(createPanel());
        frame.pack();
        frame.setSize(220, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridBagLayout());


        // JButton buttonClose, buttonConfirm;
        buttonConfirm = new JButton("Підтвердити");
        buttonConfirm.setBounds(20, 20, 160, 35);
        buttonConfirm.setBackground(Color.green);
        buttonConfirm.setForeground(Color.black);
        buttonConfirm.setFont(new Font("Serif", Font.BOLD, 18));
        buttonConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        panel.add(buttonConfirm);

        buttonClose = new JButton("Скасувати");
        buttonClose.setBounds(20, 60, 160, 35);
        buttonClose.setBackground(Color.red);
        buttonClose.setForeground(Color.black);
        buttonClose.setFont(new Font("Serif", Font.BOLD, 18));
        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        panel.add(buttonClose);

        panel.setLayout(null);
        panel.setVisible(true);
        return panel;
    }
}
