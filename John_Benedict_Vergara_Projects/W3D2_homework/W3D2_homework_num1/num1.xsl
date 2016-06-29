<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>Number 1: Select Price</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th>Price</th>
    </tr>
    <xsl:for-each select="bookstore/book">
    <tr>
      <td><xsl:value-of select="price"/></td>
    </tr>
    </xsl:for-each>
  </table>

<h2>Number 2: Price > 35</h2>
    <table border="1">
    <tr bgcolor="#9acd32">
      <th>Number 2: Price > 35</th>
    </tr>
    <xsl:for-each select="bookstore/book">
    <xsl:if test="price &gt; 35">
    <tr>
      <td><xsl:value-of select="price"/></td>
    </tr>
    </xsl:if>
    </xsl:for-each>
  </table>



  
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>