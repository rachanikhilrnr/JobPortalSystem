Clone this repository to your system.

Pre requisites :
1. Apache Netbeans / IntellIJ 
2. MySql WorkBench 
3. Jdbc Driver file (sql connector file)

Place the jdbc driver file in the library field of cloned repository

Create a database named joblistingportal in mysql workbench

Tables 

1. Applicant Table
			o applicant_id (Primary Key)
			o name
			o email
			o phone_number
			o address
2. Joblisting Table
			o job_id (Primary Key)
			o title
			o description
			o requirements
			o posted_date
			o status (active/inactive)
3. Interview Table
			o interview_id (Primary Key)
			o job_id (Foreign Key references Job Listing Table)
			o applicant_id (Foreign Key references Applicant Table)
			o interview_date

Now run the application.
