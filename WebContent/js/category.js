/**
 * 加载类别的js脚本
 */

$(function(){
			$.ajax({
				url:"/market/category/showCategory.action",
				type:"POST",
				contentType:"application/json",
				success:function(data){
				
					for(var i=0; i<data.length; i++){
						var p = "<p id='pp"+(i+1)+"' onmouseover='showNav("+i+")'>"+data[i]["cate_name"]+'</p>';
						var div = "<div id='nav"+(i+1)+"' class='nav1'><ul>";
						var li = '';
						var end = "</ul></div>";
						for(var j=0; j<data[i].cateItems.length; j++){
							li += "<li><a href='#'>"+data[i].cateItems[j].itemName+"</a></li><div class='hr'></div>";
						}
					var content = p+div+li+end;
					$('.main-nav').append(content);
					}
				}
			});

		});

$('#pp1').mouseover(function(){
	alert('aaa');
	$('#nav1').toggle('blind');
});



