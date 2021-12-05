package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import graphicalElements.Element;
import util.Direction;
import util.Case;

import java.awt.*;

public class FrogInf implements IFrog {

    private Game game;
    private Case position;
    private Direction direction;
    private int current_distance;   // distance parcourue par la grenouille
    private int old_dist;             // ancienne valeur de distance_parcourue  (comme on modifie distance_parcourue dans move(), lorqu'on veut récupérer sa valeur, on obtient la valeur suivante, d'où l'interet de concerver l'ancienne valeur)

    public FrogInf(Game g, int pos_x) {
        this.game = g;
        this.position = new Case(game.width/2,0);
        this.direction = Direction.nullDirec;
        this.current_distance = 0;
        this.old_dist = 0;
    }

    @Override
    public Case getPosition() {
        return new Case(this.position.absc, this.position.ord);
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public void move(Direction key) {
        if(key == Direction.up && position.ord < game.height - 1) {
            this.old_dist = this.current_distance;
            this.current_distance++;

        } else if (key == Direction.down && position.ord>0){
            this.current_distance--;
            this.old_dist = this.current_distance;
        } else if (key == Direction.right && position.absc < game.width - 1){
            position = new Case(position.absc+1, position.ord);
        } else if (key == Direction.left && position.absc>0){
            position = new Case(position.absc-1, position.ord);
        }

    }

    @Override
    public int getDistance(int param) {
        if (param == 1)
            return this.old_dist;
        else
            return this.current_distance;
    }
@Override
    public void resetDirection() {

        this.direction = Direction.nullDirec;
    }
}
