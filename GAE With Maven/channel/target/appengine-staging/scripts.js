var httpRequest=new XMLHttpRequest();
var name;
var postCount=0;
var seenNote=0;
var note=0;
var postCount=0;
var to;
var txt;
var successOne=0;

var login=function(){
	name=$("#name").val();
	console.info("name: "+name);
	httpRequest.open("POST","/login?name="+name,true);
	httpRequest.send();
	httpRequest.onreadystatechange = function(){
		if (httpRequest.readyState === 4) {
			if (httpRequest.status === 200) {
				openChannel(httpRequest.responseText);
				$("#myName").append("<div id='namediv'>Name: "+name+"</div></br></br></br>");
				$(".postbox").show();
				$("#loginbox").hide();
				$("#posts").show();
				$("#notificationsparent").show();
				successOne=1;
			}else {
				alert('There was a problem with the request.');
			}
		}
	}
}

var postIt=function(){
	 txt="Message Received from "+name+": "+$("#txt").val();
	to=$("#to").val();
	name=$("#name").val();
	console.info(txt);
	postCount++;
	httpRequest.open("POST","/channelapi?name="+name+"&to="+to+"&txt="+txt+"&no="+postCount,true);
	httpRequest.send();
	httpRequest.onreadystatechange = function(){
		if (httpRequest.readyState === 4) {
			if (httpRequest.status === 200) {
				var txt2=txt;
				var o=txt2.indexOf(": ");
				txt2=txt2.substring(o+2);
				$("#posts").append("</br>"+postCount+". "+txt2+"<hr>");
				}else {
				alert('There was a problem with the request.');
			}
		}
	}
}
var openChannel=function(token){
	console.info("token: "+token);
	var channel= new goog.appengine.Channel(token);
	var socket=channel.open();
	socket.onopen = onSocketOpen;
	socket.onmessage=onMessageReceived;
	socket.onerror = onSocketError;
	socket.onclose = onSocketClose;
}

onMessageReceived=function(message){
	console.info(message.data);
	var j=message.data;
	var text1=JSON.parse(j);
	
	if(text1.txt == "update"){
		console.info("SIZE: "+text1.size);
		console.info("uLIST"+text1.ulist);
		var str=new Array();
		var list=text1.ulist;
		str=list.split("*");
		$("#to").html("");
		for(var k=0;k<str.length;k++){
			if(str[k] == name)
				continue;
			console.info(k+" - "+str[k]);
			$("#to").append("<option value='"+str[k]+"'>"+str[k]+"</option>");
					
		}
		return;
	}
	console.info("STILL HERE and txt is "+text1.txt);
	name=text1.to;
	to=text1.name;
	seenNote=text1.no;
	note=text1.no;
	txt=text1.txt;
	note++;
	console.info("to: "+to+"name: "+name);
	console.info("<p class='notes' id='note"+note+"'></br>"+text1.txt+"</p>");
	$("#notifications").append("<p class='notes' id='note"+note+"' onclick='clicked("+note+",\""+txt+"\",\""+to+"\")'></br>"+txt+"</p>");
}

onSocketError = function(error){
	alert("Error is "+error.description+" and HTML code is "+error.code);
};

onSocketOpen = function() {
	console.info("Connection opened.");
	if(successOne==1){
		console.info("sending update request");
		httpRequest.open("POST","/channelapi?name="+name+"&to=updateList",true);
		httpRequest.send();
		httpRequest.onreadystatechange = function(){
			if (httpRequest.readyState === 4) {
				if (httpRequest.status === 200) {
					successOne=0;
				}else {
					alert('There was a problem with the request.');
				}
			}
		}	
	}
};

onSocketClose = function() {
	console.info("Socket Connection closed");
};


var clicked=function(note,txt2,to2){
	var str="note"+note;
	seenNote=note;
	var div=document.getElementById("notifications");
	var p=document.getElementById(str);
	div.removeChild(p);
	var o=txt2.indexOf(": ");
	txt2=txt2.substring(o+2);
	var temp=seenNote-1
	txt2=name+" has seen your message number "+temp+" : "+txt2;
	httpRequest.open("POST","/notify?to="+to2+"&name="+name+"&txt="+txt2+"&no="+note,true);
	httpRequest.send();
	httpRequest.onreadystatechange = function(){
		if (httpRequest.readyState === 4) {
			if (httpRequest.status === 200) {
				console.info("sending request");
				note--;
				}else {
				alert('There was a problem with the request.');
			}
		}
	}
}

logout=function(){
	console.info("LOGGING OUT "+name);
	httpRequest.open("POST","/channelapi?name="+name+"&txt=logout",true);
	httpRequest.send();
	httpRequest.onreadystatechange = function(){
		if (httpRequest.readyState === 4) {
			if (httpRequest.status === 200) {
				$(".postbox").hide();
				$("#loginbox").show();
				$("#posts").hide();
				$("#notificationsparent").hide();
				$("#myName").html("");
				$("#posts").html("");
				$("#to").html();
				$("#notifications").html("");
				$("#posts").append("</br></br><h2>Your Posts</h2>");
				name=null;
				postCount=0;
				seenNote=0;
				note=0;
				postCount=0;
				to=null;
				txt=null;
				successOne=0;

				onSocketClose();
			}else {
				alert('There was a problem with the request.');
			}
		}
	}
}