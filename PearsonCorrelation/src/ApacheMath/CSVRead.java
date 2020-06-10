package ApacheMath;

import java.io.*;
public class CSVRead {

	public static void main(String[] args) {
		float[][] dat= new float[200000][4]; 
		//2차원 배열로 선언해야 표를 읽어올 수 있음 [행][열]

		try {	
			// userId, movieId, ratings
			File csv=new File("C:\\Users\\sist\\Downloads\\ml-20m\\ml-20m\\ratings.csv");
			BufferedReader bf= new BufferedReader(new FileReader(csv));
			String line="";
			int row=0;
			while((line=bf.readLine()) !=null)
			{
				String[] token = line.split(",",-1);
				for(int i=0; i<3; i++)
				{	
					dat[row][i] = Float.parseFloat(token[i]);
				}
				for(int i=0;i<3;i++)
				{
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(dat[row][i]+",");
				}
				row++;
				System.out.println("============");
			}
			bf.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
