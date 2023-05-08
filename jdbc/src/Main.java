import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/test";
        String userName = "system";
        String password = "1234";
        String sql = "select * from employee";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement pstatement = connection.prepareStatement(sql);
            ResultSet resultSet = pstatement.executeQuery();

            while(resultSet.next()){
                String name = resultSet.getString("name");
                System.out.println(name);
            }

            resultSet.close();
            pstatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}