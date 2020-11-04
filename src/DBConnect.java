import java.sql.*;

public class DBConnect {
    public static void main(String[] args) {

        try {
            //путь к БД,моё имя и пароль
            String host = "jdbc:mysql://localhost:3306/employees?serverTimezone=UTC";
            String uName = "root";
            String uPass = "root";
            //устанавливаем соединение, используя метод DriverManager.getConnection ()
            Connection con = DriverManager.getConnection(host, uName, uPass);
            //18: Прежде, чем мы сможем использовать экземпляр Statement для выполнения SQL – запросов,
            // нам необходимо создать такой экземпляр. ДЛя этого используется метод Connection.createStatement().
            // 19: это запрос в БД
            // 20: Данные, полученные в результате SQL – запроса возвращаются в виде множетсва результатов,
            // которые хранятся в сущности под названием ResultSet. = метод получение данных sql
            Statement stat = con.createStatement();
            String sql = "select * from workers";
            ResultSet rs = stat.executeQuery(sql);
               // Цикл с условием выполнения (rs.next() перемещает курсор на следующую строку)
            while ( rs.next()) {
                int number = rs.getInt("ID");
                String TheWords = rs.getString("The_Words");
                System.out.println(number + " " + TheWords);
            }
        }
        //JDBC использует стандартный механизм Java для работы с ошибками: исключения.
        // getMessage() возвращает сообщение об ошибке.
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}

