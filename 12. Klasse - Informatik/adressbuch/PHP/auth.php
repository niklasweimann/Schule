<?php
	session_start();
	session_regenerate_id();
 
	if (empty($_SESSION['login'])) {
		if(subdomboolcheck() === true)
		{
			header('Location: ../page_login.php');
			exit;
		}
		else{
			header('Location: page_login.php');
			exit;
		}
	} else {
		$login_status = '
			<div style="border: 1px solid black">
				Sie sind als <strong>' . htmlspecialchars($_SESSION['user']['username']) . '</strong> angemeldet.<br />
				<a href="./logout.php">Sitzung beenden</a>
			</div>
		';
	}

	function subdomboolcheck()
	{
		$root = $_SERVER['REQUEST_URI'];
		$filePath = dirname(__FILE__);
		$pos = strpos($root, "PHP");
		if ($pos === false) {
			return false; //root
		} else {
			return true; 
		}
	}
?>