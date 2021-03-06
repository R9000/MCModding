package com.r9000.charcoalmagitech.util;

public class BlockPos {
	public int x, y, z;
	
	public BlockPos(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//Copy constructor
	public BlockPos(BlockPos pos) {
		this(pos.x, pos.y, pos.z);
	}
	
	public static boolean areEqual(BlockPos pos1, BlockPos pos2) {
		if(pos1.x == pos2.x && pos1.y == pos2.y && pos1.z == pos2.z) {
			return true;
		}else{
			return false;
		}
	}
	
	public BlockPos getPosOnSide(int side) {
		switch(side) {
		case 0:
			return new BlockPos(this.x, this.y-1, this.z);
		case 1:
			return new BlockPos(this.x, this.y+1, this.z);
		case 2:
			return new BlockPos(this.x, this.y, this.z-1);
		case 3:
			return new BlockPos(this.x, this.y, this.z+1);
		case 4:
			return new BlockPos(this.x-1, this.y, this.z);
		case 5:
			return new BlockPos(this.x+1, this.y, this.z);
		default:
			return null;
		}
	}
	
	public BlockPos[] getSurroundingPoses() {
		BlockPos positions[] = new BlockPos[6];
		for(int i = 0; i < positions.length; i++) {
			positions[i] = this.getPosOnSide(i);
		}
		return positions;
	}
	
	public int getSideInRelationToPos(BlockPos pos) {
		//pos pertains to the block connected to the one that created this pos.
		//-1 returned for error.
		int xDif = (pos.x-this.x);
		int yDif = (pos.y-this.y);
		int zDif = (pos.z-this.z);
		if (Math.abs(xDif) + Math.abs(yDif) + Math.abs(zDif) > 1) {
			return -1;
		}else{
			if(yDif == -1) return 0;
			if(yDif == 1) return 1;
			if(zDif == -1) return 2;
			if(zDif == 1) return 3;
			if(xDif == -1) return 4;
			if(xDif == 1) return 5;
			return -1;
		}
	}
}
