<%--
  Created by IntelliJ IDEA.
  User: WangCX
  Date: 2019/8/11
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
        <tr>
            <th>Id</th>
            <th>用户名</th>
            <th>密码</th>
            <th>电话</th>
            <th>用户类型</th>
            <th>用户禁用</th>

        </tr>
    </table>
</div>
<div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">

    </table>
    <script src = "/js/jquery-3.3.1.js" type="text/javascript"></script>
    <script>
        function a() {
            $.get(
                "/manage/user/list.do",
                function (dt) {
                    if(dt.status != 0){
                        alert(dt.mag)
                    }else{
                        // alert(dt.data[4])
                        for (var i = 0;i<=dt.data.length;i++){
                            var s ="<tr><td>"+dt.data[i].u_id+"</td><td>"+dt.data[i].u_name+"</td><td>"+dt.data[i].u_pwd+
                                "</td><td>"+dt.data[i].u_tel+"</td><td><a href=''>操作</a></td><td><a href=''>禁用</a></td></tr>";
                            $(".tbl-content").next().append(s);
                        }
                    }

                },
                "JSON"
            )
    </script>
</div>
</body>
</html>
