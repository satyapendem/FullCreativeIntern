<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>
		Channel API
	</title>
	<script src='/_ah/channel/jsapi'></script> 
	<script type="text/javascript" src="jquery-1.8.2.js"></script>
</head>
<body>
	
<script type="text/javascript" src="scripts.js"></script>
	<div id="loginbox">
		Name: <input type="text" id="name" name="name"/>
		<button onclick="login()" id="login">Login</button>
	</div>
	
	
	
	<div class="postbox" hidden="hidden">
			<div id="myName"></div>
			&nbsp&nbsp&nbsp&nbspTo:<select class="postbox" id="to" name="to" hidden="hidden"/></select></br>
			Text: <input type="text" id="txt" name="txt"/></br></br>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button onclick="postIt()" id="postit">Post</button>
			&nbsp&nbsp&nbsp<button onclick="logout()">Logout</button>
	</div>
	
	
	
	<div id="posts" hidden="hidden">
		</br></br>
		<h2>Your Posts</h2>
	</div>



	<div id="notificationsparent" hidden="hidden">
		<div id="notificationstitle">
			<font color="blue">Notifications</font><hr>
		</div>
		<div id="notifications"></div>
	</div>
	
	
</body>
</html>