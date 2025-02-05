package Hospital_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
    private Connection connection;


    public Doctor(Connection connection ){
        this.connection = connection;
    }

    public void viewDoctor(){
        String query = "Select * from Doctor";
        try{
            PreparedStatement PreparedStatement = connection.prepareStatement(query);
            ResultSet resultSet= PreparedStatement.executeQuery();
            System.out.println("Doctors Data");
            System.out.println("+--------------+---------------+--------------------------+");
            System.out.println("| Doctor Id |    Name     |  Specialization       | ");
            System.out.println("+--------------+---------------+--------------------------+");

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specilization = resultSet.getString("specialization");

                System.out.printf("|%-12s| %-20s|%-10s|%-12s |\n " , id,name,specilization);
                System.out.println("+--------------+---------------+-------------------------- +");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean getDoctorByID(int id) {
        String query = "select * from Doctor where id = ?";
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
