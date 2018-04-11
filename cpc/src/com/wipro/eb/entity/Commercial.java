package com.wipro.eb.entity;

public class Commercial extends Connection{

	private static final float FinalAmountPayable = 0;

	public Commercial(int currentReading, int previousReading,float slabs[]) 
	{
		super(currentReading,previousReading,slabs);
	}

	public float computeBill() {
		float ElectricityDuty=0;
		float FinalAmountPayable;
		float billamount=0;
		int readingdifference=currentReading-previousReading;
		if(readingdifference<=50)
			{
			billamount=(float) (readingdifference*5.2);
			}
		else if(readingdifference>=51&&readingdifference<=100)
		{
			billamount=(float) ((50*5.2)+(readingdifference-50)*6.8);
		}
		else
		{
			billamount=(float) ((50*5.2)+(50*6.8)+(readingdifference-100)*8.3);	
		}
if(billamount >= 10000 )
{
	ElectricityDuty =(float) (billamount* 0.09);
	 FinalAmountPayable =billamount + ElectricityDuty;
}
else if(billamount >=5000 )
{
	ElectricityDuty =(float) (billamount* 0.06);
FinalAmountPayable =billamount + ElectricityDuty;
}
else 
{
	ElectricityDuty =(float) (billamount* 0.02);
	FinalAmountPayable =billamount + ElectricityDuty;
}
//return ElectricityDuty;
return FinalAmountPayable;
}


}