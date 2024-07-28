import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        File inFile = new File ("Student.txt");
        Scanner scanFile = new Scanner(inFile);

        ArrayList<Student> students = new ArrayList<>();



        while(scanFile.hasNextLine()){
            String line = scanFile.nextLine();
            Scanner scanLine = new Scanner(line);
            scanLine.useDelimiter(";");
            if(scanLine.hasNext()){
                String stuID = scanLine.next();
                String name = scanLine.next();
                Student temp = new Student(name , stuID);
                students.add(temp);
            }
        }
        boolean cont = true;
        Scanner userIn = new Scanner(System.in);
        int choice = 0;
        while (cont){
            boolean rightInput = false;
            while(!rightInput){
                try{
                    System.out.print("You want to search by [1] student ID or [2] Name : ");
                    choice = Integer.parseInt(userIn.nextLine());
                    rightInput = true;
                }catch (NumberFormatException e){
                    System.err.println("Please insert valid input !!!");
                    userIn.nextLine();
                }
            }
            userIn.nextLine();
            boolean found = false;
            switch(choice){
                case 1:
                    System.out.print("Enter student ID : ");
                    String stuID = userIn.next();
                    found = findStudentID(students, stuID);
                    break;
                case 2:
                    System.out.print("Enter student Name: ");
                    String name = userIn.next();
                    found = findStudentName(students, name);
                    break;
            }
            System.out.println(found ? "All data found": "Data not found");
            cont = getYesOrNo("You want to continue?");
        }

    }


    public static boolean findStudentName(ArrayList<Student> st,String name){
        for(Student stu : st){
            if(stu.getName().contains(name.toUpperCase())){
                System.out.println(stu);
                return true;
            }
        }
        return false;
    }
    public static boolean findStudentID (ArrayList<Student> st,String id){
        for(Student stu : st){
            if(stu.getStuID().contains(id)){
                System.out.println(stu);
                return true;
            }
        }
        return false;
    }


    public static boolean getYesOrNo (String message){
        Scanner userIn = new Scanner(System.in);
        System.out.print(message + " (y/n):");
        char input = userIn.next().charAt(0);
        if(input == 'y' || input == 'Y'){
            return true;
        }
        else{
            return false;
        }
    }
}