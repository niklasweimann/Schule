<?php
if (isset($_SESSION['login'])) {
	header('Location: ../main.php');
} else {
	if (!empty($_POST)) 
    {
		if (empty($_POST['f']['username']) || empty($_POST['f']['password'])) 
        {
			$message['error'] = 'Bitte füllen Sie alle Felder aus.';
		} 
        else 
        {
            require('dbconnect.php');
			if ($mysqli->connect_error)
            {
				$message['error'] = 'Datenbankfehler: ' . $mysqli->connect_error;
			} 
            else 
            {
				$query = sprintf("SELECT id, username, password FROM users WHERE username = '%s'", $mysqli->real_escape_string($_POST['f']['username']));
				$result = $mysqli->query($query);

				if ($row = $result->fetch_array(MYSQLI_ASSOC))
                {
					if (crypt($_POST['f']['password'], $row['password']) == $row['password']) 
                    {
						session_start();
 
						$_SESSION = array('login' => true, 'user'  => array('username'=> $row['username']));
						$_SESSION["username"] = $row['username'];
						$_SESSION["userid"] = $row['id'];
						$message['success'] = 'Anmeldung erfolgreich, <a href="main.php">Weiter zum Inhalt.</a>';
						echo $message['success'];
						header('Location: main.php');
					} 
                    else
                    {
						$message['error'] = 'Das Kennwort ist nicht korrekt.';
					}
				} 
                else
                {
					$message['error'] = 'Der Benutzer konnte nicht gefunden werden.';
				}
				$mysqli->close();
			}
		}
	} 
    else
    {
		$message['notice'] = 'Wenn Sie noch kein Konto besitzen, können Sie <a href="./page_register.php">hier eines erstellen</a>.';
	}
}
?>
