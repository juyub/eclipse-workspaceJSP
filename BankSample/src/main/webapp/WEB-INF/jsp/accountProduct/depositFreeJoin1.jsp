<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
  <script src="http://code.jquery.com/jquery-3.5.1.min.js" ></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
var certificationNumber = '';

$(document).ready(function(){
	$('#certCheck').click(function(){
		
		$.ajax({
			type:'get',
			url:'${ pageContext.request.contextPath }/certificate',
			success : function(data){
				
				$("#sendEmailModal").modal('show');
				certificationNumber = data;
				
			},
			error : function(){
				alert("fail")
			}
		
		})
	})
})



$(document).ready(function(){
	
	$('#certConfirm').click(function(){
		let certification = $('#certification').val();
		certificationNumber = certificationNumber.substring(1,7);
		
		console.log(certification);
		console.log(certificationNumber);
		if(certificationNumber == certification){
			$("#completeEmailModal").modal('show');
		} else{
			alert("fail")
		}
		
	})
})


</script>  
<style>
	.error {
		color:red;
	}
</style>
</head>
<body>


<jsp:include page="/WEB-INF/jsp/include/header.jsp" /> 

      
<section class="appoinment-section section">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-sm-12 col-xs-12">
                <div class="accordion-section">
    <div class="section-title">
        <h3>상품 정보</h3>
    </div>
    <div class="accordion-holder">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingOne">
                    <h4 class="panel-title">
                        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            	하나 플러스 통장 <span>우대사항</span>
                        </a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                    <div class="panel-body">
                       	  하나 우대    :   이 통장에 주거래이체실적 1가지 항목 충족<br>
                       	 하나 플러스 우대 :   이 통장에 주거래이체실적 2가지 항목 이상 충족<br>
                       	 하나멤버스 우대    :   하나금융그룹의 하나멤버스 회원
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingTwo">
                    <h4 class="panel-title">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false"
                            aria-controls="collapseTwo">
                            	제공조건
                        </a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                    <div class="panel-body">
                     	급여 입금 :타인으로부터 건별 50만원이상 급여적요* 포함 입금 또는 급여지정일 전후 1영업일내 입금<br>
                      	연금 입금:4대 공적연금(국민, 공무원, 군인, 사학), 기초(노령)연금, 보훈연금, 산재보험보험급여, KEB하나은행에서 가입한 개인연금(주택연금, 연금신탁, 연금보험, 연금펀드), 기타연금(고객 지정 연금수급일 전후 1영업일에 대량이체방식으로 건당 20만원이상 입금되고 적요에 '연금' 또는 '보험사명'이 기재된 연금)<br>          
                    	카드 가맹점대금 입금:하나카드/BC카드 가맹점 대금<br>
          			         아파트관리비 출금 :자동이체방식으로 이체되는 아파트관리비
          				카드 결제대금 출금 :하나카드/현대카드의 결제대금으로 월 5만원 이상 (신용, 체크 합산)
          				주택청약종합저축 납입 :KEB하나은행의 본인명의 주택청약종합저축에 납입(청년 우대형 주택청약종합저축 포함)  
          				공과금 2건 출금 :도시가스요금, 전기료, 통신요금, 보험료 등 지로/CMS/펌뱅킹으로 이체
                    	
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingThree">
                    <h4 class="panel-title">
                        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false"
                            aria-controls="collapseThree">
                            	우대수수료 내용
                        </a>
                    </h4>
                </div>
                <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                    <div class="panel-body">
                        	당행 자동화기기를 통한 마감 후 현금인출 수수료 면제<br>
                        	당행 자동화기기를 통한 타행이체 수수료 면제<br>
                        	인터넷뱅킹, 폰뱅킹(ARS), 스마트폰뱅킹을 통한 타행이체 수수료 면제<br>
                        	납부자자동이체 및 타행자동이체 수수료 면제<br>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
            </div>
            
            <div class="col-md-6 col-sm-12 col-xs-12">
                <div class="contact-area">
    


<!-- form 태그 -->
<form:form commandName="depositAccountVO" method="post">
        <div class="row">
            
  
            <div class="col-md-12 col-sm-12 col-xs-12">
               
                <form:hidden path="id" value="${ loginVO.id }"  /> 	
                <form:hidden path="bankBookKey" value="1"  />
  

                <div class="form-group">
                	<label>비밀번호 &nbsp;</label> <form:errors path="accountPassword" class="error" /> 
                    <form:password path="accountPassword" class="form-control" placeholder="비밀번호 4자리를 설정하세요"/>
                    
                </div>
                
               
                <div class="form-group">
                	<label>입출금 자유 예금 계좌 닉네임 &nbsp;</label> <form:errors path="nickName" class="error" />
                    <form:input path="nickName" class="form-control" placeholder="닉네임을 입력하세요"/> 
                    
                </div>
                
                <div class="form-group">
                	<label>인증번호 &nbsp;</label>
                	<button type="button" class="btn btn-style-one" id="certCheck">
						인증번호 발송하기</button>	
					<div style="width:385px; float:left;">
						<form:input id = "certification" path="certification" class="form-control"  placeholder="이메일로 발송된 인증번호를 입력하세요"/>				
                	</div>
                	<div style="width:100px; float:left;">
                	<button type="button" class="btn btn-style-one" id="certConfirm" >
						확인</button>
                	</div>
                </div>
                
                <br>
                <br>
                <br>
                
                <div class="form-group text-center">
                    <button type="submit" class="btn-style-one">상품 가입</button>
                </div>

            </div>
            
            
        </div>
    </form:form>
</div>                        
            </div>
        </div>                    
    </div>
</section>
<!-- End Contact Section -->

<!--모달  ---------------------------------------------------------------------->
<div class="modal fade" id="sendEmailModal">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">이메일이 발송되었습니다.</h4>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
         	 이메일로 보내진 인증번호 6자리 값을 입력해주시기 바랍니다.
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn-style-one" data-dismiss="modal">확인</button>          
        </div>
        
      </div>
    </div>
  </div>

<div class="modal fade" id="completeEmailModal">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">인증완료</h4>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
         	 이메일 인증이 완료되었습니다.
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn-style-one" data-dismiss="modal">확인</button>          
        </div>
        
      </div>
    </div>
  </div>




	<jsp:include page="/WEB-INF/jsp/include/footer.jsp" /> 
	<jsp:include page="/WEB-INF/jsp/include/scroll.jsp" /> 


</body>
</html>