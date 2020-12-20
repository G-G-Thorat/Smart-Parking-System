<?php

$con = mysqli_connect("localhost","root","","carparkingdb");

$res =  mysqli_query($con,"SELECT * FROM pay");

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
                <li style="float:right"><a class="active" href="index.php">Logout</a></li>
            </ul>
        </div>
    <div id="content">
    <h2>Parking Details</h2>
    <table>
        <tr>
            <th>Location Id</th>
            <th>Slot No</th>
            <th>Arrival Date</th>
            <th>Arrival Time</th>
            <th>Price</th>
            <th>Transaction Id</th>
            <th>user Id</th>
            <th>Approve</th>
      
        </tr>
            <?php
            while($row = mysqli_fetch_array($res))
                {
                ?>
        <tr>
            <td><?php echo $row{"locationid"};?></td>
            <td> <?php echo $row{"slotno"};?></td>
            <td>  <?php echo $row{"arrdate"};?></td>
            <td><?php echo $row{"arrtime"};?></td>
            <td><?php echo $row{"price"};?></td>
            <td><?php echo $row{"Tid"};?></td>
            <td><?php echo $row{"uid"};?></td>
            <td><a href="Approve.php?locationid=<?php echo $row{"locationid"} . "&slotno=". $row{"slotno"} . "&uid=". $row{"uid"} ?>"><input type="submit"  name="btnUpdate" value="Approve"></a></td>
        </tr>
            <?php
            
            }?>
    </table>
    </div>

</body>
</html>
