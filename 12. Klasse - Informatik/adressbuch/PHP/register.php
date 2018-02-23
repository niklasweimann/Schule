<?php
	$message = array();
	if (!empty($_POST)) {
		if (
			empty($_POST['f']['username']) ||
			empty($_POST['f']['password']) ||
			empty($_POST['f']['password_again'])
		) 
		{
			$message['error'] = 'Bitte füllen Sie alle Felder aus.';
		} 
		else if ($_POST['f']['password'] != $_POST['f']['password_again']) 
		{
			$message['error'] = 'Die eingegebenen Passwörter stimmen nicht überein.';
		}
		else
		{
			unset($_POST['f']['password_again']);
			$salt = ''; 
			for ($i = 0; $i < 22; $i++)
			{ 
				$salt .= substr('./ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789', mt_rand(0, 63), 1); 
			}
			$_POST['f']['password'] = crypt(
				$_POST['f']['password'],
				'$2a$10$' . $salt
			);
			require('dbconnect.php');
			if ($mysqli->connect_error)
			{
				$message['error'] = 'Datenbankfehler: ' . $mysqli->connect_error;
			}
			$query = sprintf(
				"INSERT INTO users (username, password) SELECT * FROM (SELECT '%s', '%s') as new_user WHERE NOT EXISTS ( SELECT username FROM users WHERE username = '%s') LIMIT 1;",
				$mysqli->real_escape_string($_POST['f']['username']),
				$mysqli->real_escape_string($_POST['f']['password']),
				$mysqli->real_escape_string($_POST['f']['username'])
			);
			$mysqli->query($query);
			if ($mysqli->affected_rows == 1)
			{
				$message['success'] = 'Neuer Benutzer (' . htmlspecialchars($_POST['f']['username']) . ') wurde angelegt, <a href="../login.php">weiter zur Anmeldung</a>.';
				header('Location: page_login.php');
			}
			else
			{
				$message['error'] = 'Der Benutzername ist bereits vergeben.';
			}
			$mysqli->close();
		}
	}
	else 
	{
		$message['notice'] = 'Übermitteln Sie das ausgefüllte Formular um ein neues Benutzerkonto zu erstellen.';
	}
?>