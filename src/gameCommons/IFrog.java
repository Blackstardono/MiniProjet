package gameCommons;

import util.Case;
import util.Direction;

public interface IFrog {
	
	/**
	 * Donne la position actuelle de la grenouille
	 * @return
	 */
	public Case getPosition();
	
	/**
	 * Donne la direction de la grenouille, c'est � dire de son dernier mouvement 
	 * @return
	 */
	public Direction getDirection();
	
	/**
	 * D�place la grenouille dans la direction donn�e et teste la fin de partie
	 * @param key
	 */
	public void move(Direction key);


	/**
	 * @param param : 1 pour avoir old_dist, 2 pour avoir distance_parcourue.
	 * @return le nombre de lignes parcourues par la grenouille si le mode de jeu
	 * 			est infini, -1 sinon.
	 */
	public int getDistance(int param);

	/**
	 * Réinitialise  la direction de la grenouille.
	 */
	public void resetDirection();
}
