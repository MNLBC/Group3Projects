<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
>
  <xsl:output method="xml" indent="yes" />
  <xsl:template match="rpc-reply-converter-input">
    <rpc-reply-converter-input>
    <dmi-specific-rpc-reply>
    <chassis-satellites>
    <chassis-satellite>
      <xsl:for-each select="device-specific-rpc-reply-list/device-specific-rpc-reply">
        <xsl:choose>
          <xsl:when test="position()&lt;3">
            <xsl:for-each select="satellite-information/satellite">
        <satellite-name>
          <xsl:value-of select="satellite-alias"/>
        </satellite-name>
        <slotid>
          <xsl:value-of select="slot-id"/>
        </slotid>
        <product-model>
          <xsl:value-of select="product-model"/>
        </product-model>
        <version>
          <xsl:value-of select="version"/>
        </version>
        <managementAddress>
          <xsl:value-of select="management-address"/>
        </managementAddress>
        </xsl:for-each>
        <xsl:for-each select="upgrade-group-information/upgrade-group">
        <groupName><xsl:value-of select="group-name"/></groupName>
        <groupVersion><xsl:value-of select="version"/></groupVersion>
      </xsl:for-each>
                </xsl:when>
        </xsl:choose>
      </xsl:for-each>
        <connectivity>
             <xsl:for-each select="device-specific-rpc-reply-list/device-specific-rpc-reply">
        <xsl:choose>
          <xsl:when test="position()&lt;3">
            <xsl:for-each select="satellite-information/satellite/connectivity">
          <cascadePort><xsl:value-of select="cascade-port"/>
        </cascadePort>
          <uplinkIntefaceName><xsl:value-of select="uplink-interface-name"/></uplinkIntefaceName>
        <adjacencyState><xsl:value-of select="adjacency-state"/></adjacencyState>
              </xsl:for-each>
    </xsl:when>
  </xsl:choose>
</xsl:for-each>
        </connectivity>

    </chassis-satellite>
  </chassis-satellites>
</dmi-specific-rpc-reply>
</rpc-reply-converter-input>
</xsl:template>
</xsl:stylesheet>