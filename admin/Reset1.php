<?php

$locationid=$_REQUEST['locationid'];
$slotno=$_REQUEST['slotno'];

$con = mysqli_connect("localhost","root","","carparkingdb");


$res = mysqli_query($con,"UPDATE slotinfo1 SET status = 0 WHERE locationid = $locationid AND slotno=$slotno");
if($res)
        { echo "<script type='text/javascript'>alert('Updated Successfully');</script>";
       
        }
         else
        {
        echo "<script type='text/javascript'>alert('Unable to Reset');</script>";
       
        }
        
        


?>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="index.css">
         <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div id="header">
            <center><h2>Smart Parking</h2></center>
        </div>
         <div id="menu">
            <ul>
                <li><a href="AdminPanel.php">Admin Panel</a></li>
                <li><a href="AddParking.php">Add Details</a></li>
                <li><a href="viewparking.php">View Details</a></li>
                <li><a href="Pending.php">Pending Request </a></li>
                <li><a href="Reset.php">Reset Status </a></li>
                <li style="float:right"><a class="active" href="index.php">Logout</a></li>
            </ul>
        </div>
        <div id="content">
             
               
             
        </div>
             <div id="footer"> MGM's College of Engineering, Nanded. </div>
    
    </body>
</html>
