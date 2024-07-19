/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobportalsystem;
import java.sql.*;
/**
 *
 * @author RACHA NIKHIL
 */
public class Connect {
    Connection c;
    Statement s;
    public Connect(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///jobportalsystem","root","Nikhil1528?");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
