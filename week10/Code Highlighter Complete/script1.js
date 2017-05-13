$('#language').on('change',function(){
    type=this.value;
});
$('#fileName').on('change',function(){
    file_name=this.value;
});
file_name=document.getElementById('fileName').value;
   //Adding code to div
   //$("#save").hide();
   //$("#edit").hide();
   // $('#buttons').hide();
   $(document).on('mouseenter', '.code', function () {
    $(this).find(".pre_icons").show();
  });
   $(document).on("mouseleave", ".code", function() {
     $(this).find(".pre_icons").hide();
   });
   $("#show").click(function(event){
     $('#myModal').modal('hide');
     //$("#save").show();
     //$("#edit").show();
     // $('#buttons').show();

     var user_input= $('textarea#code').val();
     console.log(user_input);
     var regex_html = /<\/?[\w\s="/.':;#-\/\?]+>/g;
     if(regex_html.test(user_input)==true){
        program=formatHtml(user_input);
     }
     else{
      program= formatCode(user_input);
    }
     var code_div = $(".code");
     var icon = $("#buttons");
     if($(code_div).children().length<1){
      $(code_div).append(program);
      console.log("append");
    }
    else{
      code_div = document.createElement('div');
      code_div.setAttribute('class','code');
      // code_div.setAttribute('id',ids);
      code_div.textContent = program;
      //debugger;
      $(".code").last().after(code_div);
      // $("#"+ids).append(new_ele);
      console.log("create new div");
    }
    $(code_div).each(function() {

      var $this = $(this),
      $code = $this.html(),
      $unescaped = $('<div/>').html($code).text();
      $this.empty();
      CodeMirror(this, {
        value: $unescaped,
        lineNumbers: true,
        theme: "neo",
        readOnly: "nocursor"
      });
    });

    new_ele = $('.pre_icons').clone();
     //new_ele.removeAttr('id');
     $(code_div).append(new_ele);
     type=document.getElementById('language');
     type=type.options[type.selectedIndex].value;
     file_name=document.getElementById('fileName').value;
     $('textarea#code').val("");
   });

     $(document).on('click','.edit', function(event){
      $('#edit_modal').modal('show');
      for_update=$(this).parents(".code");
       edit_div=$(for_update).find('div.CodeMirror-code');
       edit_code = $(edit_div).clone();
      document.getElementById("Up_fileName").value=file_name;
       content_code = $(edit_code).find('div.CodeMirror-linenumber').remove();
       txt_for_update=$(edit_code).text();
       console.log(txt_for_update);
       result = formatCode(txt_for_update);
      $('textarea#code_update').val(result);
        });

      $('#update_code').click(function(){
        $('#edit_modal').modal('hide');
        //debugger;
        type=document.getElementById('language');
        type=type.options[type.selectedIndex].value;
        file_name=document.getElementById('fileName').value;
        changed_text=$('textarea#code_update').val();
        updated_text=formatCode(changed_text);
        debugger;
        $(for_update).find('.CodeMirror').remove();
        update_div = document.createElement('div');
        update_div.innerHTML = updated_text;

         //for_update = $(edit_div).parents().find('.code');
         $(for_update).prepend(update_div);
        //$(edit_div).html(updated_text);
           //$(code_div).innerHTML(txt_for_update);
           $(update_div).each(function() {
         var $this = $(this),
         $code = $this.html(),
         $unescaped = $('<div/>').html($code).text();
         $this.empty();
         CodeMirror(this, {
          value: $unescaped,
          lineNumbers: true,
          theme: "neo",
          readOnly: "nocursor"
        });
       });

    });
     $(document).on('click','.save',function(){
      for_down=$(this).parents(".code");
      down_div=$(for_down).find('div.CodeMirror-code');
      down_code = $(down_div).clone();
      console.log(down_code);
      content_code = $(down_code).find('div.CodeMirror-linenumber').remove();
      txt_for_down=$(down_code).text();
      downTxt=formatCode(txt_for_down);
      console.log(downTxt);
      console.log(file_name);
      if(file_name==""){
        file_para="program";
      }
      else{
        file_para=file_name;
      }
      switch(type){
        case "c": saveTextAsFile(file_para,"c");
        break;
        case "java": saveTextAsFile(file_para,"java");
        break;
        case "c++": saveTextAsFile(file_para,"cpp");
        break;
        case "php": saveTextAsFile(file_para,"php");
        break;
        case "markdown": saveTextAsFile(file_para,"md");
        break
        case "plaintext": saveTextAsFile(file_para,"txt");
        break

      }
      function saveTextAsFile(file,type){
        var textToWrite = downTxt;
        var textFileAsBlob = new Blob([textToWrite],{
          type:'text/plain'
        });
        var fileNameToSaveAs =file+"."+type;
        var downloadLink = document.createElement("a");
        downloadLink.download = fileNameToSaveAs;
        downloadLink.innerHTML = "Download File";
        if (window.URL != null){
          downloadLink.href = window.URL.createObjectURL(textFileAsBlob);
        }
        else{
          downloadLink.href = window.URL.createObjectURL(textFileAsBlob);
          downloadLink.onclick = destroyClickedElement;
          downloadLink.style.display = "none";
          document.body.appendChild(downloadLink);
        }
        downloadLink.click();
       }
     });
function formatCode(code) {
  var formattedCode=js_beautify(code);
  return formattedCode;
}
function formatHtml(s) {
s=s.replace(/&amp;/g,'&amp;amp;');s=s.replace(/&lt;/g,'&amp;lt;');
s=s.replace(/&gt;/g,'&amp;gt;');
s=s.replace(/\n/g,'&lt;br /&gt;\n');
s=s.replace(/\r/g,'');
return s;
}
