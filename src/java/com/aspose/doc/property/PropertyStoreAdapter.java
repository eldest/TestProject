package com.aspose.doc.property;

public abstract class PropertyStoreAdapter implements PropertyStore {

	protected byte[] data;

	public void setData(byte[] data) {
		this.data = data;
	}

	public byte[] getData() {
		return data;
	}
	
}
