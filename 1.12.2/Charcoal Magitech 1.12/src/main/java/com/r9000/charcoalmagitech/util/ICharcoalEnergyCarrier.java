package com.r9000.charcoalmagitech.util;

import com.r9000.charcoalmagitech.power.PowerNetwork;

public interface ICharcoalEnergyCarrier {
	
	public void clearConnected();
	
	public void setNetwork(PowerNetwork network);
	
	public PowerNetwork getNetwork();
	
	public boolean createNewNetwork();
	
	public boolean checkForUsers();
	
	//Really new methods.
	
	public void connectDifferentAdjacentWires();
	
	public void disconnectAdjacentWires();
	
	public boolean getCanBeConnected();
	
	public void setCanBeConnected(boolean canBeConnected);
	
	public void updateConnectedSides();
}
