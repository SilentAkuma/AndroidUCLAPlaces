package com.example.placesinucla;

import java.util.ArrayList;
import android.content.Context;

public class Retrieve
{
	private static Places Restaurant=null;
	private static Places Library=null;
	
	public static ArrayList <String> getRestaurant (Context c)
	{
		if (Restaurant==null)
			Restaurant=new Places (c, "restaurantArray.txt", "restaurantTimes.txt");
		ArrayList <String> temp= Restaurant.find();
		for(int i=0; i<temp.size(); i++)
		{
			String [] temp2=temp.get(i).split(":");
			String temp3=temp2[0]+"\n"+temp2[1];
			temp.set(i, temp3);
		}
		return temp;
	}
	
	public static ArrayList <String> getLibrary(Context c)
	{
		if(Library==null)
			Library=new Places (c,"libraryArray.txt", "libraryTimes.txt");
		return Library.find();
	}
	
	public static ArrayList<String> getAllRestaurant (Context c)
	{
		if (Restaurant==null)
			Restaurant=new Places (c,"restaurantArray.txt", "restaurantTimes.txt");
		ArrayList<String>temp= new ArrayList <String> (0);
		for( int i=0; i<Restaurant.place.length; i++)
		{
			 String [] temp2= Restaurant.place[i].split(":");
			 String temp3=temp2[0]+"\n"+temp2[1];
			 temp.add(temp3);
		}
		return temp;
	}
	
	public static ArrayList <String> getAllLibrary (Context c)
	{
		if(Library==null)
			Library=new Places (c, "libraryArray.txt", "libraryTimes.txt");
		ArrayList <String> temp= new ArrayList<String> (0);
		for (int i=0; i<Library.place.length; i++)
		{
			temp.add(Library.place[i]);
		}
		return temp;
	}
}