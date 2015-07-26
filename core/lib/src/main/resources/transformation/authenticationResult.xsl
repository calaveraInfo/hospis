<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:h="http://www.cestadomu.cz/hospis/model" xmlns:dig="http://digres.cz/">
	<xsl:template match="/">
		<h:authenticationResult>
			<xsl:choose>
				<xsl:when test="string-length(dig:LoginResponse/dig:LoginResult/text()) > 0">
					<h:authenticated>true</h:authenticated>
					<h:token><xsl:value-of select="dig:LoginResponse/dig:LoginResult"/></h:token>
				</xsl:when>
				<xsl:otherwise>
					<h:authenticated>false</h:authenticated>
				</xsl:otherwise>
			</xsl:choose>
		</h:authenticationResult>
	</xsl:template>
</xsl:stylesheet>