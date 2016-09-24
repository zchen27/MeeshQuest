package cmsc420.meeshquest.part1.infra;

import java.awt.Color;
import java.awt.geom.Point2D;

public class City extends Point2D.Double
{
	private String name;
	private Color color;

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the color
	 */
	public Color getColor()
	{
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public double distance(Point2D.Double point)
	{
		double x1 = this.getX();
		double y1 = this.getY();
		double x2 = point.getX();
		double y2 = point.getY();
		
		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	}

	@Override
	public boolean equals(Object obj)
	{
		CityCoordinateComparator ccom = new CityCoordinateComparator();
		CityNameComparator ncom = new CityNameComparator();
		
		if (!(obj instanceof City)) return false;

		if (ccom.compare(this, (City) obj) == 0
				&& ccom.compare(this, (City) obj) == 0)
			return true;
		else return false;
	}

}
