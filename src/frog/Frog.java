package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
	private Case position;
	private Direction direction;

	public Frog(Case position, Direction direction){
		this.position = position;
		this.direction = direction;
	}

	@Override
	public Case getPosition() {
		return position;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public void move(Direction key) {
		this.direction = key;
		int newCoord = 0;
		if (direction == Direction.up){
			 newCoord = this.position.ord;
			 newCoord+= 1;
			 Case newPosition = new Case(this.position.absc, newCoord);
			 this.position = newPosition;
		}
		if (direction == Direction.down){
			newCoord = this.position.ord;
			newCoord-= 1;
			Case newPosition = new Case(this.position.absc, newCoord);
			this.position = newPosition;
		}
		if (direction == Direction.right){
			newCoord = this.position.absc;
			newCoord+= 1;
			Case newPosition = new Case(newCoord,this.position.ord);
			this.position = newPosition;
		}
		if (direction == Direction.left){
			newCoord = this.position.absc;
			newCoord-= 1;
			Case newPosition = new Case(newCoord,this.position.ord);
			this.position = newPosition;
		}
	}
}
