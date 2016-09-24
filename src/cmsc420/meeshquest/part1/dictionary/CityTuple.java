package cmsc420.meeshquest.part1.dictionary;

import cmsc420.meeshquest.part1.infra.City;

public class CityTuple implements Comparable<CityTuple>
{
	private String name;
	private City city;
	
	public CityTuple(City city)
	{
		this.city = city;
		this.name = city.getName();
	}
	
	public String getName()
	{
		return name;
	}
	
	public City getCity()
	{
		return city;
	}

	@Override
	public int compareTo(CityTuple o)
	{
		// TODO Auto-generated method stub
		return ((CityTuple) o).getName().compareTo(this.name);
	}

}
