<%@tag description="Overall Page template" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">
	<head>
		<meta charset="utf-8">
		<title>Domino OIDC</title>
		<meta name="Description" content="To-Do - MVC">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=5.0">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta http-equiv="x-ua-compatible" content="IE=Edge">
		<link href="${pageContext.request.contextPath}/style/app.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/style/layout.css" rel="stylesheet">
	</head>
	<body class='index'>
		<header>
			<h1>
				Example App
			</h1>
		</header>
		<nav>
			<ul>
				<li>
					<a href="${mvc.basePath}">Home</a>
                    <a href="${mvc.basePath}/token">Token Page</a>
				</li>
			</ul>
		</nav>
		<main>
			<div>
      			<jsp:doBody />
      		</div>
		</main>
		<footer>
			
		</footer>
	</body>
</html>
