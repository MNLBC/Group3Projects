<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>My Bookstore All Prices</h2>
  <table border="1">
    <tr>
      <th>Price</th>
    </tr>
    <xsl:for-each select="bookstore/book">
    <tr>
    <td><xsl:value-of select="price"/></td>
    </tr>
    </xsl:for-each>
  </table>

   <h2>My Bookstore Prices Greater than 35</h2>
  <table border="1">
    <tr>
      <th>Price</th>
    </tr>
    <xsl:for-each select="bookstore/book">
    <tr>
      <xsl:if test="price>35">
    <td><xsl:value-of select="price"/></td>
    </xsl:if>
    </tr>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>