package sqlTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoMillion {

	final String URL
	= "jdbc:mysql://localhost:3306/millionlive?autoReconnect=true&useSSL=false";
	final String USER = "root";
	final String PASS = "0402";
	final String SQL = "select * from testtable";

	 public List<DtoMillion> findAll() {
	        List<DtoMillion> syainList = new ArrayList<>();

	        try(Connection conn =
		            DriverManager.getConnection(URL, USER, PASS);
		        PreparedStatement ps = conn.prepareStatement(SQL)){

		        try(ResultSet rs = ps.executeQuery()){
		            while (rs.next()) {
		            	DtoMillion sd = new DtoMillion();
		            	sd.setId(rs.getInt("id"));
		            	sd.setName(rs.getString("name"));
		            	sd.setYear(rs.getInt("year"));
		            	sd.setFrom(rs.getString("from"));
		            	sd.setHand(rs.getString("hand"));
		            	sd.setBirthday(rs.getInt("birthday"));
		            	sd.setBlood(rs.getString("blood"));
		            	sd.setAttribute(rs.getString("attribute"));
		            	sd.setSsr_1(rs.getInt("ssr_1"));
		            	sd.setSsr_fes(rs.getInt("ssr_fes"));
		            	sd.setMainstory_1(rs.getInt("mainstory_1"));
		            	syainList.add(sd);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		    }
	        return syainList;

}
}