import java.util.*;
 class HospitalManagementSystem {
    public static void main(String args[]){
    
        //keeping a loop so tht the system works continuously!
        int choice;
        Scanner sc = new Scanner(System.in);    
        System.out.println("----------Welcome to the Hospital Management System-------------");
        System.out.println("The System offers the following services:");
        System.out.println("1]Patient Registration and Managemnet  \n2]Doctor Related Details \n3]Appointment Scheduling and Management \n4]Billing\n5]Exit");
        

        //Patient info:
        Patient[] patientList = new Patient[3]; // Initially, set the array size to 2
        int patientCount = 3;//trcaks the patient number
        Patient p1 = new Patient();
		//Adding-Default  Patient Details:
        //Patient1 Details:
        String[] name11 = { "Arjun Kumar","Ravi Patel", "Sophia Brown"};
        String[] mobile = {"9876543210", "9988776655", "8899776655"};
        String[] gender = {"male","male" , "female"};
		int[] age11 = {23 , 45, 34};
        String[] insurance = {"yes", "no","yes"};
		
		//doctor array:
		Doctor d1 = new Doctor();
		//Doctor info:
		Doctor[] doctorList = new Doctor[3];
        doctorList[0] = new Doctor("Dr. John Smith", "Morning", 500);
        doctorList[1] = new Doctor("Dr. Alice Green", "Evening", 400);
        doctorList[2] = new Doctor("Dr. David Miller", "24-7", 600);


		//Appointment array:
		Appointment[] appointmentList = new Appointment[2];
		int appointmentCount = 0;
		Appointment a1 = new Appointment();
		
		//Billing:
		Billing b1 = new Billing();

        


        for(int i = 0; i < patientList.length; i++){
            patientList[i] = new Patient();
            patientList[i].name = name11[i];
			patientList[i].age = age11[i];
            patientList[i].contact = mobile[i];
            patientList[i].genderP = gender[i];
            patientList[i].insurancePolicy = insurance[i];
        }


       //do{
       while(true){
			System.out.println("Enter your choice (From Main System Features)");
			choice = sc.nextInt();

			if(choice < 1 || choice > 5){
				System.out.println("Invalid Number choosen!Please retry again!");
			   
			}
			else{
				switch(choice){
					case 1 : System.out.println("Welcome, You have selected the Patient Registration and Managemnet");
					p1.patientMethods(patientList , patientCount);
					break;

					case 2 : System.out.println("Welcome, You have selected the Doctor Related Details:");
					d1.doctorCase(doctorList);
					break;

					case 3 : System.out.println("Welcome, You have selected the Appointment Booking:");
					a1.appointmentCase(patientList,doctorList,appointmentList);
					break;

					case 4 : System.out.println("Welcome, You have selected the Billing Section:");
					b1.billingCase(patientList,doctorList);
					break;    

					case 5 : System.out.println("----Exiting the System----");
					return;    

					default:System.out.println("Invalid choice!");
					break;
				}
			}
        }
     
    }  
}//main class ends


//patient class:
class Patient{

    //instance:
     int patientId;
     String name;
     int age;
     String  genderP, insurancePolicy, contact;
     
    
     Patient(){
        //default;
     }

