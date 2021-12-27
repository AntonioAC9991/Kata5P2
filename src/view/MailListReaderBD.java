package view;
import model.Mail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailListReaderBD implements MailReader {

    @Override
    public List<Mail> read(String n) {
        List<Mail> res = new ArrayList<Mail>();
        Connection conn = null;
        String sql = "SELECT * FROM EMAIL";
        try {
            conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Mail m = new Mail(rs.getString("Name"));
                res.add(m);
            }
            return res;

        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
            return null;
        }

    }
    private Connection connect(){
        Connection conn = null;
        String url = "jdbc:sqlite:KATA5.db";
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conneccion establecida");
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
        }
        return  conn;
    }
}
