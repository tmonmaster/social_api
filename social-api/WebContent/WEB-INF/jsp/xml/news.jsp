<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<news>
	<c:forEach var="news" items="${newsList}">
		<item>
			<socialName>${news.socialName}</socialName>
			<title>${news.title}</title>
			<preview>${news.preview}</preview>
			<image>${news.image}</image>
			<date>${news.date}</date>
			<link>${news.link}</link>
			<provider>${news.provider}</provider>
		</item>
	</c:forEach>
</news>
    