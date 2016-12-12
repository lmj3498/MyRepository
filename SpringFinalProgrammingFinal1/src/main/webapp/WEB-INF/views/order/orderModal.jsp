<%@ page contentType="text/html;charset=UTF-8" %>



<div id="orderModal" class="modal fade" tabindex="-1" role="dialog" >
  <div class="modal-dialog" role="document" style="width:1000px;">
    <div class="modal-content" style="height:700px">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title"><b>All Order List</b></h4>
      </div>
      <div class="modal-body">

		<div class="wrapper" align="center">
			<div>
		           <fieldset style = "width:350"><br>
		                    조회 날짜 : <input id="datepicker1" type = "date" min = "1987-07-01" max = "2020-08-01" name = "date1" step = "1">
		                    ~ <input id="datepicker2" type = "date" min = "1987-07-01" max = "2020-08-01" name = "date2" step = "1">
		                    <input  id="termList" type = "submit" onclick="termList()" value = "검색"/>
		                    <input type = "reset" value = "리셋"/>
		            </fieldset>
			</div>
			
			<div style="margin-top: 20px; text-align: right; width:900px;">
	    		<a id="btnNewOrder" type="button" class="btn btn-warning" href="#">신규 주문</a>
	    	</div>
	    	
	        <table id="acrylic" style="width:900px">
	            <thead>
	                <tr>
	                    <th>주문번호</th>
	                    <th>아이디</th>
	                    <th>주문시간</th>
	                    <th>총 가격</th>
	                    <th>결제 방식</th>
	                </tr>
	            </thead>
	            <tbody id="orderTbody">
				</tbody>
	        </table>
    	</div>
      </div>
      <div class="modal-footer" style="text-align: center;"> 
      </div>
    </div>
  </div>
</div>  
