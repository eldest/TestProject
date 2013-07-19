package com.aspose.doc;

import java.util.Map;

import com.aspose.doc.property.PropertyStoreAdapter;

public class UnPackedDocument {

	public enum DocType {
		OPEN_OFFICE_FORMAT("meta.xml"),
		OPEN_XML_FORMAT("docProps/core.xml");

		private String location;

		DocType(String name) {
			this.location = name;
		}

		public String getLocation() {
			return location;
		}
	}

	private Map<String, byte[]> entries;
	private PropertyStoreAdapter property;
	private DocType type;

	public UnPackedDocument(Map<String, byte[]> entries) {
		this.entries = entries;
	}

	public Map<String, byte[]> getEntries() {
		return entries;
	}

	public void setEntries(Map<String, byte[]> entries) {
		this.entries = entries;
	}

	public PropertyStoreAdapter getProperty() {
		return property;
	}

	public void setProperty(PropertyStoreAdapter property) {
		this.property = property;
	}

	public DocType getType() {
		return type;
	}

	public void setType(DocType type) {
		this.type = type;
	}

}
