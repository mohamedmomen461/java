/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference_methode;
import java.util.function.BiPredicate;
public class StringUtils {
    public static String betterString(String s1,String s2,BiPredicate<String,String> p){
    if(p.test(s1, s2))
    {return s1;}
    else{return s2;}}
    
}
