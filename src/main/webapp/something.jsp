<html>
<body>
	
	<%@ include file="fragments/header.jsp" %>
	
	<%
		String queryData = request.getQueryString();
		out.println("Request data:" + queryData);
	%>
	<br />


</body>
</html>
