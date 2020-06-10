package ApacheMath;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class CSVReadTags {

	public static void main(String[] args) {

		List<String> list= new ArrayList<String>();
		//arraylist를 선언해도 무방하다.
		//ArrayList list=new ArrayList();
		
		try {
			File csv=new File("C:\\Users\\sist\\Downloads\\ml-20m\\ml-20m\\tags.csv");
			BufferedReader br= new BufferedReader(new FileReader(csv));
			String line="";
			
			while((line=br.readLine()) !=null)
			{
				String[] field= line.split(",");
				for(int i=0; i<field.length;i++)
				{
					try {
						Thread.sleep(10);
						System.out.println(field[i]);
						
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				System.out.println("======================================");
				//0,1,2
				
				
			
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
