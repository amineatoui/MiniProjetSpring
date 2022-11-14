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
          <h1>liste des affectations</h1>
           <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">enseignant</th>
      <th scope="col">matiere</th>
      <th scope="col">heure</th>
      <th scope="col">supprimer</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="a" items="${ listAff}">
    <tr>
      <th scope="row">${a.id }</th>
      <td>${a.ens.nom }</td>
      <td>${a.matiere.titre }</td>
      <td>${a.nbraff }</td>
      <td><a href="deleteAff/${a.id}"><i class="fa fa-trash"></i></a></td>
    </tr>
   </c:forEach>
  
  
  </tbody>
</table>
       <c:if test="${success==true}">
          <p class="text-success">affectation ajouté avec succé</p>
       </c:if>
       <c:if test="${!empty  error}">
            <p class="text-danger">${error}</p>
       </c:if>
      <h1>Affecter une matiere</h1>
       <form action="addAff" method="post">
           <div class="mb-3">
               <label for="enseignant"
                class="form-label">enseignant</label>
                 <select name="enseignant"  class="form-control" id="enseignant" required="required">
                 <c:forEach var="e" items="${listEns }">
                      <option value="${e.id }">${e.nom }</option>
                 </c:forEach>
                   </select>
          </div>
           <div class="mb-3">
               <label for="matiere" class="form-label">matiere</label>
                 <select name="matiere" class="form-control" id="matiere" required="required">
                 <c:forEach var="m" items="${listMat }">
                      <option value="${m.id }">${m.titre}</option>
                 </c:forEach>
                   </select>
          </div>
         
                     <div class="mb-3">
               <label for="nbr" class="form-label">charge d'heure</label>
               <input type="number" class="form-control" id="nbr" name="nbr"  required="required">
          </div>

 
  <button  type="submit" class="btn btn-primary"><i class="fa fa-plus">Ajouter</i></button>
</form>
     </div>
    
</body>
</html>