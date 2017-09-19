<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#formId").show();
	})
</script>
<title>查询商品列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/deleteAll.action"
		method="post" role="form" id="formId">
		查询条件：
		<table width="100%" border=1  class="table table-bordered">
			<tr>
				<!-- 如果Controller中接收的是Vo,那么页面上input框的name属性值要等于vo的属性.属性.属性..... -->
				<td><div class="form-group">
                       <label for="name">商品名称:</label>
                       <input type="text" class="form-control" id="name" name="items.name" placeholder="请输入名称">
                     </div>
                </td>
				<td>商品价格:<input type="text" name="items.price" /></td>
				<td><input type="submit" value="批量删除"  class="btn btn-warning btn-sm"/></td>
			</tr>
		</table>
		商品列表：
		<table width="100%"   class="table table-bordered">
			<tr class="warning">
				<td><input type="checkbox" /></td>
				<td>商品图片</td>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>生产日期</td>
				<td>商品描述</td>
				<td>操作</td>
			</tr >
			<c:forEach items="${itemList }" var="item">
				<tr class="success">
					<td><input type="checkbox" name="ids" value="${item.id}" /></td>
					<td><img src="/pic/e65967e9-3b96-4aa9-a301-837e8e465893.png" width=100 height=100/></td>
					<td>${item.name }</td>
					<td>${item.price }</td>
					<td><fmt:formatDate value="${item.createtime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${item.detail }</td>

					<td><a
						href="${pageContext.request.contextPath }/itemEdit.action?id=${item.id}" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-remove-sign"></span>修改</a></td>

				</tr>
			</c:forEach>

		</table>
	</form>
</body>

</html>