package kr.co.tmon.social.api.controller.util;

import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;

/**
 * @author 정승현 - RASPILLA16@tmon.co.kr
 * 
 */
public class ResponseEntityUtil {

	public static ResponseEntity<String> getXmlResponseEntity(Object jaxbObject) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(jaxbObject.getClass());
		Marshaller marshaller = jaxbContext.createMarshaller();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		marshaller.marshal(jaxbObject, byteArrayOutputStream);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/xml; charset=utf-8");

		return new ResponseEntity<String>(byteArrayOutputStream.toString(), headers, HttpStatus.OK);
	}

	public static ResponseEntity<String> getJsonResponseEntity(Object object) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");

		return new ResponseEntity<String>(new Gson().toJson(object), headers, HttpStatus.OK);
	}

}
