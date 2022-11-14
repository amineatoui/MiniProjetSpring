<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
     
         <nav class="navbar navbar-light bg-light m-4">
         <a class="btn btn-outline-success me-3" href="/MiniProjetSpring/listMatiere" type="button">Gestion Matiere</a>
         <a class="btn btn-outline-success me-3" href="/MiniProjetSpring/enseignants" type="button">Gestion Enseignant</a>
         <a class="btn btn-outline-success me-3" href="/MiniProjetSpring/affectations" type="button">Gestion Affectation</a>
     
     </nav>
     
     <div class="container">
          <h1>liste des matieres</h1>
           <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Title</th>
      <th scope="col">Niveau</th>
      <th scope="col">Nombre d'heure</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="mat" items="${ listM}">
    <tr>
      <th scope="row">${mat.id }</th>
      <td>${mat.titre }</td>
      <td>${mat.niveau }</td>
      <td>${mat.nbr }</td>
    </tr>
   </c:forEach>
  
  
  </tbody>
</table>
      <h1>Ajouter une matiere</h1>
      <c:if test="${success==true}">
         <p class="text-success">matiere ajouté avec succé</p>
      </c:if>
      <c:if test="${success == false }">
         <p class="text-danger">matiere exist déja</p>
      </c:if>
       <form action="addMatiere" method="post">
           <div class="mb-3">
               <label for="titre" class="form-label">titre</label>
               <input type="text" class="form-control" id="titre" name="titre"  required="required">
          </div>
           <div class="mb-3">
               <label for="niveau" class="form-label">niveau</label>
               <input type="text" class="form-control" id="niveau" name="niveau"  required="required">
          </div>
                     <div class="mb-3">
               <label for="nbr" class="form-label">nombre d'heure</label>
               <input type="number" class="form-control" id="nbr" name="nbr"  required="required">
          </div>

 
  <button  type="submit" class="btn btn-primary"><i class="fa fa-plus">Ajouter</i></button>
</form>
     </div>
    
</body>
</html>