<%@ include file="/jsp/includes/mainimport.jsp" %>
<html>
<head>
<%@ include file="/jsp/includes/Header.jsp"%>
<title>:: People Management ::</title>
</head>

<body onLoad="MM_preloadImages('<c:url value="/images/icon_homeover.jpg"/>','<c:url value="/images/icon_careerover.jpg"/>','<c:url value="/images/icon_contactover.jpg"/>')">
<%@ include file="/jsp/includes/TopPanel.jsp"%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td class="bgmain" align="center">
			<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr valign="top">
					<td>
						<div id="box1" class="box">
						
						<label></label>
										
						<c:url value='/user/validate.htm' var="submitUrl"/>
						
						<form:form action="${submitUrl}" modelAttribute=" ">
						<input type="hidden" name="companyId" value="1" id="companyId">
							<strong>Financial Year<br/></strong>
							<center><form:errors path="*"
										cssClass="errors" /></center>
						
						<table width="100%">
					          <tr>
					            <td width="16%">Financial Year Name </td>
					            <td width="36%"><label>
					              <input type="text" name="textfield" />
					            </label></td>
					            <td width="13%">&nbsp;</td>
					            <td width="35%">&nbsp;</td>
					          </tr>
					          <tr>
					            <td>Year Start Date  </td>
					            <td><label>
					            <input type="text" name="textfield2" />
					            </label></td>
					            <td>&nbsp;</td>
					            <td><label></label></td>
					          </tr>
							 <tr>
					            <td>Year End Date </td>
					            <td><label>
					            <input type="text" name="textfield22" />
					            </label></td>
					            <td>&nbsp;</td>
					            <td>&nbsp;</td>
					          </tr>
							  
					          <tr>
					            <td>&nbsp;</td>
					            <td><label></label></td>
					            <td>&nbsp;</td>
					            <td>&nbsp;</td>
					          </tr>
					          <tr>
					            <td colspan="4" align="center"><label>
					              <input type="submit" name="Save" value="Save" class="formfields"/>&nbsp;
								  <input type="submit" name="Cancel" value="Cancel" class="formfields"/>
								  
					            </label></td>
					          </tr>
					        </table>
						</form:form>

				<!-- End : Developer Area -->
						
						</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<%@ include file="/jsp/includes/BottomPanel.jsp"%>

<script language="javascript">
</script>
</body>

</html>