package com.aspose.doc.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aspose.doc.DocApi;
import com.aspose.doc.UnPackedDocument;
import com.aspose.doc.support.SimpleLogger;
import com.aspose.doc.utils.SaxUtils;

public class SomeSimpleTests {
	private static final SimpleLogger log = new SimpleLogger(SomeSimpleTests.class);
	
	@BeforeClass
	public static void prepare() {
		// configure log4j
		BasicConfigurator.configure();
	}
	
	@Test
	public void odtTest() throws Exception {
		UnPackedDocument document = DocApi.loadFromStream(new FileInputStream("etc/resume_007_2.odt"));
		document.getProperty().setAuthor("007");
		document.getProperty().setTitle("New title");
		document.getProperty().setSubject("New subject");
		document.getProperty().setDescription("New description");
		String [] keywords = {"123","456","789"};
		document.getProperty().setKeywords(keywords);
		document.getProperty().setCreationDate("2012-07-07T16:14:32.68");
		document.getProperty().setModifyDate("2022-07-07T09:02:00Z");
		DocApi.saveToStream(new FileOutputStream("etc/changed.odt"), document);
		log.debug("odtTest ends here");
	}
	
	@Test
	public void oxmlTest() throws Exception {
		UnPackedDocument document = DocApi.loadFromStream(new FileInputStream("etc/resume_007_2.docx"));
		document.getProperty().setAuthor("007");
		document.getProperty().setTitle("New title");
		document.getProperty().setSubject("New subject");
		document.getProperty().setDescription("New description");
		String [] keywords = {"123","456","789"};
		document.getProperty().setKeywords(keywords);
		document.getProperty().setCreationDate("2012-07-07T09:02:00Z");
		document.getProperty().setModifyDate("2022-07-07T09:02:00Z");
		DocApi.saveToStream(new FileOutputStream("etc/changed.docx"), document);
		log.debug("odtTest ends here");
	}
	
//	@Test
//	public void loadTest() throws Exception {
//		DocApi.loadFromStream(new FileInputStream("etc/resume_007_2.odt"));
//		DocApi.loadFromStream(new FileInputStream("etc/resume_007_2.docx"));
//		log.debug("loadTest ends here");
//	}
	
//	@Test
//	public void unzipZipTests() throws Exception {
//		UnPackedDocument document = FileUtils.unZip(new FileInputStream("etc/resume_007_2.odt"));
//		log.debug("unzipTest ends here");
//		FileUtils.zip(new FileOutputStream("etc/justPacked.odt"), document);
//		log.debug("zipTest ends here");
//	}
	
	@Test
	public void saxTest() throws Exception {
		byte[] data = SaxUtils.parseXml(new FileInputStream("etc/meta.xml"));
		data = SaxUtils.changeValueInXml("dc:title", "OMG, it's work!", data);
		log.debug("Must be true: %s", SaxUtils.checkElementAvailability("meta:initial-creator", data));
		log.debug("Must be false: %s", SaxUtils.checkElementAvailability("meta:neverhood", data));
		data = SaxUtils.changeValueInXml("dc:none", "It's can't be", data);
		data = SaxUtils.addElementInXml("office:meta" ,"", "", "office:my-tag", "AnyThing", data);
		data = SaxUtils.deleteValueInXml("meta:generator", data);
		new FileOutputStream("etc/newMeta.xml").write(data);
		log.debug("saxTest ends here");
	}
}
