				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="logo"><a href="/peo/welcome.htm"><img src="<c:url value="/images/logo.jpg"/>"
							width="161" height="85" border="0" /></a></td>
						<td align="right">
						<table width="100%" border="0" cellspacing="0" cellpadding="0" class="icons">
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td nowrap="nowrap"><strong>Welcome <%//UserSession.getUserSession(session).getUser().getLoginName()%></strong></td>
							</tr>
							<tr>
								<td><a href="<c:url value="/welcome.htm"/>" onmouseout=MM_swapImgRestore(); onmouseover="MM_swapImage('home','','<c:url value="/images/icon_homeover.jpg"/>',1)">
								<img
									src="<c:url value="/images/icon_home.jpg"/>" alt="Home"
									name="home" width="11" height="10" border="0" id="home" title="Home"/></a></td>
								<td><img src="<c:url value="/images/sep2.jpg"/>" width="1"
									height="9" /></td>
								<td><a href="<c:url value="/user/logout.htm"/>" onmouseout=MM_swapImgRestore(); onmouseover="MM_swapImage('career','','<c:url value="/images/icon_careerover.jpg"/>',1)">
								<img
									src="<c:url value="/images/icon_career.jpg"/>" alt="Logout"
									name="logout" width="9" height="9" border="0" id="logout" title="Logout" /></a></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
				<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">

					<tr>
						<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="10"><img
									src="<c:url value="/images/menu_left.jpg"/>" width="10"
									height="37" /></td>
								<td class="menubg">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									 <tr>
    									<td class="menubg"><%@ include file="/jsp/includes/menu.jsp"%></td>
  									</tr>
								</table>
								</td>
								<td width="11"><img
									src="<c:url value="/images/menu_rt.jpg"/>" width="11"
									height="37" /></td>
							</tr>
						</table>
						</td>
					</tr>

				</table>
				</td>
			</tr>
				</table>
				