<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="JavaScript">
<!--
function listTags()
{
 var tag, tags;
 // or you can use var allElem=document.all; and loop on it
 tags = "The tags in the page are:"
 for(i = 0; i < document.all.length; i++)
 {
   tag = document.all(i).tagName;
   tags = tags + "<br/>" + tag;
 }
 document.write(tags);
}// -->
</script>

<title>Javascript Examples</title>
</head>

<body>
<body onload="Hello()">

<table name="myTable" id="myTable" style="width:100%">
  <tr>
    <th>Origin</th>
    <th>Food</th>
    <th>Rating</th>
  </tr>
  <tr>
    <td>Baltimore</td>
    <td>Crabcakes</td>
    <td>9</td>
  </tr>
  <tr>
    <td>Shore</td>
    <td>Crabcakes</td>
    <td>10</td>
  </tr>
  <tr>
    <td>Baltimore</td>
    <td>Old Bay Wings</td>
    <td>11</td>
  </tr>
   <tr>
    <td>Miami</td>
    <td>Mangoes</td>
    <td>12</td>
  </tr>
</table>


<button onclick="newRows()">Add Rows</button>


<button onclick="listTags()">List my Tags</button>

<script>
function newRows() {
 var table = document.getElementById("myTable");
 var lastRow = table.rows.length;
 var row = table.insertRow(lastRow); 
 var cell1 = row.insertCell(0);
 var cell2 = row.insertCell(1);
 var cell3 = row.insertCell(2);
 cell1.innerHTML = "<input type='text'>";
 cell2.innerHTML = "<input type='text'>";
 cell3.innerHTML = "<input type='text'>";
}
</script>

</body>
</html>