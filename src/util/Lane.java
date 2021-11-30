package util;

import java.util.ArrayList;
import java.util.Iterator;
import gameCommons.Game;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars ;
	private boolean leftToRight;
	private double density;
	private int timer;

	// TODO : Constructeur(s)
	public Lane(Game game,int ord,double density){
		this.game = game;
		this.cars = new ArrayList<>();
		this.ord = ord;
		this.leftToRight = game.randomGen.nextBoolean();
		this.density = density;
		this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1;
	}

	public Lane(Game game, int ord) {
		this(game, ord, game.defaultDensity);
	}

	public void update() {

		// TODO
			this.timer++;
			if (this.timer <= this.speed) {
				this.moveCars(false);
			} else {
				this.moveCars(true);
				this.mayAddCar();
				this.timer = 0;
			}
		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e

	}

	// TODO : ajout de methodes

	/**
	 * Teste si la Case est sure
	 * @param c
	 * @return
	 */
	public boolean isSafe(Case c) {
		Iterator ca = this.cars.iterator();

		while(ca.hasNext()) {
			Car car = (Car)ca.next();
			if (car.onCase(c)) {
				return false;
			}
		}

		return true;
	}

	private void removeCars() {
		ArrayList<Car> toBeRemoved = new ArrayList();
		Iterator ca = this.cars.iterator();

		Car c;
		while(ca.hasNext()) {
			c = (Car)ca.next();
			if (!c.inside()) {
				toBeRemoved.add(c);
			}
		}

		ca = toBeRemoved.iterator();

		while(ca.hasNext()) {
			c = (Car)ca.next();
			this.cars.remove(c);
		}

	}

	private void moveCars(boolean b) {
		Iterator ca = this.cars.iterator();

		while(ca.hasNext()) {
			Car car = (Car)ca.next();
			car.move(b);
		}

		this.removeCars();
	}
	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}
