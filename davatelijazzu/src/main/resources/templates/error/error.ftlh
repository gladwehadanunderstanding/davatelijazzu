<!DOCTYPE>
<html>
<head>
<title>Error</title>
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<#assign
	known = Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
	<#assign 
		user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
		name = user.getUsername()
		isAdmin = user.isAdmin()
	>
<#else>
	<#assign
		name = "unknown"
		isAdmin = False
	>
</#if>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/topic">DidenkoCool</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="/topic">Topics</a>
      </li>
      <#if isAdmin>
      <li class="nav-item">
        <a class="nav-link" href="/user">Users</a>
      </li>
      </#if>
    </ul>
    <div class="navbar-text">${name}</div>
  </div>
</nav>
<div class="container mt-3">
<p class="text-center font-weight-bold">Unexpected error, sorry for troubles<p>
</div>
</body>
</html>