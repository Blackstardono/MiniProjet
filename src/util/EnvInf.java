package util;

import gameCommons.Game;
import gameCommons.IEnvironment;
import gameCommons.IFrog;

import java.util.ArrayList;
import java.util.Iterator;

public class EnvInf implements IEnvironment {
    private Game game;
    private ArrayList<Lane> roads;
    private int newCoord;
    private IFrog frog;

    public EnvInf(Game game) {
        this.game = game;
        this.roads = new ArrayList();
        this.roads.add(new Lane(game,0));
        for (int i = 1; i < game.height - 1; ++i) {
            this.roads.add(new Lane(game, i));
        }
    }

    public EnvInf(Game game,int newCoord){
        this(game);
        this.roads = new ArrayList();
        this.roads.add(new Lane(game,newCoord, game.defaultDensity));
        for (int i = 1; i < game.height - 1; ++i) {
            this.roads.add(new Lane(game, i));
        }
    }


    private void removeLanes(Direction key){
        Iterator r = this.roads.iterator();
         if(key == Direction.up) {
             this.roads.remove(r.next());
         }
    }


    public boolean isSafe(Case c) {
        return (this.roads.get(c.ord)).isSafe(c);
    }

    public boolean isWinningPosition(Case c) {
        return c.ord == this.game.height - 1;
    }

    public void update() {
        Iterator la = this.roads.iterator();
        while (la.hasNext()) {
            Lane lane = (Lane)la.next();
            lane.update();
        }
    }
}


