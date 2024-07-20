/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jobportalsystem;

import java.sql.ResultSet;
import static jobportalsystem.JobPortalSystem.readParagraph;
import static jobportalsystem.JobPortalSystem.scan;

/**
 *
 * @author RACHA NIKHIL
 */
public class JobListingManagement {
    static Connect conn = new Connect();
    public static void jobListingManagement(Connect conn){
        boolean conIn = true;
        while(conIn){
            displayMenu();
            try{
                System.out.println("Enter num = ");
                int num = scan.nextInt();
                System.out.println();
                if(num==1){
                    addNewJob();
                }
                else if(num==2){
                    viewJobListing();
                }
                else if(num==3){
                    updatingJobListing();
                }
                else if(num==4){
                    deletingJobListing();
                }
                else if(num==5){
                    conIn=false;
                }
                else{
                    System.out.println("That's not a number....Exited");
                }
            }catch(Exception e){
                System.out.println("That's not a number.... Exited");
            }
        }
    } 
    public static void displayMenu(){
        System.out.println();
        System.out.println("------Job Listing------");
        System.out.println("1. Add a new Job");
        System.out.println("2. View Job Listing Details");
        System.out.println("3. Update Job Listing Details");
        System.out.println("4. Delete a Job Listing");
        System.out.println("5. Return to Home");
        System.out.println("");
    }
    public static void addNewJob(){
        System.out.println("------Adding New Job---------");
        scan.nextLine();
        System.out.println("Enter the Title:");
        String title = readParagraph(scan);

        System.out.println("Enter the Description:");
        String description = readParagraph(scan);

        System.out.println("Enter the Requirements:");
        String requirements = readParagraph(scan);

        System.out.println("Enter the Status:");
        String status = readParagraph(scan);

        String query = "insert into joblisting(title,description,requirements,status) "
                + "values('"+title+"','"+description+"','"+requirements+"','"+status+"')";
        try{
            conn.s.executeUpdate(query);
            System.out.println(title+"Job added successfully");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void viewJobListing(){
        System.out.println("----View Job Listing Details-------");
        try{
            ResultSet r = conn.s.executeQuery("select * from joblisting");
            while(r.next()){
                System.out.println(r.getInt("job_id"));
                System.out.println(r.getString("title"));
                System.out.println(r.getString("description"));
                System.out.println(r.getString("requirements"));
                System.out.println(r.getString("posted_date"));
                System.out.println(r.getString("status"));
                System.out.println();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void updatingJobListing(){
        System.out.println("------Updating Job Listing------");
        System.out.println();
        System.out.println("Enter the Job Id you want to Update =");
        int job_id = scan.nextInt();
        System.out.println("What you want to update ?");
        System.out.println("1. Title");
        System.out.println("2. Description");
        System.out.println("3. Requirements");
        System.out.println("4. Status");
        int val = scan.nextInt();
        if(val==1){
            System.out.println("Enter New Title =");
            String title = readParagraph(scan);
            try{
                String query = "update joblisting set title='"+title+"' where job_id='"+job_id+"'";
                conn.s.executeUpdate(query);
                System.out.println("Job title updated Successfully");
            }catch(Exception e){
                System.out.println("Job Id not Found");
            }
        }
        else if(val==2){
            System.out.println("Enter the New Description =");
            String description = readParagraph(scan);
            try{
                String query = "update joblisting set description='"+description+"' where job_id='"+job_id+"'";
                conn.s.executeUpdate(query);
                System.out.println("Description updated Successfully");
            }catch(Exception e){
                System.out.println("Job Id not Found");
            }
        }
        else if(val==3){
            System.out.println("Enter the New Requirements =");
            String requirements = readParagraph(scan);
            try{
                String query = "update joblisting set requirements='"+requirements+"' where job_id='"+job_id+"'";
                conn.s.executeUpdate(query);
                System.out.println("Requirements updated Successfully");
            }catch(Exception e){
                System.out.println("Job Id not Found");
            }
        }
        else if(val==4){
            System.out.println("Enter the New Status =");
            String status = scan.next();
            try{
                String query = "update joblisting set status='"+status+"' where job_id='"+job_id+"'";
                conn.s.executeUpdate(query);
                System.out.println("Status updated Successfully");
            }catch(Exception e){
                System.out.println("Job Id not Found");
            }
        }else{
            System.out.println("Enter proper number");
        }
    }
    public static void deletingJobListing(){
        System.out.println("-----Deleting a Job-----");
        System.out.println();
        System.out.println("Enter the Job Id you want to Delete =");
        int job_id = scan.nextInt();
        try{
            String q = "delete from joblisting where job_id='"+job_id+"'";
            conn.s.executeUpdate(q);
            System.out.println("Job deleted Successfully");
        }catch(Exception e){
            System.out.println("Job Id not Found");
        }
    }
}
