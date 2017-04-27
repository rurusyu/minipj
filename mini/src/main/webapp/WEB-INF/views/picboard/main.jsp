<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../include/header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Developers</h3>
					<div class="pull-right">
						<span class="clickable filter" data-toggle="tooltip"
							title="Toggle table filter" data-container="body"> <i
							class="glyphicon glyphicon-filter"></i>
						</span>
					</div>
				</div>

				<table class="table table-hover" id="dev-table">
					<thead>
						<tr>
							<th>Ino</th>
							<th>Title</th>
							<th>Regdate</th>
						</tr>
					</thead>
					<tbody>


						<c:forEach var="imgVO" items="${list}">

							<tr>
								<td>${imgVO.ino}</td>
								<td><a class='sview' href='${imgVO.ino}'>${imgVO.titleName}</a></td>
								<td>${imgVO.regdate}</td>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
	</div>


</div>
<!--검색기능창@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  -->
<div class="box-footer clearfix">
	<form id="f1" action="/picboard/main" method="get">
		<input type='hidden' id='hpage' name='page'
			value="${pageMaker.current}">
			
		<input type='hidden' id='hsno'
			name='ino'>
		<div>
			<select name='type'>
				<option value='x' ${cri.type eq 'x'? "selected":""}>--------</option>
				<option value='n' ${cri.type eq 'n'? "selected":""}>Title</option>
				<option value='c' ${cri.type eq 'c'? "selected":""}>Date</option>
			</select> 
			<input type='text' name="keyword" value="${cri.keyword}">
			<button id='searchBtn'>Search</button>
		</div>
	</form>

	<!--페이지 메이커@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  -->
	<ul class="pagination pagination-sm no-margin pull-right">
		<c:if test="${pageMaker.prev}">
			<li><a href="${pageMaker.start-1}">«</a></li>
		</c:if>
		<c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="idx">
			<li class='${idx == pageMaker.current?"active":"" }'><a
				href="${idx}">${idx}</a></li>
		</c:forEach>
		<c:if test="${pageMaker.next}">
			<li><a href="${pageMaker.end +1 }">»</a></li>
		</c:if>
	</ul>
</div>
</div>

<script>
		$(document).ready(function() {

			console.log("AAAAAAAAAAAAAAAAAA");

			$('#searchBtn').click(function(e) {
				e.preventDefault();

				$('#hpage').val("1");

				$('#f1').submit();

			})
			
			$(".sview").on("click", function(e) {
				e.preventDefault();
				$("#hsno").val($(this).attr("href"));
				$("#f1").attr("action", "/picboard/read").submit();

			});

			$(".pagination li a").on("click", function(e) {

				e.preventDefault();
				var $this = $(this);
				$("#hpage").val($this.attr("href"));
				$("#f1").submit();

			})

		});
	</script>





<%@include file="../include/footer.jsp"%>