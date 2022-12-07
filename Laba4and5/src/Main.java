import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends Component {
    JButton button;
    JLabel titleLabel, nameLabel, numberLabel, gender, countryLabel;
    JRadioButton manGender, womanGender;
    JTextField nameInput, emailInput;
    JComboBox formatBox;
    JLabel iconLabel;

    private void run() {
        JFrame window = createWindow();
        window.setVisible(true);
    }

    private JFrame createWindow() {
        JFrame frame = new JFrame("UI lab");
        frame.getContentPane().add(createPanel());
        frame.pack();
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridBagLayout());


        ImageIcon iconLogo= new ImageIcon("F:\\LabsJava4Course\\Laba4and5\\src\\person.png");

        iconLabel = new JLabel();
        iconLabel.setIcon(iconLogo);
        iconLabel.setBounds(20, 20, 200, 450);
        panel.add(iconLabel);

        Color textColor = new Color(27, 106, 11, 253);

        titleLabel = new JLabel("РЕЄСТРАЦІЯ");
        titleLabel.setBounds(250, 20, 300, 40);
        titleLabel.setForeground(textColor);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(titleLabel);


        gender = new JLabel("Стать:");
        gender.setBounds(230, 110, 80, 60);
        gender.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(gender);


        manGender = new JRadioButton("чоловік");
        womanGender = new JRadioButton("жінка");
        manGender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon imageIcon2 = new ImageIcon("F:\\LabsJava4Course\\Laba4and5\\src\\person.png");
                iconLabel.setIcon(imageIcon2);
            }
        });
        womanGender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon imageIcon2 = new ImageIcon("F:\\LabsJava4Course\\Laba4and5\\src\\person2.png");
                iconLabel.setIcon(imageIcon2);
            }
        });

        manGender.setBounds(300, 120, 100, 25);
        manGender.setFont(new Font("SansSerif", Font.PLAIN, 16));
        womanGender.setBounds(300, 140, 100, 25);
        womanGender.setFont(new Font("SansSerif", Font.PLAIN, 16));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(manGender);
        buttonGroup.add(womanGender);

        panel.add(manGender);
        panel.add(womanGender);


        //Name and mobile number labels
        nameLabel = new JLabel("Ім'я:");
        nameLabel.setBounds(230, 70, 100, 30);
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        panel.add(nameLabel);

        numberLabel = new JLabel("E-mail:");
        numberLabel.setBounds(230, 170, 100, 30);
        numberLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        panel.add(numberLabel);



        nameInput = new JTextField("Богдан");
        nameInput.setBounds(300, 70, 200, 30);
        panel.add(nameInput);

        emailInput = new JTextField("lismanuga@gmail.com");
        emailInput.setBounds(300, 170, 200, 30);
        panel.add(emailInput);



        countryLabel = new JLabel("Країна:");
        countryLabel.setBounds(230,210,100,30);
        countryLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        panel.add(countryLabel);

        String[] choices = { "UA","GB", "USA","AU","FR","GER","BEL","PL","CAN","SPA"};
        formatBox = new JComboBox<>(choices);
        formatBox.setBounds(230, 240, 180, 25);
        panel.add(formatBox);


        //Кнопка
        button = new JButton("Зареєструватися");
        button.setBounds(350, 400, 180, 35);
        button.setBackground(Color.blue);
        button.setForeground(Color.black);
        button.setFont(new Font("Serif", Font.BOLD, 18));
        button.addActionListener(this::actionPerformed);
        panel.add(button);

        panel.setLayout(null);
        panel.setVisible(true);
        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        Pattern checkKirilLetters = Pattern.compile("^[а-яА-Я]*$");
        Matcher matcher1 = checkKirilLetters.matcher(nameInput.getText());

        Pattern checkLatinLetters = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        Matcher matcher2 = checkLatinLetters.matcher(emailInput.getText());

        if (!manGender.isSelected() && !womanGender.isSelected()) {
            JOptionPane.showMessageDialog(this, "Оберіть стать!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (nameInput.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Введіть ім'я!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (emailInput.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Введіть e-mail!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (!matcher1.matches()) {
            JOptionPane.showMessageDialog(this, "Тільки літери А-Я, а-я!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!matcher2.matches()) {
            JOptionPane.showMessageDialog(this, "Некорректний формат e-mail!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            new Exit_window().run();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Main().run());
    }
}
