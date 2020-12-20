<?php

if(isset($_POST['btnLogin']))
{
    
    $uname=$_POST['uname'];
   $pwd = $_POST['pwd'];
   
   if($uname=="admin" && $pwd=="admin")
   {header ("location: AdminPanel.php");
   }
   else {
                 echo "<script type='text/javascript'>alert('Enter Valid User id and Password');</script>";
          
   }
   
}

?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login Form</title>
        <link rel="stylesheet" href="index.css">
    </head>
    <body>
        <hgroup>
            <h1>Smart Parking</h1>
            <h3>Admin Login</h3>
        </hgroup>
        <div class="login-page">
            <div class="form">
                <form method="POST">
                    <form class="login-form">
                        <input type="text" name="uname" value=""placeholder="username" />
                        <input type="password" name="pwd" value=""placeholder="Password" />
                        <input type="submit" value="login" name="btnLogin" />
                    </form>
                </form>
            </div>
        </div>
    </body>
</html>
