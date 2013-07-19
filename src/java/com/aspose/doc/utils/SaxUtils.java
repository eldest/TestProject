package com.aspose.doc.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.XMLReaderFactory;

import com.aspose.doc.support.SimpleLogger;

public class SaxUtils {
	private static final SimpleLogger log = new SimpleLogger(SaxUtils.class);

	public static byte[] parseXml(InputStream inputStream) {
		return new SimpleParser().parse(inputStream);
	}

	public static byte[] parseXml(byte[] data) {
		return parseXml(new ByteArrayInputStream(data));
	}

	public static byte[] parseXml(InputStream inputStream, XMLFilter filter) {
		return new SimpleParser().parse(inputStream, filter);
	}

	public static byte[] parseXml(byte[] data, XMLFilter filter) {
		return parseXml(new ByteArrayInputStream(data), filter);
	}

	public static boolean checkElementAvailability(String checkedEllement, InputStream inputStream) {
		AvailabilityFilter filter = new AvailabilityFilter(checkedEllement);
		new SimpleParser().parse(inputStream, filter);

		return filter.isFinded();
	}

	public static boolean checkElementAvailability(String checkedEllement, byte[] data) {
		return checkElementAvailability(checkedEllement, new ByteArrayInputStream(data));
	}

	public static byte[] changeValueInXml(String qualifiedElementName, String value, byte[] data) {
		return changeValueInXml(qualifiedElementName, value, new ByteArrayInputStream(data));
	}

	public static byte[] changeValueInXml(String qualifiedElementName, String value, InputStream inputStream) {
		return new SimpleParser().parse(inputStream, new ChangeFilter(qualifiedElementName, value));
	}

	public static byte[] addElementInXml(String targetElement, String uri, String localName, String qualifiedName,
			String vallue, InputStream inputStream) {
		return new SimpleParser().parse(inputStream, new AddElementFilterIn(targetElement, uri, localName,
				qualifiedName, vallue));
	}

	public static byte[] addElementInXml(String targetElement, String uri, String localName, String qualifiedName,
			String vallue, byte[] data) {
		return addElementInXml(targetElement, uri, localName, qualifiedName, vallue, new ByteArrayInputStream(data));
	}

	public static byte[] addElementInXmlAfter(String targetElement, String uri, String localName, String qualifiedName,
			String vallue, InputStream inputStream) {
		return new SimpleParser().parse(inputStream, new AddElementFilterAfter(targetElement, uri, localName,
				qualifiedName, vallue));
	}

	public static byte[] addElementInXmlAfter(String targetElement, String uri, String localName, String qualifiedName,
			String vallue, byte[] data) {
		return addElementInXmlAfter(targetElement, uri, localName, qualifiedName, vallue,
				new ByteArrayInputStream(data));
	}

	public static byte[] addElementInXmlBefore(String targetElement, String uri, String localName,
			String qualifiedName, String vallue, InputStream inputStream) {
		return new SimpleParser().parse(inputStream, new AddElementFilterBefore(targetElement, uri, localName,
				qualifiedName, vallue));
	}

	public static byte[] addElementInXmlBefore(String targetElement, String uri, String localName,
			String qualifiedName, String vallue, byte[] data) {
		return addElementInXmlBefore(targetElement, uri, localName, qualifiedName, vallue, new ByteArrayInputStream(
				data));
	}
	
	public static byte[] deleteValueInXml(String qualifiedElementName, byte[] data) {
		return deleteValueInXml(qualifiedElementName, new ByteArrayInputStream(data));
	}

	public static byte[] deleteValueInXml(String qualifiedElementName, InputStream inputStream) {
		return new SimpleParser().parse(inputStream, new DeleteFilter(qualifiedElementName));
	}

	// ---------------------- internal classes ----------------------
	// ---------------------- parser ----------------------

	static class SimpleParser extends DefaultHandler {
		private StringBuilder builder = new StringBuilder();

		public byte[] parse(byte[] data) {
			return parse(new ByteArrayInputStream(data));
		}

		public byte[] parse(byte[] data, XMLFilter filter) {
			return parse(new ByteArrayInputStream(data), filter);
		}

		public byte[] parse(InputStream inputStream) {
			return parse(inputStream, null);
		}

		public byte[] parse(InputStream inputStream, XMLFilter filter) {
			try {
				XMLReader reader = XMLReaderFactory.createXMLReader();

				if (filter != null) {
					filter.setParent(reader);
					prepareAndStart(filter, inputStream);
				} else {
					prepareAndStart(reader, inputStream);
				}

			} catch (Throwable t) {
				log.error(t, "Got error in parse");
			}

			try {
				return builder.toString().getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				log.error(e, "Got error in parse mtehod");
				return null;
			}
		}

		@Override
		public void startDocument() {
			builder.append("<?xml version=\"1.0\" encoding=\"" + "UTF-8\"" + "?>" + "\n");
		}

		@Override
		public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
			builder.append("<" + qualifiedName);
			if (attributes != null) {
				int numberAttributes = attributes.getLength();
				for (int loopIndex = 0; loopIndex < numberAttributes; loopIndex++) {
					builder.append(' ' + attributes.getQName(loopIndex) + "=\"" + attributes.getValue(loopIndex) + '"');
				}
			}
			builder.append(">");
		}

		@Override
		public void endElement(String uri, String localName, String qualifiedName) {
			builder.append("</" + qualifiedName + ">");
		}

