$(".tit").click(function () {
    // $(this).next().slid
	$(".neirong").find("ul").slideUp();
	$(this).next().find("ul").slideDown();
});
// $("#userlist").click(function () {
// 	$("#shows").load("jsp/userlist.jsp")
// })