     //pramaterized constructor:
     Patient(int patientId, String name, int age, String genderP, String contact) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.genderP = genderP;
        this.contact = contact;
    }




    //choice of the user:
    Scanner sc = new Scanner(System.in);
    int choiceP;
	

    //creating the main patient method:
    void patientMethods(Patient[] patientList , int patientCount){
        System.out.println("We can help you with the following:");
        System.out.println("1]Add patient Details\n2]View All patient Details\n3]Search Specific Patient\n4]Exit");

          

			
			
				 System.out.println("Enter your choice");
				 choiceP = sc.nextInt();
				if(choiceP < 1 || choiceP > 4){
					System.out.println("Invalid Number choosen!Please retry again!");
			   
				}
				else{
						switch(choiceP){
						case 1 : System.out.println("Welcome, You have selected the Add Patient Details Option!");
						addPatient(patientList, patientCount);
						break;

						case 2 : System.out.println("Welcome, You have selected viewing All Patient Related Details!");
						displayall(patientList, patientCount);
						break;

						case 3 : System.out.println("Welcome,");
						searchPatient(patientList , patientCount);
						break;
						
						case 4 : System.out.println("--------Exiting the patient system--------");
						break;
						

					}
				}
			

    }

        //creating ADD_PATIENT METHODS:
        void addPatient(Patient[] patientList,int patientCount){
        Scanner sc = new Scanner(System.in);
		boolean check = true;

            
        // Check if the array is full and resize if necessary
			if (patientCount == patientList.length) {
				Patient[] newArray = new Patient[patientList.length + 1];  // Increase size by 1
				for (int i = 0; i < patientList.length; i++) {
					newArray[i] = patientList[i];
				}
				patientList = newArray;  // Point patientList to the new array
			}

            Patient obj = new Patient();
            System.out.print("Enter Patient Name: ");
            obj.name = sc.next();
			//patient age and validation:
			while (true) {
            System.out.print("Enter patient age: ");
            int inputage = sc.nextInt();
            if (inputage > 0|| inputage <= 100) {
				obj.age = inputage;
                break;
            } else {
                System.out.println("***ERROR:* Invalid input. Please enter a valid age.");
                System.out.println("*****************************");
            }
            }
            //gender validation:
			while (true) {
            System.out.print("Enter patient gender:(enter: 'male' , 'female' , 'other') ");
            String input = sc.next().trim().toLowerCase();
            if (input.equals("female") || input.equals("male") || input.equals("other")) {
				obj.genderP = input;
                break;
            } else {
                System.out.println("***ERROR:* Invalid input. Please enter a valid gender.");
                System.out.println("*****************************");
            }
            }
            //patient contact and validation:
             while (true) {
            System.out.print("Enter your 10-digit contact number: (should start from '7' , '8' or '9')");
            String input = sc.next();
            if ((input.length() == 10 && input.matches("[0-9]+")) && (input.charAt(0) == '9' || input.charAt(0) == '8'|| input.charAt(0) == '7') ) {
				obj.contact = input;
                break;
            } else {
                System.out.println("***ERROR:* Invalid input. Please enter a valid 10-digit contact number.");
                System.out.println("*****************************");
            }
            }
            //insurance:
			 while (true) {
            System.out.print("Do you have Insurance Policy:(Enter yes or No) ");
			String ans4 = sc.next();
            if(ans4.trim().equalsIgnoreCase("yes") || ans4.trim().equalsIgnoreCase("no")){
                obj.insurancePolicy = ans4;
				break;
            }
			else {
                System.out.println("***ERROR:* Invalid input. Please enter a valid .");
                System.out.println("*****************************");
			 }}
			
        
	
            //Add new patient to array of objects:
            patientList[patientCount] = obj;
			patientCount++;

            System.out.println("Patient added Succesfully!");
			

            System.out.println("Do you want to view all the details of the patient:");
            String ans3 = sc.next();
            if(ans3.trim().equalsIgnoreCase("yes")){
                displayall(patientList , patientCount);
            }
      
	  
		}
	  
        //Display patient method:
        void displayall(Patient[] patientList ,int patientCount){
            System.out.println("Dispalying you all the details of the Patients:");
			    
            for(int i = 0; i < patientList.length ; i++){
            
                System.out.println("The patient name is: " + patientList[i].name);
                System.out.println("Gender = " + patientList[i].genderP);
                System.out.println("Age =  " + patientList[i].age);
                System.out.println("Contact =  " + patientList[i].contact);
                System.out.println("Insurance Policy Status = " + patientList[i].insurancePolicy);
                System.out.println();
                System.out.println("-----------------------------------");
            }
        }

        //Individual Data display:
        void displayPatient(Patient patient) {
            System.out.println("Patient Details:\n");
			
            System.out.println("Name: " + patient.name);
            System.out.println("Age: " + patient.age);
            System.out.println("Gender: " + patient.genderP);
            System.out.println("Contact: " + patient.contact);
            System.out.println("Insurance Policy: " + patient.insurancePolicy);
            System.out.println("-----------------------------------");
        }
       

        //Search Method::
        void searchPatient(Patient[] patientList , int patientCount){
            System.out.println("Search the Patient by:\n1]Name\n2]Contact\n3]Exit");
            int searchChoice = sc.nextInt();

            switch(searchChoice){
                case 1 : System.out.println("Enter Patient Name");
                String searchName = sc.next();
                boolean foundName = false;

                for(int i = 0 ; i < patientCount; i++){
                    if(patientList[i].name.equalsIgnoreCase(searchName)){
                        //Patient found:
                        System.out.println("Patient found!");
                        displayPatient(patientList[i]);
                        foundName = true;
                        break;
                    }
                }

                 if (!foundName) {
                    System.out.println("Patient with name '" + searchName + "' not found.");
                    
                    System.out.println("Do you want to add new patient:");
                    String ans = sc.next();
                    if(ans.trim().equalsIgnoreCase("yes")){
                        addPatient(patientList , patientCount);
                    }
                }

                break;


                case 2 :System.out.println("Enter Patient Contact Number:");
                String searchContact = sc.next();
                boolean foundContact = false;

                for(int i = 0 ; i < patientCount; i++){
                    if(patientList[i].contact.equalsIgnoreCase(searchContact)){
                        //Patient found:
                        System.out.println("Patient found!");
                        displayPatient(patientList[i]);
                        foundContact = true;
                        break;
                    }
                }

                 if (!foundContact){
                    System.out.println("Patient with contact " + searchContact + "' not found.");
                    
                    System.out.println("Do you want to add new patient:");
                    String ans = sc.next();
                    if(ans.trim().equalsIgnoreCase("yes")){
                        addPatient(patientList , patientCount);
                    }
                }

                break;
				
				
				case 3 : System.out.println("--Exiting the System----");
				return;

            }
            
        }
		
}
     
