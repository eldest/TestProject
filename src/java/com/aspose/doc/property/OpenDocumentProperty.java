package com.aspose.doc.property;

import com.aspose.doc.utils.SaxUtils;

public class OpenDocumentProperty extends PropertyStoreAdapter {

	public OpenDocumentProperty(byte[] data) {
		setData(data);
	}
	
	@Override
	public void setAuthor(String author) {
		setPropperty("meta:initial-creator", author);
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
//		System.err.println("Not realized right now");
		
		String tag = "meta:keyword";
		
		while (SaxUtils.checkElementAvailability(tag, data)) {
			SaxUtils.deleteValueInXml(tag, data);
		}
		
		for (String keyword : keywords) {
			data = SaxUtils.addElementInXml("office:meta", "", "", tag, keyword, data);
		}
	}
	
	@Override
	public void setDescription(String description) {
		setPropperty("dc:description", description);
	}
	
	@Override
	public void setCreationDate(String creationDate) {
		setPropperty("meta:creation-date", creationDate);
	}	

	@Override
	public void setModifyDate(String modifyDate) {
		setPropperty("dc:date", modifyDate);
	}


	private void setPropperty(String name, String value) {
		if (SaxUtils.checkElementAvailability(name, data)) {
			data = SaxUtils.changeValueInXml(name, value, data);
		} else {
			data = SaxUtils.addElementInXml("office:meta", "", "", name, value, data);
		}
	}	
}
