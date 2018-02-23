<?php
    require('dbconnect.php');
    require("auth.php");
    $adrid = $_GET["userid"];
    $getKontakte ="SELECT kontakte.Adr_ID FROM kontakte WHERE kontakte.user_ID = 4 ";
    if ($result = $mysqli->query($getKontakte)) {
        echo "Error: " . $loeschenADRID . "<br>" . $mysqli->error;
    }
    //Kontakte löschen
    $loeschenkontakte = "DELETE FROM kontakte WHERE Adr_ID=$adrid";
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