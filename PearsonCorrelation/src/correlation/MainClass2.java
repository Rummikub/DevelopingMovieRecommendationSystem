package correlation;

import java.util.*;

public class MainClass2 {

	public static void main(String[] args) {

		MovieDAO dao=new MovieDAO();
	
		// 1) Count 높은 애들 50명 ...
		List<MainVO> ulist=new ArrayList<MainVO>();
		List<MainVO> myList=new ArrayList<MainVO>();
		List<MainVO> idList=new ArrayList<MainVO>();
/*		myList=dao.getMyMovieList();
		int i=1;
		for(MainVO vo:myList)
		{
			System.out.println(i+"번째 영화 정보");
			System.out.println(vo.getMno());
			System.out.println(vo.getTitle());
			System.out.println(vo.getGenre());
			System.out.println(vo.getRating());
			System.out.println(vo.getContent());
			System.out.println("================================================================");
			i++;
		}*/
		
		idList=dao.getuserId();
/*		int count;
		for(int j=0; j<idList.size(); j++)
		{
			MainVO mvo=new MainVO();
			String user_id=mvo.getUser();
			count=dao.countTopN(user_id);
			System.out.println(user_id +"가 본 영화: "+count);
		}
		*/
	/*	for(int i=0; i<ulist.size(); i++)
		{
 			String user_id=dao.getuserId();
		}
		
		for(int i=0;i<10000;i++)
		{
			MainVO vo=dao.countTopN();
		}*/
	}

}
