package cz.cestadomu.hospis.rest.lib.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"viewId"})
@XmlRootElement(name = "getViewX")
public class GetViewX implements Serializable {

	protected int viewId;

	public GetViewX() {}

	public GetViewX(int viewId) {
		this.viewId = viewId;
	}

	public int getViewId() {
		return viewId;
	}

	public void setViewId(int viewId) {
		this.viewId = viewId;
	}



}
