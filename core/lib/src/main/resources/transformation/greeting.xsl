<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:h="http://www.cestadomu.cz/hospis/model">
	<xsl:template match="/">
        <h:greeting>
        	<h:name>x<xsl:value-of select="h:greeting/h:name"/>x</h:name>
        </h:greeting>
	</xsl:template>
</xsl:stylesheet>