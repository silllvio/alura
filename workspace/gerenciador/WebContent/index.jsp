
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	Bem vindo ao nosso gerenciador de empresas!
	<br />

<br>
<c:if test="${usuarioLogado!=null}">
    Você está logado como ${usuarioLogado.email}<br/>
</c:if>

 Usuario ${usuarioLogado.email}

<br>

	<form action="control?tarefa=novaEmpresa" method="POST">
		Nome: <input type="text" name="nome"> <input type="submit"
			value="enviar">

	</form>

<br>
<br>
<form action="control?tarefa=Login" method="POST">
	LOGIN: <input type = "email" name= "email"/>
	SENHA: <input type = "password" name = "senha" />
		   <input type = "submit" value = "Enviar" />

</form>


<form action="control?tarefa=BuscaEmpresa" method="POST">
	Buscar Empresa: <input type = "text" name= "empresaBuscada"/>
	 <input type="submit" value="Buscar" />
</form>

<br>
<br>

<form action="control?tarefa=Logout" method="post">
    <input type="submit" value="Logout" />
</form>

</body>
</html>