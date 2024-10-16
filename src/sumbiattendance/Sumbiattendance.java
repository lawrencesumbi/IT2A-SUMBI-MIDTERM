package sumbiattendance;

import java.util.Scanner;

public class Sumbiattendance {

     public void addAttendance(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Enter Student ID: ");
        int student_id = sc.nextInt();
        System.out.print("Enter Date: ");
        String date = sc.next();
        System.out.print("Enter Status: ");
        String status = sc.next();
        System.out.print("Enter Course ID: ");
        String course_id = sc.next();
        System.out.print("Enter Remarks: ");
        String remarks = sc.next();

        String sql = "INSERT INTO attendance (student_id, date, status, course_id, remarks) VALUES (?, ?, ?, ?, ?)";

        conf.addRecord(sql, student_id, date, status, course_id, remarks);

    }
    
    private void viewAttendance() {
        String query = "SELECT * FROM attendance";
        String[] headers = {"Attendance ID", "Student ID", "Date", "Status", "Course ID", "Remarks"};
        String[] columns = {"attendance_id", "student_id", "date", "status", "course_id", "remarks"};

        config conf = new config();
        conf.viewRecords(query, headers, columns);
    }
    
    
    private void updateAttendance(){
    
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        
        System.out.print("Enter new Student ID: ");
        int student_id = sc.nextInt();
        System.out.print("Enter new Date: ");
        String date = sc.next();
        System.out.print("Enter new Status: ");
        String status = sc.next();
        System.out.print("Enter new Course ID: ");
        String course_id = sc.next();
        System.out.print("Enter new Remarks: ");
        String remarks = sc.next();
        
        String query = "UPDATE attendance SET student_id = ?, date = ?, status = ?, course_id = ?, remarks = ? WHERE attendance_id = ?";
        
        config conf = new config();
        conf.updateRecord(query, student_id, date, status, course_id, remarks, id);
        
    }
    
    private void deleteAttendance(){
    
        Scanner sc = new Scanner (System.in);
        
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        
        String query = "Delete FROM attendance WHERE attendance_id = ?";
       
        config conf = new config();
        conf.deleteRecord(query, id);

    }
    

    public static void main(String[] args) {
        
        Sumbiattendance test = new Sumbiattendance();
        Scanner input = new Scanner(System.in);
        String response;
        
        do{    
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = input.nextInt();

            switch(action){
                case 1:
                    test.addAttendance();
                break; 
                case 2:
                    test.viewAttendance();
                break;
                case 3:
                    test.viewAttendance();
                    test.updateAttendance();
                    break;
                case 4:
                    test.viewAttendance();
                    test.deleteAttendance();
                    test.viewAttendance();
                break;
            }
            
            System.out.print("Do you want to Continue? ");
            response = input.next();
            
        }while(response.equalsIgnoreCase("yes"));
            System.out.println("Thank You!");
            
    }
     
}

    

