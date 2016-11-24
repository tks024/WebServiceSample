package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StockData {

	@Resource(name="jdbc/dbSample")
	private DataSource ds = null;

	public StockData(){ /* コンストラクター */ }

	private String productID;
	public void setProductID(String productID) { this.productID = productID; }
	public String getProductID() { return this.productID; }

	private String productColorID;
	public void setProductColorID(String productColorID) { this.productColorID = productColorID; }
	public String getProductColorID() { return this.productColorID; }

	private int quatity;
	public void setQuatity(int quatity) { this.quatity = quatity; }
	public int getQuatity() { return this.quatity; }

	private int status;
	public void setStatus(int status) { this.status = status; }
	public int getStatus() { return this.status; }


	public void InsertProc() {
		int result = 0;
		Connection db = null;
		PreparedStatement ps =null;
		try {
			//現在時刻取得
			Date now = new Date();
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");

			//DB登録
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/dbSample");
			db = ds.getConnection();
			ps = db.prepareStatement("INSERT INTO DT_Stock(productID, productColorID, quatity,status,u_date) VALUES(? ,? ,? ,? ,?)");
			ps.setString(1, this.productID);
			ps.setString(2, this.productColorID);
			ps.setInt(3, this.quatity);
			ps.setInt(4, this.status);
			ps.setString(5,df.format(now));
			result = ps.executeUpdate();
			ps.close();
			db.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) { ps.close(); }
				if(db!=null) { db.close(); }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
