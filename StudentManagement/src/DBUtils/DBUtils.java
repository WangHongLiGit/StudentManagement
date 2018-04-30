package DBUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
	
	
	
	//直接得到连接(四String————>三空————>驱动注册 ————>得到链接)
		//重点：Properties文件的使用
		//1.得到当前类————>当前类加载器————>获得properties文件InputStream的对象——(in)
		//2.定义prop对象——————>加载load(in)————————>获取prop.getProperty("driverclass")
	
	public static Connection getConn(){
		InputStream in  = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop = new Properties();
		Connection conn = null;
		try {
			prop.load(in);
			String driverClass = prop.getProperty("driverClass");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			//注册驱动
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	//将定义String语句  进行预处理 得到预处理对象

	public static PreparedStatement getPstmt(String sql){
		Connection conn =getConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	//  增   删   改
	//  传过来 ps  可以向前得到  Connection
	
	public static void closeUpdateRes(PreparedStatement ps){
		if(ps != null){
			try {
				Connection conn = ps.getConnection();
				ps.close();
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//  查
	//  传过来 rs  可以向前获得pstmt  再向前获得  conn  
	
	public static void closeQueryRes(ResultSet rs){
		if(rs != null){
			Statement pstmt;
			try {
				pstmt = rs.getStatement();
				if(pstmt != null){
					Connection conn = pstmt.getConnection();
					rs.close();
					pstmt.close();
					if(conn != null){
						conn.close();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
