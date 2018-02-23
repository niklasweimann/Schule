<?php
require('dbconnect.php');
require("auth.php");
//Adresse einfügen
$strasse = $_GET["strasse"];
$plz = $_GET["plz"];
$Hausnummer = $_GET["Hausnummer"];
$ort = $_GET["ort"];
$addAdresse = ("INSERT INTO adresse (Adr_ID, Strasse, PLZ, Hausnummer, Ort) VALUES (NULL, \"$strasse\", \"$plz\", \"$Hausnummer\", \"$ort\")");
echo("Einfügen von Adresse"); //DEBUG
echo("<br>");
if (!$mysqli->query($addAdresse)) {
    echo "Error: " . $addAdresse . "<br>" . $mysqli->error;
}

//ID der Adresse abfragen
$abfrage = ("SELECT Adr_ID FROM adresse ORDER BY Adr_ID DESC LIMIT 0,1 ");
if (!$mysqli->query($abfrage)) {
    echo "Error: " . $abfrage . "<br>" . $mysqli->error;
}
else{
    $neue_id = $mysqli->query($abfrage);
    $row = $neue_id->fetch_row();
}

//kontakt in die Datenbank eintragen
$vorname = $_GET["vorname"];
$nachname = $_GET["nachname"];
$birthdate = $_GET["birthdate"];
$email = $_GET["email"];
$telefonnr = $_GET["telefonr"];
$adrid = $row[0];
$userid = $_SESSION['userid'];

$addKontakt = ("INSERT INTO kontakte (ID, Nachname, Vorname, Telefonnummer, EMail, Geburtsdatum, Adr_ID, user_ID) VALUES (Null, \"$nachname\", \"$vorname\", \"$telefonnr\", \"$email\", \"$birthdate\", \"$adrid\", \"$userid\")");
echo("Einfügen von kontakt"); //DEBUG
if (!$mysqli->query($addKontakt)) {
    echo "Error: " . $addAdresse . "<br>" . $mysqli->error;
}

//ID des Nutzers abfragen
$abfrage2 = "SELECT ID FROM kontakte ORDER BY ID DESC LIMIT 0,1 "; 
if (!$mysqli->query($abfrage2)) {
    echo "Error: " . $abfrage2 . "<br>" . $mysqli->error;
}
else{
    $neue_id = $mysqli->query($abfrage2);
}
echo("Jetzt sollte weitergeleitet werden.");
header("Location: ../main.php");
?>
