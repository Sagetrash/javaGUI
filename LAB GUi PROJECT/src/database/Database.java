package database;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class Database {
    static Statement stmt;

    public static void main(String[] args) {
        Database db = new Database();
        System.out.println(db.Printtable());
    }

    public Database() {
        String url = "jdbc:postgresql://localhost:5432/gendul";
        String user = "postgres";
        String password = "postgres";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
            stmt = conn.createStatement();
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS employee (id int PRIMARY KEY, fname VARCHAR(50), state VARCHAR(50),contact int);");
            System.out.println("table created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String Printtable() {
        String output = "";
        try {
            ResultSet res = stmt.executeQuery("SELECT * FROM EMPLOYEE;");
            output = output + "\n id   fname   address   contact";
            output = output + "\n ______________________________";

            while (res.next()) {

                String stringLine = "\n" + res.getInt("id") + "     " + res.getString("fname") + "      "
                        + res.getString("state") + "   " + res.getInt("contact");
                output = output + stringLine;
            }

        } catch (Exception e) {
            System.out.println("error in printing");
        }
        return output;
    }

    public static void insert(int id, String fname, String state, int contact) {
        String query = String.format("INSERT INTO EMPLOYEE VALUES(%d,'%s','%s',%d)", id, fname, state, contact);
        try {
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(int contact, String column, String value) {
        String query = String.format("UPDATE employee set %s = '%s' WHERE id = %d", column, value, contact);
        try {
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("error in update");
        }
    }

    public static void Delete(int id) {
        String query = String.format("DELETE FROM employee WHERE id = %d;", id);
        try {
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("error in delete");
        }
    }

}