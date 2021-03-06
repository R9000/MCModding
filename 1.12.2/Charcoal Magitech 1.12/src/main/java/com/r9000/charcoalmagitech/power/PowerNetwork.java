package com.r9000.charcoalmagitech.power;

import java.util.ArrayList;

import com.r9000.charcoalmagitech.util.BlockPos;
import com.r9000.charcoalmagitech.util.ICharcoalEnergyCarrier;
import com.r9000.charcoalmagitech.util.ICharcoalEnergyGiver;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PowerNetwork {

	public ArrayList<BlockPos> wires = new ArrayList();
	public ArrayList<BlockPos> receivers = new ArrayList();
	public ArrayList<BlockPos> transmitters = new ArrayList();
	
	public World worldObj;
	
	public PowerNetwork(World world) {
		this.worldObj = world;
	}
	
	public static PowerNetwork mergeNetworks(World world, ArrayList<PowerNetwork> networks) {
		PowerNetwork mergedNetwork = new PowerNetwork(world);
		//System.out.println("///Running merge.///");
		//System.out.println(networks.size());
		for(int i = 0; i < networks.size(); i++) {
			for(int j = 0; j < networks.get(i).wires.size(); j ++) {
				mergedNetwork.addWireToList(networks.get(i).wires.get(j));
				//System.out.println("Added wire to merged network at: " + networks.get(i).wires.get(j).x + " " + networks.get(i).wires.get(j).y + " " + networks.get(i).wires.get(j).z);
			}
			for(int j = 0; j < networks.get(i).receivers.size(); j ++) {
				mergedNetwork.addReceiverToList(networks.get(i).receivers.get(j));		
			}
			for(int j = 0; j < networks.get(i).transmitters.size(); j ++) {
				mergedNetwork.addTransmitterToList(networks.get(i).transmitters.get(j));
			}
		}
		mergedNetwork.refreshNetwork();
		return mergedNetwork;
	}
	
	public void addWireToList(BlockPos pos) {
		//Only add positions not already in the list.
		boolean canAdd = true;
		for(int i = 0; i < wires.size(); i++) {
			if(pos.areEqual(pos, wires.get(i))) canAdd = false;
		}
		if(canAdd) wires.add(pos);
	}
	
	public void addReceiverToList(BlockPos pos) {
		//Only add positions not already in the list.
		boolean canAdd = true;
		for(int i = 0; i < receivers.size(); i++) {
			if(pos.areEqual(pos, receivers.get(i))) canAdd = false;
		}
		if(canAdd) receivers.add(pos);
	}
	
	public void addTransmitterToList(BlockPos pos) {
		//Only add positions not already in the list.
		boolean canAdd = true;
		for(int i = 0; i < transmitters.size(); i++) {
			if(pos.areEqual(pos, transmitters.get(i))) canAdd = false;
		}
		if(canAdd) transmitters.add(pos);
	}
	
	public void removeWireFromList(BlockPos pos) {
		for(int i = 0; i < wires.size(); i++) {
			if(pos.areEqual(pos, wires.get(i))) {
				wires.remove(i);
			}
		}
	}
	
	public void removeReceiverFromList(BlockPos pos) {
		for(int i = 0; i < receivers.size(); i++) {
			if(pos.areEqual(pos, receivers.get(i))) {
				receivers.remove(i);
			}
		}
	}
	
	public void removeTransmitterFromList(BlockPos pos) {
		for(int i = 0; i < transmitters.size(); i++) {
			if(pos.areEqual(pos, transmitters.get(i))) {
				transmitters.remove(i);
			}
		}
	}
	
	
	public void refreshNetwork() {
		if(!worldObj.isRemote) {
			//Checks for any receivers or transmitters connected to the network, and notifies the transmitters of the receivers.
			
			//Disconnect all receivers and transmitters before reformatting.
			this.clearConnections();
			
			for(int i = 0; i < wires.size(); i++) {
				BlockPos currentWire = wires.get(i);
				TileEntity te = worldObj.getTileEntity(currentWire.x, currentWire.y, currentWire.z);
				if(te != null && te instanceof ICharcoalEnergyCarrier) {
					ICharcoalEnergyCarrier carrier = (ICharcoalEnergyCarrier)te;
					//Add all found power users to network.
					carrier.checkForUsers();
				}
			}
			//Add the every receiver to every transmitter's list in order to supply them power.
			notifyTransmitters();
		}
	}
	
	public void clearConnections() {
		//Disconnect all receivers from the transmitters before reformatting.
		if(!worldObj.isRemote) {
			for(int j = 0; j < transmitters.size(); j++) {
				TileEntity te = worldObj.getTileEntity(transmitters.get(j).x, transmitters.get(j).y, transmitters.get(j).z);
				if(te != null && te instanceof ICharcoalEnergyGiver) {
					ICharcoalEnergyGiver giver = (ICharcoalEnergyGiver)te;
					for(int k = 0; k < receivers.size(); k++) {
						giver.removeReceiverFromList(receivers.get(k));
					}
				}
			}
		}
		receivers.clear();
		transmitters.clear();
	}
	
	//Add the every receiver to every transmitter's list in order to supply them power.
	public void notifyTransmitters() {
		for(int j = 0; j < transmitters.size(); j++) {
			BlockPos currentTransmitter = transmitters.get(j);
			TileEntity te = worldObj.getTileEntity(currentTransmitter.x, currentTransmitter.y, currentTransmitter.z);
			if(te != null && te instanceof ICharcoalEnergyGiver) {
				ICharcoalEnergyGiver transmitter = (ICharcoalEnergyGiver)te;
				for(int k = 0; k < receivers.size(); k ++) {
					transmitter.addReceiverToList(receivers.get(k));
				}
			}
		}
	}
	
	//Provide the positions of every transmitter on the network (used for refreshing when a wire is destroyed).
	public ArrayList<BlockPos> getTransmitterPositions() {
		return transmitters;
	}
}
