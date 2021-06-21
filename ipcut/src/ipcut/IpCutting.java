/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipcut;

/**
 *
 * @author smc
 */
public class IpCutting {
    private String cmdLine;

    public IpCutting(String cmdLine) {
        this.cmdLine = cmdLine;
    }

    public String getCmdLine() {
        return cmdLine;
    }

    public void setCmdLine(String cmdLine) {
        this.cmdLine = cmdLine;
    }

    
    
    void  ipcut(){
    String[] parts=cmdLine.split("\\.");
    if(parts.length<4){
    System.out.println("false");}
    else{
    System.out.println(Integer.parseInt(parts[0]));
    System.out.println(Integer.parseInt(parts[1]));
    System.out.println(Integer.parseInt(parts[2]));
    System.out.println(Integer.parseInt(parts[3]));
    }
    
    
    }
}
   
