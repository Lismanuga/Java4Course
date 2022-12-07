import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;


public class Main extends Canvas {
    static JFrame frame;

    public static String getBiggestCountryName(String sq1, String name1, String sq2, String name2, String sq3, String name3){

        HashMap<String,String> map = new HashMap<>();
        map.put(sq1,name1);
        map.put(sq2,name2);
        map.put(sq3,name3);
        int maxSquere = Integer.MIN_VALUE;
        for (String s : map.keySet()){
            if (Integer.parseInt(s) > maxSquere){
                maxSquere = Integer.parseInt(s);
            }
        }
        for (String s : map.keySet()){
            if (Integer.parseInt(s) == maxSquere){
                return map.get(s);
            }
        }
        return "";
    }

    public static void createFrame(JTextField s1,JTextField n1,JTextField s2,JTextField n2,JTextField s3,JTextField n3)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new JFrame("LABA 6");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                try
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JPanel panel = new JPanel();
                frame.setSize(300,300);
                panel.setSize(300,300);
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setOpaque(true);


                JLabel message = new JLabel("Країна з найбільшою площею: "+ getBiggestCountryName(
                        s1.getText(),n1.getText(),s2.getText(),n2.getText(),s3.getText(),n3.getText()));
                panel.add(message);


                JButton button = new JButton("Вийти");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                panel.add(button);

                frame.getContentPane().add(BorderLayout.CENTER, panel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                frame.setResizable(false);

            }
        });
    }

    public static void main(String[] args) {
        Main form = new Main();
        frame = new JFrame();
        frame.setSize(700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lab 6");
        frame.getContentPane().setBackground(Color.white);


        ImageIcon imageIcon = new ImageIcon("F:\\LabsJava4Course\\Laba6\\src\\world.png");
        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(imageIcon);
        iconLabel.setBounds(20,20,600,400);
        frame.add(iconLabel);


        JLabel sideLabel = new JLabel("Введіть назви країн та їх площу: ");
        sideLabel.setBounds(30, 390, 250, 70);
        frame.add(sideLabel);

        JTextField countryNameTextfield1 = new JTextField("Україна");
        countryNameTextfield1.setBounds(35, 460, 150, 30);
        frame.add(countryNameTextfield1);


        JTextField squereTextField1 = new JTextField("603");
        squereTextField1.setBounds(200, 460, 50, 30);
        frame.add(squereTextField1);

        JTextField countryNameTextfield2 = new JTextField("Франція");
        countryNameTextfield2.setBounds(35, 530, 150, 30);
        frame.add(countryNameTextfield2);


        JTextField squereTextField2 = new JTextField("415");
        squereTextField2.setBounds(200, 530, 50, 30);
        frame.add(squereTextField2);

        JTextField countryNameTextfield3 = new JTextField("Німеччина");
        countryNameTextfield3.setBounds(35, 600, 150, 30);
        frame.add(countryNameTextfield3);


        JTextField squereTextField3 = new JTextField("390");
        squereTextField3.setBounds(200, 600, 50, 30);
        frame.add(squereTextField3);


        JButton secondFormButton = new JButton("Продовжити");
        secondFormButton.setBounds(300, 530, 150, 30);
        secondFormButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createFrame(squereTextField1 ,countryNameTextfield1,
                        squereTextField2 ,countryNameTextfield2,
                        squereTextField3 ,countryNameTextfield3);
            }
        });
        frame.add(secondFormButton);


        JMenuBar mainMenu = new JMenuBar();
        JMenu programMenu = new JMenu("Програма");
        JMenu fileMenu = new JMenu("Правка");


        JMenuItem check = new JMenuItem("Перевірка");
        JMenuItem countSquere = new JMenuItem("Обчислити");
        JMenuItem exitProgram = new JMenuItem("Вийти");

        programMenu.add(check);
        programMenu.add(countSquere);
        programMenu.addSeparator();
        programMenu.add(exitProgram);


        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(squereTextField1.getText()) < 0 || Integer.parseInt(squereTextField2.getText()) < 0 ||
                        Integer.parseInt(squereTextField3.getText()) < 0){
                    JOptionPane.showMessageDialog(frame,"Невірно введені дані!");
                } else {
                    JOptionPane.showMessageDialog(frame,"Все ок!");
                }
            }
        });

        countSquere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFrame(squereTextField1 ,countryNameTextfield1,
                        squereTextField2 ,countryNameTextfield2,
                        squereTextField3 ,countryNameTextfield3);
            }
        });

        exitProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        JMenuItem copyMenu = new JMenuItem("Копіювати");
        JMenuItem pasteMenu = new JMenuItem("Вставити");

        fileMenu.add(copyMenu);
        fileMenu.add(pasteMenu);

        mainMenu.add(programMenu);
        mainMenu.add(fileMenu);

        frame.add(mainMenu);
        frame.setJMenuBar(mainMenu);


        JPopupMenu contextMenu = new JPopupMenu();

        JMenuItem changeMap = new JMenuItem("Україна");
        JMenuItem deleteImage = new JMenuItem("Видалити");
        JMenuItem createLabel = new JMenuItem("Я люблю Україну!");

        contextMenu.add(changeMap);
        contextMenu.add(deleteImage);
        contextMenu.add(createLabel);

        frame.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent me) {
                if (me.isPopupTrigger()) contextMenu.show(me.getComponent(), me.getX(), me.getY());
            }
        });

        changeMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon imageIcon2 = new ImageIcon("F:\\LabsJava4Course\\Laba6\\src\\ua.png");
                iconLabel.setIcon(imageIcon2);
            }
        });

        deleteImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iconLabel.setIcon(null);
            }
        });

        createLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel newLabel = new JLabel("      Я люблю Україну!");
                newLabel .setBounds(150,30,150,30);
                frame.add(newLabel);
            }
        });

        frame.add(form);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
