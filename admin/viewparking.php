<?php

$con = mysqli_connect("localhost","root","","carparkingdb");

$res =  mysqli_query($con,"SELECT * FROM slot");

?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
       <style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
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
                <li><a href="Pending.php">Pending Request </a></li>
                <li><a href="Reset.php">Reset Status </a></li>
                <li style="float:right"><a class="active" href="index.php">Logout</a></li>
            </ul>
        </div>
    <div id="content">
    <h2>Parking Details</h2>
    <table>
        <tr>
            <th>Location Name</th>
            <th>Number of Slots</th>
            <th>Longitude</th>
            <th>Latitude</th>
            <th>Price</th>
            <th>Update Record</th>
        </tr>
            <?php
            while($row = mysqli_fetch_array($res))
                {
                ?>
        <tr>
            <td><?php echo $row{"location"};?></td>
            <td> <?php echo $row{"nslot"};?></td>
            <td>  <?php echo $row{"longitude"};?></td>
            <td><?php echo $row{"latitude"};?></td>
            <td><?php echo $row{"price"};?></td>
            <td><a href="Update.php?id=<?php echo $row{"id"} . "&location=". $row{"location"} . "&nslot=".  $row{"nslot"} ."&longitude= ".$row{"longitude"} ."&latitude=". $row{"latitude"}."&price=". $row{"price"}; ?>"><input type="submit"  name="btnUpdate" value="Update"></a></td>
        </tr>
            <?php
            
            }?>
    </table>
    </div>
       
</body>
</html>
