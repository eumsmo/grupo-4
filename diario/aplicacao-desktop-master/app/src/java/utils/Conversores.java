package utils;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

import java.io.StringWriter;

public class Conversores {

	public static String converterDocumentEmXMLString(Document doc) throws TransformerException {
		DOMSource dom = new DOMSource(doc);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformador = tf.newTransformer();

		transformador.setOutputProperty(OutputKeys.METHOD, "xml");
		transformador.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformador.setOutputProperty(OutputKeys.INDENT, "yes");
		transformador.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

		StringWriter escreveLinhas = new StringWriter();
		StreamResult resultado = new StreamResult(escreveLinhas);

		transformador.transform(dom, resultado);
		return escreveLinhas.toString();
	}

}