//class Doctor:
class Doctor{

     String name , timings;
     double consultationFee;
	 
	 Doctor(){
	 }

     Doctor(String name, String timings, double consultationFee) {
        this.name = name;
        this.timings = timings;
        this.consultationFee = consultationFee;
    }

	void doctorCase(Doctor[] doctorList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice:\n1]Display Doctor Availability \n2]Exit");
        int choiceD = sc.nextInt();

		switch(choiceD){
            case 1 : System.out.println("Welcome, You have selected the see Doctor Details Option!");
                    displayDoctor(doctorList);
                    break;
            case 2 : System.out.println("--Exiting the System----");
			return;
        }
	}

    void displayDoctor(Doctor[] doctorList){
        for(int i = 0; i < doctorList.length ;i++){
            System.out.println(i+1 + ". " + doctorList[i].name + " --  " +  doctorList[i].timings + " -->  Consultation Fee  Rs." + doctorList[i].consultationFee );
        }
    }
}//doctor class ends--


//Appointment class:
class Appointment {
    Patient patient1; // Patient object
    Doctor doctor;   // Doctor object
    String date;     // Appointment date
    String time;     // Appointment time
	static int appointmentCount;
	
	Appointment(){
		//default Constructor:
	}
	
	 // Constructor for Appointment
        Appointment(Patient patient1, Doctor doctor, String date, String time) {
        this.patient1 = patient1;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }
	
	void appointmentCase(Patient patientList[] , Doctor doctorList[], Appointment[] appointmentList){
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice:\n1]Schedule an Appointment And Display \n2]Exit");
        int choiceD = sc.nextInt();
		
		 
			   
			
			switch(choiceD){
				case 1 : System.out.println("Welcome,");
				 if (appointmentCount < appointmentList.length) {
							Appointment newAppointment = scheduleAppointment(patientList, doctorList);
							appointmentList[appointmentCount] = newAppointment; // Store the new appointment
							 // Increment appointment count
							System.out.println("Appointment scheduled successfully!");
							System.out.println("Number of appointments scheduled so far: " + (appointmentCount + 1)); // Display the count
							appointmentCount++;
							appointmentList[appointmentCount] = scheduleAppointment(patientList , doctorList);;
							System.out.println("Appointment scheduled successfully!");
							System.out.println("Number of appointments scheduled so far: " + (appointmentCount + 1));
							 
							
							if(appointmentCount == appointmentList.length){
								System.out.println("Would you like to see all the appointments so far:");
								  String ans = sc.next();
								if (ans.equalsIgnoreCase("yes")) {
									displayAllAppointments(appointmentList , appointmentCount) ;// Display all scheduled appointments
								}
							}
				 } else {
							System.out.println("Appointment list is full.");
						}
						break;
				
						
				case 2 : System.out.println("--Exiting the System----");
				return;
			    }
	        
        }
	
	        void displayAllAppointments(Appointment[] appointmentList, int appointmentCount) {
			if (appointmentCount == 0) {
				System.out.println("No appointments scheduled yet.");
			} else {
				for (int i = 0; i < appointmentCount; i++) {
					System.out.println("Appointment " + (i + 1) + ":");
					appointmentList[i].displayAppointment();
				}
			}
           }
		
		//display method:
		     // Display Appointment Details directly using selected patient and doctor
        void displayAppointment() {
       
		System.out.println("-----------------------------------");
        System.out.println("Appointment Details:\n");
        // Displaying Patient details directly
        System.out.println("Patient Details:");
        System.out.println("Name: " + patient1.name);
        System.out.println("Age: " + patient1.age);
        System.out.println("Gender: " + patient1.genderP);
        System.out.println("Contact: " + patient1.contact);
        System.out.println("Insurance Policy: " + patient1.insurancePolicy);

        // Displaying Doctor details directly
        System.out.println("\nDoctor Details:");
        System.out.println("Name: " + doctor.name);
        System.out.println("Timings: " + doctor.timings);
        System.out.println("Consultation Fee: Rs. " + doctor.consultationFee);

        // Appointment details
        System.out.println("\nAppointment Date: " + date);
        System.out.println("Appointment Time: " + time);
        System.out.println("-----------------------------------");
    }
	
		   //schedule appointment method:
	        Appointment scheduleAppointment(Patient[] patientList, Doctor[] doctorList) {
			Scanner sc = new Scanner(System.in);

			// Select Patient
			System.out.println("Select Patient by Index:");
			for (int i = 0; i < patientList.length; i++) {
				System.out.println(i + ". " + patientList[i].name);
			}
			int patientIndex = sc.nextInt();
			Patient selectedPatient = patientList[patientIndex];
			
			
			 // Select Doctor
			System.out.println("Select Doctor by Index:");
			for (int i = 0; i < doctorList.length; i++) {
				System.out.println(i + ". " + doctorList[i].name);
			}
			int doctorIndex = sc.nextInt();
			Doctor selectedDoctor = doctorList[doctorIndex];
			
			//appointment date nd time:
			System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
			String date = sc.next();
			
			System.out.print("Enter Appointment Time (Moring / Evening): ");
			String time = sc.next();
				
			// Create and return appointment
			  Appointment obj = new Appointment(selectedPatient, selectedDoctor, date, time);
			 
			
			  System.out.println("Do you want to view this Patient details of the appointment:");
              String ans = sc.next();
              if(ans.trim().equalsIgnoreCase("yes")){
              obj.displayAppointment();
            }
			
			
			 
			 return obj;
			
			
	    }
	
	
}//appointment class ends --

