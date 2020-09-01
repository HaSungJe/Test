<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<!-- inc Start -->
<%@ include file="../../include/inc.jsp" %>
<!-- inc End -->

<meta charset="UTF-8">
<title>Main</title>
</head>
<body>	
	<!-- header Start -->
	<%@ include file="../../include/header.jsp" %>
	<!-- header End -->	
	
	<!-- JQuery -->
	<script>
		$(document).ready(function() {
			/* DatePicker */
			$("#birth").datepicker({
                dateFormat: 'yy-mm-dd' //Input Display Format 변경
                ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
                ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
                ,changeYear: true //콤보박스에서 년 선택 가능
                ,changeMonth: true //콤보박스에서 월 선택 가능                
                ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
                ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
                ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
                ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
                ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
                ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
                ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
                ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
                ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
                ,minDate: "-100Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
                ,maxDate: "+0M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                
            });  
			
			/* ID 중복체크 */
			$("#btnIdCheck").click(function() {
				var id = $("#id").val();
				var data = {"id" : id};
				if(id.length < 6) {
					alert("아이디는 최소 6글자 이상이어야 합니다.");
					$("#id").focus();
					return;
				} else {
					$.get("/user/checkId", data, function(rData) {
						if(rData > 0) {
							$("#idCheck").val("0");
							$("#labelIdCheck").css("color", "red");
							$("#labelIdCheck").text("중복된 아이디입니다.");
							$("#id").focus();
						} else {
							$("#idCheck").val("1");
							$("#labelIdCheck").css("color", "green");
							$("#labelIdCheck").text("사용가능한 아이디입니다.");
						}
					});
				}
			});
			
			/* 별명 중복체크 */
			$("#btnSubnameCheck").click(function() {
				var subname = $("#subname").val();
				var data = {"subname" : subname};
				if(subname.length < 2) {
					alert("별명은 최소 2글자 이상이어야 합니다.");
					$("#subname").focus();
					return;
				} else {
					$.get("/user/checkSubname", data, function(rData) {
						if(rData > 0) {
							$("#subnameCheck").val("0");
							$("#labelSubnameCheck").css("color", "red");
							$("#labelSubnameCheck").text("중복된 별명입니다.");
							$("#subname").focus();
						} else {
							$("#subnameCheck").val("1");
							$("#labelSubnameCheck").css("color", "green");
							$("#labelSubnameCheck").text("사용가능한 별명입니다.");
						}
					});
				}
			});
			
			
			/* 연락처 숫자만 입력 가능하도록 설정 */
			$("input:text[numberOnly]").on("keyup", function() {
			    $(this).val($(this).val().replace(/[^0-9]/g,""));
			});
			
			/* 연락처 숫자만 입력 가능하도록 설정 */
			$("#id").on("change", function() {
				idCheck = $("#idCheck").val("0");
				$("#labelIdCheck").css("color", "white");
				$("#labelIdCheck").text("");
			});
			

			/* 회원가입 유효성 검사 */
			$("#btnSign").click(function() {
				// 1. ID 중복확인
				var idCheck = $("#idCheck").val();				
				if(idCheck == "0") {
					alert("아이디 중복확인은 필수사항입니다.");
					$("#id").focus();
					return;
				}
				
				// 1-2. 별명 확인
				var subname = $("#subname").val();
				if(subname == "0") {
					alert("별명 중복확인은 필수사항입니다.");
					$("#subname").focus();
					return;
				}

				// 2. 비밀번호 일치 확인
				var pw1 = $("#pw").val();
				var pw2 = $("#pw2").val();
				if(pw1.length < 6) {
					alert("비밀번호는 최소 6글자 이상이어야 합니");
					$("#pw").focus();
					return;
				} else if(pw1 != pw2) {
					alert("비밀번호가 서로 다릅니다.");
					$("#pw").focus();
					return;
				}
					
				// 3. 이름 확인
				var name = $("#name").val();
				if(name.length < 2) {
					alert("이름을 2글자 이상 입력해주세요.");
					$("#name").focus();
					return;
				}
				
				// 4. 생년월일 확인
				var birth = $("#birth").val();
				if(birth == "" || birth == null) {
					alert("생년월일을 선택해주세요.");
					$("#birth").focus();
					return;
				}
				
				// 5. 연락처 확인
				var phone1 = $("#phone1").val();
				var phone2 = $("#phone2").val();
				var phone3 = $("#phone3").val();
				
				if(phone1.length < 3) {
					alert("지역번호를 확인해주세요.");
					$("#phone1").focus();
					return;
				} else if(phone2.length < 3) {
					alert("연락처를 확인해주세요.");
					$("#phone2").focus();
					return;
				} else if(phone3.length < 4) {
					alert("연락처를 확인해주세요.");
					$("#phone3").focus();
					return;
				} else {
					$("#phone").val(phone1+"-"+phone2+"-"+phone3);
				}
				
				var signCheck = confirm("입력한 정보로 회원가입을 하시겠습니까?");
				if(signCheck > 0) {
					$("#signForm").submit();
				}

			});
		});
	</script>
	<!-- JQuery End -->
	
    <div class="container">
      <!-- Content Start -->
      <div class="jumbotron">
        <h1>회원가입</h1>
        <div class="container-fluid">
			<form role="form" method="post" action="/user/signRun" id="signForm">
				<input type="hidden" id="rip" name="rip" value="" />
				<div class="form-group">
					<label for="id" >
						아이디
					</label>&nbsp;&nbsp;
					<input type="text" class="form" id="id" name="id" maxlength="15"/>
						&nbsp;&nbsp;
					<button type="button" class="btn btn-success" id="btnIdCheck">중복확인</button>
					<label id="labelIdCheck"></label>
					<input type="hidden" id="idCheck" value="0" />
				</div>
				<div class="form-group">	 
					<label for="subname" style="margin-right: 15px;">
						별명
					</label>&nbsp;&nbsp;
					<input type="text" class="form" id="subname" name="subname" maxlength="8"/>
					&nbsp;&nbsp;
					<button type="button" class="btn btn-success" id="btnSubnameCheck">중복확인</button>
					<label id="labelSubnameCheck"></label>
					<input type="hidden" id="subnameCheck" value="0" />
				</div>				
				<div class="form-group">	 
					<label for="name" style="margin-right: 15px;">
						이름
					</label>&nbsp;&nbsp;
					<input type="text" class="form" id="name" name="name"/>
				</div>
				<div class="form-group">	 
					<label for="pw" style="margin-right: 15px;">
						비밀번호
					</label>&nbsp;&nbsp;
					<input type="password" class="form" id="pw" name="pw"/>
				</div>
				<div class="form-group">	 
					<label for="pw2" style="margin-right: 15px;">
						비밀번호확인
					</label>&nbsp;&nbsp;
					<input type="password" class="form" id="pw2" name="pw2"/>
				</div>
				<div class="form-group">	 
					<label for="birth" style="margin-right: 15px;">
						생년월일
					</label>&nbsp;&nbsp;
					<input type="text" class="form" id="birth" name="birth" readonly="readonly"/>
				</div>
				<div class="form-group">	 
					<label for="gender" style="margin-right: 15px;">
						성별
					</label>&nbsp;&nbsp;
					<input type="radio" id="gender" name="gender" value="M" checked="checked"/>남&nbsp;&nbsp;
					<input type="radio" id="gender" name="gender" value="W" />여&nbsp;&nbsp;
				</div>
				<div class="form-group">	 
					<label for="phone" style="margin-right: 15px;">
						연락처
					</label>&nbsp;&nbsp;	
					<input type="text" id="phone1" maxlength="3" numberOnly/>
					<input type="text" id="phone2" maxlength="4" numberOnly/>
					<input type="text" id="phone3" maxlength="4" numberOnly/>
					<input type="hidden" id="phone" name="phone" />
				</div>
			</form>
			<button type="button" class="btn btn-success" id="btnSign">회원가입</button>
			<button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/" />'">돌아가기</button>
		</div>

      </div>
      <!-- Content End -->   
    </div>
</body>
</html>







    
