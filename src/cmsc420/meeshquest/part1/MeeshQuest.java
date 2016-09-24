package cmsc420.meeshquest.part1;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cmsc420.xml.XmlUtility;

public class MeeshQuest
{
	private static Document doc = null;
	private static Document results = null;

	public static void main(String[] args)
	{

	}

	public static void parse()
	{
		parse(System.in);
	}

	public static void parse(InputStream in)
	{
		try
		{
			doc = XmlUtility.validateNoNamespace(in);
			results = XmlUtility.getDocumentBuilder().newDocument();

			Element commandNode = doc.getDocumentElement();

			final NodeList nl = commandNode.getChildNodes();
			for (int i = 0; i < nl.getLength(); i++)
			{
				if (nl.item(i).getNodeType() == Document.ELEMENT_NODE)
				{
					commandNode = (Element) nl.item(i);
				}
			}
		}
		catch (SAXException | IOException | ParserConfigurationException e)
		{
			/* TODO: Process fatal error here */
		}
		finally
		{
			try
			{
				XmlUtility.print(results);
			}
			catch (TransformerException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private static void processCommand(Element command)
	{
		
	}
}
