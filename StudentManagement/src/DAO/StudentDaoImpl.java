package DAO;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import DBUtils.DBUtils;
import Modle.Student;

public class StudentDaoImpl implements StudentDao {

	public List<Student> selectStudentByClass(Integer classNumber) {
		String sql="select * from student_teacher where class_number=?";
		PreparedStatement pstmt = DBUtils.getPstmt(sql);
		List<Student> studentList = new ArrayList<Student>();
		ResultSet rs = null;
		try{			
			pstmt.setInt(1,classNumber);
			rs = pstmt.executeQuery();
			//定义存储Student的集合
			while(rs.next()){
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				Integer username = rs.getInt("username");
				String password = rs.getString("password");
				Integer gender = rs.getInt("gender");
				java.util.Date birthday = rs.getDate("birthday");//Util下的日期是     1999-12-12
				String address = rs.getString("address");
				String role=rs.getString("role");
				//封装成user对象
				Student student=new Student();
				student.setId(id);
				student.setName(name);
				student.setUsername(username);
				student.setPassword(password);
				student.setGender(gender);
				student.setBirthday(birthday);
				student.setAddress(address);
				student.setClassNumber(classNumber);
				student.setRole(role);
				studentList.add(student);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				DBUtils.closeQueryRes(rs);
			}
		return studentList;
	}
//	insert into STUDENT_TEACHER values(seqstudent.nextval,'汪政',1705010115,'1314',1,to_date('1981/12/12' , 'yyyy/mm/dd'),
//			'东莞','普通学生',1);
	public void insertStudent(Student student) {
		String sql="insert into STUDENT_TEACHER values(seqstudent.nextval,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = DBUtils.getPstmt(sql);
		try{			
			pstmt.setString(1,student.getName());
			pstmt.setInt(2, student.getUsername());
			pstmt.setString(3, student.getPassword());
			pstmt.setInt(4, student.getGender());
			pstmt.setDate(5, new java.sql.Date(student.getBirthday().getTime()));
			pstmt.setString(6, student.getAddress());
			pstmt.setString(7, student.getRole());
			pstmt.setInt(8, student.getClassNumber());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeUpdateRes(pstmt);
		}
	}

	public Student selectStudentById(Integer id) {
		String sql="select * from student_teacher where id=?";
		PreparedStatement pstmt = DBUtils.getPstmt(sql);
		ResultSet rs = null;
		Student student=null;
		try{			
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();
			//定义存储Student的集合
				rs.next();
				String name = rs.getString("name");
				Integer username = rs.getInt("username");
				String password = rs.getString("password");
				Integer gender = rs.getInt("gender");
				java.util.Date birthday = rs.getDate("birthday");//Util下的日期是     1999-12-12
				Integer classNumber=rs.getInt("class_number");
				String address = rs.getString("address");
				String role=rs.getString("role");
				//封装成user对象
				student=new Student();
				student.setId(id);
				student.setName(name);
				student.setUsername(username);
				student.setPassword(password);
				student.setGender(gender);
				student.setBirthday(birthday);
				student.setAddress(address);
				student.setClassNumber(classNumber);
				student.setRole(role);
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				DBUtils.closeQueryRes(rs);
			}
		return student;
	}
//	update STUDENT_TEACHER s set s.name='汪',s.username=1705010115,s.password='1314',s.gender=1,s.birthday=to_date('1981/12/12' , 'yyyy/mm/dd'),
//			s.address='东莞',s.role='普通学生',s.class_number=1 where s.id=22;
	public void updateStudent(Student student) {
		String sql="update STUDENT_TEACHER s set s.name=?,s.username=?,s.password=?,s.gender=?,s.birthday=?,s.address=?,s.role=?,s.class_number=? where s.id=?";
		PreparedStatement pstmt = DBUtils.getPstmt(sql);
		try{			
			pstmt.setString(1,student.getName());
			pstmt.setInt(2, student.getUsername());
			pstmt.setString(3, student.getPassword());
			pstmt.setInt(4, student.getGender());
			pstmt.setDate(5, new java.sql.Date(student.getBirthday().getTime()));
			pstmt.setString(6, student.getAddress());
			pstmt.setString(7, student.getRole());
			pstmt.setInt(8, student.getClassNumber());
			pstmt.setInt(9, student.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeUpdateRes(pstmt);
		}
		
	}

	public void deleteById(Integer id) {
		String sql="delete from STUDENT_TEACHER s where s.id=?";
		PreparedStatement pstmt = DBUtils.getPstmt(sql);
		try{			
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeUpdateRes(pstmt);
		}
	}

	public Student selectStudentByNameAndPass(Integer Studentname, String Studentpassword) {
		String sql="select * from student_teacher s where s.username=? and s.password=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Student student=null;
		try {
			pstmt=DBUtils.getPstmt(sql);
			pstmt.setInt(1,Studentname );
			pstmt.setString(2, Studentpassword);
			rs=pstmt.executeQuery();
			//定义存储Student的集合
			while(rs.next()){
				//获得查询上来的每一条数据
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				Integer username = rs.getInt("username");
				String password = rs.getString("password");
				Integer gender = rs.getInt("gender");
				java.util.Date birthday = rs.getDate("birthday");//Util下的日期是     1999-12-12
				String address = rs.getString("address");
				String role=rs.getString("role");
				Integer classNumber=rs.getInt("class_number");
				//封装成user对象
				student = new Student();
				student.setId(id);
				student.setName(name);
				student.setUsername(username);
				student.setPassword(password);
				student.setGender(gender);
				student.setBirthday(birthday);
				student.setAddress(address);
				student.setClassNumber(classNumber);
				student.setRole(role);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				DBUtils.closeQueryRes(rs);
			}
		return student;
	}

	
}
