package kr.pe.moongwiwoo.utils.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


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
	 * 객체를 XMLString 으로 반환
	 * @return String
	 */
	public static <T> String parserObjToStr(T obj) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    StringWriter sw = new StringWriter();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    jaxbMarshaller.marshal(obj, sw);

		return sw.toString();

	}

	/**
	 * XML String을 객체로 반환
	 * @return String
	 */
	public static <T> T parserStrToObj(String xml, Class<T> clazz) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
		Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();

		Object obj = jaxUnmarshaller.unmarshal(new StringReader(xml));

		return clazz.cast(obj);

	}
}
