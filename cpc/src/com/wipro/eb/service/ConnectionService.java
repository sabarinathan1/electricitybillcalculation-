package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;



	public class ConnectionService {
		
		public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException{
			
			if((currentReading<previousReading)||(currentReading<0)||(previousReading<0))
				throw new InvalidReadingException();
				
			else if(!(type.equals("Domestic")||type.equals("Commercial")))
				throw new InvalidConnectionException();
			
			else
				return true;
			
		}
		
		
		public float calculateBillAmt(int currentReading, int previousReading, String type) {
			
			float billAmount=0;
			//Domestic domestic;
			//Commercial commercial;
			Connection connection=null;
			float slabDomestic[]={2.3f, 4.2f, 5.5f};
			float slabCommercial[]={5.2f, 6.8f, 8.3f};
			try{
				if(validate(currentReading, previousReading, type)){
					if(type.equals("Domestic")){
						connection=new Domestic(currentReading, previousReading, slabDomestic);
					}
					else{
						connection=new Commercial(currentReading, previousReading, slabCommercial);					
					}
					
				}
				
			}
			catch(InvalidReadingException e){
				return -1;
			}
			catch(InvalidConnectionException e){
				return -2;
			}
			return connection.computeBill();
			
			
		}
		
		public String generateBill(int currentReading, int previousReading, String type){

			String output="";
			float billAmount=0;
			billAmount=calculateBillAmt(currentReading, previousReading, type);
			if(billAmount==-1)
			{
				output="Incorrect Reading";
			}
			else if(billAmount==-2)
			{
				output="Invalid ConnectionType";
			}
				
			else
			{
				output="Amount to be paid : "+billAmount;
			}
		return output;
		
		}
		
	}
