import java.io.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Places
{
	public string[] place;
	public Block [] MonThurs;
	public Block [] Friday;
	public Block [] Saturday;
	public Block [] Sunday;
	
	//Name1 is the Name to the array of string, Name2 is the name indexed data
	public Places(String Name1, String Name2)
	{
		File textfile=context.getFilesDir()+"/"+Name1;
		BufferedReader in=null;
		try
		{
			in=new BufferedReader(new InputStreamReader(context.openFileInput(Name1, Context.MODE_PRIVATE)));
			String line= in.readLine();
			String [] temp=line.split("\t");
			place=new String [temp[0]);
			for(int k=0; k<temp[0]; k++)
			{
				place[k]=temp[k+1];
			}
			
	
		}
		catch (IOException ioe)
		{
			System.out.println(ioe);
		}
		finally
		{
			try
			{
				if (in!=null)
					in.close();
			}
			catch(IOException ioe2)
			{
				System.out.println("Unable to close stream: "+ioe2);
			}	
		}
		
		textfile=context.getFilesDir()+"/"+Name2;
		try
		{
			in=new BufferedReader(new InputStreamReader(context.openFileInput(Name1, Context.MODE_PRIVATE)));
			String line=in.readLine();
			int size1=Integer.parseInt(line);
			MonThurs=new Block [size1];
			for(int i=0; i<size1; i++)
			{
				line=in.readLine();
				String [] temp=line.split("\t");
				int startHours=Integer.parseInt(temp[0]);
				int startMinutes=Integer.parseInt(temp[1]);
				int endHours=Integer.parseInt(temp[2]);
				int endMinutes=Integer.parseInt(temp[3]);
				int size2=Integer.parseInt(temp[4]);
				int [] temp2= new int[size2];
				for (int j=0; j<size2; j++)
					temp2[j]=temp[j+5];
				MonThur[i]=new Block(startHours, startMinutes, endHours, endMinutes, size2, temp2);
			}
			
			line=in.readLine();
			size1=Integer.parseInt(line);
			Friday=new Block [size1];
			for(int i=0; i<size1; i++)
			{
				line=in.readLine();
				String [] temp=line.split("\t");
				int startHours=Integer.parseInt(temp[0]);
				int startMinutes=Integer.parseInt(temp[1]);
				int endHours=Integer.parseInt(temp[2]);
				int endMinutes=Integer.parseInt(temp[3]);
				int size2=Integer.parseInt(temp[4]);
				int [] temp2= new int[size2];
				for (int j=0; j<size2; j++)
					temp2[j]=temp[j+5];
				Friday[i]=new Block(startHours, startMinutes, endHours, endMinutes, size2, temp2);
			}
			
			line=in.readLine();
			size1=Integer.parseInt(line);
			Saturday=new Block [size1];
			for(int i=0; i<size1; i++)
			{
				line=in.readLine();
				String [] temp=line.split("\t");
				int startHours=Integer.parseInt(temp[0]);
				int startMinutes=Integer.parseInt(temp[1]);
				int endHours=Integer.parseInt(temp[2]);
				int endMinutes=Integer.parseInt(temp[3]);
				int size2=Integer.parseInt(temp[4]);
				int [] temp2= new int[size2];
				for (int j=0; j<size2; j++)
					temp2[j]=temp[j+5];
				Saturday[i]=new Block(startHours, startMinutes, endHours, endMinutes, size2, temp2);
			}
			
			line=in.readLine();
			size1=Integer.parseInt(line);
			Sunday=new Block [size1];
			for(int i=0; i<size1; i++)
			{
				line=in.readLine();
				String [] temp=line.split("\t");
				int startHours=Integer.parseInt(temp[0]);
				int startMinutes=Integer.parseInt(temp[1]);
				int endHours=Integer.parseInt(temp[2]);
				int endMinutes=Integer.parseInt(temp[3]);
				int size2=Integer.parseInt(temp[4]);
				int [] temp2= new int[size2];
				for (int j=0; j<size2; j++)
					temp2[j]=temp[j+5];
				Sunday[i]=new Block(startHours, startMinutes, endHours, endMinutes, size2, temp2);
			}
		}
		catch (IOException ioe3)
		{
			System.out.println(ioe3);
		}
		finally
		{
			try
			{
				if (in!=null)
					in.close();
			}
			catch(IOException ioe4)
			{
				System.out.println("Unable to close stream: "+ioe4);
			}	
		}
		
	
	}

	public ArrayList <String> find()
	{
		Calendar c=Calendar.getInstance();
		int week=c.get(Calendar.DAY_OF_WEEK);
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int minute=c.get(Calendar.MINUTE);
		Time time= new Time (hour, minute);
		ArrayList<String> list=new ArrayList <String> (0);
		if(week=2||week=3||week=4||week=4)
		{
			int length=MonThurs.size();
			for (int i=0; i<length; i++)
			{
				if(Time.compare (time, Block.end)<0)
				{
					for(int j=0; j<Block.size; j++)
					{
						list.add(place[openPlace[j]]);
					}
				}
				
			}
		}
		else if(week=5)
		{
			int length=Friday.size();
			for (int i=0; i<length; i++)
			{
				if(Time.compare (time, Block.end)<0)
				{
					for(int j=0; j<Block.size; j++)
					{
						list.add(place[openPlace[j]]);
					}
				}
				
			}
		}
		else if(week=6)
		{
			int length=Saturday.size();
			for (int i=0; i<length; i++)
			{
				if(Time.compare (time, Block.end)<0)
				{
					for(int j=0; j<Block.size; j++)
					{
						list.add(place[openPlace[j]]);
					}
				}
				
			}
		}
		else
		{
			int length=Sunday.size();
			for (int i=0; i<length; i++)
			{
				if(Time.compare (time, Block.end)<0)
				{
					for(int j=0; j<Block.size; j++)
					{
						list.add(place[openPlace[j]]);
					}
				}
				
			}
		}
		return list;
	}
	
}
