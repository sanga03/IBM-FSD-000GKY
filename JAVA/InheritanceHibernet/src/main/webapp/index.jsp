<html>
<head>

<script>
function change(){
	console.log("hey")
	document.getElementById("a").style.hidden=false;
	document.getElementById("a").style.display="block";
	if(document.getElementById("ctype").value=="fe"){
		document.getElementById("yyear").style.hidden=false;
		document.getElementById('a').value="feature remarks";
		document.getElementById("yyear").style.display="block";
		}
}

</script>
</head>
<body>
<h2>CD World!</h2>
<form action="createHiber">

<input type="text" name="title" placeholder="title"></input>
<br>
<input type="text" name="artist" placeholder="artist"></input>
<br>
<input type="date" name="rdate"></input>
<br>
<select name="ctype" id="ctype" onchange="change()">
<option value="cd">CD</option>
<option value="sp">Special Edition</option>

<option value="fe">Featured Edition</option>
</select>
<input type="text" id="a" placeholder="Spacial remarks" name="sptext" hidden="true">
<br>
<input type="number" placeholder=" feature version" name="yyear" id="yyear"hidden="true">
<br>
<input type="submit" value="submit">


</form>


</body>
</html>
