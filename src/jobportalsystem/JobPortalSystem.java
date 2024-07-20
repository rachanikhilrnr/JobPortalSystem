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
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Connect conn = new Connect();
        boolean con = true;
        while(con){
            displayMenu();
            try{
                System.out.println("Enter num =");
                int userInput = scan.nextInt();
                System.out.println();
                try{
                    if(userInput == 1){
                        // Application Management 
                        ApplicantManagement obj = new ApplicantManagement();
                        obj.applicantManagement(conn);
                    }
                    else if(userInput == 2){
                        // Job Listing Management 
                        JobListingManagement obj = new JobListingManagement();
                        obj.jobListingManagement(conn);
                    }
                    else if(userInput == 3){
                        InterviewManagement obj = new InterviewManagement();
                        obj.interviewManagement(conn);
                    }
                    else if(userInput==4){
                        con = false;
                    }else{
                        System.out.println("Enter number properly");
                    }
                }catch(Exception e){
                    System.out.println("Enter number properly");
                }
            }catch(Exception e){
                System.out.println("That's not a number... Exited");
                break;
            }
        }
    }
    public static void displayMenu(){
        System.out.println("--------HOME------------");
        System.out.println("1. Applicant Management");
        System.out.println("2. Job Listing Management");
        System.out.println("3. Interview Management");
        System.out.println("4. Exit");
        System.out.println();
        
    }
    public static String readParagraph(Scanner scanner) {
        StringBuilder paragraph = new StringBuilder();
        String line;

        while (!(line = scanner.nextLine()).isEmpty()) {
            paragraph.append(line).append("\n");
        }

        return paragraph.toString().trim(); // To remove the last new line
    }
}
