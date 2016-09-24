package cmsc420.meeshquest.part1.infra;

import java.util.Comparator;

/**
 * Comparator for comparing cities by name in ascii order
 * 
 * @author zhehao
 *
 */
public class CityNameComparator implements Comparator<City>
{

	@Override
	public int compare(City o1, City o2)
	{
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}