//Billing class::
class Billing{
	Patient patient;
	Doctor doctor;
	double consultationFee;
	double bill;
	
	Billing(){
		//default constructor
	}
	
	
	Billing(Patient patient , Doctor doctor , double consultationFee , double bill){
		this.patient = patient;
		this.doctor = doctor;
		this.consultationFee = consultationFee;
		this.bill = bill;
	}
	
	void billingCase(Patient patientList[] , Doctor doctorList[]){
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice:\n1]Display the bill \n2]Exit");
        int choiceD = sc.nextInt();

		switch(choiceD){
            case 1 : System.out.println("Welcome,");
                    billingCalculation(patientList , doctorList);
                    break;
            case 2 : System.out.println("--Exiting the System----");
			return;
        }
	}
	
	
	
	
		void displayBilling() {
       
		System.out.println("-----------------------------------");
        System.out.println("Billing Details:\n");
        // Displaying Patient details directly
        System.out.println("Patient Details:");
        System.out.println("Name: " + patient.name);
        System.out.println("Age: " + patient.age);
        System.out.println("Gender: " + patient.genderP);
        System.out.println("Contact: " + patient.contact);
        System.out.println("Insurance Policy: " + patient.insurancePolicy);

        // Displaying Doctor details directly
        System.out.println("\nDoctor Details:");
        System.out.println("Doctor Name: " + doctor.name);
        System.out.println("Doctor Timings: " + doctor.timings);
        System.out.println("Doctor Consultation Fee: Rs. " + doctor.consultationFee);
		
		//Displaying total bill:
		System.out.println("\nBilling Summary\n");
		System.out.println("Final bill Amoint is: " + bill);
		System.out.println("-------------------------------");
	}
	
	
	
	
	void billingCalculation(Patient[] patientList, Doctor[] doctorList) {
			Scanner sc = new Scanner(System.in);
			// Select Patient
			System.out.println("Select Patient by Index:");
			for (int i = 0; i < patientList.length; i++) {
				System.out.println(i + ". " + patientList[i].name);
			}
			int patientIndex = sc.nextInt();
			Patient selectedPatient = patientList[patientIndex];
			
			
			 // Select Doctor
			System.out.println("Select Doctor by Index:");
			for (int i = 0; i < doctorList.length; i++) {
				System.out.println(i + ". " + doctorList[i].name);
			}
			int doctorIndex = sc.nextInt();
			Doctor selectedDoctor = doctorList[doctorIndex];
			
			//calculate bill:
			double consultationFee = selectedDoctor.consultationFee;
			double discount = 0;
			
			if(selectedPatient.insurancePolicy.trim().equalsIgnoreCase("yes")){
				discount = consultationFee * 0.1;//gives 10% discount

			}
			
			this.bill = consultationFee - discount;
			
			//creating a new obj:
			 Billing obj1 = new Billing(selectedPatient, selectedDoctor, consultationFee , this.bill);
			
			
			  System.out.println("Do you want to view all the details of the appointment:(enter yes or no)");
              String ans = sc.next();
              if(ans.trim().equalsIgnoreCase("yes")){
              obj1.displayBilling();
            }
			
			
		}
	
}//billing class ends here!