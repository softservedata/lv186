<?xml version="1.0"?>
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
  <xsl:template match="testmessage">
    <xsl:choose>
      <xsl:when test ="@status = 'FAILED'">
        <tr class="failed" valign="top">
          <td width="249">
            <span class="failed">
              <a href="{./@reportPath}">
                <xsl:value-of select ="./@testName"/>
              </a>
            </span>
          </td>
          <td width="239">
            <span class="failed">
              <xsl:value-of select ="./@status"/>
            </span>
          </td>
          <td width="479">
            <span class="failed">
              <xsl:value-of select ="./@duration"/>
            </span>
          </td>
        </tr>
      </xsl:when>
      <xsl:when test ="@status = 'PASSED'">
        <tr class="success" valign="top">
          <td width="249">
            <span class="success">
              <a href="{./@reportPath}">
                <xsl:value-of select ="./@testName"/>
              </a>
            </span>
          </td>
          <td width="239">
            <span class="success">
              <xsl:value-of select ="./@status"/>
            </span>
          </td>
          <td width="479">
            <span class="success">
              <xsl:value-of select ="./@duration"/>
            </span>
          </td>
        </tr>
      </xsl:when>
      <xsl:when test ="@status = 'UNDERFINE'">
        <tr class="undefine" valign="top">
          <td width="249">
            <span class="undefine">
              <a href="{./@reportPath}">
                <xsl:value-of select ="./@testName"/>
              </a>
            </span>
          </td>
          <td width="239">
            <span class="undefine">
              <xsl:value-of select ="./@status"/>
            </span>
          </td>
          <td width="479">
            <span class="undefine">
              <xsl:value-of select ="./@duration"/>
            </span>
          </td>
        </tr>
      </xsl:when>
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
          .content span.tests {
          margin: 38px 0 12px;
          }
          table.data-tests, table.data-tests th, table.data-tests td {
          border: 1px solid #d5d5d5;
          }
          table.data-tests {
          border-bottom: 0;
          border-left: 0;
          }
          table.data-tests td, table.data-tests th {
          border-top: 0;
          border-right: 0;
          padding-right:3px;
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
          .content tr.success {
          background: rgba(223,255,191,0.5);
          }
          .content span.success, .content span.failed, .content span.undefine {
          min-height: 30px;
          padding-left: 10px;
          font-size: 13px;
          line-height: 30px;
          color: rgb(18,119,6);
          }
          .content span.success a, .content span.failed a, .content span.undefine a {
          border-bottom: 1px solid rgb(166,204,161);
          font-size: 13px;
          text-decoration: none;
          line-height: 30px;
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
          .content tr.undefine {
          background: rgb(255,255,255);
          }
          .content span.undefine {
          color: rgb(68,68,68)
          }
          .content span.undefine a {
          border-bottom: 1px solid rgb(121,171,255);
          color: rgb(70,138,255);
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
          background: rgba(255,165,0, 0.5);
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
          margin-top: 50px;
          width: 1024px;
          height: 24px;
          background: rgb(42,120,175);
          }
          .dropdown {
          width: 970px;
          }
          .details-header {
          width: 968px;
          height: 28px;
          background: rgb(238,238,238);
          border: 1px solid #d5d5d5;
          }
          .details-header input.switcher {
          float: left;
          outline: none;
          width: 29px;
          height: 28px;
          border: none;
          border-right: 1px solid #d5d5d5;
          background: none;
          text-align: center;
          vertical-align: text-top;
          line-height: 28px;
          color: rgb(95,95,95);
          cursor: pointer;
          }
          .details-header span.details {
          display: inline-block;
          padding-left: 10px;
          font-size: 14px;
          vertical-align: middle;
          line-height: 28px;
          color: rgb(95,95,95);
          cursor: pointer;
          }
          .details-hidden {
          display: none;
          width: 918px;
          padding: 10px 10px 10px 40px;
          border: 1px solid #d5d5d5;
          }
          .details-hidden span.item {
          display: block;
          font-size: 13px;
          line-height: 18px;
          color: rgb(68,68,68);
          }
          canvas{
          width: 600px;
          height: 400px;
          }
          sup {
          margin-left: 5px;
          font-size: 10px;
          font-weight: normal;
          line-height: 8px;
          cursor: pointer;
          }
        </style>
        <script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
        <script>
        <![CDATA[
		      function calculateScale(data){
			      var max = Math.max.apply(Math, data);
			      var step = max/5;
			      if(step<1){
				      return {
					      scaleSteps: 1,
					      scaleStepWidth: max 
				      }
			      }
			      return{
				      scaleSteps: 5,
				      scaleStepWidth: Math.ceil(step) 
			      }
		      }
          
          window.Chart = function(context){
	var chart = this;

	var animationOptions = {
		linear : function (t){
			return t;
		}
	};

	var width = context.canvas.width;
	var height = context.canvas.height;

	if (window.devicePixelRatio) {
		context.canvas.style.width = width + "px";
		context.canvas.style.height = height + "px";
		context.canvas.height = height * window.devicePixelRatio;
		context.canvas.width = width * window.devicePixelRatio;
		context.scale(window.devicePixelRatio, window.devicePixelRatio);
	}

	this.Bar = function(data,options){
		chart.Bar.defaults = {
			scaleOverlay : false,
			scaleOverride : false,
			scaleSteps : null,
			scaleStepWidth : null,
			scaleStartValue : null,
			scaleLineColor : "rgba(0,0,0,.1)",
			scaleLineWidth : 1,
			scaleShowLabels : true,
			scaleLabel : "<%=value%>",
			scaleFontFamily : "'Arial'",
			scaleFontSize : 12,
			scaleFontStyle : "normal",
			scaleFontColor : "#666",
			scaleShowGridLines : true,
			scaleGridLineColor : "rgba(0,0,0,.05)",
			scaleGridLineWidth : 1,
			barShowStroke : true,
			barStrokeWidth : 2,
			barValueSpacing : 5,
			barDatasetSpacing : 1,
			animation : true,
			animationSteps : 60,
			animationEasing : "linear",
			onAnimationComplete : null
		};		
		var config = (options) ? mergeChartConfig(chart.Bar.defaults,options) : chart.Bar.defaults;
		
		return new Bar(data,config,context);		
	}
	
	var clear = function(c){
		c.clearRect(0, 0, width, height);
	};	
	var Bar = function(data,config,ctx){
		var maxSize, scaleHop, calculatedScale, labelHeight, scaleHeight, valueBounds, labelTemplateString, valueHop,widestXLabel, xAxisLength,yAxisPosX,xAxisPosY,barWidth, rotateLabels = 0;
			
		calculateDrawingSizes();
		
		valueBounds = getValueBounds();
		labelTemplateString = (config.scaleShowLabels)? config.scaleLabel : "";
		if (!config.scaleOverride){
			
			calculatedScale = calculateScale(scaleHeight,valueBounds.maxSteps,valueBounds.minSteps,valueBounds.maxValue,valueBounds.minValue,labelTemplateString);
		}
		else {
			calculatedScale = {
				steps : config.scaleSteps,
				stepValue : config.scaleStepWidth,
				graphMin : config.scaleStartValue,
				labels : []
			}
			populateLabels(labelTemplateString, calculatedScale.labels,calculatedScale.steps,config.scaleStartValue,config.scaleStepWidth);
		}
		
		scaleHop = Math.floor(scaleHeight/calculatedScale.steps);
		calculateXAxisSize();
		animationLoop(config,drawScale,drawBars,ctx);		
		
		function drawBars(animPc){
			ctx.lineWidth = config.barStrokeWidth;
			for (var i=0; i<data.datasets.length; i++){
					ctx.fillStyle = data.datasets[i].fillColor;
					ctx.strokeStyle = data.datasets[i].strokeColor;
				for (var j=0; j<data.datasets[i].data.length; j++){
					var barOffset = yAxisPosX + config.barValueSpacing + valueHop*j + barWidth*i + config.barDatasetSpacing*i + config.barStrokeWidth*i;
					
					ctx.beginPath();
					ctx.moveTo(barOffset, xAxisPosY);
					ctx.lineTo(barOffset, xAxisPosY - animPc*calculateOffset(data.datasets[i].data[j],calculatedScale,scaleHop)+(config.barStrokeWidth/2));
					ctx.lineTo(barOffset + barWidth, xAxisPosY - animPc*calculateOffset(data.datasets[i].data[j],calculatedScale,scaleHop)+(config.barStrokeWidth/2));
					ctx.lineTo(barOffset + barWidth, xAxisPosY);
					if(config.barShowStroke){
						ctx.stroke();
					}
					ctx.closePath();
					ctx.fill();
				}
			}
		}
		function drawScale(){
			ctx.lineWidth = config.scaleLineWidth;
			ctx.strokeStyle = config.scaleLineColor;
			ctx.beginPath();
			ctx.moveTo(width-widestXLabel/2+5,xAxisPosY);
			ctx.lineTo(width-(widestXLabel/2)-xAxisLength-5,xAxisPosY);
			ctx.stroke();
			
			if (rotateLabels > 0){
				ctx.save();
				ctx.textAlign = "right";
			}
			else{
				ctx.textAlign = "center";
			}
			ctx.fillStyle = config.scaleFontColor;
			for (var i=0; i<data.labels.length; i++){
				ctx.save();
				if (rotateLabels > 0){
					ctx.translate(yAxisPosX + i*valueHop,xAxisPosY + config.scaleFontSize);
					ctx.rotate(-(rotateLabels * (Math.PI/180)));
					ctx.fillText(data.labels[i], 0,0);
					ctx.restore();
				}
				
				else{
					ctx.fillText(data.labels[i], yAxisPosX + i*valueHop + valueHop/2,xAxisPosY + config.scaleFontSize+3);					
				}

				ctx.beginPath();
				ctx.moveTo(yAxisPosX + (i+1) * valueHop, xAxisPosY+3);
				
					ctx.lineWidth = config.scaleGridLineWidth;
					ctx.strokeStyle = config.scaleGridLineColor;					
					ctx.lineTo(yAxisPosX + (i+1) * valueHop, 5);
				ctx.stroke();
			}
			
			//Y axis
			ctx.lineWidth = config.scaleLineWidth;
			ctx.strokeStyle = config.scaleLineColor;
			ctx.beginPath();
			ctx.moveTo(yAxisPosX,xAxisPosY+5);
			ctx.lineTo(yAxisPosX,5);
			ctx.stroke();
			
			ctx.textAlign = "right";
			ctx.textBaseline = "middle";
			for (var j=0; j<calculatedScale.steps; j++){
				ctx.beginPath();
				ctx.moveTo(yAxisPosX-3,xAxisPosY - ((j+1) * scaleHop));
				if (config.scaleShowGridLines){
					ctx.lineWidth = config.scaleGridLineWidth;
					ctx.strokeStyle = config.scaleGridLineColor;
					ctx.lineTo(yAxisPosX + xAxisLength + 5,xAxisPosY - ((j+1) * scaleHop));					
				}
				else{
					ctx.lineTo(yAxisPosX-0.5,xAxisPosY - ((j+1) * scaleHop));
				}
				
				ctx.stroke();
				if (config.scaleShowLabels){
					ctx.fillText(calculatedScale.labels[j],yAxisPosX-8,xAxisPosY - ((j+1) * scaleHop));
				}
			}
		}
		function calculateXAxisSize(){
			var longestText = 1;
			if (config.scaleShowLabels){
				ctx.font = config.scaleFontStyle + " " + config.scaleFontSize+"px " + config.scaleFontFamily;
				for (var i=0; i<calculatedScale.labels.length; i++){
					var measuredText = ctx.measureText(calculatedScale.labels[i]).width;
					longestText = (measuredText > longestText)? measuredText : longestText;
				}
				longestText +=10;
			}
			xAxisLength = width - longestText - widestXLabel;
			valueHop = Math.floor(xAxisLength/(data.labels.length));	
			
			barWidth = (valueHop - config.scaleGridLineWidth*2 - (config.barValueSpacing*2) - (config.barDatasetSpacing*data.datasets.length-1) - ((config.barStrokeWidth/2)*data.datasets.length-1))/data.datasets.length;
			
			yAxisPosX = width-widestXLabel/2-xAxisLength;
			xAxisPosY = scaleHeight + config.scaleFontSize/2;				
		}		
		function calculateDrawingSizes(){
			maxSize = height;
			ctx.font = config.scaleFontStyle + " " + config.scaleFontSize+"px " + config.scaleFontFamily;
			widestXLabel = 1;
			for (var i=0; i<data.labels.length; i++){
				var textLength = ctx.measureText(data.labels[i]).width;
				widestXLabel = (textLength > widestXLabel)? textLength : widestXLabel;
			}
			if (width/data.labels.length < widestXLabel){
				rotateLabels = 45;
				if (width/data.labels.length < Math.cos(rotateLabels) * widestXLabel){
					rotateLabels = 90;
					maxSize -= widestXLabel; 
				}
				else{
					maxSize -= Math.sin(rotateLabels) * widestXLabel;
				}
			}
			else{
				maxSize -= config.scaleFontSize;
			}

			maxSize -= 5;
			
			labelHeight = config.scaleFontSize;
			
			maxSize -= labelHeight;
			
			scaleHeight = maxSize;
			
		}		
		function getValueBounds() {
			var upperValue = Number.MIN_VALUE;
			var lowerValue = Number.MAX_VALUE;
			for (var i=0; i<data.datasets.length; i++){
				for (var j=0; j<data.datasets[i].data.length; j++){
					if ( data.datasets[i].data[j] > upperValue) { upperValue = data.datasets[i].data[j] };
					if ( data.datasets[i].data[j] < lowerValue) { lowerValue = data.datasets[i].data[j] };
				}
			};
	
			var maxSteps = Math.floor((scaleHeight / (labelHeight*0.66)));
			var minSteps = Math.floor((scaleHeight / labelHeight*0.5));			
			return {
				maxValue : upperValue,
				minValue : lowerValue,
				maxSteps : maxSteps,
				minSteps : minSteps
			};
		}
	}
	function calculateOffset(val,calculatedScale,scaleHop){
		var outerValue = calculatedScale.steps * calculatedScale.stepValue;
		var adjustedValue = val - calculatedScale.graphMin;
		var scalingFactor = CapValue(adjustedValue/outerValue,1,0);
		return (scaleHop*calculatedScale.steps) * scalingFactor;
	}
	
	function animationLoop(config,drawScale,drawData,ctx){
		var animFrameAmount = (config.animation)? 1/CapValue(config.animationSteps,Number.MAX_VALUE,1) : 1,
			easingFunction = animationOptions[config.animationEasing],
			percentAnimComplete =(config.animation)? 0 : 1;
		
		if (typeof drawScale !== "function") drawScale = function(){};
		
		requestAnimFrame(animLoop);
		
		function animateFrame(){
			var easeAdjustedAnimationPercent =(config.animation)? CapValue(easingFunction(percentAnimComplete),null,0) : 1;
			clear(ctx);
			if(config.scaleOverlay){
				drawData(easeAdjustedAnimationPercent);
				drawScale();
			} else {
				drawScale();
				drawData(easeAdjustedAnimationPercent);
			}				
		}
		function animLoop(){
				percentAnimComplete += animFrameAmount;
				animateFrame();	
				if (percentAnimComplete <= 1){
					requestAnimFrame(animLoop);
				}
				else{
					if (typeof config.onAnimationComplete == "function") config.onAnimationComplete();
				}
		}		
	}
	var requestAnimFrame = (function(){
		return window.requestAnimationFrame ||
			window.webkitRequestAnimationFrame ||
			window.mozRequestAnimationFrame ||
			window.oRequestAnimationFrame ||
			window.msRequestAnimationFrame ||
			function(callback) {
				window.setTimeout(callback, 1000 / 60);
			};
	})();

	function calculateScale(drawingHeight,maxSteps,minSteps,maxValue,minValue,labelTemplateString){
			var graphMin,graphMax,graphRange,stepValue,numberOfSteps,valueRange,rangeOrderOfMagnitude,decimalNum;
			
			valueRange = maxValue - minValue;
			
			rangeOrderOfMagnitude = calculateOrderOfMagnitude(valueRange);

        	graphMin = Math.floor(minValue / (1 * Math.pow(10, rangeOrderOfMagnitude))) * Math.pow(10, rangeOrderOfMagnitude);
            
            graphMax = Math.ceil(maxValue / (1 * Math.pow(10, rangeOrderOfMagnitude))) * Math.pow(10, rangeOrderOfMagnitude);
            
            graphRange = graphMax - graphMin;
            
            stepValue = Math.pow(10, rangeOrderOfMagnitude);
	        numberOfSteps = Math.round(graphRange / stepValue);
	        while(numberOfSteps < minSteps || numberOfSteps > maxSteps) {
	        	if (numberOfSteps < minSteps){
			        stepValue /= 2;
			        numberOfSteps = Math.round(graphRange/stepValue);
		        }
		        else{
			        stepValue *=2;
			        numberOfSteps = Math.round(graphRange/stepValue);
		        }
	        };
	        var labels = [];
	        populateLabels(labelTemplateString, labels, numberOfSteps, graphMin, stepValue);
	        return {
		        steps : numberOfSteps,
				stepValue : stepValue,
				graphMin : graphMin,
				labels : labels		        
	        }
			function calculateOrderOfMagnitude(val){
			  return Math.floor(Math.log(val) / Math.LN10);
			}		
	}
    function populateLabels(labelTemplateString, labels, numberOfSteps, graphMin, stepValue) {
        if (labelTemplateString) {
            for (var i = 1; i < numberOfSteps + 1; i++) {
                labels.push(tmpl(labelTemplateString, {value: (graphMin + (stepValue * i)).toFixed(getDecimalPlaces(stepValue))}));
            }
        }
    }
	function Max( array ){
		return Math.max.apply( Math, array );
	};
	function Min( array ){
		return Math.min.apply( Math, array );
	};
	function Default(userDeclared,valueIfFalse){
		if(!userDeclared){
			return valueIfFalse;
		} else {
			return userDeclared;
		}
	};
	function isNumber(n) {
		return !isNaN(parseFloat(n)) && isFinite(n);
	}
	function CapValue(valueToCap, maxValue, minValue){
		if(isNumber(maxValue)) {
			if( valueToCap > maxValue ) {
				return maxValue;
			}
		}
		if(isNumber(minValue)){
			if ( valueToCap < minValue ){
				return minValue;
			}
		}
		return valueToCap;
	}
	function getDecimalPlaces (num){
		var numberOfDecimalPlaces;
		if (num%1!=0){
			return num.toString().split(".")[1].length
		}
		else{
			return 0;
		}
		
	} 
	function mergeChartConfig(defaults,userDefined){
		var returnObj = {};
	    for (var attrname in defaults) { returnObj[attrname] = defaults[attrname]; }
	    for (var attrname in userDefined) { returnObj[attrname] = userDefined[attrname]; }
	    return returnObj;
	}
	  var cache = {}; 
	  function tmpl(str, data){
	    var fn = !/\W/.test(str) ?
	      cache[str] = cache[str] ||
	        tmpl(document.getElementById(str).innerHTML) :
	      new Function("obj",
	        "var p=[],print=function(){p.push.apply(p,arguments);};" +
	      
	        "with(obj){p.push('" +
	       
	        str
	          .replace(/[\r\t\n]/g, " ")
	          .split("<%").join("\t")
	          .replace(/((^|%>)[^\t]*)'/g, "$1\r")
	          .replace(/\t=(.*?)%>/g, "',$1,'")
	          .split("\t").join("');")
	          .split("%>").join("p.push('")
	          .split("\r").join("\\'")
	      + "');}return p.join('');");

	    return data ? fn( data ) : fn;
	  };
}
]]>        </script>
      </head>
      <body>
        <div class="container">
          <div class="header">
            <img id="ss_logo" src="ss_logo.png"/>
            <p>Automation Framework Report</p>
            <img id="abiliton_logo" src="abiliton_logo.png"/>
          </div>
          <div class="content">
            <span class="main-h">Project Test List</span>
            <span class="summary">Summary Information</span>
            <div class="sum-inform">
              <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td>
                    <span class="inform-name">Suite name:</span>
                  </td>
                  <td>
                    <span class="inform-res">
                      <xsl:apply-templates select="//suiteInfo/@name"/>
                    </span>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span class="inform-name">Project name:</span>
                  </td>
                  <td>
                    <span class="inform-res">
                      <xsl:apply-templates select="//suiteInfo/@projectName"/>
                    </span>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span class="inform-name">Start time:</span>
                  </td>
                  <td>
                    <span class="inform-res">
                      <xsl:apply-templates select="//suiteStatistic/@startTime"/>
                    </span>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span class="inform-name">End time:</span>
                  </td>
                  <td>
                    <span class="inform-res">
                      <xsl:apply-templates select="//suiteStatistic/@endTime"/>
                    </span>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span class="inform-name">Total Run:</span>
                  </td>
                  <td>
                    <span class="inform-res">
                      <xsl:apply-templates select="//suiteStatistic/@runnedTestsCount"/>
                    </span>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span class="inform-name">Total Passed:</span>
                  </td>
                  <td>
                    <span class="inform-res">
                      <xsl:apply-templates select="//suiteStatistic/@passedTestsCount"/>
                    </span>
                  </td>
                </tr>
                <tr>
                  <td>
                    <span class="inform-name">Total Failed:</span>
                  </td>
                  <td>
                    <span class="inform-res">
                      <xsl:apply-templates select="//suiteStatistic/@failedTestsCount"/>
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
                    <span class="t-caption">Befor test run</span>
                  </th>
                </tr>
                <xsl:apply-templates select="//start-report-metadata"/>
              </table>
            </xsl:if>
            <span class="summary tests">Tests</span>
            <table class="data-tests" border="0" cellpadding="0" cellspacing="0">
              <tr class="t-caption" valign="top">
                <th width="249">
                  <span class="t-caption">test name</span>
                </th>
                <th width="239">
                  <span class="t-caption">test result</span>
                </th>
                <th width="479">
                  <span class="t-caption">duration</span>
                </th>
              </tr>
              <xsl:apply-templates select="//testmessage"/>
            </table>
            <xsl:if test="//message != ''">
              <br/>
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
            </xsl:if>
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
            <span class="summary tests">
              Time to execute business methods<sup>(1)</sup>
            </span>
            <table class="data-tests" border="0" cellpadding="0" cellspacing="0">
              <tr class="t-caption" valign="top">
                <th width="350">
                  <span class="t-caption">method name</span>
                </th>
                <th width="124">
                  <span class="t-caption">number of calls</span>
                </th>
                <th width="124">
                  <span class="t-caption">
                    total execution time<sup>(2)</sup>
                  </span>
                </th>
                <th width="124">
                  <span class="t-caption">
                    average execution time<sup>(3)</sup>
                  </span>
                </th>
                <th width="124">
                  <span class="t-caption">
                    longest execution<sup>(4)</sup>
                  </span>
                </th>
                <th width="124">
                  <span class="t-caption">
                    shortest execution<sup>(5)</sup>
                  </span>
                </th>
              </tr>
              <xsl:apply-templates select="//stat-methodexecution"/>
            </table>
            <br/>
            <div class="dropdown">
              <div class="details-header">
                <input type="button" class="switcher" value="+"/>
                <span class="details">
                  Top reused methods<sup>(6)</sup>
                </span>
              </div>
              <div class="details-hidden">
                <canvas id="topreusedCanvas" height="450" width="970"></canvas>
                <script>
                  var lab1 = [<xsl:for-each select="//stat-topreused">
                    "<xsl:value-of select="@method" />",
                  </xsl:for-each>]
                  var dat1 = [<xsl:for-each select="//stat-topreused">
                    "<xsl:value-of select="@value" />",
                  </xsl:for-each>]
                  var barChartData1 = {
                  labels : lab1,
                  datasets : [{
                  fillColor : "rgba(223,255,191,0.5)",
                  strokeColor : "rgba(220,220,220,1)",
                  data : dat1
                  }]
                  }
                  var scaleOpt1 = calculateScale(dat1);
                  var op1= {
                  scaleShowGridLines : false,
                  animation : false,
                  scaleOverride :true,
                  scaleStartValue : 0,
                  scaleSteps : scaleOpt1.scaleSteps,
                  scaleStepWidth : scaleOpt1.scaleStepWidth
                  }
                  var topreusedCanvasBar = new Chart(document.getElementById("topreusedCanvas").getContext("2d")).Bar(barChartData1, op1);
                </script>
              </div>
            </div>
            <br/>
            <div class="dropdown">
              <div class="details-header">
                <input type="button" class="switcher" value="+"/>
                <span class="details">
                  Top unused methods<sup>(7)</sup>
                </span>
              </div>
              <div class="details-hidden">
                <canvas id="topunusedCanvas" height="450" width="970"></canvas>
                <script>
                  var lab2 = [<xsl:for-each select="//stat-topunused">
                    "<xsl:value-of select="@method" />",
                  </xsl:for-each>]
                  var dat2 = [<xsl:for-each select="//stat-topunused">
                    "<xsl:value-of select="@value" />",
                  </xsl:for-each>]
                  var barChartData2 = {
                  labels : lab2,
                  datasets : [{
                  fillColor : "rgba(223,255,191,0.5)",
                  strokeColor : "rgba(220,220,220,1)",
                  data : dat2
                  }]
                  }
                  var scaleOpt2 = calculateScale(dat2);
                  var op2= {
                  scaleShowGridLines : false,
                  animation : false,
                  scaleOverride :true,
                  scaleStartValue : 0,
                  scaleSteps : scaleOpt2.scaleSteps,
                  scaleStepWidth : scaleOpt2.scaleStepWidth
                  }
                  var topunusedCanvasBar = new Chart(document.getElementById("topunusedCanvas").getContext("2d")).Bar(barChartData2, op2);
                </script>
              </div>
            </div>
            <br/>
            <div class="dropdown">
              <div class="details-header">
                <input type="button" class="switcher" value="+"/>
                <span class="details">
                  Top time consuming methods<sup>(8)</sup>
                </span>
              </div>
              <div class="details-hidden">
                <canvas id="toptimeconsumingCanvas" height="450" width="970"></canvas>
                <script>
                  var lab3 = [<xsl:for-each select="//stat-toptimeconsuming">
                    "<xsl:value-of select="@method" />",
                  </xsl:for-each>]
                  var dat3 = [<xsl:for-each select="//stat-toptimeconsuming">
                    "<xsl:value-of select="@value" />",
                  </xsl:for-each>]
                  var barChartData3 = {
                  labels : lab3,
                  datasets : [{
                  fillColor : "rgba(223,255,191,0.5)",
                  strokeColor : "rgba(220,220,220,1)",
                  data : dat3
                  }]
                  }
                  var scaleOpt3 = calculateScale(dat3);
                  var op3= {
                  scaleShowGridLines : false,
                  animation : false,
                  scaleOverride :true,
                  scaleStartValue : 0,
                  scaleSteps : scaleOpt3.scaleSteps,
                  scaleStepWidth : scaleOpt3.scaleStepWidth
                  }
                  var toptimeconsumingCanvasBar = new Chart(document.getElementById("toptimeconsumingCanvas").getContext("2d")).Bar(barChartData3, op3);
                </script>
              </div>
            </div>
            <br/>
            <br/>
            <div class="dropdown">
              <div class="details-header">
                <input type="button" id="refSwitcher" class="switcher" value="+"/>
                <span class="details">References</span>
              </div>
              <div id="pefenerces" class="details-hidden">
                <span class="item">1) Item One</span>
                <span class="item">2) Item Two</span>
                <span class="item">3) Item Three</span>
                <span class="item">4) Item Three</span>
                <span class="item">5) Item Three</span>
                <span class="item">6) Item Three</span>
                <span class="item">7) Item Three</span>
                <span class="item">8) Item Three</span>
              </div>
            </div>
          </div>
          <div class="footer"></div>
        </div>
        <script>
          $(document).ready(function(){
          $(document).ready(function(){
          function showcomments(){
          $('#refSwitcher').val('-');
          $('#pefenerces').show();
          $('html, body').animate({
          scrollTop: $("#pefenerces").offset().top
          }, 1000);
          }

          function openDropdown(event){
          var target = $( event.target );
          if(!target.is('sup')){
          var parent = $(this).closest('.dropdown');
          var dropDown = parent.find('.details-hidden');
          var switcher = parent.find('.switcher');
          if(switcher.val()==='+'){
          switcher.val('-');
          dropDown.show();
          $('html, body').animate({
          scrollTop: parent.offset().top
          }, 500);
          }else{
          switcher.val('+');
          dropDown.hide();
          }
          }
          }

          $('sup').click(showcomments);
          $('.dropdown').on('click', 'input', openDropdown);
          $('.dropdown').on('click', 'span.details', openDropdown);
          });
          });
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
  <xsl:template match="stat-methodexecution">
    <tr>
      <td class='system-info-style'>
        <span class="metadata">
          <xsl:value-of select ="./@methodName"/>
        </span>
      </td>
      <td class='system-info-style'>
        <span class="metadata">
          <xsl:value-of select ="./@callCount"/>
        </span>
      </td>
      <td class='system-info-style'>
        <span class="metadata">
          <xsl:value-of select ="./@totalExec"/>
        </span>
      </td>
      <td class='system-info-style'>
        <span class="metadata">
          <xsl:value-of select ="./@avgExec"/>
        </span>
      </td>
      <td class='system-info-style'>
        <span class="metadata">
          <xsl:value-of select ="./@longAvgExec"/>
        </span>
      </td>
      <td class='system-info-style'>
        <span class="metadata">
          <xsl:value-of select ="./@shortAvgExec"/>
        </span>
      </td>
    </tr>
  </xsl:template>
</xsl:stylesheet>