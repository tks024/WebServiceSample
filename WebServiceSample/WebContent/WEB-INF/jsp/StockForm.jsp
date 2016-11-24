<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.naming.*, javax.sql.*, java.text.* ,java.io.*, java.util.*"%>
<!DOCTYPE html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">

<title>在庫登録画面</title>
</head>

<body>
<header>在庫登録画面</header>

<main>
	<div class='regist-container'>

		<div class="message">
			<%
			String msg = (String)request.getAttribute("msg");
			if(msg != null){
			%>
				<p class='message-info'> <%= msg %>  </p>
			<%
			}
			%>

			<%
			ArrayList<String> errors = (ArrayList<String>)request.getAttribute("errors");
			if(errors != null){
			    for(int i=0; i < errors.size(); i++) {
			%>
			    	<p class='message-alert'> <%= errors.get(i) %> </p>

			<%
			    }
			}

			%>
		</div>


		<form action="stock_save.action" method="post" >
			<table class="form_table">
				<tbody>
					<tr class="product-item">
						<th>品目</th>
						<td>
							<select name="select-product-item" >
								<option value="item-01">商品01</option>
								<option value="item-02">商品02</option>
								<option value="item-03">商品03</option>
								<option value="item-04">商品04</option>
							</select>
						</td>
					</tr>


					<tr class="product-color">
						<th>色種</th>
						<td>
							<select name="select-product-color" >
								<option value="color-01">ブラック</option>
								<option value="color-02">ホワイト</option>
								<option value="color-03">レッド</option>
								<option value="color-04">ブルー</option>
								<option value="color-05">イエロー</option>
								<option value="color-06">グリーン</option>
							</select>
						</td>
					</tr>

					<tr class="quantity">
						<th>個数</th>
						<td>
							<input type="text" name="text-quatity" size="10" />個
						</td>
					</tr>

					<tr class="status">
						<th>状態</th>
						<td>
							<input type="radio" name="radio-status" value="status-new"> 新品
							<input type="radio" name="radio-status" value="status-old"> 中古
						</td>
					</tr>


					<tr>


					</tr>


					<tr>
						<td colspan="2">
							<input class="job_submit" type="submit" value="登録" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

</main>

<footer>

</footer>

</body>
</html>