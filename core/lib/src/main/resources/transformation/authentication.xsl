<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:h="http://www.cestadomu.cz/hospis/model">
	<xsl:template match="/">
        <dig:Login xmlns:dig="http://digres.cz/">
            <dig:strLoginName><xsl:value-of select="h:credentials/h:username"/></dig:strLoginName>
            <dig:strPassword><xsl:value-of select="h:credentials/h:password"/></dig:strPassword>
        </dig:Login>
	</xsl:template>
</xsl:stylesheet>