<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
   
<style>

.file{
background-color: aqua;
width: 100px;
height: 100px;
}

.f1{
background-color: gray;
width: 100px;
height: 100px;
}

</style>

    <div class="panel panel-default">
        <div class="panel-body">
            REGISTER --------
            <form method="post">
                <div class="form-group1">
                    <label for="exampleInputEmail1">title</label> <input type="text"
                        class="form-control" name="title" value="title">
                </div>
                <div class="form-group2">
                    <label for="exampleInputPassword1">content</label> <input
                        type="text" class="form-control" name="content" value="content">
                </div>
                <div class="form-group3">
                    <label for="exampleInputPassword1">writer</label> <input
                        type="text" class="form-control" name="writer" value="writer">
                </div>
                <div  >
                    <input class="f1" type="hidden" class="form-control" name="pname" value="pname">
                
                </div>
                
                <button class="btn">제출</button>
            </form>
                 <div class="file">
                    
                </div>

            <script src="https://code.jquery.com/jquery-3.2.1.min.js"
                integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
                crossorigin="anonymous"></script>


            <script>
                $(document).ready(function(e) {
            
                    
                 $(".file").on("dragenter dragover", function(e) {
                    e.preventDefault();
                })
                    
                $(".file").on("drop", function(e) {
                    e.preventDefault();
                    
                    var files = e.originalEvent.dataTransfer.files;
                    
                    console.log(files);
                    
                    var file = files[0];
                    
                    var formData = new FormData();

                    formData.append("file",file);
                    
                    $(".f1").text(files[0].name);
                    $(".f1").val(files[0].name);
                    
                    $.ajax({
                        url:"/picboard/upload",
                        data: formData,
                        processData:false,
                        contentType:false,
                        type:'post',
                        success:function(result){
                        console.log(result)
                        }

                });
                });
                    

                });
            </script>



        </div>
    </div>
    
    <%@include file="../include/footer.jsp"%>

