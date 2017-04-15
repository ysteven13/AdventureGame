import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 * Created by caleb on 4/15/17.
 */
public class GameplayWindow extends AdvWindow implements ActionListener {

    AdvPanel game = new AdvPanel();
    AdvPanel options = new AdvPanel();
    AdvPanel otherOptions = new AdvPanel();
    Player p = new Player();

    private JButton[] optionButtons = {new JButton("Stats"), new JButton("Gear Info"), new JButton("Map"), new JButton("Backpack"), new JButton("Explore"), new JButton("Leave")};

    public GameplayWindow() {
        System.out.println("1");

        mainFrame.getContentPane().removeAll();


        game.setBackground(Color.GRAY);
        options.setBackground(Color.WHITE);

        mainFrame.add(game, BorderLayout.CENTER);
        mainFrame.add(options, BorderLayout.EAST);


        //adding borders
        otherOptions.addBorder(otherOptions, "Actions");
        options.addBorder(options, "Options");

        components();
        mainFrame.add(otherOptions, BorderLayout.AFTER_LAST_LINE);
        mainFrame.validate();
        mainFrame.repaint();


        game.add(new JLabel("hello"));
        mainFrame.setVisible(true);

    }


    void components() {
        GridLayout grid = new GridLayout(8, 8);
        options.setLayout(grid);
//        BoxLayout layout = new BoxLayout(otherOptions, BoxLayout.Y_AXIS);
//        otherOptions.setLayout(layout);

        for (int b = 0; b <= optionButtons.length - 1; b++) {
            if (b <= 3) {

                options.add(optionButtons[b]);
                optionButtons[b].setAlignmentX(Component.CENTER_ALIGNMENT);
                optionButtons[b].setPreferredSize(new Dimension(100, 100));
                optionButtons[b].addActionListener(this);
            } else {
                otherOptions.add(optionButtons[b]);
                optionButtons[b].setAlignmentX(Component.CENTER_ALIGNMENT);
                optionButtons[b].addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == optionButtons[0]) {
            JOptionPane.showMessageDialog(null, p.Stats());
        } else if (e.getSource() == optionButtons[1]) {
            JOptionPane.showMessageDialog(null, p.gear.gearInfo(1));
        } else if (e.getSource() == optionButtons[2]) {
            JOptionPane.showMessageDialog(null, map());
        } else if (e.getSource() == optionButtons[3]) {
            //JOptionPane.showMessageDialog(null, gameInstruct());
        } else if (e.getSource() == optionButtons[4]) {

        } else if (e.getSource() == optionButtons[5]) {

        }
    }

    String map() { // displays a print out version of map
        return "Map:" +
                "\n                                                     " +
                "\n    (Jex) ---- (Capital) ---- (Lana)           " +
                "\n                                                     ";
    }


}
