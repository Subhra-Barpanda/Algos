package arrayLists.metroCards;

import java.util.ArrayList;
import java.util.List;

public class Card {
	
	private String cardNo;
	private double balance;
	private static final double minmBalance = 50;
	private static final double initialBalance = 100;
	@Override
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		return true;
	}
	
	public Card(String cardNo) {
		super();
		this.cardNo = cardNo;
	}

	public static double getInitialbalance() {
		return initialBalance;
	}

	private List<TravelLog> travelListForCard = new ArrayList<TravelLog>();
	
	public List<TravelLog> getTravelListForCard() {
		return travelListForCard;
	}
	public void setTravelListForCard(List<TravelLog> travelListForCard) {
		this.travelListForCard = travelListForCard;
	}
	public static double getMinmbalance() {
		return minmBalance;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
