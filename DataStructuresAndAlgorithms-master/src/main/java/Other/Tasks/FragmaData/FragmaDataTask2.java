package Other.Tasks.FragmaData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;

public class FragmaDataTask2 {

	public static final String delimiter = ",";

	public static void read(String csvFile,String csvFile2) 
			{
				HashMap<String,int[]> map = new HashMap<>();
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
							s=year+"#"+tempArr[2];
							if(Integer.parseInt(tempArr[13])==4)
							      {
								val[0]=1;
								val[1]=0;
							      }
							else if(Integer.parseInt(tempArr[13])==6)
							      {
								val[0]=0;
								val[1]=1;
							      }
							else
							      {
								val[0]=0;
								val[1]=0;
							      }
							val[2]=Integer.parseInt(tempArr[15]);
							if(map.containsKey(s))
								{
									int t[]=map.get(s);
									int v[]=new int[3];
									v[0]=val[0]+t[0];
									v[1]=val[1]+t[1];
									v[2]=val[2]+t[2];
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
					{	int vl[]=m.getValue();
						String[] k=(m.getKey()).split("#");
						System.out.println(k[0]+"    "+k[1]+"    "+vl[0]+"    "+vl[1]+"    "+vl[2]);
					}
			
			}

	public static void main(String[] args) 
			{
				// csv file to read
				String csvFile = "deliveries.csv";
				String csvFile2 = "matches.csv";
				FragmaDataTask2.read(csvFile,csvFile2);
			}

}