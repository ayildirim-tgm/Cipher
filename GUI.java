package ayildirim.view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ayildirim.controller.Controller;

public class GUI extends JFrame {

    private JPanel panel;
    private JPanel subPanel;
    private JPanel shiftPanel;
    private JPanel inputPanel;
    private JPanel outPanel;
    
    private JLabel sub = new JLabel();
    private JLabel shift = new JLabel();
    private JLabel inputL = new JLabel();
    private JLabel out = new JLabel();
    
    public JButton shiftEncrypt;
    public JButton shiftDecrypt;
    public JButton subEncrypt;
    public JButton subDecrypt;
    
    private JTextField alphabet;
    private JTextField shiftValue;
    private JTextField input;
    private JTextField output;
    
    public GUI(Controller c) {
    	
        super("Verschlüsselung");
        
        this.panel = new JPanel();
        this.subPanel = new JPanel();
        this.shiftPanel = new JPanel();
        this.inputPanel = new JPanel();
        this.outPanel = new JPanel();
        
        this.sub.setText("Substitution: ");
        this.shift.setText("Shift: ");
        this.inputL.setText("Input: ");
        this.out.setText("Output: ");
        
        this.shiftEncrypt = new JButton("Encrypt");
        this.shiftDecrypt = new JButton("Decrypt");
        this.subEncrypt = new JButton("Encrypt");
        this.subDecrypt = new JButton("Decrypt");
        
        this.shiftEncrypt.addActionListener(c);
        this.shiftDecrypt.addActionListener(c);
        this.subEncrypt.addActionListener(c);
        this.subDecrypt.addActionListener(c);
        
        this.alphabet = new JTextField();
        this.shiftValue = new JTextField();
        this.input = new JTextField();
        this.output = new JTextField();
        
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.shiftPanel.setLayout(new BoxLayout(shiftPanel, BoxLayout.X_AXIS));
        this.subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.X_AXIS));
        this.inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        this.outPanel.setLayout(new BoxLayout(outPanel, BoxLayout.X_AXIS));
        
        subPanel.add(sub);
        subPanel.add(subEncrypt);
        subPanel.add(subDecrypt);
        subPanel.add(alphabet);
        
        shiftPanel.add(shift);
        shiftPanel.add(shiftEncrypt);
        shiftPanel.add(shiftDecrypt);
        shiftPanel.add(shiftValue);
        
        inputPanel.add(inputL);
        inputPanel.add(input);
        
        outPanel.add(out);
        outPanel.add(output);
        
        panel.add(subPanel);
        panel.add(shiftPanel);
        panel.add(inputPanel);
        panel.add(outPanel);
        
        
        super.add(panel);
        
        super.setMinimumSize(new Dimension(700, 300));
        super.setSize(super.getMinimumSize());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        super.setVisible(true);
        
    }

    public String getAlphabetInput() {
    	
        return this.alphabet.getText();
        
    }
    public int getShiftValueInput() {
    	
        try {
        	
            return Integer.parseInt(this.shiftValue.getText());
            
        } catch(NumberFormatException e) {
        	
            JOptionPane.showMessageDialog(null, "No Shift value specified!");
            return 0;
            
        }
        
    }
    
    public String getInput() {
    	
        return this.input.getText();
        
    }
    
    public void setOutput(String output) {
    	
        this.output.setText(output);
        
    }
}