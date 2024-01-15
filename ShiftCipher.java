package ayildirim.model;

public class ShiftCipher extends MonoAlphabeticCipher {

    private int shiftValue;
    
    public ShiftCipher(int shiftValue) {
    	
        this.setShiftValue(shiftValue);
        
    }
    
    public void setShiftValue(int shiftValue){
        
        String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
        String secret = "";
        
        if(shiftValue > 30 || shiftValue < 0) {
        	
            System.out.println("The Shift Value must be between 0 and 30!");
            return;
            
        }
              
        for(int i = 0; i <= alphabet.length() - 1; i++) {
        	
            if(i + shiftValue < 30) {
            	
                secret += alphabet.charAt(i + shiftValue);
                
            } else {
            	
                secret += alphabet.charAt((i  + shiftValue) - 30);
                
            }
        }
        
        this.shiftValue = shiftValue;
        super.setSecretAlphabet(secret);
        
    }
    
    public int getShiftValue() {
    	
        return this.shiftValue;
        
    }
}