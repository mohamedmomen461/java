/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphabets;

/**
 *
 * @author smc
 */
public class Alphabets {
    public static boolean isStringonlyAlphabett(String str){
            return ((str!=null)&&(!str.equals(""))&&(str.chars().allMatch(Character::isLetter)));
        }
    
}
