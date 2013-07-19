package com.aspose.doc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;

import com.aspose.doc.UnPackedDocument.DocType;
import com.aspose.doc.property.OpenDocumentProperty;
import com.aspose.doc.property.OpenXmlProperty;
import com.aspose.doc.support.SimpleLogger;
import com.aspose.doc.utils.FileUtils;
import com.aspose.doc.utils.SaxUtils;

public class DocApi {
	private static final SimpleLogger log = new SimpleLogger(DocApi.class);

	//	public static final String OPEN_OFFICE_FORMAT = "meta.xml";
	//	public static final String OPEN_XML_FORMAT = "docProps/core.xml";

	public static UnPackedDocument loadFromStream(InputStream inputStream) throws Exception {
		Map<String, byte[]> entries = FileUtils.unZip(inputStream);
		UnPackedDocument document = new UnPackedDocument(entries); 

		if (entries.containsKey(DocType.OPEN_OFFICE_FORMAT.getLocation())) {
			log.debug("This is OpenOffice format");
			document.setType(DocType.OPEN_OFFICE_FORMAT);
			document.setProperty(
					new OpenDocumentProperty(
							SaxUtils.parseXml(
									entries.get(DocType.OPEN_OFFICE_FORMAT.getLocation()))));

		} else if (entries.containsKey(DocType.OPEN_XML_FORMAT.getLocation())) {
			log.debug("This is OpenXml format");
			document.setType(DocType.OPEN_XML_FORMAT);
			document.setProperty(
					new OpenXmlProperty(
							SaxUtils.parseXml(
									entries.get(DocType.OPEN_XML_FORMAT.getLocation()))));
			
		} else {
			log.warn("Uncnown format");
			return null;
		}

		return document;
	}

	public static void saveToStream(FileOutputStream fileOutputStream, UnPackedDocument document) throws Exception {
		document.getEntries().put(document.getType().getLocation(), document.getProperty().getData());
		FileUtils.zip(fileOutputStream, document.getEntries());
	}

}
