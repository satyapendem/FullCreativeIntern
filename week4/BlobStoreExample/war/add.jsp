<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Hello App Engine</title>
  </head>

  <body>
    <h1>Hello App Engine!</h1>
	
    <form action="<%= blobstoreService.createUploadUrl("/addperson") %>" method="post" enctype="multipart/form-data">
    <h4>enter name:</h4>
    <input type="text" name="uname" />
    <h4>Select Image:</h4>
    <input type="text">
            <input type="file" name="myFile">
    <br>
    <input type="submit" name="submit" value="Add">
    </form>
  </body>
</html>
