
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        table{
            width: 500px;
            border-collapse: collapse;
        }
        table th, table td{
            border: 1px solid black;
            padding: 4px;
        }
        table caption{
            text-indent: -9999px;
        }
    </style>
</head>
<body>
    <div id="wrap">
        <header>
            <h1>사원목록</h1>
        </header>
        <article>
            <table>
                <caption>사원목록테이블</caption>
                <colgroup>
                    <col width="80px"/>
                    <col width="*"/>
                    <col width="150px"/>
                    <col width="80px"/>
                </colgroup>
                <thead>
                    <tr>
                        <td colspan="4" class="no-border">
                            <form action="empSearch" method="post">
                                <select name="type">
                                    <option value="0">사번</option>
                                    <option value="1">이름</option>
                                    <option value="2">직종</option>
                                    <option value="3">부서</option>
                                </select>
                                <input type="text" name="value"/>
                                <button type="button"
                                onclick="exe(this.form)">검색</button>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <th>사번</th>
                        <th>이름</th>
                        <th>직종</th>
                        <th>부서</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="vo" items="${ar}">
                    <tr>
                        <td>${vo.empno}</td>
                        <td>${vo.ename}</td>
                        <td>${vo.job}</td>
                        <td>${vo.deptno}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </article>
    </div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <script>
        

        function exe(frm){
            //유효성 검사
            let v = frm.value.value;
            if(v.trim().length < 1){
                alert("검색어를 입력하세요");
                frm.value.focus();
                return;
            }
            frm.submit();
        }
    </script>
</body>
</html>
