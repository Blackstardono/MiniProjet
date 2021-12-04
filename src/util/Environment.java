package util;

import java.util.ArrayList;
import java.util.Iterator;

import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {

    private Game game;
    private ArrayList<Lane> roads;

    public Environment(Game game) {
        this.game = game;
        this.roads = new ArrayList();
        this.roads.add(new Lane(game, 0, 0.0D));

        for(int i = 1; i < game.height - 1; ++i){
            this.roads.add(new Lane(game, i));
        }

        this.roads.add(new Lane(game, game.height - 1, 0.0D));
    }


    //TODO

    public boolean isSafe(Case c) {
        return (this.roads.get(c.ord)).isSafe(c);
    }

    public boolean isWinningPosition(Case c) {
        return c.ord == this.game.height - 1;
    }

    public void update() {
        Iterator la = this.roads.iterator();

        while(la.hasNext()) {
            Lane lane = (Lane)la.next();
            lane.update();
        }

    }
}

