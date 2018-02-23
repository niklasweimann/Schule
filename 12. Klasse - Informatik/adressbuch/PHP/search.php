<?php
    require("auth.php");
    require('dbconnect.php');
    $search = $_GET['search'];
    $_SESSION['searchTag'] = $search;
    $userid = $_SESSION['userid'];
    $searchsql = "SELECT * FROM kontakte,adresse WHERE kontakte.Adr_ID = adresse.Adr_ID and kontakte.user_ID = $userid and(Vorname LIKE '%".$search."%' OR Nachname LIKE '%".$search."%' OR kontakte.Telefonnummer LIKE '%".$search."%' OR kontakte.EMail LIKE '%".$search."%' OR kontakte.Geburtsdatum LIKE '%".$search."%' OR adresse.Strasse Like '%".$search."%' OR adresse.PLZ LIKE '%".$search."%' OR adresse.Hausnummer LIKE '%".$search."%' OR adresse.Ort LIKE '%".$search."%')";
    $_SESSION['sql'] = $searchsql;
    //echo $searchsql;
    header("Location: ../main.php");
?>