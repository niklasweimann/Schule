<?php
    require('dbconnect.php');
    require("auth.php");
    //EintragID
    $entryID = $_GET['id'];
    //Adresse
    $strasse = $_GET["strasse"];
    $plz = $_GET["plz"];
    $Hausnummer = $_GET["Hausnummer"];
    $ort = $_GET["ort"];
    //Kontakt
    $vorname = $_GET["vorname"];
    $nachname = $_GET["nachname"];
    $birthdate = $_GET["birthdate"];
    $email = $_GET["email"];
    $telefonnr = $_GET["telefonr"];
    $userid = $_SESSION['userid'];

    $sqlUpdate = "UPDATE kontakte, adresse SET Nachname='$nachname',Vorname='$vorname',Telefonnummer='$telefonnr',EMail='$email',Geburtsdatum='$birthdate',adresse.Strasse='$strasse', adresse.PLZ='$plz', adresse.Hausnummer='$Hausnummer', adresse.Ort='$ort' WHERE kontakte.ID='$entryID'";
    if (!$mysqli->query($sqlUpdate)) {
        echo "Error: " . $sqlUpdate . "<br>" . $mysqli->error;
    }
    header("Location: ../main.php");
?>