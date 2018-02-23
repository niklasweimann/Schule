<?php
    session_start();
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
    //Ausgabe
    $modal3 = "
        <div id=\"modal2\" class=\"modal modal-fixed-footer\">
            <div class=\"modal-content\">
            <h4>Kontakt bearbeiten</h4>
                <form action=\"PHP/update.php\" method=\"get\">
                    <label for=\"vorname\"> Vorname:
                        <input type=\"text\" name=\"vorname\" value=\"$row[1]\" maxlength=\"30\" />
                    </label><br>
                    <label for=\"nachname\"> Nachname:
                        <input type=\"text\" name=\"nachname\" value=\"$row[2]\" maxlength=\"30\" />
                    </label><br>
                    <label for=\"gebdat\"> Geburtsdatum:
                        <input type=\"date\" name=\"birthdate\" value=\"$row[5]\" maxlength=\"30\" />
                    </label><br>
                    <label for=\"email\"> E-Mail:
                        <input type=\"email\" name=\"email\" value=\"$row[4]\" maxlength=\"30\" />
                    </label><br>
                    <label for=\"Telefon\"> Telefon:
                        <input type=\"text\" name=\"telefonr\" value=\"$row[3]\" maxlength=\"30\" />
                    </label><br>
                    <br>
                    <label for=\"Straße\"> Straße:
                        <input type=\"text\" name=\"strasse\" value=\"$row[9]\" maxlength=\"30\" />
                    </label><br>
                    <label for=\"PLZ\"> PLZ:
                        <input type=\"text\" name=\"plz\" value=\"$row[10]\" maxlength=\"30\" />
                    </label><br>
                    <label for=\"Hausnummer\"> Hausnummer:
                        <input type=\"text\" name=\"Hausnummer\" value=\"$row[11]\" maxlength=\"30\" />
                    </label><br>
                    <label for=\"Ort\"> Ort:
                        <input type=\"text\" name=\"ort\" value=\"$row[12]\" maxlength=\"30\" />
                    </label><br>
                    <input type=\"hidden\" name=\"id\" value=\"$row[0]\">
            </div>
            <div class=\"modal-footer\">
                <button type=\"submit\" id=\"absenden\" class=\"waves-effect waves-light btn\">Speichern</button>
                <button type=\"reset\" id=\"loeschen\" class=\"waves-effect waves-light btn\">Eingaben leeren</button>
            </form>
            </div>
        </div>";
?>