<?php
    require('config.php');
    $mysqli = new mysqli(DBHOST, DBUSER, DBPW, DB);
    if ($mysqli->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    } 
?>