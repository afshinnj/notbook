/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Helper;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author afshin
 */
public class Base64 {
    
    public static String encode(String text){
        
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        String normalString = text;
        String encodedString = encoder.encodeToString( 
        normalString.getBytes(StandardCharsets.UTF_8) );
       // System.out.println(encodedString);
        return encodedString;
    
    }
    
    public static String decode(String text){
        java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(text);

        return new String(decodedByteArray);
    }
}
