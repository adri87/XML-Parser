import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Parser {
	
	public static String getTagValue(String tag, Element elemento) {
		NodeList lista = elemento.getElementsByTagName(tag).item(0).getChildNodes();
		Node valor = (Node) lista.item(0);
		return valor.getNodeValue();
	}

	
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		org.w3c.dom.Document doc = docBuilder.parse (new File("/home/adri/Documentos/Noticias TVi/contenidos_Noticias_TVi/contenidos/noticias/Envio_38_20100801_0340/RMMCUL_20100801_0340.xml"));
		((Node) doc.getDocumentElement ()).normalize ();
		System.out.println ("El elemento raíz es " + doc.getDocumentElement().getNodeName());
		System.out.println ("El elemento raíz es " + doc.getDocumentElement().getAttribute("Version"));
		NodeList listaNoticias = doc.getElementsByTagName("NewsItem");
		int totalNoticias = listaNoticias.getLength();
		System.out.println("Número total de noticias : " + totalNoticias);
		for (int i = 0; i < totalNoticias ; i ++) {
			Node noticia = listaNoticias.item(i);
			if (noticia.getNodeType() == Node.ELEMENT_NODE){
				Element elemento = (Element) noticia;
				System.out.println("Nombre : "  + getTagValue("HeadLine",elemento ));
				System.out.println(doc.getFirstChild().getNodeValue());
			}
		}
		
	}
}
