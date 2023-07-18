package Other.Tasks.FragmaData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;

public class FragmaDataTask3 {

	public static final String delimiter = ",";

	public static void read(String csvFile,String csvFile2) 
			{
				HashMap<String,int[]> map = new HashMap<>();
				HashMap<String,Double> map2 = new HashMap<>();
				try
				 {
					File file = new File(csvFile);
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					
					String line = "";
			 
					String[] tempArr;
					String[] tempArr2;
					line = br.readLine();                    // to skip the line containing title of columns in csv file 
					String s=new String("");
					String year=new String("");
					int[] val=new int[3];
					
					while ((line = br.readLine()) != null) 
						{
							tempArr = line.split(delimiter);
							int id=Integer.parseInt(tempArr[0]);
							String line2 = "";
							File file2 = new File(csvFile2);
							FileReader fr2 = new FileReader(file2);
							BufferedReader br2 = new BufferedReader(fr2);
							line2 = br2.readLine();
							while ((line2 = br2.readLine()) != null)
								{
									tempArr2 = line2.split(delimiter);
									if(id==Integer.parseInt(tempArr2[0]))
										{
											year=tempArr2[1];
											br2.close();
											break;
										}
								}
							s=year+"#"+tempArr[7];
							val[0]=1;
							val[1]=Integer.parseInt(tempArr[15])-Integer.parseInt(tempArr[9])-Integer.parseInt(tempArr[10]);
							if(map.containsKey(s))
								{
									int t[]=map.get(s);
									int v[]=new int[2];
									v[0]=t[0]+val[0];
									v[1]=t[1]+val[1];
									map.put(s,v);
								}
							else
								{
									map.put(s,val);
								}
						}
					br.close();
					
				}
				catch (IOException ex) 
				{
					ex.printStackTrace();
				}
				for(Map.Entry<String, int[]> m : map.entrySet())
					{	
						int vl[]=m.getValue();
						int ovr=0;
						if(vl[0]<6)
							ovr=1;
						else
							ovr=vl[0]/6;                            // number of overs bowled
						Double eco=Double.valueOf(vl[1])/ovr;
						map2.put(m.getKey(),eco);
					}
				
			
				List<Map.Entry<String, Double> > list = new LinkedList<Map.Entry<String, Double> >(map2.entrySet()); 
  
        			// Sort the list 
        			Collections.sort(list, new Comparator<Map.Entry<String, Double> >() 
					{ 
            					public int compare(Map.Entry<String, Double> o1,Map.Entry<String, Double> o2) 
           						{ 
               							 return -1*(o1.getValue()).compareTo(o2.getValue()); 
            						} 
        				}); 

				for(int i=0;i<10;i++)
					{
						Map.Entry<String,Double> l=list.get(i);
						String[] sa=(l.getKey()).split("#");
						System.out.println(sa[0]+" "+sa[1]+" "+l.getValue());
					}
			}

	public static void main(String[] args) 
			{
				// csv file to read
				String csvFile = "deliveries.csv";
				String csvFile2 = "matches.csv";
				FragmaDataTask3.read(csvFile,csvFile2);
			}

}