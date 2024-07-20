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
public class InterviewManagement {
    static Connect conn = new Connect();
    public static void interviewManagement(Connect conn){
        boolean conIn = true;
        while(conIn){
            displayMenu();
            try{
                System.out.println("Enter num = ");
                int num = scan.nextInt();
                if(num==1){
                    scheduleInterview();
                }else if(num==2){
                    viewInterviewDetails();
                }else if(num==3){
                    updateInterviewDetails();
                }else if(num==4){
                    cancelInterview();
                }else if(num==5){
                    conIn = false;
                }else{
                    System.out.println("Enter number properly");
                }
            }catch(Exception e){
                System.out.println("That's not a Number... Exited");
            }
        }
    }
    public static void displayMenu(){
        System.out.println();
        System.out.println("----Interview Management-----");
        System.out.println("1. Schedule an Interview for an Applicant ");
        System.out.println("2. View Interview Details");
        System.out.println("3. Update Interview Information");
        System.out.println("4. Cancel an Interview");
        System.out.println("5. Return to Home");
        System.out.println();
    }
    public static void scheduleInterview(){
        System.out.println();
        System.out.println("--------Scheduling an Interview------");
        System.out.println("Enter the Job Id =");
        int job_id = scan.nextInt();
        System.out.println("Enter the Applicant Id =");
        int app_id = scan.nextInt();
        System.out.println("Enter the Interview Date in the Format YYYY-MM-DD =");
        String interview_date = scan.next();
        System.out.println("Enter the Status of Interview");
        String status = scan.next();
        System.out.println("");
        try{
            String q = "insert into interview(job_id,applicant_id,interview_date,status) "
                    + "values('"+job_id+"','"+app_id+"','"+interview_date+"','"+status+"')";
            conn.s.executeUpdate(q);
            System.out.println("Interview Scheduled Successfully");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void viewInterviewDetails(){
        System.out.println();
        System.out.println("------View Interview Details------");
        try{
            String query = "select * from interview";
            ResultSet r = conn.s.executeQuery(query);
            while(r.next()){
                System.out.println(r.getInt("interview_id")+" | "+r.getInt("job_id")+" | "+r.getInt("applicant_id")+" | "+r.getString("interview_date")+" | "+r.getString("status"));
            }System.out.println();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void updateInterviewDetails(){
        System.out.println();
        System.out.println("-----Update Interview Details------");
        System.out.println("Enter the Interview Id you want to Update =");
        int interview_id = scan.nextInt();
        System.out.println();
        System.out.println("What do you want to Update ?");
        System.out.println("1. Job Id");
        System.out.println("2. Applicant Id");
        System.out.println("3. Interview Date");
        System.out.println("4. Status ");
        System.out.println();
        System.out.println("Enter num =");
        int val = scan.nextInt();
        System.out.println();
        if(val==1){
            System.out.println("Enter the new Job Id =");
            int job_id = scan.nextInt();
            try{
                String q = "update interview set job_id='"+job_id+"' where interview_id='"+interview_id+"'";
                conn.s.executeUpdate(q);
                System.out.println("Updated Successfully");
            }catch(Exception e){
                System.out.println("Interview Id not Found");
            }
        }
        if(val==2){
            System.out.println("Enter the new Applicant Id =");
            int app_id = scan.nextInt();
            try{
                String q = "update interview set app_id='"+app_id+"' where interview_id='"+interview_id+"'";
                conn.s.executeUpdate(q);
                System.out.println("Updated Successfully");
            }catch(Exception e){
                System.out.println("Interview Id not Found");
            }
        }
        if(val==3){
            System.out.println("Enter the new Interview Date in format YYYY-MM-DD =");
            String date = scan.next();
            try{
                String q = "update interview set interview_date='"+date+"' where interview_id='"+interview_id+"'";
                conn.s.executeUpdate(q);
                System.out.println("Updated Successfully");
            }catch(Exception e){
                System.out.println("Interview Id not Found");
            }
        }
        if(val==4){
            System.out.println("Enter the new Status of Job =");
            String status = scan.next();
            try{
                String q = "update interview set status='"+status+"' where interview_id='"+interview_id+"'";
                conn.s.executeUpdate(q);
                System.out.println("Updated Successfully");
            }catch(Exception e){
                System.out.println("Interview Id not Found");
            }
        }
    }
    public static void cancelInterview(){
        System.out.println();
        System.out.println("-------Cancel an Interview-------");
        System.out.println("Enter the Interview Id =");
        int interview_id = scan.nextInt();
        try{
            String q = "delete from interview where interview_id='"+interview_id+"'";
            conn.s.executeUpdate(q);
        }catch(Exception e){
            System.out.println("Interview Id not Found");
        }
    }
}
