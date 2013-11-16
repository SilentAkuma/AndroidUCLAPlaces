
public class Main
{
	public static void main(String [] args)
	{
		String dir1="/Users/Tong/Desktop/AndroidUCLAPlaces/restaurantarray.txt";
		String dir2="/Users/Tong/Desktop/AndroidUCLAPlaces/restaurants3.txt";
		
		Places2 place=new Places2 (dir1, dir2);
		
		Places2.print(place);
	}
}

