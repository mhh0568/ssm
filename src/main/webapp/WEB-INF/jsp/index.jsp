<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/ssm/js/jquery.js"></script>
    <script type="text/javascript" src="/ssm/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/ssm/css/bootstrap.min.css">
</head>
<body>
    <table class="table table-striped" class="table table-bordered" style="width: 850px;height: 300px;"align="center">
        <caption><h1 align="center">鲜花管理系统</h1></caption>
        <tr>
            <td colspan="2">
                <button id="addbtn" class="btn-primary" data-toggle="modal" data-target="#addModal">添加</button>
                <button onclick="delbatchbtn()" class="btn-danger">批量删除</button>
            </td>
            <td colspan="4">
                <form action="/ssm/index" id="form" method="get" class="form-inline">
                    <div class="form-group">
                        <select id="flowerCategory" name="cid" value="${queryVo.cid}" class="form-control">
                            <option value="">鲜花种类</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>花名:</label>
                        <input type="text" style="width: 100px" name="fname" value="${queryVo.fname}" class="form-control" placeholder="请输入花名">
                    </div>
                    <div class="form-group">
                        <label>价格:</label>
                        <input type="text" style="width: 140px" name="low" class="form-control" value="${queryVo.low}" id="low" placeholder="请输入区间最低值"> -
                        <input type="text" style="width: 140px" name="high" class="form-control" value="${queryVo.high}" id="high" placeholder="请输入区间最高值">
                    </div>
                    <button type="submit" class="btn btn-success">查询</button>
                </form>
            </td>
        </tr>
        <tr>
            <th>
                <div class="checkbox">
                    <label>
                        <input onclick="press()" id="father" type="checkbox" />
                    </label>
                </div>
            </th>
            <th>鲜花编号</th>
            <th>花名</th>
            <th>价格</th>
            <th>品种</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${flowers}" var="flower">
            <tr>

                <td>
                    <div class="checkbox">
                        <label>
                            <input class="son" name="fid" value="${flower.fid}" type="checkbox" />
                        </label>
                    </div>
                </td>
                <td>${flower.fid}</td>
                <td>${flower.fname}</td>
                <td>${flower.price}</td>
                <td>${flower.cname}</td>
                <td>
                    <button onclick="updatebtn(${flower.fid})" class="btn-info" data-toggle="modal" data-target="#updateModal" id="updatebtn">修改</button>
                    <button onclick="delbtn(${flower.fid})" class="btn-warning">删除</button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6" align="center">
                ${pages}
            </td>
        </tr>
    </table>
        <script>
            <%--查询所有鲜花种类信息--%>
            $.ajax({
                url:"/ssm/queryCategories",
                type:"get",
                dataType:"json",
                success:function (data) {
                    for (var i=0; i<data.length;i++){

                        $("#flowerCategory").append("<option  value="+data[i].cid+">"+data[i].cname+"</option>")
                    }
                    $('#flowerCategory option').each(function () {
                        if($(this).val()=="${queryVo.cid}"){
                            $(this).prop("selected","true");
                        }
                    })

                }
            });
            //下拉列表改变时 查询条件为cid的鲜花
            $('#flowerCategory').change(function () {
                var cid = $(this).val();
                window.location.href="/ssm/index?cid="+cid;
            });

            /*var form = $("#form").serialize();
            $.ajax({
                url:"/ssm/index",
                data:form,
                Type:"get"
            });*/
        </script>



    <!-- Modal 添加模态窗-->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" align="center" id="myModalLabel">添加鲜花信息</h4>
                </div>
                <div class="modal-body">
                    <form action="/ssm/addOrUpdateFlower" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">花名</label>
                            <div class="col-sm-10">
                                <input type="text" name="fname" class="form-control" id="fname" placeholder="请输入花名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">鲜花价格</label>
                            <div class="col-sm-10">
                                <input type="text" name="price" class="form-control" id="price" placeholder="请输入鲜花价格">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">鲜花种类</label>
                            <div class="col-sm-10">
                                <select id="category" name="cid" value="${queryVo.cid}" class="form-control">
                                    <option value="">鲜花种类</option>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <div class="col-sm-offset-2 col-sm-10" align="center">
                                <button type="submit" class="btn btn-primary">添加</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script>
        $("#addbtn").click(function () {
            <%--查询所有鲜花种类信息，回写到添加页面--%>
            $.ajax({
                url:"/ssm/queryCategories",
                type:"get",
                dataType:"json",
                success:function (data) {
                    for (var i=0; i<data.length;i++){

                        $("#category").append("<option  value="+data[i].cid+">"+data[i].cname+"</option>")
                    }
                }
            });
        });
    </script>
    <!-- Modal 修改模态窗-->
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" align="center">修改鲜花信息</h4>
                </div>
                <div class="modal-body">


                    <form action="/ssm/addOrUpdateFlower" class="form-horizontal">
                        <input type="hidden" name="fid" id="fid" class="form-control">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">花名</label>
                            <div class="col-sm-10">
                                <input type="text" name="fname" class="form-control" id="updatefname" placeholder="请输入花名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">鲜花价格</label>
                            <div class="col-sm-10">
                                <input type="text" name="price" class="form-control" id="updateprice" placeholder="请输入鲜花价格">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">鲜花种类</label>
                            <div class="col-sm-10">
                                <select id="updatecategory" name="cid" value="${queryVo.cid}" class="form-control">
                                    <option value="">鲜花种类</option>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <div class="col-sm-offset-2 col-sm-10" align="center">
                                <button type="submit" class="btn btn-primary">修改</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>
        //回写需要修改的鲜花信息
        function updatebtn(fid) {
            $.ajax({
               url:"/ssm/queryByFid" ,
                data:{"fid":fid},
                dataType:"json",
                Type:"post",
                success:function (data) {
                   alert(data.fid)
                   var cid=data.cid;
                   $("#fid").val(data.fid);
                    $("#updatefname").val(data.fname);
                    $("#updateprice").val(data.price);

                <%--查询所有鲜花种类信息--%>
                    $.ajax({
                        url:"/ssm/queryCategories",
                        type:"get",
                        dataType:"json",
                        success:function (data) {
                            for (var i=0; i<data.length;i++){

                                $("#updatecategory").append("<option  value="+data[i].cid+">"+data[i].cname+"</option>")
                            }
                            $('#updatecategory option').each(function () {
                                if($(this).val()==cid){
                                    $(this).prop("selected","true");
                                }
                            })

                        }
                    });
               }
            });
        }
    </script>
    <script>
        //单删
        function delbtn(fid) {
            location.href="/ssm/delFlower?fid="+fid;
        }
        //批删
        function delbatchbtn() {
            var fid=[];
            $(".son ").each(function () {
                if($(this).prop("checked")){
                    fid.push($(this).val());
                }
            });
            if (fid.length==0){
                alert(fid.length)
                alert("至少选中一条记录")
            }else{
                location.href="/ssm/delFlower?fid="+fid.join(",");
            }
        }
        function press() {
                $(".son").each(function () {
                    $(this).prop('checked',$("#father").prop('checked'));
                })
        
        }


        $(".son").click(function () {

            if($(".son:checked").length==$(".son").length){
                $("#father").prop("checked",true)
            }else{
                $("#father").prop("checked",false)
            }

        });


    </script>

</body>
</html>
