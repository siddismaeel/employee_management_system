<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/assets/css/login.css">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<div class="sidenav">
         <div class="login-main-text">
            <h2>Employee Management<br> Password Change Form</h2>
            <p>Enter you new Password.</p>
         </div>
      </div>
      
      <div class="main">
         <div class="col-md-8 ">
            <div class="login-form">
<form action="change-password.html" method="post">
                  <div class="form-group">
                     <label>Enter New password:</label>
                     <input type="password" id="newpassword" placeholder="Enter password" name="newpassword">
                  </div>
				<div class="form-group">
                     <label>Confirm New password:</label>
                     <input type="password" id="confirmpassword" placeholder="Confirm Password" name="confirmnewpassword">
                  </div>
				  <div class="registrationFormAlert" style="color:green;" id="CheckPasswordMatch"></div>                
                  <button type="submit" id="button" class="btn btn-black" onclick="matchPassword()">Change Password</button>
                  
               </form>
            </div>
         </div>
      </div>
      

<!--  <form action="change-password.html" method="post">
Enter new Password
<input type="password" id="newpassword" placeholder="Enter password" name="newpassword">
Confirm new Password
<input type="password" id="confirmpassword" placeholder="Confirm Password" name="confirmnewpassword">
<div class="registrationFormAlert" style="color:green;" id="CheckPasswordMatch"></div>

<input type="submit" value="Change Password" onclick="matchPassword()">
</form>
-->
<script>
    function checkPasswordMatch() {
        var password = $("#newpassword").val();
        var confirmPassword = $("#confirmpassword").val();
        if (password != confirmPassword)
            $("#CheckPasswordMatch").css('color','red').html("Passwords does not match!");
        else
            $("#CheckPasswordMatch").css('color','green').html("Passwords match.");
    }
    $(document).ready(function () {
       $("#confirmpassword").keyup(checkPasswordMatch);
    });
    </script>
    
</body>
</html>