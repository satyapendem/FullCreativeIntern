var editor = CodeMirror.fromTextArea(document.getElementById("code"), {
  lineNumbers: false,
  highlightMatches: true,
  stylesheet: "lib/jscolors.css",
  indentUnit: 4
});
editor.focus();
editor.setSize(540, 200);
var editor1 = CodeMirror.fromTextArea(document.getElementById("code_update"), {
  lineNumbers: false,
  highlightMatches: true,
  stylesheet: "lib/jscolors.css",
  indentUnit: 4
});
editor1.focus();
editor1.setSize(540, 200);
   //Adding code to div
   //$("#save").hide();
   //$("#edit").hide();
   // $('#buttons').hide();
   //MOUSEHOVER
  $(document).on('mouseenter', '.code', function () {
    $(this).find("#pre_icons").show();
   });
   $(document).on("mouseleave", ".code", function() {
     $(this).find("#pre_icons").hide();
   });
  //Snippet div creation
  var create_snippet= document.getElementById('show');
  create_snippet.addEventListener('click',createsnippet);
  function createsnippet(){
    $('#myModal').modal('hide');
    var program = editor.getValue();
    var code_div=document.getElementsByClassName('.code');
    var icons = document.getElementById('buttons');
    if(code_div.childElementCount<1){
      code_div.appendChild(program);
      console.log("append");
    }
    else {
        code_div = document.createElement('div');
        code_div.setAttribute('class','code');
        // code_div.setAttribute('id',ids);
        code_div.innerHTML = program;
        //debugger;
         var add = document.getElementsByClassName('code');
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
      new_ele=document.getElementById('pre_icons');
      var clone_ele=new_ele.cloneNode(true);
      code_div.appendChild(clone_ele);

      console.log(code_div);
      editor.setValue("");
      var name= document.getElementById('fileName');
      name.value="";
       /*Edit option listeners*/
      var edit_code = document.querySelectorAll('.edit');
      editor1.setValue("");
      for(var i=0;i<edit_code.length;i++){
        edit_code[i].addEventListener('click',function () {
          $('#edit_modal').modal('show');
          editor1.setValue("");
          for_update = this.parentNode.parentNode;
          console.log(for_update);
          edit_div=for_update.getElementsByClassName('CodeMirror-code');
          console.log(edit_div);
          //linenumbers = edit_div[0].getElementsByClassName('CodeMirror-linenumber');
          //console.log(linenumbers);
          code_edit= edit_div[0].cloneNode(true);
          linenumbers=code_div.getElementsByClassName('CodeMirror-linenumber');
          for(i=0;i<linenumbers.length;i++){
            linenumbers[i].remove();
          }

          //console.log(codeContent);
          //for(i=0;i<edit_div.length;i++){
            //if(edit_div[i].classList.contains('CodeMirror-linenumbers'))
              //    console.log("found");

          //  text=edit_div[i].textContent;
          //}
          //editor1.setValue(text);
          document.getElementById('update_code').addEventListener('click',function(){
            $('#edit_modal').modal('hide');
              //console.log("inside update button");
              //var updated_text=editor1.getValue();
              //edit_div.innerHTML=updated_text;

          });
          //console.log(text);
          //linenumbers = edit_div.getElementsByClassName('CodeMirror-linenumber');
          //console.log(linenumbers);
          //code_edit= edit_div.cloneNode(true);
          //codeContent = code_edit.getElementsByClassName('CodeMirror-linenumber').remove();
          //console.log(codeContent);
        });
      }
    }
