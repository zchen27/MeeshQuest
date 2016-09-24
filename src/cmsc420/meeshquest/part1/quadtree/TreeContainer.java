package cmsc420.meeshquest.part1.quadtree;

import java.awt.geom.Point2D;
import java.awt.Color;

import cmsc420.meeshquest.part1.infra.City;
import cmsc420.drawing.CanvasPlus;
import cmsc420.geom.Circle2D;

public class TreeContainer
{
	private Node root;
	private Point2D.Double location;
	private double width;
	private double height;
	private int size;
	private String name;
	private CanvasPlus canvas;
	
	public TreeContainer(String name, double width, double height)
	{
		this.location = new Point2D.Double();
		this.root = new WhiteNode(location, canvas, width, height);
		this.canvas = new CanvasPlus(name, (int) width, (int) height);
		this.width = width;
		this.height = height;
		this.name = name;
		this.size = 0;
	}
	
	public void add(City city)
	{
		this.root = this.root.add(city);
		size++;
	}
	
	public boolean contains(City city)
	{
		return root.contains(city);
	}
	
	public void remove (City city)
	{
		this.root = root.remove(city);
	}

	public Point2D.Double getLocation()
	{
		return location;
	}
	public double getWidth()
	{
		return width;
	}

	public double getHeight()
	{
		return height;
	}

	public int getSize()
	{
		return size;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
}
