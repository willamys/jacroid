package util;

import java.text.Normalizer;

import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

    public class UnaccentedNoSpace extends PlainDocument {  
        
    	public void insertString(int offs, String str, javax.swing.text.AttributeSet a)  
                throws BadLocationException {  
              
            if (str == null) {  
                return;  
            }  
      
            String unaccented = Normalizer.normalize(str, Normalizer.Form.NFD); // elimina os acentos.  
            unaccented = unaccented.replaceAll("[^\\p{ASCII}]", ""); // remove as sujeiras do processo acima.  
            unaccented = unaccented.replaceAll("[^a-zA-Z]","");
            super.insertString(offs, unaccented, a);  
        }  
    }  