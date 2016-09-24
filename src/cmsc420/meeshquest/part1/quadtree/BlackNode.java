package cmsc420.meeshquest.part1.quadtree;

import java.awt.Color;
import java.awt.geom.Point2D;

import cmsc420.drawing.CanvasPlus;
import cmsc420.meeshquest.part1.infra.City;

public class BlackNode extends Node
{
	private double width;
	private double height;

	private Point2D.Double location;
	private City city;

	private CanvasPlus canvas;

	public BlackNode(City city, Point2D.Double location, CanvasPlus canvas,
			double width, double height)
	{
		this.width = width;
		this.height = height;
		this.location = location;
		this.city = city;
		this.canvas = canvas;
	}

	@Override
	public Node add(City city)
	{
		// Creating a new GreyNode to replace current Node
		GreyNode replace = new GreyNode(this.location, this.canvas, this.width,
				this.height);

		// Adds both the old city and new city
		replace.add(this.city);
		replace.add(city);
		
		// Adds quadrant partitions
		if (this.canvas != null)
		{
			this.canvas.addLine(this.location.x,
					this.location.y + this.height / 2,
					this.location.x + this.width,
					this.location.y + this.height / 2, Color.BLACK);
			this.canvas.addLine(this.location.x + this.width / 2,
					this.location.y, this.location.x + this.width / 2,
					this.location.y + this.height, Color.BLACK);
			this.canvas.removePoint(this.city.getName(), this.city.x,
					this.city.y, Color.BLACK);
		}

		// Returns the new grey node
		return replace;
	}

	@Override
	public boolean contains(City city)
	{
		// Compares cities to check if city is indeed contained
		return this.city.equals(city);
	}

	@Override
	public Node remove(City city)
	{
		if (this.canvas != null)
		{
			this.canvas.removePoint(city.getName(), city.x, city.y, Color.BLACK);
		}
		
		// Returns white node with same coordinates
		return new WhiteNode(this.location, this.canvas, this.width,
				this.height);
	}

	public double getWidth()
	{
		return width;
	}

	public double getHeight()
	{
		return height;
	}

	public Point2D.Double getLocation()
	{
		return location;
	}

	public City getCity()
	{
		return city;
	}
}
