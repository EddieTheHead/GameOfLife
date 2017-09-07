package pl.air.bossy.cellularAutomata.gameoflife.model;

import java.lang.Math;
import java.util.Random;

public class WorldState {
	public WorldState(int width, int heigh){
		cells = new CellState[width][heigh];
		this.width = width;
		this.heigh = heigh;
	}
	
	public void randomizeState(){
		Random rnd = new Random();
		
		for(int x = 0; x < width; ++x){
			for (int y = 0; y< heigh; ++y){
				cells[x][y] = rnd.nextBoolean() ? CellState.Alive : CellState.Dead;
			}
		}
	}
	
	enum CellState{
		Alive,
		Dead
	};
	public CellState[][] getCells() {
		return cells;
	}
	public void setCells(CellState[][] cells) {
		this.cells = cells;
		
	}
	//rules
	private CellState nextCellState(int x, int y){
		int neighbors = 0;
		//top row
		if(y != 0){
			if(x != 0){
				if(cells[x-1][y-1] == CellState.Alive ) neighbors++;
			}
			if(cells[x][y-1] == CellState.Alive) neighbors++;
			if(x != width-1){
				if(cells[x+1][y-1] == CellState.Alive ) neighbors++;
			}
		}
		if(x != 0 && cells[x-1][y] == CellState.Alive) neighbors++;
		if(x != width-1 && cells[x+1][y] == CellState.Alive) neighbors++;
		//bottom row
		if(y != heigh-1){
			if(x != 0){
				if(cells[x-1][y+1] == CellState.Alive ) neighbors++;
			}
			if(cells[x][y+1] == CellState.Alive) neighbors++;
			if(x != width-1){
				if(cells[x+1][y+1] == CellState.Alive ) neighbors++;
			}
		}
		if(neighbors == 3) return CellState.Alive;
		if(cells[x][y] == CellState.Alive || neighbors == 2) return CellState.Alive;
		return CellState.Dead;
	}
	
	public WorldState getNextState(){
		WorldState next = new WorldState(width, heigh);
		for(int x = 0; x<width; ++x){
			for(int y = 0; y<heigh; ++y){
				next.cells[x][y] = nextCellState(x, y);
			}
		}
		return next;
	}
	
	private CellState[][] cells;
	int width;
	int heigh;
	

}
