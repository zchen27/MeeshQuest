package cmsc420.meeshquest.part1.quadtree;

import cmsc420.meeshquest.part1.infra.City;

public abstract class Node
{
	/**
	 * Adds a city to the current tree
	 * 
	 * @param city
	 * @return
	 */
	public abstract Node add(City city);
	
	/**
	 * Checks if the tree contains a city
	 * 
	 * @param city
	 * @return
	 */
	public abstract boolean contains(City city);
	
	/**
	 * Removes a city from the current node;
	 * 
	 * @param city
	 * @return
	 */
	public abstract Node remove(City city);
}
