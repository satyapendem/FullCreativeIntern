$(document).ready(function(){
  
  $("a").on('click', function(event) {
      if (this.hash !== "") {
      
      event.preventDefault();
      var hash = this.hash;
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 800, function(){
   
      window.location.hash = hash;
      });
    } 
  });
});
$(document).ready( function()

	    {
	    $( "#Form" ).submit(function( event ){        
	        var proceed = true;
	        $("#Form input[required=true], #Form textarea[required=true]").each(function(){
	                $(this).css('border-color',''); 
	                if(!$.trim($(this).val())){  
	                    $(this).css('border-color','red');    
	                   proceed = false; 
	                }
	                
	                var email_reg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/; 
	                if($(this).attr("type")=="email" && !email_reg.test($.trim($(this).val()))){
	                    $(this).css('border-color','red');    
	                    proceed = false;             
	                }   
	        });
	        
	        if(proceed){ 
	            return true;
	        }
	        event.preventDefault(); 
	    });
	    $("#Form input[required=true], #Form textarea[required=true]").keyup(function() { 
	        $(this).css('border-color',''); 
	        $("#result").slideUp();
	    });

	});

function countChar(val) {
	  var len = val.value.length;
	  var text_max = 150;

	  if (len >= text_max) {
	    val.value = val.value.substring(0, text_max);
	    $('#textarea_feedback').text(((text_max - len) + 1) + ' characters remaining - out of limit');
	  } else {
	    $('#textarea_feedback').text((text_max - len) + ' characters remaining');
	  }
	};