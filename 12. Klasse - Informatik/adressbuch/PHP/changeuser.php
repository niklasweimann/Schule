<?php
    require('dbconnect.php');
    require("auth.php");
    $adrid = $_GET["userid"];
    //Kontakte löschen
    $loeschenkontakte = "DELETE FROM  kontakte WHERE Adr_ID=$adrid";
    if (!$mysqli->query($loeschenkontakte)) {
        echo "Error: " . $loeschenADRID . "<br>" . $mysqli->error;
    }
    //konto löschen
    $loeschenuser = "";
    if (!$mysqli->query($loeschenADRID)) {
        echo "Error: " . $loeschenADRID . "<br>" . $mysqli->error;
    }
    header("Location: ../main.php");
?>