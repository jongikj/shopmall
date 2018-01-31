<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
	<div class="container">
		<div class="row">
			<div id="shop_buy_list">
				<h2 class="title text-center">구매 완료</h2>
				<table id="buy_table"style="width: 90%; margin-left: auto; margin-right: auto; table-layout: fixed;">
					<thead>
						<tr style="border-bottom: 1px solid #F0F0E9; height: 30px">
							<th colspan="2" style="text-align: center">타이틀</th>
							<th style="text-align: center;">수량</th>
							<th style="text-align: center;">가격</th>
						</tr>
					</thead>
					<tbody id="shop_buy_tbody">
						<c:forEach items="${buyList}" var="list">
						<tr style="text-align: center">
							<td><img style="height: 100px;" src="/web/resources/img/title/bloodborne.jpg" alt="'+data.image+'"></td>
							<td style="text-align: left;">제목<input id="hd_count'+flag+'" type="hidden" value="'+data.count+'"><input id="hd_seq'+flag+'" type="hidden" value="'+data.seq+'"></td>
							<td>1</td>
							<td><span id="buy_price'+flag+'">20000</span><input id="hd_price'+flag+'" value="'+data.price+'" type="hidden"></td>
						</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr style="height: 50px; border-top: 1px solid #F0F0E9;">
							<td colspan="3" style="text-align: right;"><span style="font-size: 25px; color: #FE980F; font-family: 'Roboto', sans-serif; font-weight: 700">합계 금액 : </span></td>
							<td style="text-align: center;"><span id="shop_buy_price" style="font-size: 25px; font-family: 'Roboto', sans-serif; font-weight: 700"></span><input id="hd_buy_price" type="hidden"></td>
						</tr>
					</tfoot>
				</table>
			</div>
			<div id="buy_info" style="text-align: center; padding-top: 30px;">
			</div>
		</div>
	</div>
</section>
<script src="/web/resources/js/main.js"></script>
<script>
</script>