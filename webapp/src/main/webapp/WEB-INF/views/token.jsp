<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fn" uri="jakarta.tags.functions" %>
<t:layout>
  <h2>Active Authentication Token</h2>
  
  <h4>Token</h4>
  
  <p><c:out value="${token.token}"/></p>
  
  <h4>Claims</h4>
  <dl>
  <c:forEach items="${token.claims}" var="entry">
    <dt><c:out value="${entry.key}"/></dt>
    <dd>
      <c:out value="${entry.value}"/>
      <c:if test="${entry.key == 'auth_time' or entry.key == 'exp' or entry.key == 'iat'}">
      <br />
      <c:out value="${temporal.toTimestamp(entry.value)}"/>
      </c:if>
    </dd>
  </c:forEach>
  </dl>
</t:layout>