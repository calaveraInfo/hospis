<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:diff="urn:schemas-microsoft-com:xml-diffgram-v1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:h="http://www.cestadomu.cz/hospis/model"
	xmlns:dig="http://digres.cz/">
	<xsl:template match="/">
		<h:employees>
			<xsl:apply-templates select="dig:GetViewXResponse/dig:GetViewXResult/diff:diffgram/DocumentElement/*"/>
		</h:employees>
	</xsl:template>
	<xsl:template match="WEB_x0020_zaměstnanci_x0020_pro_x0020_výkaz_x0020_práce">
		<h:id><xsl:value-of select="c0"/></h:id>
		<h:firstName><xsl:value-of select="c1"/></h:firstName>
		<h:lastName><xsl:value-of select="c2"/></h:lastName>
		<h:jobDescription><xsl:value-of select="c3"/></h:jobDescription>
	</xsl:template>
</xsl:stylesheet>