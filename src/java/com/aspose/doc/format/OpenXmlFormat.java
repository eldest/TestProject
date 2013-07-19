package com.aspose.doc.format;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import com.aspose.doc.property.PropertyStore;

/** @see http://msdn.microsoft.com/en-us/library/bb447589.aspx */
@Root(name = "coreProperties")
@NamespaceList( {
		@Namespace(reference = "http://schemas.openxmlformats.org/package/2006/metadata/core-properties", prefix = "cp"),
		@Namespace(reference = "http://purl.org/dc/elements/1.1/", prefix = "dc"),
		@Namespace(reference = "http://purl.org/dc/terms/", prefix = "dcterms"),
		@Namespace(reference = "http://purl.org/dc/dcmitype/", prefix = "dcmitype"),
		@Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi") })
public class OpenXmlFormat implements PropertyStore {
	
	@Element(required = false)
	@Namespace(reference = "http://purl.org/dc/elements/1.1/")
	private String title;

	@Element(required = false)
	@Namespace(reference = "http://purl.org/dc/elements/1.1/")
	private String subject;

	@Element(required = false)
	@Namespace(reference = "http://purl.org/dc/elements/1.1/")
	private String creator;

	@Element(required = false)
	@Namespace(reference = "http://schemas.openxmlformats.org/package/2006/metadata/core-properties")
	private String keywords;

	@Element(required = false)
	@Namespace(reference = "http://purl.org/dc/elements/1.1/")
	private String description;

	@Element(required = false)
	@Namespace(reference = "http://schemas.openxmlformats.org/package/2006/metadata/core-properties")
	private String lastModifiedBy;

	@Element(required = false)
	@Namespace(reference = "http://schemas.openxmlformats.org/package/2006/metadata/core-properties")
	private String revision;

	@Element(required = false)
	@Namespace(reference = "http://purl.org/dc/elements/1.1/")
	private String created;

	@Element(required = false)
	@Namespace(reference = "http://purl.org/dc/terms/")
	private String modified;

	@Element(required = false)
	@Namespace(reference = "http://purl.org/dc/terms/")
	private String contentType;

	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public void setAuthor(String author) {
		setCreator(author);
		
	}

	@Override
	public void setCreationDate(String creationDate) {
		setCreated(creationDate);		
	}

	@Override
	public void setKeywords(String[] keywords) {
		setKeywords(keywords);	
	}

	@Override
	public void setModifyDate(String modifyDate) {
		setModified(modifyDate);
	}

}
