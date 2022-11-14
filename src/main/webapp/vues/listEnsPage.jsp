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
          <h1>liste des enseignants</h1>
           <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">nom</th>
      <th scope="col">prenom</th>
      <th scope="col">charge d'heure</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="e" items="${ listEns}">
    <tr>
      <th scope="row">${e.id }</th>
      <td>${e.nom }</td>
      <td>${e.prenom }</td>
      <td>${e.chargeH }</td>
    </tr>
   </c:forEach>
  
  
  </tbody>
</table>
      <h1>Ajouter un enseignant</h1>
      <c:if test="${success==true}">
         <p class="text-success">enseignant ajouté avec succé</p>
      </c:if>
      <c:if test="${success == false }">
         <p class="text-danger">enseignant exist déja</p>
      </c:if>
       <form action="addEns" method="post">
           <div class="mb-3">
               <label for="nom" class="form-label">nom</label>
               <input type="text" class="form-control" id="nom" name="nom"  required="required">
          </div>
           <div class="mb-3">
               <label for="prenom" class="form-label">prenom</label>
               <input type="text" class="form-control" id="prenom" name="prenom"  required="required">
          </div>
                     <div class="mb-3">
               <label for="charge" class="form-label">charge d'heure</label>
               <input type="number" class="form-control" id="nbr" name="charge"  required="required">
          </div>

 
  <button  type="submit" class="btn btn-primary"><i class="fa fa-plus">Ajouter</i></button>
</form>
     </div>
    
</body>
</html>