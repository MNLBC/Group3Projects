<?xml version="1.0" encoding="UTF-8"?>
<!-- Copyright (c) 2006-2007, Juniper Networks, Inc. -->
<!-- All rights reserved -->

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs xsi xsl">
	<xsl:output method="xml" encoding="UTF-8" indent="yes" />
	<xsl:template match="/rpc-reply-converter-input">
		<rpc-reply-converter-output>
			<dmi-specific-rpc-reply>
				<chassis-satellites>
					<chassis-satellite>
						
						
						<xsl:if test="device-specific-rpc-reply-list/device-specific-rpc-reply[1]">
									<xsl:for-each select="satellite-information/satellite">
										<xsl:if test="satellite-alias">
											<satelliteName>
												<xsl:value-of select="normalize-space(satellite-alias)" />
											</satelliteName>
										</xsl:if>
										<xsl:if test="slot-id">
											<slotId>
												<xsl:value-of select="normalize-space(slot-id)" />
											</slotId>
										</xsl:if>
										<xsl:if test="product-model">
											<productModel>
												<xsl:value-of select="normalize-space(product-model)" />
											</productModel>
										</xsl:if>
										<xsl:if test="version">
											<version>
												<xsl:value-of select="normalize-space(version)" />
											</version>
										</xsl:if>
										<xsl:if test="management-address">
											<managementAddress>
												<xsl:value-of select="normalize-space(management-address)" />
											</managementAddress>
										</xsl:if>
									</xsl:for-each>
								</xsl:when>
								
								<xsl:when test="position() =2 ">
									<xsl:for-each select="upgrade-group-information/upgrade-group">
										<xsl:if test="group-name">
											<groupName>
												<xsl:value-of select="normalize-space(group-name)" />
											</groupName>
										</xsl:if>
										<xsl:if test="version">
											<groupVersion>
												<xsl:value-of select="normalize-space(version)" />
											</groupVersion>
										</xsl:if>
									</xsl:for-each>
								</xsl:when>
							
						</xsl:if>
						<xsl:for-each
							select="device-specific-rpc-reply-list/device-specific-rpc-reply">
							<xsl:choose>
								<xsl:when test="position() =1 ">
									<xsl:for-each select="satellite-information/satellite">
										<xsl:if test="connectivity">
											<connectivity>
												<xsl:if test="connectivity/cascade-port">
													<cascade-port>
														<xsl:value-of select="normalize-space(connectivity/cascade-port)" />
													</cascade-port>
												</xsl:if>
												<xsl:if test="connectivity/uplink-interface-name">
													<uplink-interface-name>
														<xsl:value-of
															select="normalize-space(connectivity/uplink-interface-name)" />
													</uplink-interface-name>
												</xsl:if>
												<xsl:if test="connectivity/adjacency-state">
													<adjacencyState>
														<xsl:value-of
															select="normalize-space(connectivity/adjacency-state)" />
													</adjacencyState>
												</xsl:if>
											</connectivity>
										</xsl:if>
									</xsl:for-each>
								</xsl:when>
							</xsl:choose>
						</xsl:for-each>
						
					</chassis-satellite>
				</chassis-satellites>
			</dmi-specific-rpc-reply>
		</rpc-reply-converter-output>
	</xsl:template>
</xsl:stylesheet>