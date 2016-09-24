package cmsc420.meeshquest.part1.infra;

import java.util.Comparator;

/**
 * Comparator for comparing the coordinates of cities by row-major order
 * 
 * @author zhehao
 *
 */
public class CityCoordinateComparator implements Comparator<City>
{

	@Override
	public int compare(City o1, City o2)
	{
		// TODO Auto-generated method stub
		double x1 = o1.getX();
		double x2 = o2.getX();
		double y1 = o1.getY();
		double y2 = o2.getY();

		if (y2 > y1) return -1;
		else if (y2 < y1) return 1;
		else
		{
			if (x2 > x1) return -1;
			else if (x2 < x1) return 1;
			else return 0;
		}
	}

}