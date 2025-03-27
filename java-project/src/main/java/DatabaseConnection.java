import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://mysql:3306/my_database"; // path per trovare il dtavase 
        String user = "root";  // user name del database
        String password = "root"; // password del database

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            // connessione database
            Connection connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Connected to the database! \n ! Test Passed !");   // risultato 

                Statement statement = connection.createStatement(); // init dei cosi 
                
                System.out.println("List of databases:"); // stampa i database 

                ResultSet resultSet = statement.executeQuery("SHOW DATABASES"); // mi va la query  SHOW DATABASES dentor il db
                while (resultSet.next()) { // 
                    System.out.println(resultSet.getString(1));  
                }
            }
            

            // chiudi connessione
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
