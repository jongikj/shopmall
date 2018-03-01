<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section>
	<div class="container">
		<div class="row">
			<div id="shop_buy_list">
				<h2 class="title text-center">위시리스트</h2>
				<table id="buy_table"style="width: 90%; margin-left: auto; margin-right: auto; table-layout: fixed;">
					<thead>
						<tr style="border-bottom: 1px solid #F0F0E9; height: 30px">
							<th colspan="2" style="text-align: center">타이틀</th>
							<th style="text-align: center;">가격</th>
							<th style="width: 20px;"></th>
						</tr>
					</thead>
					<tbody id="shop_buy_tbody">
						<tr style="text-align: center">
							<td><img style="height: 100px;" src="/web/resources/img/title/darksoul3.jpg" alt="이미지"></td>
							<td id="" style="text-align: left;">타이틀</td>
							<td><span id="">52,500</span></td>
							<td><i id="" class="count glyphicon glyphicon-remove" onclick="removeBuy(\''+ i +'\')"></i></td>
						</tr>
						<tr style="text-align: center">
							<td><img style="height: 100px;" src="/web/resources/img/title/darksoul3.jpg" alt="이미지"></td>
							<td id="" style="text-align: left;">타이틀</td>
							<td><span id="">52,500</span></td>
							<td><i id="" class="count glyphicon glyphicon-remove" onclick="removeBuy(\''+ i +'\')"></i></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="buy_info" style="text-align: center; padding-top: 30px;">
				<span>* 위시리스트는 계정별로 서버에 저장됩니다.</span>
			</div>
			<div style="text-align: center; padding: 40px">
 				<input id="shop_buy_button" class="btn btn-default" style="width: 120px; height: 50px; font-size: 17px;" type="button" value="구매하기"/>
			</div>
		</div>
	</div>
</section>
<script src="/web/resources/js/main.js"></script>
<script>
$(function() {
	$.ajax({
		url : '/web/member/session',
		async : false,
		success : function(session) {
			
		},
		error : function() {
			alert('위시리스트 세션 읽는 중 오류 발생');
		}
	});
});
</script>