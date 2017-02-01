package com.jdoexample;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@SuppressWarnings("serial")
public class AddPersonServlet extends HttpServlet {
	
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
         long startTime;
		 String name = req.getParameter("uname");
		 Person p = new Person(name);
		 Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
	        List<BlobKey> blobKeys = blobs.get("myFile");

	        if (blobKeys == null || blobKeys.isEmpty()) {
	            res.sendRedirect("/");
	        } else {
	            res.sendRedirect("/serve?blob-key=" + blobKeys.get(0).getKeyString());
	        }
		 PersistenceManager pm = PerManFact.get().getPersistenceManager();

		 try
		 {
		     startTime = System.currentTimeMillis();  
            	
		     pm.makePersistent(p);
		     System.out.println("Time taken by DataStore: " + (System.currentTimeMillis() - startTime) + "ms");
		 }
		 
		 finally
		 {
		 	
		 	pm.close();
		 }
		 
		res.setContentType("text/plain");
		res.getWriter().println("Hello,"+name);
		
	}
}
