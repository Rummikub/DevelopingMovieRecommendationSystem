package correlation;
import java.util.*;

import java.sql.*;
public class MovieDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@211.238.142.210:1521:XE";
	
	//DAO 생성자 (드라이버 검색)
	public MovieDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	//연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	//해제
	public void disConnection()
	{
		try
		{
			if(ps!=null)ps.close();
			if(conn!=null) conn.close();
			
		}catch(Exception ex) {}
		
	}

	// 1) 유저 ID 기준으로 긁어온다 (no 없음 ==> 컬럼에만 존재한다)
	public List<MainVO> getuserId()
	{
		List<MainVO> userList= new ArrayList<MainVO>();
		try {
				getConnection();
				String sql="SELECT user_id FROM review GROUP BY (user_id)";
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();			
				while(rs.next())
				{
					MainVO vo=new MainVO();
					if(rs.getString(1)!="kkon1")
						vo.setUser(rs.getString(1));
					userList.add(vo);
				}
				rs.close();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		
		  return userList;	
	}
	
	// 2. 나 자신을 제외한 인원중에 평점을 매긴 영화가 겹치는게 있는(유저 이름, mno)
	public List<MainVO> getMovieList(String mainUser, String opponent)
	{
		List<MainVO> mlist=new ArrayList<MainVO>();
		try {
			getConnection();
			String sql="SELECT * FROM(SELECT count(*) as count,movie_id FROM review WHERE (user_id=? or user_id =?) GROUP by movie_id) "
					+ "where count>=2";
				System.out.println(mainUser);
				ps=conn.prepareStatement(sql);
				ps.setString(1, "kkon1");
				ps.setString(2, opponent);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					MainVO vo=new MainVO();
					vo.setMno(rs.getInt(2));
					mlist.add(vo);
				}
				rs.close();
			
		
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		
		  return mlist;	
	}	
	
	// 3. 유저 이름, mno를 토대로 두명의 평점을 가져온다.
	public double getRating(int mno, String mainUser) //String mainUser=오모리찌개(kkon****)
	{
		double rating=0;
		try {
			getConnection();
			String sql="SELECT rate from review WHERE movie_id=? and user_id=?";  
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setString(2, "kkon1");
			ResultSet rs=ps.executeQuery();
			rs.next();
			rating=rs.getDouble(1);
			rs.close();
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return rating;
	}
	
	
	// 4. 오모리찌개 (임의로 한명 지정)가 본 영화 리스트 받아오자
	public List<MainVO> getMyMovieList()
	{
		List<MainVO> myList=new ArrayList<MainVO>();
		try {
			getConnection();
			String sql="SELECT review.movie_id,title,genre,rate,content,poster FROM naver_re_movies,review WHERE naver_re_movies.movie_id=review.movie_id AND review.user_id='kkon1' ORDER BY movie_id";
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					MainVO vo=new MainVO();
					vo.setMno(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setGenre(rs.getString(3));
					vo.setRating(rs.getInt(4));
					vo.setContent(rs.getString(5));
					vo.setPoster(rs.getString(6));
					myList.add(vo);
				}
				rs.close();
					
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		
		  return myList;	
	}
	
	
	//5. COUNT 해서 Top10만 비교해보자 
	public int countTopN(String user_id)
	{
		
		int count=0;
		try {
			getConnection();
			String sql="SELECT COUNT (*) FROM (SELECT * FROM review WHERE user_id=?)";
			ps=conn.prepareStatement(sql);
			
			if(user_id!="kkon1")
			ps.setString(1, user_id);
			
			ResultSet rs=ps.executeQuery();
			count=rs.getInt(1);
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		
		return count;
	}
	
}
