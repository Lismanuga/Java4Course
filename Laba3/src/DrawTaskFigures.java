import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class DrawTaskFigures extends JPanel {
    public void paintComponent(Graphics g) {
        Triangle_Shape triangleShape = new Triangle_Shape(new Point2D.Double(300, 100),
                new Point2D.Double(400, 250), new Point2D.Double(200, 250));

        Square_Shape squareShape = new Square_Shape(new Point2D.Double(150, 50),
        new Point2D.Double(450, 50), new Point2D.Double(150, 300), new Point2D.Double(450, 300));

        g.setColor(Color.RED);
        Graphics2D g2d_square = (Graphics2D) g.create();
        g2d_square.fill(squareShape);
        g2d_square.draw(squareShape);

        g.setColor(Color.GREEN);
        Graphics2D g2d_triangle = (Graphics2D) g.create();
        g2d_triangle.fill(triangleShape);
        g2d_triangle.draw(triangleShape);

        g.setColor(Color.BLUE);
        g.fillOval(250, 150, 100, 100);


    }
    public static void main (String [] args){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Грищенко Богдан Анатолійович");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setSize(600, 600);

        DrawTaskFigures panel = new DrawTaskFigures();
        JLabel name = new JLabel("Назва шедевру");
        Font font = new Font("Courier", Font.BOLD | Font.ITALIC,20);
        name.setFont(font);
        name.setForeground(Color.RED);

        JLabel myName = new JLabel("Грищенко Богдан", SwingConstants.RIGHT);

        panel.add(name);
        panel.add(myName);
        frame.add(panel);

        frame.setVisible(true);
    }
}
class Triangle_Shape extends Path2D.Double {
    public Triangle_Shape(Point2D... points) {
        moveTo(points[0].getX(), points[0].getY());
        lineTo(points[1].getX(), points[1].getY());
        lineTo(points[2].getX(), points[2].getY());
        closePath();
    }
}

class Square_Shape extends Path2D.Double {
    public Square_Shape(Point2D... points) {
        moveTo(points[0].getX(), points[0].getY());
        lineTo(points[1].getX(), points[1].getY());
        lineTo(points[1].getX(), points[2].getY());
        moveTo(points[2].getX(), points[2].getY());
        lineTo(points[0].getX(), points[0].getY());
        lineTo(points[3].getX(), points[3].getY());
        closePath();
    }
}

