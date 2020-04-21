package kr.pe.moongwiwoo.utils.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.JAXBContextFactory;


/**
 * <pre>
 * XML 파싱
 * </pre>
 * <pre>
 * <b>History:</b>
 *    "Moon Gwi Woo", 1.0, 2020. 04. 21. 초기작성
 * </pre>
 *
 * @author "Moon Gwi Woo"
 * @version 1.0
 */
public class XmlUtils {

	/**
	 * JAXB
	 * 객체를 XMLString 으로 반환
	 * JAXB_FORMATTED_OUTPUT true
	 * JAXB_FRAGMENT false
	 * @return String
	 */
	public static <T> String parserObjToStr(T obj) throws JAXBException {
		return parserObjToStr(obj, true);
	}

	/**
	 * JAXB
	 * 객체를 XMLString 으로 반환
	 * JAXB_FRAGMENT false
	 * @return String
	 */
	public static <T> String parserObjToStr(T obj, boolean isFormat) throws JAXBException {
		return parserObjToStr(obj, isFormat, false);
	}

	/**
	 * JAXB
	 * 객체를 XMLString 으로 반환
	 * @return String
	 */
	public static <T> String parserObjToStr(T obj, boolean isFormat, boolean isFragment) throws JAXBException {

		JAXBContext jaxbContext = JAXBContextFactory.createContext(new Class[] { obj.getClass() }, null);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    StringWriter sw = new StringWriter();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, isFormat);
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, isFragment);
	    jaxbMarshaller.marshal(obj, sw);

		return sw.toString();

	}

	/**
	 * XML String을 객체로 반환
	 * @return String
	 */
	public static <T> T parserStrToObj(String xml, Class<T> clazz) throws JAXBException {

		JAXBContext jaxbContext = JAXBContextFactory.createContext(new Class[] { clazz }, null);
		Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();

		Object obj = jaxUnmarshaller.unmarshal(new StringReader(xml));

		return clazz.cast(obj);

	}
}
