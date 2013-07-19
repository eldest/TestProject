package com.aspose.doc.format;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import com.aspose.doc.property.PropertyStore;

/**
 * @see http://docs.oasis-open.org/office/v1.1/OS/OpenDocument-v1.1-html/OpenDocument
 *      -v1.1.html#3.Metadata%20Elements|outline
 */
@Root(name = "document-meta")
@NamespaceList( { @Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:office:1.0", prefix = "office"),
		@Namespace(reference = "http://www.w3.org/1999/xlink", prefix = "xlink"),
		@Namespace(reference = "http://purl.org/dc/elements/1.1/", prefix = "dc"),
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0", prefix = "meta"),
		@Namespace(reference = "http://openoffice.org/2004/office", prefix = "ooo"),
		@Namespace(reference = "http://www.w3.org/2003/g/data-view#", prefix = "grddl") })
public class OpenDocumentFormat implements PropertyStore {
	
	@Attribute(required = false)
	@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:office:1.0")
	private String version;

	@Attribute(required = false)
	@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:office:1.0")
	private String transformation;
	
	@Element
	@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
	private Meta meta;

	public Meta getMeta() {
		return meta;
	}
	
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTransformation() {
		return transformation;
	}

	public void setTransformation(String transformation) {
		this.transformation = transformation;
	}
	
	// Meta structure
	@Root
	@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
	public static class Meta {
		@Element(required = false)
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		private String generator;

		@Element(required = false)
		@Namespace(reference = "http://purl.org/dc/elements/1.1/")
		private String title;

		@Element(required = false)
		@Namespace(reference = "http://purl.org/dc/elements/1.1/")
		private String description;

		@Element(required = false)
		@Namespace(reference = "http://purl.org/dc/elements/1.1/")
		private String subject;

		@ElementList(required = false, inline = true)
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		private List<Keyword> keywords;

		@Element(required = false, name = "initial-creator")
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		private String initialCreator;

		@Element(required = false)
		@Namespace(reference = "http://purl.org/dc/elements/1.1/")
		private String creator;

		@Element(required = false, name = "printed-by")
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		private String printedBy;

		@Element(required = false, name = "creation-date")
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		private String creationDate;

		@Element(required = false)
		@Namespace(reference = "http://purl.org/dc/elements/1.1/")
		private String date;

		@Element(required = false, name = "print-date")
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		private String printDate;

		@Element(required = false)
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		private Template template;

		// I'm tired here =(
		// ... so something miss now...

		@Element(required = false, name = "editing-cycles")
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		private String editingCycles;
		
		@Element(required = false, name = "editing-duration")
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		private String editingDuration;
		
		@Element(required = false, name = "document-statistic")
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		private DocumentStatistic documentStatistic;

		
		public String getGenerator() {
			return generator;
		}

