<?php require("PHP/login.php"); ?>
<!DOCTYPE html>
<html>
	<head>
		<title>Login - Adressbuch</title>
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link rel="stylesheet" href="Style/LoginStyle.css">
		<link rel="stylesheet" href="Style/materialize.css">
	</head>
	<body>
		<div class="site">
		<div class="navbar-fixed">
			<nav>
				<div class="nav-wrapper">
				<a href="#" class="brand-logo left"> <i class="large material-icons">contacts</i></a>
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li><a href="page_register.php">Registrieren</a></li>
					<li><a href="page_login.php">Login</a></li>
				</ul>
				</div>
			</nav>
		</div>
		<center>
			<div class="container">
				<div class="loginBox z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 10px 48px; border: 1px solid #EEE;">
				<h2 class="loginH2">Login</h2>
				<form action="" method="post" class="col s12">
						<div>
							<label for="username">Benutzername</label>
							<input type="text" name="f[username]" id="username"
							<?php echo isset($_POST['f']['username']) ? ' value="' . htmlspecialchars($_POST['f']['username']) . '"' : '' ?> />
						</div>
						<div>
							<label for="password">Kennnwort</label> 
							<input type="password" name="f[password]" id="password" />
						</div>
						<div>
						<button class="btn waves-effect waves-light" type="submit" name="submit" value="Anmelden">Login
							<i class="material-icons right">send</i>
						</button>
						</div>
						<div>
						</div>				
				</form>
				</div>
			</div>
		</center>
		<center>
		<div class="container">
		<div class="infocard">

			<?php 
				if (isset($message['error'])): 
			?>
			<div class="row">
				<div class="col s12 m6">
				<div class="card blue-grey darken-1">
					<div class="card-content white-text">
					<span class="card-title">Fehler</span>
					<p>
						<?php 
							echo $message['error'];
						?>
					</p>
					</div>
				</div>
				</div>
			</div>
			<?php 
				endif;
				if (isset($message['success'])): 
			?>

			<div class="row">
				<div class="col s12 m6">
				<div class="card blue-grey darken-1">
					<div class="card-content white-text">
					<span class="card-title">Erfolg</span>
					<p>
						<?php
							echo $message['success'];
						?>
					</p>
					</div>
				</div>
				</div>
			</div>

			<?php 
				endif;
				if (isset($message['notice'])): 
			?>

			<div class="row">
				<div class="col s12 m9">
				<div class="card blue-grey darken-1">
					<div class="card-content white-text">
					<span class="card-title">Hinweis</span>
					<p>
						<?php
							echo $message['notice'];
						?>
					</p>
					</div>
				</div>
				</div>
			</div>

			<?php
				endif; 
			?>
		</div>
		</div>
		</center>
		</div>
	</body>
</html>