package com.wipro.eb.entity;

public class Domestic  extends Connection{

	public Domestic(int currentReading, int previousReading,float slabs[]) 
	{
		super(currentReading,previousReading,slabs);
		
		
	}

	@Override
	public float computeBill() {
		float billamount;
	int readingdifference=currentReading-previousReading;
	if(readingdifference<=50)
		{
		billamount=(float) (readingdifference*2.3);
		return billamount;
		}
	else if(readingdifference>=51&&readingdifference<=100)
	{
		billamount=(float) ((float) ((readingdifference-50)*4.2)+(50*2.3));
		return billamount;
	}
	else
	{
		billamount=(float) ((float) (((readingdifference-100)*5.5)+(50*4.2)+(50*2.3)));	
		return billamount;
	}
	}

}
