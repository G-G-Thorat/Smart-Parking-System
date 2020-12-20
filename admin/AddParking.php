 <?php
 if(isset($_POST['btnSave']))
{     
	define('HOST','localhost');
	define('USER','root');
	define('PASS','');
	define('DB','carparkingdb');	
	$con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
        
	$location=$_REQUEST['location'];
	$nslot =$_REQUEST['nslot']; 
	$longitude=$_REQUEST['longitude'];
	$latitude=$_REQUEST['latitude'];
        
	$price=$_REQUEST['price'];
	
        if(!is_numeric($location) && is_numeric($nslot) && is_numeric($longitude) && is_numeric($latitude) && is_numeric($price))
        {
            
       
	$res = mysqli_query($con,"INSERT INTO `slot` (`id`, `location`, `nslot`, `longitude`, `latitude`,`price`) VALUES (NULL, '$location', '$nslot', '$longitude', '$latitude','$price');");


	if($res)
        {
        $result = mysqli_query($con, "SELECT MAX(id)as id from slot");
        $maxid=0;
        while($row=mysqli_fetch_array($result))
        {
            $maxid=$row['id'];
           
            }
        $i=1;
        while($i<=$nslot)
        {
         $result1 = mysqli_query($con,"INSERT INTO `slotinfo1` (`id`,`locationid`, `slotno`, `status`,`location`,`price`) VALUES (NULL,$maxid, $i,0,'$location',$price);");
         $i=$i+1;   
            
        }
         
       
	echo "<script type='text/javascript'>alert('Successfully Saved');</script>";
          
       
        }
        }
        else
        {
        echo "<script type='text/javascript'>alert('Unable to Save');</script>";
       
        }
        
        
        
}


?>



<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
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
                            <h2>Add Parking Details</h2>
                            <br><br>
                            <table>
                                <tr>
                                    <td> Location Name:</td>
                                    <td><input type="text" name="location" value="" required/> </td>
                                </tr>
                                <tr>
                                    <td> Number of slot:</td>
                                    <td><input type="text" name="nslot" value="" required/></td>
                                </tr>
                                <tr>
                                    <td>Longitude: </td>
                                    <td><input type="text" name="longitude" value="" required/></td>
                                </tr>
                                <tr>
                                    <td>Latitude:</td>
                                    <td><input type="text" name="latitude" value="" required/></td>
                                </tr>
                                <tr>
                                    <td>Price:</td>
                                    <td><input type="text" name="price" value="" required/></td>
                                </tr>
                                
                                <tr>
                                     <td></td>
                                    <td><input type="reset" value="Reset"/> </td>
                                    <td><input type="submit" value="Save" name="btnSave" /></td>
                                </tr>
                        </center>
</table>
             </form>
         </div>
             <div id="footer"> MGM's College of Engineering, Nanded. </div>
    
    </body>
</html>