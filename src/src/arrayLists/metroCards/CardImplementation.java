package arrayLists.metroCards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CardImplementation {
	
	private static List<Card> travelDetails = new ArrayList<Card>();
	private final List<String> stationList = Arrays.asList("A1","A2","A3","A4","A5","A6","A7","A8","A9","A10");
	
	private static Map<String,Integer> footCount = new HashMap<String,Integer>();
	
	
	public double getFare(int noOfStations,int dayNo)
	{
		double totalFare;
		switch(dayNo)
		{
			case 6:
				totalFare = noOfStations*5.5;
				break;
			case 7:
				totalFare = noOfStations*5.5;
				break;
			default:
				totalFare = noOfStations*7;
		
		}
		return totalFare;
		
	}
	
	public int getNoOfStationsTarvelled(String sourceStation,String destStation)
	{
		
		int noOfStations = 0;
		if(stationList.contains(sourceStation) && stationList.contains(destStation))
		{
			noOfStations = stationList.indexOf(destStation) - stationList.indexOf(sourceStation);
			return Math.abs(noOfStations);
		}
		return noOfStations;
	}
	
	public void getFootCount(String stationName)
	{
		if(footCount.containsKey(stationName))
		{
			System.out.println("stationName = "+stationName+ " total foot counts = "+footCount.get(stationName));
		}
	}
	
	public void getCardReport(String cardName)
	{
		//Card currCard = new Card(cardName);
		for(int i = 0;i<travelDetails.size();i++)
		{
			Card card = travelDetails.get(i);
			if(card.getCardNo().equals(cardName))
			{
				List<TravelLog> log = card.getTravelListForCard();
				for(TravelLog g:log)
				{
					System.out.println("Card "+cardName+" used to travel from "+g.getInStation()+" to station "+g.getOutStation()+" .Fare is Rs. "+g.getFare()+" and balance on card is Rs. "+g.getBalanceafterTravel());
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		CardImplementation cardImpl = new CardImplementation();
		
		for(int i=0;i<3;i++)
		{
			System.out.println("Enter Card No");
			Scanner scan = new Scanner(System.in);
			String cardNo = scan.next();
			System.out.println("Enter Source Station");
			String sourceStation = scan.next();
			System.out.println("Enter destination Station");
			String destStation = scan.next();
			System.out.println("Enter day No");
			int dayNo = scan.nextInt();
			
			
			/*if(travelDetails.contains(new Card(cardNo)))
			{
				Iterator<Card> it = (Iterator<Card>)travelDetails.keySet().iterator(); 
				while(it.hasNext())
				{*/
			if(travelDetails.contains(new Card(cardNo)))
			{
				int index = travelDetails.indexOf(new Card(cardNo));
				Card cardObj = travelDetails.get(index);
				/*if(cardObj.getCardNo().equals(cardNo))
				{*/
				if(cardObj.getBalance() >= cardObj.getMinmbalance())
				{
					if(footCount.containsKey(sourceStation))
					{
						int currCount = footCount.get(sourceStation);
						footCount.put(sourceStation,currCount+1);
					}
					else
					{
						footCount.put(sourceStation,1);
					}
					
					
					int noOfStations = cardImpl.getNoOfStationsTarvelled(sourceStation,destStation);
					double fare = cardImpl.getFare(noOfStations, dayNo);
					
					if(cardObj.getBalance() - fare >= 0)
					{
						if(footCount.containsKey(destStation))
						{
							int currCount = footCount.get(destStation);
							footCount.put(destStation,currCount+1);
						}
						else
							footCount.put(destStation,1);
						
						double remainBalance = cardObj.getBalance() - fare;
						cardObj.getTravelListForCard().add(new TravelLog(sourceStation,destStation,fare,remainBalance));
						cardObj.setBalance(remainBalance);
					}
					else
					{
						System.out.println("Insufficeint balance for Exit");
					}
					
					travelDetails.set(index,cardObj);
				}
				else
				{
					System.out.println("Insufficeint Minimum balance for Entry");
				}
				/*}*/
				/*}*/
			}
			else
			{
				Card newCard = new Card(cardNo);
				int noOfStations = cardImpl.getNoOfStationsTarvelled(sourceStation,destStation);
				double fare = cardImpl.getFare(noOfStations, dayNo);
				if(footCount.containsKey(sourceStation))
				{
					int currCount = footCount.get(sourceStation);
					footCount.put(sourceStation,currCount+1);
				}
				else
					footCount.put(sourceStation,1);
				
				if(Card.getInitialbalance() - fare >= 0)
				{
					
					if(footCount.containsKey(destStation))
					{
						int currCount = footCount.get(destStation);
						footCount.put(destStation,currCount+1);
					}
					else
						footCount.put(destStation,1);
					
					double remainBalance = Card.getInitialbalance() - fare;
					newCard.getTravelListForCard().add(new TravelLog(sourceStation,destStation,fare,remainBalance));
					newCard.setBalance(remainBalance);
					
					travelDetails.add(newCard);
				}
				else
				{
					System.out.println("Insufficeint balance for Exit for New User");
				}
			}
		}
			
		cardImpl.getCardReport("C1");
		cardImpl.getFootCount("A3");
		
	}

}
