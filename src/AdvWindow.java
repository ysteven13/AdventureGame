import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by caleb on 4/12/17.
 */
public class AdvWindow extends JFrame implements ActionListener {
    static JFrame mainFrame;
    static AdvPanel mainPanel;



    public AdvWindow() {
        mainFrame = new JFrame();
        mainPanel = new AdvPanel();

        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setSize(700, 600);
        mainFrame.setResizable(false);
        mainFrame.setContentPane(mainPanel);
        mainPanel.setBackground(Color.CYAN);




    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
