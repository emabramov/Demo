import java.sql.*;
import java.util.ArrayList;

public class MYSQLPractice {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String name = "root";
        String pass = "qwerty123";

        try {
            //Создаем соединение
            Connection connection = DriverManager.getConnection(url, name, pass);
            //Обычный statement
            Statement statement = connection.createStatement();

            //Подготовленный statement
            PreparedStatement prepare = connection.prepareStatement("SELECT COUNT(*) FROM subscriptions s JOIN courses c JOIN students st ON s.course_id = c.id AND s.student_id = st.id " +
                    "WHERE s.course_id = ?  ORDER BY s.subscription_date");
            PreparedStatement courseName = connection.prepareStatement("SELECT name, id FROM courses WHERE id = ?");
            PreparedStatement monthCount = connection.prepareStatement("SELECT MONTH(subscription_date) FROM subscriptions WHERE course_id = ? GROUP BY MONTH(subscription_date) ORDER BY MONTH(subscription_date)");

            ArrayList<Integer> course_id = new ArrayList<>();
            ArrayList<Double> monthCountArray = new ArrayList<>();

            for (int i = 1; i < 46; i++) {
                course_id.add(i);
                monthCount.setInt(1, course_id.get(i - 1));
                monthCount.execute();
                ResultSet res = monthCount.getResultSet();
                double b = 0;
                double a = 0;
                double result = 0;
                double saleCount = 0;

                while (res.next()) {
                    if (res.isFirst()) {
                        a += res.getInt(1);
                    }
                    if (res.isLast()) {
                        b += res.getInt(1);
                    }
                    saleCount += 1;
                }
                result = (b - a) + 1;

                monthCountArray.add(saleCount/result);

            }


            for (int i = 0; i < course_id.size(); i++) {
                prepare.setInt(1, course_id.get(i));
                courseName.setInt(1, course_id.get(i));
                courseName.execute();
                ResultSet courseNameSet = courseName.getResultSet();
                while(courseNameSet.next()) {
                    System.out.println("Курс:" + (courseNameSet.getString(1) + " " + courseNameSet.getString(2)));
                }
                    prepare.execute();
                    ResultSet set = prepare.getResultSet();
                    ResultSetMetaData meta = set.getMetaData();
                    while (set.next()) {
                        for (int l = 1; l <= meta.getColumnCount(); l++) {
                            System.out.print("Количество продаж:\t" + set.getString(l) + "\nСреднее количество продаж: " + String.format("%.2f", monthCountArray.get(i)) + "\n");
                        }
                        System.out.println();
                    }
                }

            prepare.close();

            statement.close();
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
