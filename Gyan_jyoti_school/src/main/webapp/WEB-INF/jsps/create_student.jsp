<%@ page import="com.gyanjyoti.controller.WELOCMEController" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Add custom styles here */
        .container.form {
            max-width: 500px;
            margin: auto;
            margin-top: 50px;
            margin-bottom: 80px;
        }
        .form-group label {
            font-weight: bold;
        }
          body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #f8f9fa;
    margin: 0;
    padding: 0;
  }
  .jumbotron {
    background-color:#455EE7;
    color: #fff;
    padding: 1px 0;
    text-align: center;
    margin-bottom: 30px;
  }
  .btn-container {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
  }
   .btn-container .btn, .btn-container .link-box {
      margin: 10px;
      width: 150px;
      font-size: 15px;
      background-color:#28BA0B;
      color: #fff;
      border: none;
      border-radius: 25px;
      text-decoration: none;
      text-align: center;
      padding: 10px 20px;
      transition: background-color 0.3s, color 0.3s;
      display: flex;
      align-items: center;
      justify-content: center;
       font-weight: bold;
    }
    .btn-container .btn:hover, .btn-container .link-box:hover {
      background-color: #fff;
      color: #040D7A;
    }
  .header-text {
    font-size: 36px;
    font-weight: bold;
    margin-bottom: 30px;
     font-family: 'Times New Roman';
      letter-spacing: 0.1em;
       word-spacing: 0.5em; /* Add space between letters */
  }
  marquee {
    background-color:  #C6140B;
    color: #fff;
    padding: 10px;
    font-size: 15px;
    border-radius: 5px;
  }
  .container {
    margin-top: 20px;
  }
  .infrastructure {
    text-align: center;
    margin-bottom: 20px;
  }
  .infrastructure img {
    margin: 10px;
    width: 50px;
  }

    /* Custom class for link box color */
    .custom-link-box {
      background-color:#2FC70A !important; /* Change the box color here */
    }
    .dropbtn {
      margin: 10px;
      width: 150px;
      font-size: 15px;
     border-radius: 25px;
  background-color: #04AA6D;
  color: white;
     padding: 10px 20px;
  font-size: 16px;
   background-color:#28BA0B;
      color: #fff;
      
     
      font-weight: bold;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color:#28BA0B;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}
    </style>
</head>
<%
WELOCMEController.setAppSession(session);
%>
<body>
<marquee behavior="scroll" direction="left">Children are the future of our India let's educate them</marquee>
<div class="jumbotron">
  <div class="container">
    <%--
    <h1 class="header-text">GYAN JYOTI PUBLIC SCHOOL</h1>
 --%>
    <div class="btn-container">
      <a href="/home" class="btn btn-primary custom-link-box">Home</a>
      <a href="/listStudentCt?id=${id}" class="btn btn-primary custom-link-box">See All student</a>
      
      
         <a href="/about" class="btn btn-primary custom-link-box">About us</a>
       <div class="dropdown">
  <button class="dropbtn">Login</button>
  <div class="dropdown-content">
    <a href="#">Principle</a>
    <a href="/classteacherLogin">class teacher</a>
    <a href=""></a>Student
  </div>
</div>
      </div>
     
    </div>
  </div>



 <
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<div class="container">
  <h1> Welcome Mr ${name}</h1>
  <br>
   <h4> Your class:  ${className} </h4><br>
  
 <h4>  Email  ${email}</h4>
  <br>
</div>
            
    <div class="container form">
        <h2 class="text-center mb-4">New Student</h2>
        <form action="/create"  method="post">
                 <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <textarea id="address" name="address" class="form-control" rows="3" required></textarea>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <textarea id="password" name="password" class="form-control"  required></textarea>
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="tel" id="phone" name="phone" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="fathersName">Father's Name:</label>
                <input type="text" id="fathersName" name="fathersName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="dob">Date of Birth:</label>
                <input type="date" id="dob" name="dob" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="classTeacherName">Class Teacher's Name:</label>
                <input type="text" id="classTeacherName" name="classTeacherName" value="${name}" class="form-control" readonly>
            </div>
            <div class="form-group">
                <label for="classTeacherId">Class Teacher ID:</label>
                <input type="text" id="classTeacherId" name="classTeacherId" value="${id} " class="form-control" readonly>
            </div>
            <div class="form-group">
                <label for="className">Class Name:</label>
                <input type="text" id="className" name="className" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="busRouteno">Bus Route Number:</label>
                <input type="text" id="busRouteno" name="busRouteno" class="form-control">
            </div>
            <div class="form-group">
                <label for="addmissionNo">Admission Number:</label>
                <input type="text" id="addmissionNo" name="addmissionNo" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="rollNo">Roll Number:</label>
                <input type="text" id="rollNo" name="rollNo" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <!-- Bootstrap JS (Optional) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
