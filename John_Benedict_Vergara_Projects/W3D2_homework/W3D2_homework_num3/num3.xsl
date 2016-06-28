<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xs="http://www.w3.org/2001/XMLSchema"
                exclude-result-prefixes="xs xsi xsl">
    <xsl:output method="xml" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/rpc-reply-converter-input">

<rpc-reply-converter-output>
	<dmi-specific-rpc-reply>
		<chassis-satellites>
			<chassis-satellite>
				<xsl:for-each select="device-specific-rpc-reply-list/device-specific-rpc-reply">
					<xsl:choose>
							<xsl:when test="position() = 1"> 
								<satelliteName>
									<xsl:for-each select="satellite-information/satellite">
										<xsl:value-of select="normalize-space(satellite-alias)"/>
									</xsl:for-each>
								</satelliteName>
								<slotId>
									<xsl:for-each select="satellite-information/satellite">
										<xsl:value-of select="normalize-space(slot-id)"/>
									</xsl:for-each>
								</slotId>
								<productModel>
									<xsl:for-each select="satellite-information/satellite">
										<xsl:value-of select="normalize-space(product-model)"/>
									</xsl:for-each>
								</productModel>
								<version>
									<xsl:for-each select="satellite-information/satellite">
										<xsl:value-of select="normalize-space(version)"/>
									</xsl:for-each>
								</version>
								<managementAddress>
									<xsl:for-each select="satellite-information/satellite">
										<xsl:value-of select="normalize-space(management-address)"/>
									</xsl:for-each>
								</managementAddress>
							</xsl:when>
						</xsl:choose>
					</xsl:for-each>



					<xsl:for-each select="device-specific-rpc-reply-list/device-specific-rpc-reply">
						<xsl:choose>
							<xsl:when test="position() = 2"> 
								<groupName>
									<xsl:for-each select="upgrade-group-information/upgrade-group">
										<xsl:value-of select="normalize-space(group-name)"/>
									</xsl:for-each>
								</groupName>
								<groupVersion>
									<xsl:for-each select="upgrade-group-information/upgrade-group">
										<xsl:value-of select="normalize-space(version)"/>
									</xsl:for-each>
								</groupVersion>
							</xsl:when>
						</xsl:choose>
					</xsl:for-each>

				<connectivity>
					<xsl:for-each select="device-specific-rpc-reply-list/device-specific-rpc-reply">
						<xsl:choose>
							<xsl:when test="position() = 1">
							<xsl:for-each select="satellite-information/satellite/connectivity">
								<cascadePort>
									<xsl:value-of select="normalize-space(cascade-port)"/>
								</cascadePort>
								<uplinkIntefaceName>
									<xsl:value-of select="normalize-space(uplink-interface-name)"/>
								</uplinkIntefaceName>
								<adjacencyState>
									<xsl:value-of select="normalize-space(adjacency-state)"/>
								</adjacencyState>
							</xsl:for-each>
							</xsl:when>
						</xsl:choose>
					</xsl:for-each>
				</connectivity>

			</chassis-satellite>
		</chassis-satellites>
	</dmi-specific-rpc-reply>
</rpc-reply-converter-output>


</xsl:template>
</xsl:stylesheet>