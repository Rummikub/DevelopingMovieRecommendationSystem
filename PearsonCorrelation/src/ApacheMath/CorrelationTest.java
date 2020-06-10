package ApacheMath;

import java.util.Arrays;

import org.apache.commons.math3.stat.correlation.*;

public class CorrelationTest{

	public void testMath() throws Exception{
	

/*	double[] x={0.91, 1.14, 1.20, 4.80, 2.95, 2.06, 1.09, 1.87, 3.54, 4.97,
			4.3, 1.5, 0.16, 3.87, 4.61, 4.63, 3.49, 0.25, 1.81, 2.10};
	double[] y={4.25, 1.49, 4.15, 2.62, 3.47, 0.58, 0.90, 3.13, 3.62, 4.59, 
			1.690742398498581, 0.41967087723182583, 0.8124573771449978, 3.156705120595966, 3.116032675786461, 2.360616216280456, 0.4567456298076361, 2.49633989240057, 3.5864489842553833, 3.663063033957028};
	double[] z=new double[10];*/
	
		
	double[] U332={4.0,3.0,3.0};
	double[] U377={5.0,4.0,3.0};

	
		
		
	
	/*
	 *  영화 a,b를 기준으로 => uno=1,uno=2,uno=3,....
	 *  유저 1,2를 기준으로 => mno=A,mno=B 
	*/
	 
	/*for(int i=0; i< x.length ;i++)
	{
		w[i] = Math.random()*5; 

	}*/

	/*System.out.println("x: "+ Arrays.toString(x)); 
	System.out.println("y: "+ Arrays.toString(y));
	System.out.println("z: "+ Arrays.toString(z));
	*/

	System.out.println("User 332: "+Arrays.toString(U332));
	System.out.println("User 377: "+Arrays.toString(U377));
		
	
	System.out.println(new PearsonsCorrelation().correlation(U332, U377));
	
	}
	
	public static void main(String[] args) {
		CorrelationTest ct=new CorrelationTest();
		try{
			
		ct.testMath();
	
		}catch(Exception ex){ 
			System.out.println(">>>>>>>>>>>UNHANDLED<<<<<<<<<<<");
		}

	}
}