/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author
 */
public class EntradaDeCaracteres extends PlainDocument {

    private int quantidadeMaxima;

    public EntradaDeCaracteres(int tamanhoMaximo) {
        super();
        if (tamanhoMaximo <= 0) {
            throw new IllegalArgumentException("Especifica a quantidade");
        }
        quantidadeMaxima = tamanhoMaximo;

    }

    @Override

    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr)
            throws BadLocationException {
        
        if(str == null || getLength() == quantidadeMaxima){
        return;
        }
        
        int tamanho = (getLength() + str.length());
        
        if(tamanho <= quantidadeMaxima){
        super.insertString(offset, str.replaceAll("[^a-z |^A-Z]", ""), attr);
        return;
        }
        
        String nove = str.substring(0, getLength()- quantidadeMaxima);
        
    }
    
    

    public void replace(int offset, String str, javax.swing.text.AttributeSet attr)
            throws BadLocationException {
        super.insertString(offset, str.replaceAll("[^a-z |^A-Z]", ""), attr);
    }
}
