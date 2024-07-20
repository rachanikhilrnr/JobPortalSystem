/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobportalsystem;

import java.sql.ResultSet;
import static jobportalsystem.JobPortalSystem.scan;

/**
 *
 * @author RACHA NIKHIL
 */
public class ApplicantManagement {
    static Connect conn = new Connect();
    public static void applicantManagement(Connect conn){
        boolean conIn = true;
        while(conIn){   
            displayMenu();
            try{
                System.out.println("Enter num =");
                int val = scan.nextInt();
                System.out.println();
                if(val==1){
                    // Registering the new applicant
                    registerNewApplicant();
                }
                else if(val==2){
                    // Displaying all Applicant details
                    displayApplicants();
                }
                else if(val==3){
                    // Updating Applicant
                    updateApplicant();
                }
                else if(val==4){
                    // Deleting Applicant
                    deleteApplicant();
                }
                else if(val==5){
                    // Exiting Applicant Management
                    conIn=false;
                }else{
                    System.out.println("Enter number properly");
                }
            }catch(Exception e){
                System.out.println("That't not a number.... Exited");
            }
        }
    }
    public static void displayMenu(){
        System.out.println("--------Application Management-------");
        System.out.println("1. Register Applicant");
        System.out.println("2. View Applicant Details");
        System.out.println("3. Update Applicant Details");
        System.out.println("4. Delete Applicant");
        System.out.println("5. Return to Home");
    }
    public static void registerNewApplicant(){
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
    public static void displayApplicants(){
        try{
            ResultSet r = conn.s.executeQuery("select * from applicant");
            System.out.println("");
            System.out.println("-------Applicant Details---------");
            while(r.next()){
                System.out.println(r.getInt("applicant_id")+" | "+r.getString("name")+" | "+r.getString("email")+" | "+r.getString("phone_number")+" | "+r.getString("address"));
            }
            System.out.println();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void updateApplicant(){
        System.out.println("------Update Application Details------ ");
        System.out.println("Enter the Applicant Id of the person you want to Update =");
        int app_id = scan.nextInt();
        System.out.println("What do you want to Update ?");
        System.out.println("1. Name");
        System.out.println("2. Email");
        System.out.println("3. Phone Number");
        System.out.println("4. Address");
        System.out.println("5. Exit Application Update");
        System.out.println("Enter num =");
        int updNum = scan.nextInt();
        String q ="";
        if(updNum==1){
            System.out.println("Enter New Name =");
            String name = scan.next();
            q = "update applicant set name='"+name+"' where applicant_id='"+app_id+"' ";
        }
        else if(updNum==2){
            System.out.println("Enter New Email");
            String email = scan.next();
            q = "update applicant set email='"+email+"' where applicant_id='"+app_id+"'";
        }
        else if(updNum==3){
            System.out.println("Enter New Phone Number");
            String phone_number = scan.next();
            q = "update applicant set phone_number ='"+phone_number+"' where applicant_id='"+app_id+"'";
        }
        else if(updNum==4){
            System.out.println("Enter New Address");
            String address = scan.next();
            q = "update applicant set address ='"+address+"' where applicant_id='"+app_id+"' ";
        }
        String empty = "";
        if(!q.equals(empty)){
            try{
                conn.s.executeUpdate(q);
                System.out.println("Updated Successfully");
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void deleteApplicant(){
        System.out.println("Enter Applicant Id =");
        int applicant_id = scan.nextInt();
        try{
            String query = "delete from applicant where applicant_id='"+applicant_id+"'";
            conn.s.executeUpdate(query);
            System.out.println("Applicant Deleted Successfully");
        }catch(Exception e){
            System.out.println("Unable to delete this user because his interview already scheduled");
        }
    }
}
