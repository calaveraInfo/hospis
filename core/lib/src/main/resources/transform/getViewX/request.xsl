<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:h="http://www.cestadomu.cz/hospis/model"
	xmlns:dig="http://digres.cz/">
	<xsl:param name="token"></xsl:param>
	<xsl:template match="/">
		<dig:GetViewX>
			<dig:strAuthKey><xsl:value-of select="$token"/></dig:strAuthKey>
			<dig:nViewID><xsl:value-of select="h:getViewX/h:viewId"/></dig:nViewID>
			<dig:strLanguage>CS</dig:strLanguage>
		</dig:GetViewX>
	</xsl:template>
</xsl:stylesheet>