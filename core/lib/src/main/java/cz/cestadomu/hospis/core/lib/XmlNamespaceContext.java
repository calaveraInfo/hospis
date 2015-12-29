package cz.cestadomu.hospis.core.lib;

import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;

import cz.cestadomu.hospis.model.Schema;

public class XmlNamespaceContext implements NamespaceContext {

	public static final String DIGRES_NAMESPACE = "http://digres.cz/";
	public static final String DIFF_NAMESPACE = "urn:schemas-microsoft-com:xml-diffgram-v1";
	public static final String DIG = "dig";
	public static final String DIFF = "diff";
	public static final String H = "h";

	@Override
	public String getNamespaceURI(String prefix) {
		return H.equalsIgnoreCase(prefix) ? Schema.NAMESPACE
				: DIFF.equalsIgnoreCase(prefix) ? DIFF_NAMESPACE
						: DIG.equalsIgnoreCase(prefix) ? DIGRES_NAMESPACE : null;
	}

	@Override
	public String getPrefix(String namespaceURI) {
		throw new UnsupportedOperationException(
				"Current state of implementation supports namespaces only for XPath needs.");
	}

	@Override
	public Iterator getPrefixes(String namespaceURI) {
		throw new UnsupportedOperationException(
				"Current state of implementation supports namespaces only for XPath needs.");
	}

}
