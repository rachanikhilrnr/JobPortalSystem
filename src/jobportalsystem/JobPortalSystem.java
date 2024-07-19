/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jobportalsystem;
import java.util.*;
import java.sql.*;
/**
 *
 * @author RACHA NIKHIL
 */
public class JobPortalSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("HELLWORLD");
        Connect conn = new Connect();
        boolean con = true;
        while(con){
            System.out.println("1. Applicant Management");
            System.out.println("2. Job Listing Management");
            System.out.println("3. Interview Management");
            System.out.println("4. Exit");
            System.out.println("Enter value =");
            int userInput = scan.nextInt();
            if(userInput == 1){
                boolean conIn = true;
                while(conIn){   
                    System.out.println("1. Register Applicant");
                    System.out.println("2. View Applicant Details");
                    System.out.println("3. Update Applicant Details");
                    System.out.println("4. Delete Applicant");
                    System.out.println("5. Go to Menu");
                    System.out.println("Enter value =");
                    int val = scan.nextInt();
                    if(val==1){
                        // Registering the new applicant
                        System.out.println("Enter name =");
                        String name = scan.next();
                        System.out.println("Enter email =");
                        String email = scan.next();
                        System.out.println("Enter Phone number =");
                        String phone_number = scan.next();
                        System.out.println("Enter Address =");
                        String address = scan.next();
                        System.out.println("Applicant "+name+" added successfully");
                        try{
                            String query = "insert into applicant(name,email,phone_number,address) "
                                + "values('"+name+"','"+email+"','"+phone_number+"','"+address+"')";
                            conn.s.executeUpdate(query);
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        
                    }
                    if(val==2){
                        // Displaying all applicant details
                        try{
                            ResultSet r = conn.s.executeQuery("select * from applicant");
                            System.out.println("");
                            System.out.println("-------Applicant Details---------");
                            while(r.next()){
                                System.out.println(r.getInt("applicant_id")+" "+r.getString("name")+" "+r.getString("email")+" "+r.getString("phone_number")+" "+r.getString("address"));
                            }
                            System.out.println();
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        //viewApplicants();
                    }
                    if(val==3){
                        // Updating Applicant Details
                    }
                    if(val==4){
                        // Deleting Applicant
                    }
                    if(val==5){
                        // Exiting Applicant Management
                        conIn=false;
                    }
//                    try{
//                        ResultSet r = conn.s.executeQuery("select * from applicant");
//                        while(r.next()){
//                            System.out.println(r.getInt("applicant_id")+" "+r.getString("name")+" "+r.getString("email")+" "+r.getString("phone_number")+" "+r.getString("address"));
//                        }
//                        System.out.println("");
//                    }catch(Exception e){
//                        System.out.println(e);
//                    }
                }
            }
            if(userInput==4){
                con = false;
            }
        }
    }
}
