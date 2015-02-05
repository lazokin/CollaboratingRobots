package application.test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class Window extends JFrame {

    private JPanel panel;
    private Simulator sim;

    public Window(final Simulator sim) {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.sim = sim;

        JButton stepBackButton = new JButton("StepBack");
        JButton playStopButton = new JButton("Play/Stop");
        JButton stepForwardButton = new JButton("StepForward");
        JButton resetButton = new JButton("Reset");
        JButton fasterButton = new JButton("Faster");
        JButton slowerButton = new JButton("Slower");
        JLabel counterLabel = new JLabel("0", JLabel.CENTER);
        JLabel stateLabel = new JLabel("Stopped", JLabel.CENTER);

        stepBackButton.setPreferredSize(new Dimension(100, 50));
        playStopButton.setPreferredSize(new Dimension(100, 50));
        stepForwardButton.setPreferredSize(new Dimension(100, 50));
        resetButton.setPreferredSize(new Dimension(100, 50));
        fasterButton.setPreferredSize(new Dimension(100, 50));
        slowerButton.setPreferredSize(new Dimension(100, 50));
        counterLabel.setPreferredSize(new Dimension(100, 50));
        counterLabel.setFont(new Font("Incosolata", Font.PLAIN, 20));
        stateLabel.setPreferredSize(new Dimension(100, 50));
        stateLabel.setFont(new Font("Incosolata", Font.PLAIN, 20));

        stepBackButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sim.stepBackward();
            }
        });

        playStopButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                SwingWorker<String, Object> sw = new SwingWorker<String, Object>() {
                    @Override
                    protected String doInBackground() throws Exception {
                        sim.playpause();
                        return null;
                    }
                };
                sw.execute();
            }
        });

        stepForwardButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sim.stepForward();
            }
        });

        resetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sim.stop();
            }
        });

        fasterButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                sim.speedUp();
            }
        });

        slowerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sim.slowDown();
            }
        });

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(stepBackButton);
        panel.add(playStopButton);
        panel.add(stepForwardButton);
        panel.add(resetButton);
        panel.add(slowerButton);
        panel.add(fasterButton);
        panel.add(counterLabel);
        panel.add(stateLabel);

        this.getContentPane().add(panel);

        this.setVisible(true);
    }

    public void changeCounterLabel(String count) {
        ((JLabel) panel.getComponent(6)).setText(count);
    }

    public void changeStateLabel(String count) {
        ((JLabel) panel.getComponent(7)).setText(count);
    }

}
