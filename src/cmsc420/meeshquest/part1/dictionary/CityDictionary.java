package cmsc420.meeshquest.part1.dictionary;

import cmsc420.meeshquest.part1.infra.City;
import cmsc420.meeshquest.part1.quadtree.TreeContainer;

public class CityDictionary
{
	private AvlTree<CityTuple> avl;
	private TreeContainer quad;
	
	public CityDictionary(String name, float width, float height)
	{
		quad = new TreeContainer(name, width, height);
		avl = new AvlTree<CityTuple>();
	}
	
	public void add(City city)
	{
		CityTuple c = new CityTuple(city);
		
		avl.insert(c);
		quad.add(city);
	}
}
