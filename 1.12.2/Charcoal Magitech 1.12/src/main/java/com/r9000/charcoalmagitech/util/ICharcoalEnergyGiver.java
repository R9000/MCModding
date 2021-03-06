package com.r9000.charcoalmagitech.util;

public interface ICharcoalEnergyGiver {
	
	//Charges the ICharcoalEnergyUser.
	public boolean charge(int chargeAmount);
	
	//Discharges the ICharcoalEnergyUser.
	public boolean discharge(int dischargeAmount);
	
	//Checks if this can charge by a given amount.
	public boolean canCharge(int chargeAmount);
	
	//Checks if this can discharge by a given amount.
	public boolean canDischarge(int dischargeAmount);
	
	//Adds a receiver to the pos Arraylist to be transmitted to.
	public void addReceiverToList(BlockPos pos);
	
	//Removes a receiver from the list.
	public void removeReceiverFromList(BlockPos pos);
	
	
	public boolean getCanAddTransmit(BlockPos wirePos);
	
	//Gets the dischargeRate of this, which is the max. amount of charge this can give per receiver.
	public int getDischargeRate();
	
	
	public void refreshSurroundingWires();
}
