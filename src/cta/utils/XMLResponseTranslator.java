package cta.utils;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class XMLResponseTranslator {
	
	public static void parse(File inputFile) {
		
		try {	
						
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile); // DOM Document object
			
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getDocumentElement().getChildNodes();
			for (int i = 0; i < nList.getLength(); i++) {
				
				Node nNode = nList.item(i);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element eElement = (Element) nNode;
					System.out.println("\tValue: " + eElement.getTextContent());					
					/*
					System.out.println("First Name : " 
							+ eElement
							.getElementsByTagName("firstname")
							.item(0)
							.getTextContent());
					*/
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://lapi.transitchicago.com/api/1.0/ttarrivals.aspx?key=5ae04ab42f7a408f9f1e9f7361273b68&mapid=40380&max=5");
		File input = DataClient.sendAPIQuery(url);
		XMLResponseTranslator.parse(input);
	}
}
