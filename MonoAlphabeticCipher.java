package ayildirim.model;

import javax.swing.JOptionPane;

public class MonoAlphabeticCipher implements Cipher{

	private String secretAlphabet;
	
	public MonoAlphabeticCipher(){
		
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		
	}
	
	@Override
    public String encrypt(String input) {
		
    String out = "";
    input = input.toLowerCase();
    
        for(int i = 0; i < input.length(); i++) {
        	
            if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
            	
                out += String.valueOf((secretAlphabet.charAt((char)input.charAt(i) -'a') ));
                
            } else if(input.charAt(i) == 'ä' || input.charAt(i) == 'ö' || input.charAt(i) == 'ü' || input.charAt(i) == 'ß'){
                
                switch(input.charAt(i)) {
                
                case 'ä':
                    out +=  secretAlphabet.charAt(26);
                    break;
                    
                case 'ö':
                    out +=  secretAlphabet.charAt(27);
                    break;
                    
                case 'ü':
                    out +=  secretAlphabet.charAt(28);
                    break;
                    
                case 'ß':
                    out +=  secretAlphabet.charAt(29);
                    break;
                    
                }
                
            } else {
            	
                out += input.charAt(i);
                
            }
            
        }
        
        return out;
        
    }

	@Override
    public String decrypt(String input) {
		
        String out = "";
        input = input.toLowerCase();
        
        for(int i = 0; i < input.length(); i++) {
            
            if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z' ) {
            	
                out += String.valueOf((char)(secretAlphabet.indexOf(input.charAt(i)) + 'a'));
                
            } else if(input.charAt(i) == this.secretAlphabet.charAt(26)) {
            	
                out +=  "ä";
                
            } else if(input.charAt(i) == this.secretAlphabet.charAt(27)) {
            	
                out +=  "ö";
                
            } else if(input.charAt(i) == this.secretAlphabet.charAt(28)) {
            	
                out += "ü";
                
            } else if(input.charAt(i) == this.secretAlphabet.charAt(29)) {
            	
                out += "ß";
                
            }
                
             else {
            	 
                out += input.charAt(i);
                
            }
            
        }
        
        return out;
         
    }    
	
	public String getSecretAlphabet() {
		
		return this.secretAlphabet;
		
	}
	
		
	public void setSecretAlphabet(String s) {
        
        if(s.length() != 30) {
        	
            JOptionPane.showMessageDialog(null, "Invalid Alphabet!");
            
        }
        
        String temp = "";
        
        for(int i = 0; i < s.length(); i++) {
        	
            if(temp.contains(String.valueOf(s.charAt(i)))) {
            	
                throw new IllegalArgumentException("Invalid alphabet");
                
            }
            
            temp += String.valueOf(s.charAt(i));
        }
        this.secretAlphabet = temp;
    }
		
}
