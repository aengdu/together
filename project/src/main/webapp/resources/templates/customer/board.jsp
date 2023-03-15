<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<jsp:include page="../fragments/head.jsp"/>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
.accordion {
  background-color: #eee;
  color: #444;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
  transition: 0.4s;
}

.active, .accordion:hover {
  background-color: #ccc;
}

.panel {
  padding: 0 18px;
  background-color: white;
  max-height: 0;
  overflow: hidden;
  transition: max-height 0.2s ease-out;
}
.container{
	margin-top:50px;
}
.row{
	margin:0px auto;
	width: 900px;
}
h1{
	text-align: center;
}

/* Style the links inside the pill navigation menu */
.pill-nav a {
  display: inline-block;
  color: black;
  text-align: center;
  padding: 14px;
  text-decoration: none;
  font-size: 17px;
  border-radius: 5px;
}

/* 마우스 올렸을 때 색상 변경 */
.pill-nav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.pill-nav a.active {
  background-color: dodgerblue;
  color: white;
}
</style>
<body>
<jsp:include page="../fragments/header.jsp"/>

<div>
 <div class="container">
 <h1>Tabs</h1>
  <div class="row">
  <div class="pill-nav">
  <a class="active" href="#home">자주묻는질문</a>
  <a href="#news">회원서비스</a>
  <a href="#contact">이용문의</a>
  <a href="#about">광고&제휴</a>
</div>
   <table class="table">
    <tr>
     <td>
<p></p>
<button class="accordion">[회원] 소셜 로그인으로 가입은 어떻게 진행되나요?</button>
<div class="panel">
  <p>소셜로그인은 별도 정보 입력 없이 이미 가입된 소셜로그인 (카카오,네이버,애플)정보만 인증하여 간편하게 가입/로그인 하실 수 있는 서비스입니다. 로그인 혹은 회원가입 페이지에서 선택하신 소셜로그인을 통해 진행이 가능합니다 .
  </p>
</div>

<button class="accordion">[회원] 탈퇴했던 아이디로 다시 가입할 수 있나요?
</button>
<div class="panel">
  <p>탈퇴한 아이디는 재가입이 불가능합니다.</p>
</div>

<button class="accordion">[회원] 회원탈퇴는 어떻게 하나요?
</button>
<div class="panel">
  <p> [마이페이지] > 설정(회원명 옆 톱니바퀴 모양) > [회원탈퇴] 에서 탈퇴 가능합니다.
  </p>
</div>

     </td>
    </tr>
   </table>
  </div>
 </div>
</div>
<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight) {
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    } 
  });
}

</script>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>