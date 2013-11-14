public class Block
{
	public Time start;
	public Time end;
	public int size;
	public int [] openPlaces;
	
	public Block(int startHours, int startMin, int endHours, int endMin, int sizeTemp, int [] openPlacesTemp)
	{
		start=new Time(startHours, startMin);
		end=new Time(endHours, endMin);
		size=sizeTemp;
		openPlaces=new int [size];
		for(int i=0; i<size; i++)
			openPlaces[i]=openPlacesTemp[i];
	}
}
