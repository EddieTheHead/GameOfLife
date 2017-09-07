package  pl.air.bossy.cellularAutomata.gameoflife;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.air.bossy.cellularAutomata.gameoflife.model.WorldState;

public class Main extends Application {

	public static void main(String[] args) {
		System.out.println("test");
		WorldState first = new WorldState(100, 200);
		first.randomizeState();
		System.out.println("test2");
		for(int i = 0; i<10; ++i){
			first = first.getNextState();
		}
		System.out.println("test3");

		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
