<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="servlet.Constants" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
<link rel="stylesheet" href="./css/stylesheet.css">
<link href='http://fonts.googleapis.com/css?family=Stalinist+One' rel='stylesheet' type='text/css'>
</head>

<%String dr = (String) request.getAttribute(Constants.DISPLAY_RESULT); %>
<%String clr = (String) request.getAttribute(Constants.CLEAR); %>


<body>
	<form action="http://localhost:8080/Calculator/CalcServlet" method="get">
		<input type="hidden" id="clear" name="clear" value="<%= clr != null ? clr : ""%>"/>
		
		<table class="calcTable">
			<tr>
				<td colspan="4">
					<input id="displayResult" class="disp" type="text" name="display" 
						value="<%= dr!= null ? dr : "" %>">	
				</td>
			</tr>
			<tr>
				<td class="calcTd">
					<input class="btn" type="submit" name="action" value="C"/>
				</td>
				<td class="calcTd">
					<input class="btn" type="submit" name="action" value="/"/>
				</td>
				<td class="calcTd">
					<input class="btn" type="submit" name="action" value="*"/>
				</td>
				<td class="calcTd">
					<input class="btn" type="button" onclick="updateDisplayResult(this.value)" name="action" value="del"/>
				</td>
			</tr>
			<tr>
				<td class="calcTd">
					<input class="btn" type="button" onclick="updateDisplayResult(this.value)" name="action" value="7"/>
				</td>
				<td class="calcTd">
					<input class="btn" type="button" onclick="updateDisplayResult(this.value)" name="action" value="8"/>
				</td>
				<td class="calcTd">
					<input class="btn" type="button" onclick="updateDisplayResult(this.value)" name="action" value="9"/>
				</td>
				<td class="calcTd">
					<input class="btn" type="submit" name="action" value="-"/>
				</td>
			</tr>
			<tr>
				<td class="calcTd">
					<input class="btn" type="button" onclick="updateDisplayResult(this.value)" name="action" value="4"/>
				</td>
				<td class="calcTd">
					<input class="btn" type="button" onclick="updateDisplayResult(this.value)" name="action" value="5"/>
				</td>
				<td class="calcTd">
					<input class="btn" type="button" onclick="updateDisplayResult(this.value)" name="action" value="6"/>
				</td>
				<td class="calcTd">
					<input class="btn" type="submit" name="action" value="+"/>
				</td>
			</tr>
			<tr>
				<td class="calcTd">
					<input class="btn" type="button" onclick="updateDisplayResult(this.value)" name="action" value="1"/>
				</td>
				<td class="calcTd">
					<input class="btn" type="button" onclick="updateDisplayResult(this.value)" name="action" value="2"/>
				</td>
				<td class="calcTd">
					<input class="btn" type="button" onclick="updateDisplayResult(this.value)" name="action" value="3"/>
				</td>
				<td rowspan="2">
					<input class="btn" type="submit" name="action" value="="/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input class="btn" type="button" onclick="updateDisplayResult(this.value)" name="action" value="0"/>
				</td>
				<td class="calcTd">
					<input class="btn" type="button" onclick="updateDisplayResult(this.value)" name="action" value="."/>
				</td>
				
			</tr>
		</table>
	</form>
</body>

<script>
	function updateDisplayResult(num){
		var clr = document.getElementById('clear');
		var dr = document.getElementById('displayResult');
		
		if(clr.value == "clear"){
			dr.setAttribute("value", "");
			clr.setAttribute("value", "");
		}
		
		if(num == "del"){
			var len = dr.value.length;
			dr.setAttribute("value", dr.value.substring(0, len-1));
		}else{
			dr.setAttribute("value", dr.value+num);
		}
	}
</script>

</html>