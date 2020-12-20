<?php

$id=$_REQUEST['id'];
$location=$_REQUEST['location'];
$nslot=$_REQUEST['nslot'];
$longitude=$_REQUEST['longitude'];
$latitude=$_REQUEST['latitude'];
$price=$_REQUEST['price'];

    
if(isset($_POST['btnUpdate']))
{

    	
$con = mysqli_connect("localhost","root","","carparkingdb");

if(!is_numeric($location) && is_numeric($nslot) && is_numeric($longitude) && is_numeric($latitude) && is_numeric($price))
        {
$res = mysqli_query($con,"UPDATE slot SET location = '$location', nslot = $nslot, longitude=$longitude, latitude = $latitude , price=$price WHERE id = $id");
if($res)
        { header ("location: viewparking.php");
        }

        }
         else
        {
        echo "<script type='text/javascript'>alert('Unable to Update');</script>";
       
        }
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
             
                <form method="POST">
                    
                        <center>
                            <br>
                            <h2>Update Details</h2>
                            <br>
                            <table>
                                <tr>
                                    <td> Location Name:</td>
                                    <td><input type="text" name="location" value="<?php echo $location;?>" required/></td>
                                </tr>
                                <tr>
                                    <td> Number of slot:</td>
                                    <td><input type="text" name="nslot" value="<?php echo $nslot;?>" required/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Longitude: </td>
                                    <td><input type="text" name="longitude" value="<?php echo $longitude; ?>" required />
                                    </td>
                                </tr>
                                <tr>
                                    <td>Latitude:</td>
                                    <td><input type="text" name="latitude" value="<?php echo $latitude;?>" required/>
                                    </td>
                                </tr>
                                 <tr>
                                    <td>Price:</td>
                                    <td><input type="text" name="price" value="<?php echo $price;?>" required/>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td><td><input type="submit" value="Update" name="btnUpdate" />
                                    </td>
                                </tr>
                        </center>
</table>
                    </form>
             
        </div>
             <div id="footer"> MGM's College of Engineering, Nanded. </div>
    
    </body>
</html>
