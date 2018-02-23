<?php
    require('dbconnect.php');
    require("auth.php");
    $adrid = $_GET["adrid"];
    $loeschenADRID = "DELETE FROM adresse WHERE Adr_ID=$adrid";
    if (!$mysqli->query($loeschenADRID)) {
        echo "Error: " . $loeschenADRID . "<br>" . $mysqli->error;
    }
    $id = $_GET["id"];
    $loeschenID = "DELETE FROM kontakte WHERE ID=$id";
    if (!$mysqli->query($loeschenID)) {
        echo "Error: " . $loeschenID . "<br>" . $mysqli->error;
    }
    header("Location: ../main.php");
?>