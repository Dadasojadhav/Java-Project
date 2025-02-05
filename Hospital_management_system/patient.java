package Hospital_management_system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class patient {
     private Connection connection;
     private  Scanner scanner;

     public patient(Connection connection , Scanner scanner){
         this.connection = connection;
         this.scanner = scanner;
     }
     public  void addPatient(){
         System.out.print("Enter Patient name : ");
         String name = scanner.next();

         System.out.print("Enter Patient Age: ");
         int age = scanner.nextInt();

         System.out.print("Enter Patient Gender: ");
         String gender = scanner.next();

         try{
             String query = "INSERT INTO patients(name , age , gender) VALUES(?,?,?) ";
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             preparedStatement.setString(1,name);
             preparedStatement.setInt(2,age);
             preparedStatement.setString(3,gender);

             int affectedRows  = preparedStatement.executeUpdate();

             if(affectedRows>0){
                 System.out.println("patient added sucessfully");
             }
             else{
                 System.out.println("Failed to add patient");
             }

         }catch (SQLException e){
             e.printStackTrace();
         }



     }
    public void viewPatient(){
         String query = "Select * from Patient";
         try{
             PreparedStatement PreparedStatement = connection.prepareStatement(query);
             ResultSet resultSet= PreparedStatement.executeQuery();
             System.out.println("Patient Data");
             System.out.println("+--------------+---------------+---------+-----------------+");
             System.out.println("| patient Id |    Name     |  Age   |      Gender  | ");
             System.out.println("+--------------+---------------+---------+-----------------+");

             while(resultSet.next()){
                 int id = resultSet.getInt("id");
                 String name = resultSet.getString("name");
                 int age = resultSet.getInt("age");
                 String gender = resultSet.getString("gender");

                 System.out.printf("|%-12s| %-20s|%-10s|%-12s | \n  " ,id,name,gender);
                 System.out.println("+--------------+---------------+---------+-----------------+");

             }

         }
         catch (SQLException e){
             e.printStackTrace();
         }
    }

    public boolean getpatientByID(int id) {
         String query = "select * from patient where id = ?";
         try{
             PreparedStatement Preparestatement = connection.prepareStatement(query);
             ResultSet resultSet = Preparestatement.executeQuery();
             if (resultSet.next()) {

                 return  true;
             }else {
                 return false;
             }
         }catch (SQLException e){
             e.printStackTrace();
         }
         return false;
    }
}
