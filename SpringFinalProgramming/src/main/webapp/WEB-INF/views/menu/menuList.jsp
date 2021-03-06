<%@ page contentType="application/json; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

{ 
	"list": [
		<c:forEach var="menu" items="${list}" varStatus="status">
			{
				"mid": "${menu.mid}",
				"mgroup": "${menu.mgroup}",
				"mname": "${menu.mname}",
				"hot_ice": "${menu.hot_ice}",
				"mprice": "${menu.mprice}",
				"mcontents": "${menu.mcontents}",
				"msavedfile": "${menu.msavedfile}",
				"mmimetype": "${menu.mmimetype}",
				"sid": "${menu.sid}"
			}
			<c:if test="${!status.last}">,</c:if>
		</c:forEach>
	],
	
	"pageNo": ${pageNo},
	"rowsPerPage": ${rowsPerPage},
	"pagesPerGroup": ${pagesPerGroup},
	"totalBoardNo": ${totalBoardNo},
	"totalPageNo": ${totalPageNo},
	"totalGroupNo": ${totalGroupNo},
	"groupNo": ${groupNo},
	"startPageNo": ${startPageNo},
	"endPageNo": ${endPageNo},
	"keyword": "${keyword}"
}