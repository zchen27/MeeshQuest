package cmsc420.meeshquest.part1.quadtree;

import cmsc420.drawing.CanvasPlus;
import cmsc420.meeshquest.part1.infra.City;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * The representation of a grey node.
 * 
 * @author zhehao
 *
 */
public class GreyNode extends Node
{
	private double width;
	private double height;

	private Node[] quadrants = new Node[4];

	private Point2D.Double location;

	private CanvasPlus canvas;

	/**
	 * Creates a new GreyNode instance with the location, width, and height
	 * 
	 * @param location
	 * @param width
	 * @param height
	 */
	public GreyNode(Point2D.Double location, CanvasPlus canvas, double width,
			double height)
	{
		// Heights and widths of the children
		double nextw = width / 2;
		double nexth = height / 2;

		// Sets the current node up
		this.width = width;
		this.height = height;
		this.location = location;
		this.canvas = canvas;

		// Creates four children as white nodes
		quadrants[0] = new WhiteNode(
				new Point2D.Double(width + nextw, height + nexth), canvas,
				nextw, nexth);
		quadrants[1] = new WhiteNode(
				new Point2D.Double(width - nextw, height + nexth), canvas,
				nextw, nexth);
		quadrants[2] = new WhiteNode(
				new Point2D.Double(width - nextw, height - nexth), canvas,
				nextw, nexth);
		quadrants[3] = new WhiteNode(
				new Point2D.Double(width + nextw, height - nexth), canvas,
				nextw, nexth);
	}

	@Override
	public Node add(City city)
	{
		// Simply add a city to the correct quadrant
		int qi = findQuadrant(city);
		quadrants[qi] = quadrants[qi].add(city);

		return this;
	}

	@Override
	public boolean contains(City city)
	{
		// TODO Auto-generated method stub
		return quadrants[0].contains(city) || quadrants[1].contains(city)
				|| quadrants[2].contains(city) || quadrants[3].contains(city);
	}

	@Override
	public Node remove(City city)
	{
		int whites;
		int qi = findQuadrant(city);
		Node remain;
		// Finds the appropriate quadrant to remove city
		quadrants[qi] = quadrants[qi].remove(city);
		whites = whiteQuadrants();
		remain = quadrants[firstNonWhite()];

		// Manages the grey node after removal
		if (whites > 3)
		{
			// Removes quadrant partitions
			if (this.canvas != null)
			{
				this.canvas.removeLine(this.location.x,
						this.location.y + this.height / 2,
						this.location.x + this.width,
						this.location.y + this.height / 2, Color.BLACK);
				this.canvas.removeLine(this.location.x + this.width / 2,
						this.location.y, this.location.x + this.width / 2,
						this.location.y + this.height, Color.BLACK);
			}

			if (whites == 3)
			{
				// Three white nodes, check if the next node is black
				if (remain instanceof BlackNode)
				{
					// Has only a black node, turns this into a black node
					City c = ((BlackNode) remain).getCity();
					return new BlackNode(c, this.location, this.canvas,
							this.width, this.height);
				}
				else
				{
					// Has another grey node, returns self
					return this;
				}
			}
			else
			{
				// Four white nodes, change grey node to white
				return new WhiteNode(this.location, this.canvas, this.width,
						this.height);
			}
		}
		else
		{
			// More than two nonwhite quadrants, returns self
			return this;
		}
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

	/**
	 * Finds which quadrant of the current node the city belong in.
	 * 
	 * @param city
	 * @return correct quadrant of the city
	 */
	private int findQuadrant(City city)
	{
		if (city.getX() >= location.getX())
		{
			if (city.getY() >= location.getY())
				// Q1 above and to the right
				return 0;
			else
				// Q3 below and to the right
				return 2;
		}
		else
		{
			if (city.getY() >= location.getY())
				// Q2 above and to the left
				return 1;
			else
				// Q4 below and to the left
				return 3;
		}
	}

	/**
	 * Finds the number of white quadrants of the tree
	 * 
	 * @return the number of white quadrants
	 */
	private int whiteQuadrants()
	{
		int counter = 0;

		for (Node n : quadrants)
		{
			if (n instanceof WhiteNode)
				counter++;
		}

		return counter;
	}

	/**
	 * Checks the four quadrants and return the first non-white quadrant, or -1
	 * if all quadrants are white
	 * 
	 * @return the first non-white quadrant
	 */
	private int firstNonWhite()
	{
		for (int i = 0; i < 4; i++)
		{
			Node n = quadrants[i];
			if (!(n instanceof WhiteNode))
				return i;
		}

		return -1;
	}
}
