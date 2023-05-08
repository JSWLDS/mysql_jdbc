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
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String belong = resultSet.getString("belong");
                System.out.println(id + " " + name + " " + age + " " + belong);
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