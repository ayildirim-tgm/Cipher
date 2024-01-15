package ayildirim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ayildirim.model.Cipher;
import ayildirim.model.ShiftCipher;
import ayildirim.model.SubstitutionCipher;
import ayildirim.view.GUI;

public class Controller implements ActionListener {
    
    private GUI gui;
    private SubstitutionCipher sub;
    private ShiftCipher sc;

    public static void main(String[] args) {    
//    	Cipher c = new SubstitutionCipher("acbdefghijklmnopqrstuvwxyzäöüß");
//    	System.out.println(c.encrypt("                             "));
        Controller c = new Controller();
        c.start();
        
    }

    public void start() {
    	
        this.gui = new GUI(this);
        sub = new SubstitutionCipher("fghijklmnopqrstuvwxyzäöüßabcde");
        sc = new ShiftCipher(0);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if(e.getSource().equals(gui.subEncrypt)) {
        	
            sub.setSecretAlphabet(gui.getAlphabetInput());
            gui.setOutput(sub.encrypt(gui.getInput()));
            
        } else if(e.getSource().equals(gui.subDecrypt)) {
        	
            gui.setOutput(sub.decrypt(gui.getInput()));
            
        } else if(e.getSource().equals(gui.shiftEncrypt)) {
        	
            sc.setShiftValue(gui.getShiftValueInput());
            gui.setOutput(sc.encrypt(gui.getInput()));
            
        } else  if(e.getSource().equals(gui.shiftDecrypt)) {
        	
            gui.setOutput(sc.decrypt(gui.getInput()));
            
        }
        
    }
    
}

