import java.sql.*;

public class Test1 {
    public static void main(String[] args) throws SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user", "1234");
            if (conn==null) {
                System.out.println("Не работает");
                System.exit(0);
            }

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM computers");

            while (rs.next()) {
                System.out.println(rs.getRow() + ". " + rs.getString("Short_name") + " " + rs.getString("OS")
                + " " + rs.getString("IP") + " " + rs.getString("Admin_password"));
            }
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if (conn != null){
                conn.close();
            }
        }
    }
}
