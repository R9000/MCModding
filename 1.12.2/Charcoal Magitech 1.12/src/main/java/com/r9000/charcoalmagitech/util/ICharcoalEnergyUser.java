package com.r9000.charcoalmagitech.util;

public interface ICharcoalEnergyUser {
	
	//Charges the ICharcoalEnergyUser.
	public boolean charge(int chargeAmount);
	
	//Discharges the ICharcoalEnergyUser.
	public boolean discharge(int dischargeAmount);
	
	public boolean canCharge(int chargeAmount);
	
	public boolean canDischarge(int dischargeAmount);
	
	public BlockPos getMainTEPos();
	
	public boolean getCanAddReceive(BlockPos wirePos);
}