		public void setGenerator(String generator) {
			this.generator = generator;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public List<Keyword> getKeywords() {
			return keywords != null ? keywords : new ArrayList<Keyword>();
		}

		public void setKeywords(List<Keyword> keywords) {
			this.keywords = keywords;
		}

		public String getInitialCreator() {
			return initialCreator;
		}

		public void setInitialCreator(String initialCreator) {
			this.initialCreator = initialCreator;
		}

		public String getCreator() {
			return creator;
		}

		public void setCreator(String creator) {
			this.creator = creator;
		}

		public String getPrintedBy() {
			return printedBy;
		}

		public void setPrintedBy(String printedBy) {
			this.printedBy = printedBy;
		}

		public String getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(String creationDate) {
			this.creationDate = creationDate;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getPrintDate() {
			return printDate;
		}

		public void setPrintDate(String printDate) {
			this.printDate = printDate;
		}

		public Template getTemplate() {
			return template;
		}

		public void setTemplate(Template template) {
			this.template = template;
		}
		
		public String getEditingCycles() {
			return editingCycles;
		}
		
		public void setEditingCycles(String editingCycles) {
			this.editingCycles = editingCycles;
		}
		
		public String getEditingDuration() {
			return editingDuration;
		}
		
		public void setEditingDuration(String editingDuration) {
			this.editingDuration = editingDuration;
		}
		
		public DocumentStatistic getDocumentStatistic() {
			return documentStatistic;
		}
		
		public void setDocumentStatistic(DocumentStatistic documentStatistic) {
			this.documentStatistic = documentStatistic;
		}
	}

	// Keyword structure
	@Root
	@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
	public static class Keyword {

		@Attribute
		private String name;

		public Keyword(String name) {
			this.name = name;
		}
		
		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	// Template structure
	@Root
	@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
	public static class Template {

		@Element(required = false)
		@Namespace(reference = "http://www.w3.org/1999/xlink")
		private String href;

		@Element(required = false)
		@Namespace(reference = "http://www.w3.org/1999/xlink")
		private String title;

		@Element(required = false)
		@Namespace(reference = "http://www.w3.org/1999/xlink")
		private String date;

		public void setHref(String href) {
			this.href = href;
		}

		public String getHref() {
			return href;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getTitle() {
			return title;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getDate() {
			return date;
		}
	}
	
	@Root
	@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
	public static class DocumentStatistic {
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="page-count", required = false)
		private int page;
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="table-count", required = false)
		private int table;
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="draw-count", required = false)
		private int draw;
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="image-count", required = false)
		private int image;
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="object-count", required = false)
		private int object;
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="ole-object-count", required = false)
		private int oleObject;
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="paragraph-count", required = false)
		private int paragraph;
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="word-count", required = false)
		private int word;
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="character-count", required = false)
		private int character;
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="row-count", required = false)
		private int row;
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="frame-count", required = false)
		private int frame;
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="sentence-count", required = false)
		private int sentence;
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="syllable-count", required = false)
		private int syllable;
		
		@Namespace(reference = "urn:oasis:names:tc:opendocument:xmlns:meta:1.0")
		@Attribute(name="non-whitespace-character-count", required = false)
		private int nonWhitespaceCharacter;

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public int getTable() {
			return table;
		}

		public void setTable(int table) {
			this.table = table;
		}

		public int getDraw() {
			return draw;
		}

		public void setDraw(int draw) {
			this.draw = draw;
		}

		public int getImage() {
			return image;
		}

		public void setImage(int image) {
			this.image = image;
		}

		public int getObject() {
			return object;
		}

		public void setObject(int object) {
			this.object = object;
		}

		public int getOleObject() {
			return oleObject;
		}

		public void setOleObject(int oleObject) {
			this.oleObject = oleObject;
		}

		public int getParagraph() {
			return paragraph;
		}

		public void setParagraph(int paragraph) {
			this.paragraph = paragraph;
		}

		public int getWord() {
			return word;
		}

		public void setWord(int word) {
			this.word = word;
		}

		public int getCharacter() {
			return character;
		}

		public void setCharacter(int character) {
			this.character = character;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getFrame() {
			return frame;
		}

		public void setFrame(int frame) {
			this.frame = frame;
		}

		public int getSentence() {
			return sentence;
		}

		public void setSentence(int sentence) {
			this.sentence = sentence;
		}

		public int getSyllable() {
			return syllable;
		}

		public void setSyllable(int syllable) {
			this.syllable = syllable;
		}

		public int getNonWhitespaceCharacter() {
			return nonWhitespaceCharacter;
		}

		public void setNonWhitespaceCharacter(int nonWhitespaceCharacter) {
			this.nonWhitespaceCharacter = nonWhitespaceCharacter;
		}
		
	}

	@Override
	public void setAuthor(String author) {
		getMeta().setInitialCreator(author);
	}

	@Override
	public void setCreationDate(String creationDate) {
		getMeta().setCreationDate(creationDate);
	}

	@Override
	public void setKeywords(String[] keywords) {	
		for (String string : keywords) {
			getMeta().getKeywords().add(new Keyword(string));
		}
	}

	@Override
	public void setModifyDate(String modifyDate) {
		getMeta().setDate(modifyDate);
	}

	@Override
	public void setSubject(String subject) {
		getMeta().setSubject(subject);
	}

	@Override
	public void setTitle(String title) {
		getMeta().setTitle(title);
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}
}
