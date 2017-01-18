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

$('textarea').keypress(function(){

    if(this.value.length > 150){
        return false;
    }
    $("#remainingC").html("Remaining characters : " +(150 - this.value.length));
});

if ($('#back-to-top').length) {
    var scrollTrigger = 100, 
        backToTop = function () {
            var scrollTop = $(window).scrollTop();
            if (scrollTop > scrollTrigger) {
                $('#back-to-top').addClass('show');
            } else {
                $('#back-to-top').removeClass('show');
            }
        };
    backToTop();
    $(window).on('scroll', function () {
        backToTop();
    });
    $('#back-to-top').on('click', function (e) {
        e.preventDefault();
        $('html,body').animate({
            scrollTop: 0
        }, 700);
    });
}

