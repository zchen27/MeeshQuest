package cmsc420.meeshquest.part1.quadtree;

import cmsc420.drawing.CanvasPlus;
import cmsc420.meeshquest.part1.infra.City;
import java.awt.geom.Point2D;

public class WhiteNode extends Node
{
	private double width;
	private double height;

	private Point2D.Double location;

	private CanvasPlus canvas;

	public WhiteNode(Point2D.Double location, CanvasPlus canvas, double width,
			double height)
	{
		this.width = width;
		this.height = height;
		this.location = location;
		this.canvas = canvas;
	}

	@Override
	public Node add(City city)
	{
		// TODO Auto-generated method stub
		if (this.canvas != null)
		{
			canvas.addPoint(city.getName(), city.getX(), city.getY(),
					city.getColor());
		}

		return new BlackNode(city, this.location, this.canvas, this.width,
				this.height);
	}

	@Override
	public boolean contains(City city)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node remove(City city)
	{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(
				"Cannot remove city from white node");
	}

	public double getWidth()
	{
		return width;
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}

	public Point2D.Double getLocation()
	{
		return location;
	}

}
