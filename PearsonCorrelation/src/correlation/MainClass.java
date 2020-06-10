package correlation;

import java.util.ArrayList;
import java.util.List;

public class MainClass {


	public static void main(String[] args) {
		
		MovieDAO dao=new MovieDAO();
		List<MainVO> ulist=new ArrayList<MainVO>(); //100만 +
		List<MainVO> mlist=new ArrayList<MainVO>();
	//	List<Double> corr=new ArrayList<Double>(); 
		List<Double> main_userRate; //{영1,영277,영1220}
		List<Double> opponentRate; //{영1,영277,영1220}
				
		ulist=dao.getuserId(); //10000
		for(int i=0;i<ulist.size();i++)
		{									//${session.userId}
			mlist=dao.getMovieList("오모리찌개(kkon****)", ulist.get(i).getUser()); //두 유저가 본 영화 목록 {avatar, titanic, 극한직업}
			
			for(int j=0;j<mlist.size();j++)
			{
				main_userRate=new ArrayList<Double>();
				main_userRate.add(dao.getRating(mlist.get(j).getMno(), "오모리찌개(kkon****)"));
			
				opponentRate=new ArrayList<Double>();
				opponentRate.add(dao.getRating(mlist.get(j).getMno(), ulist.get(i).getUser()));
			
				System.out.println("상대방:"+dao.getRating(mlist.get(j).getMno(), ulist.get(i).getUser()));
				System.out.println("오모리: "+dao.getRating(mlist.get(j).getMno(), "오모리찌개(kkon****)"));
			}
			
		}
		
	}
}