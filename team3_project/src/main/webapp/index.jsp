<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
		<label for="name">이름</label><br>
		<input id="name" type="text" name="name"><br> 
		<label for="age">나이</label><br>
		<input id="age" type="text" name="age"><br>
		<label for="gender">성별</label><br>
		<input id="gender" type="text" name="gender"><br> 
		<label for="city">지역</label><br>
		<input id="city" type="text" name="city"><br> 
		<input type="submit" value="삽입">   
	</form>
	
	<form action="read" method="get">
	<label for="id">ID</label><br>
		<input id="id" type="number" name="id"><br> 
		<input type="submit" value="조회">        
	</form>
	
	<form action="update" method="post">
	<label for="id">ID</label><br>
		<input id="id" type="number" name="id"><br> 
		<label for="name">이름</label><br>
		<input id="name" type="text" name="name"><br> 
		<label for="age">나이</label><br>
		<input id="age" type="text" name="age"><br>
		<label for="gender">성별</label><br>
		<input id="gender" type="text" name="gender"><br> 
		<label for="city">지역</label><br>
		<input id="city" type="text" name="city"><br> 
		<input type="submit"  value="수정">        
	</form>
	
	<form action="delete" method="post">
	<label for="id">ID</label><br> 
		<input id="id" type="number" name="id"><br> 
		<input type="submit"  value="삭제">        
	</form>
	
</body>
</html>