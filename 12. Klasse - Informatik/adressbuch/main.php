<?php
    require("PHP/auth.php");

?>

<DOCTYPE html>
<html lang="de">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width-device-width, initial-scale=1.0">
        <title>Main - Adressbuch</title>
        <!-- stylesheets-->
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="Style/materialize.css">
        <link rel="stylesheet" href="Style/MainStyle.css">
        <!-- JavaScript -->
        <script type="text/javascript" src="JavaScript/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="JavaScript/materialize.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
            $('.modal-trigger1').leanModal({
            });
            $('.modal-trigger2').leanModal({
            });
            });
        </script>
        <title>Main - Adressbuch</title>
    </head>
    <body>

        <div class="navbar-fixed">
			<nav>
				<div class="nav-wrapper">
				<a href="#" class="brand-logo left"> <i class="large material-icons">contacts</i></a>
				<ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><span id="welcomeText">Willkommen, <?php echo $_SESSION["username"]?></span</li>
					<li><a href="PHP/logout.php">Loggout</a></li>
				</ul>
				</div>
			</nav>
		</div>    
        <div class="addButton">
            <a class="modal-trigger1 btn-floating btn-large waves-effect waves-light red" href="#modal1"><i class="material-icons">add</i></a>
        </div>
         <!-- Modal Structure -->
        <div id="modal1" class="modal modal-fixed-footer">
            <div class="modal-content">
            <h4>Kontakt hinzufügen</h4>
                <form action="PHP/einfuegen.php" method="get">
                    <label for="vorname"> Vorname:
                        <input type="text" name="vorname" maxlength="30" />
                    </label><br>
                    <label for="nachname"> Nachname:
                        <input type="text" name="nachname" maxlength="30" />
                    </label><br>
                    <label for="gebdat"> Geburtsdatum:
                        <input type="date" name="birthdate" maxlength="30" />
                    </label><br>
                    <label for="email"> E-Mail:
                        <input type="email" name="email" maxlength="30" />
                    </label><br>
                    <label for="Telefon"> Telefon:
                        <input type="text" name="telefonr" maxlength="30" />
                    </label><br>
                    <br>
                    <label for="Straße"> Straße:
                        <input type="text" name="strasse" maxlength="30" />
                    </label><br>
                    <label for="PLZ"> PLZ:
                        <input type="text" name="plz" maxlength="30" />
                    </label><br>
                    <label for="Hausnummer"> Hausnummer:
                        <input type="text" name="Hausnummer" maxlength="30" />
                    </label><br>
                    <label for="Ort"> Ort:
                        <input type="text" name="ort" maxlength="30" />
                    </label><br>
            </div>
            <div class="modal-footer">
                <button type="submit" id="absenden" class="waves-effect waves-light btn">Speichern</button>
                <button type="reset" id="loeschen" class="waves-effect waves-light btn">Eingaben leeren</button>
            </form>
            </div>
        </div>
        <div class="container">
            <form action="PHP/search.php" method="get">
                <input type="text" name="search" maxlength="30" style="width: 89%; float: left;" />
                <button type="submit" id="search" class="btn-floating btn-large waves-effect waves-light red" style="float: right;"><i class="material-icons">search</i></button>
            </form>
        </div>
        <div class="container">
				<div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 10px 48px; border: 1px solid #EEE;">
                    <div class="tabelle">
                    <table class="striped">
                        <thead>
                            <tr class="firstrow">
                                <td>
                                    Nachname
                                </td>
                                <td> 
                                    Vorname
                                </td>
                                <td> 
                                    Telefonnummer
                                </td>
                                <td> 
                                    E-Mail
                                </td>
                                <td> 
                                    Geburtsdatum
                                </td>
                                <td> 
                                    Straße
                                </td>
                                <td> 
                                    PLZ
                                </td>
                                <td> 
                                    Hausnummer
                                </td>
                                <td> 
                                    Ort
                                </td>
                                <td>
                                    
                                </td>
                            </tr>
                        </thead>
            <?php
                    require_once("PHP/dbconnect.php");
                    if(isset($_SESSION["sql"])){
                        $sql = $_SESSION["sql"];
                        //echo "Search: ".$sql;
                    }
                    else{
                        $sql = "SELECT * FROM kontakte,adresse WHERE kontakte.Adr_ID = adresse.Adr_ID and kontakte.user_ID = ".$_SESSION['userid'];
                        //echo "No search: ".$sql;
                    }
                    if ($result=$mysqli->query($sql)) {
                        $modal =2;
                        while ($row = $result->fetch_row())
                        {

                            echo "
                                <tr>
                                    <td>
                                        $row[1]
                                    </td>
                                    <td> 
                                        $row[2]
                                    </td>
                                    <td> 
                                        $row[3]
                                    </td>
                                    <td> 
                                        <a href=\"mailto:$row[4]\">$row[4]</a>
                                    </td>
                                    <td> 
                                        $row[5]
                                    </td>
                                    <td> 
                                        $row[9]
                                    </td>
                                    <td> 
                                        $row[10]
                                    </td>
                                    <td> 
                                        $row[11]
                                    </td>
                                    <td> 
                                        $row[12]
                                    </td>
                                    <td>
                                        <a class='dropdown-button btn btn-floating' href='#' data-activates='dropdown".$modal."'><i class=\"material-icons\">settings</i></a>
                                        <!-- Dropdown Structure -->
                                        <ul id='dropdown".$modal."' class='dropdown-content'>
                                            <li><a class=\"modal-trigger2\" href=\"#modal".$modal."\">Edit</a></li>
                                            <li><a target=\"_blank\" href=https://www.google.de/maps/place/$row[9]+$row[11],+$row[10]+$row[12]>GMaps</a></li>
                                            <li class=\"divider\"></li>
                                            <li><a href=\"PHP\loeschen.php?id=$row[0]&adrid=$row[8]\">Delete</a></li>
                                        </ul>
                                    </td>
                                </tr>
                                <div id=\"modal".$modal."\" class=\"modal modal-fixed-footer\">
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
        </div>
                        ";
                        $modal++;
                        }
                    }
                    else 
                    {
                        echo "Error: " . $sql . "<br>" . $mysqli->error;
                    }
            ?>
            </table>
            </div>
            </div>
        </div>
    </body>
</html>