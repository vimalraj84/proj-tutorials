package com.bilqu.utils;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class XmlSchemaValidator {

    public static void main(String[] a){
        File ipDir = new File("C:/Mule/payload/1094B_files");
        String schemaSource = "C:\\WS_MULE_2019_03_02\\newheights-uber\\newheights-esb\\irsairsubmissionclientflows\\src\\main\\resources\\ty18\\MSG\\IRS-Form1094-1095BTransmitterUpstreamMessage.xsd";

        Arrays.stream(ipDir.listFiles()).parallel()
                .filter(f -> f.isFile())
                .filter(f1 -> !f1.getName().contains("BB0XP"))
                .filter(file -> ! validateSchema(file,schemaSource))
                .forEach(of -> System.out.format(" -> %s -> %s \n",of.getName(),new Date(of.lastModified()).toString()));
    }


    public static boolean validateSchema(File xmlFileLoc, String SchemaLocation) {
        boolean result = false;
        try{
            Source schemaSource = new StreamSource(SchemaLocation);
            Source xmlFile = new StreamSource(xmlFileLoc);
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(schemaSource);
            javax.xml.validation.Validator validator = schema.newValidator();
            final List<SAXParseException> list = new ArrayList<>();
            validator.setErrorHandler(new ErrorHandler() {

                @Override
                public void warning(SAXParseException arg0) throws SAXException {
                    list.add(arg0);
                }

                @Override
                public void fatalError(SAXParseException arg0) throws SAXException {
                    // TODO Auto-generated method stub

                }

                @Override
                public void error(SAXParseException arg0) throws SAXException {
                    list.add(arg0);
                }
            });
            validator.validate(xmlFile);
            if(!list.isEmpty() &&  list.size()>1){
                StringBuilder builderString = new StringBuilder();
                for(SAXParseException exc : list) {
                    builderString = builderString.append("Line no. : " +exc.getLineNumber()+" : "+exc.getMessage());
                }
                throw new SAXException(builderString.toString());
            }
        } catch (SAXException e) {
//            e.printStackTrace();
            System.err.print(e.getMessage());
            return false;
        } catch (IOException e) {
//            e.printStackTrace();
            System.err.print(e.getMessage());
            return false;
        }
        return true;
    }


}
