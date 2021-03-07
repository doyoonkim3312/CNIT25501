package Lab_4;

import java.awt.*;
import javax.swing.*;

public class SwingDemo {
    public static void main(String[] args) {

        // This mehtod can be declared using Lambda statement
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame mainFrame =new SimpleFrame();
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.setLocation(20,20);
                mainFrame.setBounds(new Rectangle(700, 600));   // setBound controls size of frame

                mainFrame.setVisible(true);
            }
        });
    }
}

class SimpleFrame extends JFrame {
    private static final int frameWidth = 0;
    private static final int framedepth = 0;

    // Construct new Frame with default width and depth
    public SimpleFrame() {
        // setSize(frameWidth, framedepth);

        /*
        // Get Screen Dimensions
        Toolkit kit = Toolkit.getDefaultToolkit();  // Retrieve default toolkit based on native windowing system
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // Set frame width, height and let platform pick screen location
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);
         */

        add(new SimpleComponent());

        repaint();

        // void pack(): Resizes this window, taking into account the preferred sizes of its components.
        pack();
    }
}

class SimpleComponent extends JComponent {
    public static int messageX = 350;
    public static int messageY = 300;

    public void paintComponet(Graphics graphics) {
        graphics.drawString("Hello World!, Hello Swing!", messageX, messageY);
    }

    Toolkit kit = Toolkit.getDefaultToolkit();  // Retrieve default toolkit based on native windowing system
    public Dimension getPrefferedScreenSize() {
        return kit.getScreenSize();
    }



}