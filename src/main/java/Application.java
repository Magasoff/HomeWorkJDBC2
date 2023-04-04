import java.sql.*;

public class Application {
    public static void main(String[] args) {

        // Задаем параметры для подключения к базе данных:
        // имя пользователя, пароль и URL
        final String user = "postgres";
        final String password = "123RaMoS174RUS321";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        // Создаем соединение с базой данных внутри try-with-resources,
        // чтобы автоматически закрыть его после использования
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             // Создаем объект PreparedStatement с SQL-запросом
             // для выборки всех записей из таблицы book
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM  employee")) {

            // Выполняем SQL-запрос
            // и получаем результаты в виде объекта ResultSet
            ResultSet resultSet = statement.executeQuery();

            // Обрабатываем результаты запроса, перебирая все записи в таблице
            while (resultSet.next()) {
                // Получаем значения полей записи и выводим их на экран
                int idOfEmployee = resultSet.getInt("id");
                System.out.println("ID: " + idOfEmployee);

                String name = resultSet.getString("имя");
                String family = resultSet.getString("фамилия");
                int age = resultSet.getInt("age");
                int city = resultSet.getInt("city_id");

                System.out.println("Имя " + name);
                System.out.println("Фамилия " + family);
                System.out.println("Возраст " + age);
                System.out.println("Город " + city);
            }

        } catch (SQLException e) {
            // В случае возникновения ошибки при работе с базой данных
            // выводим сообщение об ошибке и информацию об исключении
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }
}