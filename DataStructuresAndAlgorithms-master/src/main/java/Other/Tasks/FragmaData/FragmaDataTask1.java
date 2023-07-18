package Other.Tasks.FragmaData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FragmaDataTask1
{

	public static final String delimiter = ",";

	public static void read(String csvFile)
	{
			HashMap<String, Integer> map1 = new HashMap<>();
			HashMap<String, Integer> map2 = new HashMap<>();
			try
			{
				File file = new File(csvFile);
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
	
				String line = "";
				String[] tempArr;
				line = br.readLine();                    
				String s=new String("");
				while ((line = br.readLine()) != null)
				{
					tempArr = line.split(delimiter);
					if(Integer.parseInt(tempArr[1])==2016 && tempArr[7].equals("field"))
					{
						s=Integer.toString(2016)+"#"+tempArr[6];   //year+winnerteam will be key for hashmap 
						if(map1.containsKey(s))
						{
							map1.put(s,map1.get(s)+1);	
						}
						else
						{
							map1.put(s,1);
						}
					}
					
					if(Integer.parseInt(tempArr[1])==2017 && tempArr[7].equals("field"))
					{
						s=Integer.toString(2017)+"#"+tempArr[6];   //year+winnerteam will be key for hashmap 
						if(map2.containsKey(s))
						{
							map2.put(s,map2.get(s)+1);	
						}
						else
						{
							map2.put(s,1);
					
						}
					}
				}

	
			}catch (Exception e)
			{
				System.out.println("Exception Generated");
			}
			
			LinkedList<Map.Entry<String, Integer>> list1 = new LinkedList<Map.Entry<String, Integer>>(map1.entrySet());
			
			Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>()
				{
					public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2)
					{
						return -1*(obj1.getValue()).compareTo(obj2.getValue());
					}
				}			);
			System.out.println("\nYEAR2016");
			for(int i=0;i<4;i++)
			{
				Map.Entry<String, Integer> l=list1.get(i);
				String[] sa=(l.getKey()).split("#");
				System.out.println(sa[0]+"\t"+sa[1]+"\t"+l.getValue());
			}

			System.out.println("\nYEAR2017");
			
			List<Map.Entry<String, Integer> > list2 = new LinkedList<Map.Entry<String, Integer> >(map2.entrySet()); 
			  
	        // Sort the list 
	        Collections.sort(list2, new Comparator<Map.Entry<String, Integer> >()
	        { 
	            public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) 
	            { 
	                return -1*(o1.getValue()).compareTo(o2.getValue()); 
	            } 
	        }				); 

			for(int i=0;i<4;i++)
			{
				Map.Entry<String, Integer> l=list2.get(i);
				String[] sa=(l.getKey()).split("#");
				System.out.println(sa[0]+"\t"+sa[1]+"\t"+l.getValue());
			}
							
	}
	public static void main(String[] args)
	{
		// csv file to read
		String csvFile = "matches.csv";
		FragmaDataTask1.read(csvFile);
	}

}