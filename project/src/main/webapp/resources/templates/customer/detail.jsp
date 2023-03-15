<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../fragments/head.jsp"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<body>
<jsp:include page="../fragments/header.jsp"/>
<div>
<div class="wrapper row3 rows">
  <main class="container clear">
    <table class="table">
      <tr>
        <th width=20% class="text-center">번호</th>
        <td width=30% class="text-center">{{cs_detail.nno}}</td>
        <th width=20% class="text-center">작성일</th>
        <td width=30% class="text-center">{{cs_detail.dbday}}</td>
      </tr>
      <tr>
        <th width=20% class="text-center">이름</th>
        <td width=30% class="text-center">{{cs_detail.name}}</td>
        <th width=20% class="text-center">조회수</th>
        <td width=30% class="text-center">{{cs_detail.hit}}</td>
      </tr>
      <tr>
        <th width=20% class="text-center">제목</th>
        <td colspan="3">{{cs_detail.subject}}</td>
      </tr>
      <tr>
        <td colspan="4" class="text-left" valign="top" height="200"><pre style="white-space: pre-wrap;background-color: white;border: none">{{cs_detail.content}}</pre></td>
      </tr>
      <tr>
        <td colspan="4" class="text-right">
          <a :href="'customer/update.do?nno='+customer_detail.nno" class="btn btn-xs btn-danger">수정</a>
          <a :href="'customer/delete.do?nno='+customer_detail.nno" class="btn btn-xs btn-success">삭제</a>
          <a href="customer/list.do" class="btn btn-xs btn-info">목록</a>
        </td>
      </tr>
    </table>
  </main>
</div>>
</div>
<script>
new Vue({
	  el:'.rows',
	  data:{
		  nno:${nno},
		  board_detail:{}
	  },
	  mounted:function(){
		  let _this=this
		  axios.get("http://localhost/web/customer/detail_vue.do",{
			  params:{
				  nno:this.nno
			  }
		  }).then(function(response){
			  _this.cs_detail=response.data
		  })
	  }
})
</script>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>