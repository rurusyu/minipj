<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<!-- /.box-header -->


				<div class="row">
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="..." alt="...">
							<!--이미지 삽입  -->
							<div class="caption">
								<div class="thumb">얖썸네일 이미지</div>
								<div class="content1">${list.content}</div>
								<div class="reply">댓글 영역</div>
							</div>
							<form id="f1" action="/picboard/update">
								<input type='hidden' id='hsno' name='ino' value="${list.ino}">
								<div>
									<button type="submit" id='modifyBtn'>Modify</button>
								</div>
							</form>
							 <a href="#" class="btn btn-del" role="button">Delete</a> 
							 <a href="#" class="btn btn-main" role="button">Main</a>
						</div>
					</div>
				</div>
				<!-- /.box-body -->


			</div>

			</form>

			<form action="/picboard/main">
				<div class="box-footer" style="float: right">
					<button type="submit" class="btn btn-primary">Cancel</button>
				</div>
			</form>


		</div>
		<!-- /.box -->
	</div>
	<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->



<%@include file="../include/footer.jsp"%>