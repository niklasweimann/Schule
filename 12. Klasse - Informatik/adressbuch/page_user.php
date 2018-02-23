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
        <link rel="stylesheet" href="Style/Usertyle.css">
        <title>User - Adressbuch</title>
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
        <center>
            <div class="container">
                <div class="row">
                    <form class="col s12" action="PHP\changeuser.php" method="GET">
                    <div class="row">
                        <div class="input-field col s6">
                        <input id="first_name" type="text" class="validate">
                        <label for="first_name">Username</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                        <input id="email" type="email" class="validate">
                        <label for="email">Passwort</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                        <input class="waves-effect waves-light btn" type="submit" class="validate">
                    </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <form action="PHP\deleteuser.php">
                    <input class="waves-effect waves-light btn" type="submit" class="validate">
                </form>
            </div>
        </center>
    </body>
</html>