package com.aspose.doc.property;

import com.aspose.doc.utils.SaxUtils;

public class OpenXmlProperty extends PropertyStoreAdapter {

	public OpenXmlProperty(byte[] data) {
		setData(data);
	}

	@Override
	public void setAuthor(String author) {
		setPropperty("dc:creator", author);
	}

	@Override
	public void setSubject(String subject) {
		setPropperty("dc:subject", subject);
	}

	@Override
	public void setTitle(String title) {
		setPropperty("dc:title", title);
	}

	@Override
	public void setKeywords(String[] keywords) {
		String keywordsString = "";
		for (String keyword : keywords) {
			keywordsString += keyword + ";";
		}
		setPropperty("cp:keywords", keywordsString);
	}

	@Override
	public void setDescription(String description) {
		setPropperty("dc:description", description);
	}

	@Override
	public void setCreationDate(String creationDate) {
		setPropperty("dcterms:created", creationDate);
	}

	@Override
	public void setModifyDate(String modifyDate) {
		setPropperty("dcterms:modified", modifyDate);
	}

	private void setPropperty(String name, String value) {
		if (SaxUtils.checkElementAvailability(name, data)) {
			data = SaxUtils.changeValueInXml(name, value, data);
		} else {
			data = SaxUtils.addElementInXml("cp:coreProperties", "", "", name, value, data);
		}
	}
}