		@Override
		public void characters(char characters[], int start, int length) {
			String characterData = (new String(characters, start, length)).trim();
			if (characterData.indexOf("\n") < 0 && characterData.length() > 0) {
				builder.append(characterData);
			}
		}

		@Override
		public void processingInstruction(String target, String data) {
			builder.append("<?" + target);
			if (data != null && data.length() > 0) {
				builder.append(" " + data);
			}
			builder.append("?>");
		}

		@Override
		public void ignorableWhitespace(char characters[], int start, int length) {
			//characters(characters, start, length);
		}

		@Override
		public void warning(SAXParseException exception) {
			System.err.println("Warning: " + exception.getMessage());
		}

		@Override
		public void error(SAXParseException exception) {
			System.err.println("Error: " + exception.getMessage());
		}

		@Override
		public void fatalError(SAXParseException exception) {
			System.err.println("Fatal error: " + exception.getMessage());
		}

		private void prepareAndStart(XMLReader reader, InputStream inputStream) throws Exception {
			reader.setFeature("http://xml.org/sax/features/namespaces", true);
			reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);

			reader.setContentHandler(this);
			reader.setEntityResolver(this);
			reader.setErrorHandler(this);
			reader.setDTDHandler(this);

			reader.parse(new InputSource(inputStream));
		}
	}

	// ---------------------- filters ----------------------

	abstract static class AddElementFilter extends XMLFilterImpl {

		protected String target, uri, localName, qualifiedName, vallue;

		public AddElementFilter(String target, String uri, String localName, String qualifiedName, String vallue) {
			this.target = target;
			this.uri = uri;
			this.localName = localName;
			this.qualifiedName = qualifiedName;
			this.vallue = vallue;
		}
	}

	static class AddElementFilterAfter extends AddElementFilter {

		public AddElementFilterAfter(String target, String uri, String localName, String qualifiedName, String vallue) {
			super(target, uri, localName, qualifiedName, vallue);
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equals(target)) {
				super.startElement(uri, localName, qualifiedName, null);
				super.characters(vallue.toCharArray(), 0, vallue.length());
				super.endElement(uri, localName, qualifiedName);
			}
			super.endElement(uri, localName, qName);
		}
	}

	static class AddElementFilterBefore extends AddElementFilter {

		public AddElementFilterBefore(String target, String uri, String localName, String qualifiedName, String vallue) {
			super(target, uri, localName, qualifiedName, vallue);
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
			if (qName.equals(target)) {
				super.startElement(uri, localName, qualifiedName, null);
				super.characters(vallue.toCharArray(), 0, vallue.length());
				super.endElement(uri, localName, qualifiedName);
			}
			super.startElement(uri, localName, qName, atts);
		}

	}

	static class AddElementFilterIn extends AddElementFilter {

		public AddElementFilterIn(String target, String uri, String localName, String qualifiedName, String vallue) {
			super(target, uri, localName, qualifiedName, vallue);
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
			if (qName.equals(target)) {
				super.startElement(uri, localName, qName, atts);

				super.startElement(uri, localName, qualifiedName, null);
				super.characters(vallue.toCharArray(), 0, vallue.length());
				super.endElement(uri, localName, qualifiedName);
			} else
				super.startElement(uri, localName, qName, atts);
		}
	}

	static class ChangeFilter extends XMLFilterImpl {

		String currentEllement, currentVallue, necessaryEllement, newVallue;

		public ChangeFilter(String necessaryEllement, String newVallue) {
			this.necessaryEllement = necessaryEllement;
			this.newVallue = newVallue;
		}

		@Override
		public void startElement(String uri, String localName, String qualifiedName, Attributes atts)
				throws SAXException {
			currentEllement = qualifiedName;
			super.startElement(uri, localName, qualifiedName, atts);
		}

		@Override
		public void characters(char[] characters, int start, int length) throws SAXException {
			currentVallue = (new String(characters, start, length)).trim();
			if (currentEllement.equals(necessaryEllement)) {
				super.characters(newVallue.toCharArray(), 0, newVallue.length());
			} else
				super.characters(characters, start, length);
		}

	}

	static class AvailabilityFilter extends XMLFilterImpl {
		private boolean finded = false;
		String checkedEllement;

		public AvailabilityFilter(String checkedEllement) {
			this.checkedEllement = checkedEllement;
		}

		public boolean isFinded() {
			return finded;
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
			if (qName.equals(checkedEllement)) {
				finded = true;
			}

			super.startElement(uri, localName, qName, atts);
		}
	}

	static class DeleteFilter extends XMLFilterImpl {

		String currentEllement, necessaryEllement;

		public DeleteFilter(String necessaryEllement) {
			this.necessaryEllement = necessaryEllement;
		}

		@Override
		public void startElement(String uri, String localName, String qualifiedName, Attributes atts)
				throws SAXException {
			if (!qualifiedName.equals(necessaryEllement))
				super.startElement(uri, localName, qualifiedName, atts);
			else currentEllement = qualifiedName;
		}

		@Override
		public void characters(char[] characters, int start, int length) throws SAXException {
			if (currentEllement == null)
				super.characters(characters, start, length);
			else currentEllement = null;
		}

		@Override
		public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
			if (!qualifiedName.equals(necessaryEllement))
				super.endElement(uri, localName, qualifiedName);
		}

	}
}
