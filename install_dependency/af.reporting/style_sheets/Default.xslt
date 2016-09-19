﻿<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="message">
    <xsl:choose>
      <xsl:when test ="@level = 'VALIDATION-FAILED'">
        <tr class="validation failed" valign="top">
          <td width="159">
            <span class="failed">
              <xsl:value-of select ="./@time"/>
            </span>
          </td>
          <td width="119">
            <span class="failed">
              VALIDATION FAILURE
            </span>
          </td>
          <td width="688">
            <span class="failed">
              <xsl:copy-of select ="."/>
            </span>
          </td>
        </tr>
      </xsl:when>
      <xsl:when test ="@level = 'VALIDATION-SUCCESSFUL'">
        <tr class="validation success" valign="top">
          <td width="159">
            <span class="success">
              <xsl:value-of select ="./@time"/>
            </span>
          </td>
          <td width="119">
            <span class="success">
              VALIDATION SUCCESS
            </span>
          </td>
          <td width="688">
            <span class="success">
              <xsl:copy-of select ="."/>
            </span>
          </td>
        </tr>
      </xsl:when>
      <xsl:when test ="@level = 'VERBOSE'">
        <tr class="verbose" valign="top">
          <td width="159">
            <span class="metadata">
              <xsl:value-of select ="./@time"/>
            </span>
          </td>
          <td width="119">
            <span class="metadata">
              <xsl:value-of select ="./@level"/>
            </span>
          </td>
          <td width="688">
            <span class="metadata">
              <xsl:copy-of select ="."/>
            </span>
          </td>
        </tr>
      </xsl:when>
      <xsl:when test ="@level = 'WARNING'">
        <tr class="warning" valign="top">
          <td width="159">
            <span class="metadata">
              <xsl:value-of select ="./@time"/>
            </span>
          </td>
          <td width="119">
            <span class="metadata">
              <xsl:value-of select ="./@level"/>
            </span>
          </td>
          <td width="688">
            <span class="metadata">
              <xsl:copy-of select ="."/>
            </span>
          </td>
        </tr>
      </xsl:when>
      <xsl:when test ="@level = 'ERROR'">
        <tr class="error failed" valign="top">
          <td width="159">
            <span class="failed">
              <xsl:value-of select ="./@time"/>
            </span>
          </td>
          <td width="119">
            <span class="failed">
              <xsl:value-of select ="./@level"/>
            </span>
          </td>
          <td width="688">
            <span class="failed">
              <xsl:copy-of select ="."/>
            </span>
          </td>
        </tr>
      </xsl:when>
      <xsl:when test ="@level = 'SUCCESS'">
        <tr class="testresult success" valign="top">
          <td width="159">
            <span class="success">
              <xsl:value-of select ="./@time"/>
            </span>
          </td>
          <td width="119">
            <span class="success">
              <xsl:value-of select ="./@level"/>
            </span>
          </td>
          <td width="688">
            <span class="success">
              <xsl:copy-of select ="."/>
            </span>
          </td>
        </tr>
      </xsl:when>
      <xsl:when test ="@level = 'FAILURE'">
        <tr class="testresult failed" valign="top" id = "failureId">
          <td width="159">
            <span class="failed">
              <xsl:value-of select ="./@time"/>
            </span>
          </td>
          <td width="119">
            <span class="failed">
              <xsl:value-of select ="./@level"/>
            </span>
          </td>
          <td width="688">
            <span class="failed">
              <xsl:copy-of select ="."/>
            </span>
          </td>
        </tr>
      </xsl:when>
      <xsl:otherwise>
        <tr class="info" valign="top">
          <td width="159">
            <span class="metadata">
              <xsl:value-of select ="./@time"/>
            </span>
          </td>
          <td width="119">
            <span class="metadata">
              <xsl:value-of select ="./@level"/>
            </span>
          </td>
          <td width="688">
            <xsl:choose>
              <xsl:when test="a">
                <xsl:apply-templates select="a"/>
              </xsl:when>
              <xsl:otherwise>
                <span class="metadata">
                  <xsl:copy-of select="."/>
                </span>
              </xsl:otherwise>
            </xsl:choose>
          </td>
        </tr>
      </xsl:otherwise>
    </xsl:choose>

  </xsl:template>
  <xsl:template match="/report">
    <html>
      <head>
        <title>
          <xsl:value-of select ="/report/@title"/>
        </title>
        <style type="text/css">
          * {
          margin: 0;
          padding: 0;
          font-family: Arial, Helvetica, sans-serif;
          }
          .container {
          position: relative;
          width: 1024px;
          height: 100%;
          margin: 0 auto;
          padding-bottom: 104px;
          }
          .header {
          height: 37px;
          padding: 28px 25px 19px 30px;
          border-bottom: 6px solid rgb(42,120,175);
          }
          .header img#ss_logo {
          float: left;
          margin-right: 10px;
          }
          .header p {
          float: left;
          margin-top: 11px;
          padding-left: 10px;
          border-left: 1px solid #666666;
          font-size: 15px;
          line-height: 16px;
          color: rgb(51,51,51);
          }
          .header img#abiliton_logo {
          float: right;
          margin-top: 1px;
          }
          .content {
          width: 970px;
          margin-left: 30px;
          }
          .content span {
          display: block;
          }
          .content span.main-h {
          margin: 23px 0 32px;
          font-size: 18px;
          line-height: 13px;
          color: rgb(136,136,136);
          }
          .content span.summary {
          font-size: 13px;
          font-weight: bold;
          line-height: 10px;
          color: rgb(17,17,17);
          }
          .content .sum-inform {
          margin: 8px 0 0 10px;
          }
          .content span.inform-name, .content span.inform-res {
          font-size: 13px;
          font-weight: bold;
          line-height: 24px;
          color: rgb(68,68,68);
          }
          .content span.inform-res {
          padding-left: 20px;
          font-weight: normal;
          }
          .content span.failed-up {
          display: inline-block;
          font-weight: bold;
          text-transform: uppercase;
          color: rgb(255,82,82);
          }
          .content span.tests {
          float: left;
          margin: 38px 0 12px;
          }
          .content span.view-ll {
          margin-top: 45px;
          }
          .content form#view-log-level {
          float: left;
          margin-top: 41px;
          }
          .content form#view-log-level input.checkbox {
          display: none;
          }
          .content form#view-log-level label.tocheckbox {
          display: block;
          float: left;
          height: 18px;
          margin-left: 30px;
          padding-left: 30px;
          background: url('data:image/jpg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAABGAAD/4QMraHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjMtYzAxMSA2Ni4xNDU2NjEsIDIwMTIvMDIvMDYtMTQ6NTY6MjcgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDUzYgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjIyREZENDY2OTE5ODExRTNCN0MxODk1RjIzMzE5RDFFIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjIyREZENDY3OTE5ODExRTNCN0MxODk1RjIzMzE5RDFFIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6MjI4N0ExMDU5MTk4MTFFM0I3QzE4OTVGMjMzMTlEMUUiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6MjI4N0ExMDY5MTk4MTFFM0I3QzE4OTVGMjMzMTlEMUUiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7/7gAOQWRvYmUAZMAAAAAB/9sAhAAEAwMDAwMEAwMEBgQDBAYHBQQEBQcIBgYHBgYICggJCQkJCAoKDAwMDAwKDAwNDQwMEREREREUFBQUFBQUFBQUAQQFBQgHCA8KCg8UDg4OFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBT/wAARCAASABIDAREAAhEBAxEB/8QAawAAAgMBAAAAAAAAAAAAAAAAAwUEBgcIAQEAAAAAAAAAAAAAAAAAAAAAEAAABAMDCAsAAAAAAAAAAAAAAQIDBDQFETEy8GFiM1MUlDZS0mOzdBU1VYWW1hEBAAAAAAAAAAAAAAAAAAAAAP/aAAwDAQACEQMRAD8A7fotFo8RR6e+/T4Z192GZW66tltS1LU2kzUozTaZmd5gJ3kFB9rhOHa6oCj7tDbFHMu5YSldjdq9DDmAXigeg0vwkP3SQDEBnf60AKGlmeZcCZKVuLU9n0NGwAX7aAV8bO5fIAP/2Q==') left center no-repeat;
          font-size: 13px;
          line-height: 18px;
          color:rgb(96,96,96);
          }
          .content form#view-log-level label#first-l {
          margin-left: 20px;
          }
          .content form#view-log-level input[type="checkbox"]:checked + label {
          background: url('data:image/jpg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAABGAAD/4QMraHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjMtYzAxMSA2Ni4xNDU2NjEsIDIwMTIvMDIvMDYtMTQ6NTY6MjcgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDUzYgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjNGQzEyMkM4OTE5ODExRTNCNjgzQThBMjU3NDdGREE3IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjNGQzEyMkM5OTE5ODExRTNCNjgzQThBMjU3NDdGREE3Ij4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6M0Y4MTMyQjE5MTk4MTFFM0I2ODNBOEEyNTc0N0ZEQTciIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6M0Y4MTMyQjI5MTk4MTFFM0I2ODNBOEEyNTc0N0ZEQTciLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7/7gAOQWRvYmUAZMAAAAAB/9sAhAAEAwMDAwMEAwMEBgQDBAYHBQQEBQcIBgYHBgYICggJCQkJCAoKDAwMDAwKDAwNDQwMEREREREUFBQUFBQUFBQUAQQFBQgHCA8KCg8UDg4OFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBT/wAARCAASABIDAREAAhEBAxEB/8QAbgAAAgMBAAAAAAAAAAAAAAAAAwUCBAYIAQEAAAAAAAAAAAAAAAAAAAAAEAABAwICBQgLAAAAAAAAAAABAgMEBQYAETESMjM08CFBYWJTFDZRgSJCUmOUhZbWBxEBAAAAAAAAAAAAAAAAAAAAAP/aAAwDAQACEQMRAD8A7dotIokik09x+BFdlOxWXXVLZbU4orQCVKJGZzPScAjNZtqZdybQt+hQ6pKie3X5aUNNx6e37qVKDa9d5R5g0nr1iMsBT8NG7lHmXwWyOF7nRu+xs9WAjc/87F6WzRJ1IqDlDu2BDYFPrUZS23A0ptOuy4WylRbVnnp5j6wQ09jWVSrDt9mh0sFagS7NmL3smSsDXdWfScsgOgZDAZ/9twAo3DM+ZdhPBcLoG5+X8HZywBfy3AK/reN5fcMB/9k=') left center no-repeat;
          }
          table.data-tests, table.data-tests th, table.data-tests td {
          border: 1px solid #d5d5d5;
          }
          table.data-tests {
          clear: both;
          border-bottom: 0;
          border-left: 0;
          }
          table.data-tests td, table.data-tests th {
          border-top: 0;
          border-right: 0;
          }
          .content tr.t-caption {
          background: rgb(238,238,238);
          }
          .content span.t-caption {
          min-height: 35px;
          padding-left: 10px;
          font-size: 11px;
          font-weight: bold;
          text-transform: uppercase;
          text-align: left;
          line-height: 35px;
          color: rgb(95,95,95);
          }
          .content span.metadata {
          min-height: 18px;
          padding: 6px 0 6px 10px;
          font-size: 13px;
          line-height: 18px;
          color: rgb(68,68,68);
          }
          .content span.image {
          position: relative;
          float: left;
          margin: 10px;
          }
          .content span.image a.zoom {
          position: absolute;
          bottom: 0;
          right: 0;
          width: 22px;
          height: 22px;
          background: url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABYAAAAWCAYAAADEtGw7AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAwdJREFUeNqcVU1IVFEUfn/TvHHUGqIfSAdq0Sqjn0WDGSiFzGrcVIIQRIva2Kpt0rJF7cJVqzY2SJSQ2yBEnCGYpGQGRNAIaVQmR40pdd74+r46164zY4UHPu59557z3XPvOec+0/d9o1pMCAYLsGU0ZYnGW0CFo1/PWcSpQ2iLPijYJzpDCDeBDQLmHnV1N6BO9CQNAE3AkYGBgYtzc3PPSqXS50qlUiY4p45rtBFb+piKZ5uvirQZaEmlUvc9z9vwdxGu0Ya24lNDrogd2b1lbGzsgSKYn5/PPoLEYrE7BOfUqXXaCjl9nR3EEq3Lo/X3919RkU5MTIxalnUd+gQQFySo45qKnD5yLa4etSGJ2Q+cyGazz1Wktm1fg64buACcFnDezTUVeS6XS9JXOGxFbEk5MfvhaDR6iTsNDw+/RrJWMV0CvgB5AedLXKMNbVtbWzvoKxyWKgpFzJIKhkKho1SOjIzkMJD4K7AMFAXLolsVG4M+juO4wmHpdWxptfv7bmy7jOGHgHfuSZ0bSi82tLXE166OeFtQpzy60dvbe9L4hyibtbW1BSSxpkEsrUW96enpd1QmEomrOF4DT8orQqQOIffYgLUwbWg7MzPzXmv1HRuwuA8DbT09PTfK5fImsz05OfkiEAicZX6AQ4IodOczmcxLVcvwuQt9TOrZrVtuQEcymXyinBYXFz/g+15fX18XwXk+n/+od+HU1FQqHA53wfc40MhbqGkQ4BRweWhoaFBFvots6R+4jreRSKQNvgelOsyalgbOkDwej9/GezC6srKS95gdkBWLxQW08ZvOzs6H6XR6R+Szs7Ov4HeMOfhVQCSW59KRZPFROSBolIShqmwTjeFLTtxgMNiM1r55DsLIEMRge3v7Y6nzkrl9H3/IXdk1rHWUoz30puiaXNdtHh8fv1UoFD7hhE+hWxDi76b+Rv/HQ69KKiCbN8r6pnQqO/MbsG7u4ddkaBu7somvdeo6e8L8y29rV8G+qo1VK/uqyQgmc0/E2qmM6tOo/99PAQYASw4dseRkTywAAAAASUVORK5CYII=') no-repeat;
          }
          .content tr.warning {
          background: rgba(255,165,0, 0.23);
          }
          .content tr.success {
          background: rgba(223,255,191,0.5);
          }
          .content span.success, .content span.failed, .content span.warning {
          min-height: 18px;
          padding: 6px 0 6px 10px;
          font-size: 13px;
          line-height: 18px;
          color: rgb(18,119,6);
          }
          .content span.success a, .content span.failed a, .content span.undefine a {
          border-bottom: 1px solid rgb(166,204,161);
          font-size: 13px;
          text-decoration: none;
          line-height: 18px;
          color: rgb(18,119,6);
          }
          .content span.success a:hover, .content span.failed a:hover, .content span.undefine a:hover {
          border-bottom: none;
          }
          .content tr.failed {
          background: rgba(255,191,191,0.3);
          }
          .content span.failed {
          color: rgb(157,0,0);
          }
          .content span.failed a {
          border-bottom: 1px solid rgb(218,159,159);
          color: rgb(157,0,0);
          }
          .footer {
          float: left;
          margin-top: 80px;
          width: 1024px;
          height: 24px;
          background: rgb(42,120,175);
          }
          .invisible
          {
          display:none;
          }
        </style>
      </head>
      <body>
        <div class="container">
          <div class="header">
            <img id="ss_logo" src="ss_logo.png"/>
            <p>Automation Framework Report</p>
            <img id="abiliton_logo" src="abiliton_logo.png"/>
          </div>
          <div class="content">
            <span class="main-h">Test Report</span>
            <span class="summary">Summary Information</span>
            <div class="sum-inform">
              <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td>
                    <span class="inform-name">Test Name:</span>
                  </td>
                  <td>
                    <span class="inform-res">
                      <xsl:apply-templates select="//report-name/@value"/>
                    </span>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span class="inform-name">Test Result:</span>
                  </td>
                  <td>
                    <span class="inform-res">
                      <span class="failed-up" onclick='scrollToError("failureId");' id="testResult" />
                    </span>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span class="inform-name">Description:</span>
                  </td>
                  <td>
                    <span class="inform-res">
                      <xsl:apply-templates select="//report-description/@value"/>
                    </span>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span class="inform-name">Start Time:</span>
                  </td>
                  <td>
                    <span class="inform-res">
                      <xsl:apply-templates select="//report-start-datetime/@value"/>
                    </span>
                  </td>
                </tr>
              </table>
            </div>
            <xsl:if test="//start-report-metadata">
              <br/>
              <table class="data-tests" border="0" cellpadding="0" cellspacing="0">
                <tr class="t-caption" valign="top">
                  <th width="159">
                    <span class="t-caption">runtime</span>
                  </th>
                  <th width="808">
                    <span class="t-caption">Before test run</span>
                  </th>
                </tr>
                <xsl:apply-templates select="//start-report-metadata"/>
              </table>
            </xsl:if>
            <span class="summary tests view-ll">View Log Level:</span>
            <form action="" id="view-log-level">
              <input type="checkbox" class="checkbox" id="verbose" name="verbose" onClick="toggleRows('verbose', this.checked);" checked="1" />
              <label for="verbose" class="tocheckbox" id="first-l">Verbose</label>
              <input type="checkbox" class="checkbox" id="info" name="info" onClick="toggleRows('info', this.checked);" checked="1" />
              <label for="info" class="tocheckbox">Info</label>
              <input type="checkbox" class="checkbox" id="warning" name="warning" onClick="toggleRows('warning', this.checked);" checked="1" />
              <label for="warning" class="tocheckbox">Warning</label>
              <input type="checkbox" class="checkbox" id="error" name="error" onClick="toggleRows('error', this.checked);" checked="1" />
              <label for="error" class="tocheckbox">Error</label>
              <input type="checkbox" class="checkbox" id="validation" name="validation" onClick="toggleRows('validation', this.checked);" checked="1" />
              <label for="validation" class="tocheckbox">Validation</label>
              <input type="checkbox" class="checkbox" id="test-result" name="test-result" onClick="toggleRows('testresult', this.checked);" checked="1" />
              <label for="test-result" class="tocheckbox">Test Result</label>
            </form>
            <table class="data-tests" border="0" cellpadding="0" cellspacing="0">
              <tr class="t-caption" valign="top">
                <th width="159">
                  <span class="t-caption">time</span>
                </th>
                <th width="119">
                  <span class="t-caption">level</span>
                </th>
                <th width="688">
                  <span class="t-caption">message</span>
                </th>
              </tr>
              <xsl:apply-templates select="//message"/>
            </table>
            <xsl:if test="//end-report-metadata">
              <br/>
              <table class="data-tests" border="0" cellpadding="0" cellspacing="0">
                <tr class="t-caption" valign="top">
                  <th width="159">
                    <span class="t-caption">runtime</span>
                  </th>
                  <th width="808">
                    <span class="t-caption">after test run</span>
                  </th>
                </tr>
                <xsl:apply-templates select="//end-report-metadata"/>
              </table>
            </xsl:if>
          </div>
          <div class="footer">
          </div>
        </div>
        <script>
          <![CDATA[ 
          function toggleRows(className, doShow){
            var rows = document.getElementsByTagName('tr');
			      var invisible = 'invisible';
            for(var i = 0; i < rows.length; i++){
              var row = rows[i];
              var rowClass = row.className;
              if(rowClass.indexOf(className) != -1){
                var isRowVisible = rowClass.indexOf(invisible) < 0;
                if (doShow && !isRowVisible){
                  row.className = rowClass.substring(0,rowClass.length - invisible.length -1);
                }
                if (!doShow && isRowVisible){
                  row.className = rowClass + ' ' + invisible;
                }
              }
            }
          }
          var testResult = document.getElementById("testResult");
          var failureElement = document.getElementById("failureId");
          if(failureElement != null){
            testResult.innerHTML = "FAILED";
            testResult.style.color = "red";
          }
          else{
            testResult.innerHTML = "PASSED";
            testResult.style.color ="green";
          }
          function scrollToError(elementId){
            var element = document.getElementById(elementId);
            element.scrollIntoView(true);
          }]]>
        </script>
      </body>
    </html>
  </xsl:template>
  <xsl:template match="lf">
    <br/>
  </xsl:template>
  <xsl:template match="a">
    <span class="image">
      <xsl:copy-of select ="node()"/>
      <a class="zoom">
        <xsl:attribute name="href">
          <xsl:value-of select="@href"/>
        </xsl:attribute>
      </a>
    </span>
  </xsl:template>
  <xsl:template match="start-report-metadata">
    <tr valign="top">
      <td width="159">
        <span class="metadata">
          <xsl:value-of select ="./@key"/>
        </span>
      </td>
      <td width="808">
        <span class="metadata">
          <xsl:value-of select ="./@value"/>
        </span>
      </td>
    </tr>
  </xsl:template>
  <xsl:template match="end-report-metadata">
    <tr valign="top">
      <td width="159">
        <span class="metadata">
          <xsl:value-of select ="./@key"/>
        </span>
      </td>
      <td width="808">
        <span class="metadata">
          <xsl:value-of select ="./@value"/>
        </span>
      </td>
    </tr>
  </xsl:template>
</xsl:stylesheet>