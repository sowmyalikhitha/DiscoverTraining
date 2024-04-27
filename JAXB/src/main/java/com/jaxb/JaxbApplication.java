package com.jaxb;

import java.io.File;
import java.io.StringWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.jaxb.entity.productEntity;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;


@SpringBootApplication
public class JaxbApplication {

	 public static void main(String[] args) throws JAXBException {
		 
		 productEntity product = new productEntity(1L, "Iphone", 20000, "phone", "apple");
	        
		 JAXBContext context = JAXBContext.newInstance(productEntity.class);
		    Marshaller marshaller= context.createMarshaller();
		    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		   // marshaller.marshal(product, new File("./marshaller.xml"));
		    
		    System.out.println("after marshalling");
		    StringWriter stringWriter = new StringWriter();
	        marshaller.marshal(product, stringWriter);
	        String xmlOutput = stringWriter.toString();
	        System.out.println(xmlOutput);

		    
		    Unmarshaller unmarshaller = context.createUnmarshaller();
		    productEntity productentity = (productEntity) unmarshaller.unmarshal(new File("./marshaller.xml"));
		    System.out.println("after unmarshalling");
		    System.out.println(productentity);
	 }
}
