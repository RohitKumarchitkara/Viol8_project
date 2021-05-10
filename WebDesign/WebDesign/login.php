<!DOCTYPE html>
<html lang="en">
    <?php
        session_start();
       // print_r($_SESSION);
    ?>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LogIn</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>

   
    <?php

 $emailErr = $passwordErr =  "";
 $email = $password =  "";
 $login_error = "";
//    if ($_SERVER["REQUEST_METHOD"] == "POST") {
//    if (empty($_POST["email"])) {
//     $emailErr = "Email is mandatory";
//    }else {
//     $email = test_input($_POST["email"]);
//      // check if e-mail address is well-formed
//      if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
//         $emailErr = "Invalid email format"; 
//       }
//    }
// }
//    if (empty($_POST["password"])) {
//     $passwordErr = "password is required";
//    }else {
//     $password= test_input($_POST["password"]);
      
//    }
//    function test_input($data) {
//     $data = trim($data);
//     $data = stripslashes($data);
//     $data = htmlspecialchars($data);
//     return $data;
//  }




    if(isset($_POST[ 'submit' ]))
    {
        $username = $_POST['username'];
        $password = $_POST['password'];
     // echo "$email";
     //  echo "$password"

        if(strlen($username) !==0 and strlen($password) !==0)
        {
        
        $headers  = [

            'Content-Type: application/json;charset=UTF-8'
        ];
        $post = [
			'username' => $username,
			'password' =>  $password,

		];
        $url = 'stgvclocalapi.vl8.in./login';
        $ch = curl_init();
		curl_setopt($ch, CURLOPT_URL,$url);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER,true);//check
		curl_setopt($ch, CURLOPT_POST, true);
		curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($post));
		curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        $response = curl_exec($ch);

		$statusCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        if($statusCode == 401){
            //$login_error = "Please Enter Valid Data";
            $c=1;
            //header("Location: login.php");
             
		} 
        else{
        $data = json_decode($response);
        
        $u_id=$data->user_id;
        $u_role=$data->user_role;
        $token=$data->token;

        

		//print_r($response);
        $arr = (array)$data;
        $av = array_values($arr);
        echo '<br>';
		// echo $data->message ;  
		echo '<br>';
		// echo $data->token;
		// echo '<br>';
		// echo $data->userid;
		// echo '<br>';
		// echo $data->role[0];
        // echo $data->message;
    
                  $_SESSION['user_id'] = $u_id;
                  $_SESSION['user_role'] = $u_role; 
                  $_SESSION['token'] = $token;
              // 	$_SESSION["token"]= $data->token;
              // 	$_SESSION["userRole"]= $data->role[0];
              // 	$_SESSION["userId"]= $data->userid; 
              // 	if($data->role[0] == 'ROLE_ADMIN'){
                  // $_SESSION["s_id"]=$av['user_id'];
                  // echo ($_SESSION);
                  //echo '<script type="text/javascript">console.log(1);   alert("login successull")</script>';
                  $_SESSION['login'] = true;
                  echo ("<script LANGUAGE='JavaScript'>
                    
                       swal('Login Successfull','', 'success');
                       window.location.href='landing_page.php';
                    </script>");
                   //header("Location: landing_page.php");

		 	}
             if($c===1)
             {
                 //echo '<script>alert("Login Failed .Please enter valid details")</script>';
                 //swal("Good job!", "You clicked the button!", "success");
                 echo '<script>swal("Login Failed!", "Please Enter Correct Username and Password!", "error");</script>';
                
             }
		// }else{
		// 	print_r('<p style="color:red">'.$data->message.'</p>');
		// }

	curl_close($ch);
   }
}




?>

 <section>
        <div class="imgBox">
            <img src="assets/img/img.jpg">
        </div>
        <div class="contentBox">
            <div class="formBox">
                <div class="img">
                    <img class="logo" src="assets/img/logo.png">
                </div>    
                <div class = "inputBox">
                                <?php echo $login_error; ?>
                                <spann> <?php echo ($login_error); ?> </span>
                                <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="POST">
                                    <div class="inputBox" > 
                                        <span>Username</span>
                                        <input  id ="username" name ="username" placeholder="Username" type="text" required>
                                    </div>
                                    <div class="inputBox"> 
                                        <span>Password&nbsp;&nbsp;</span>
                                        <input id ="password" name ="password" type="password" placeholder="********" required>
                                    </div>
                                    <div class="remember">
                                        <div>
                                            <input type="checkbox" id="c1" name="cb" required>
                                            <label for="c1"> Remember me</label>
                                        </div>
                                    </div>
                                    <div class="inputBox">
                                        <input type="submit"  name="submit" id= "submit" value="LogIn">
                                    </div>
                                    <a href="forgot_pwd.php" id ="container1">Forgot password? </a>
                                    
                                    <div class="inputBox">
                                        <p>Don't have an account?<a href="signup.php">Signup</a></p>
                                    </div>
                                    
                                </form> 


                                <?php
                                   
                                            
                               ?>

                        </div>
            </div>
        </div>
    </section>    

    
</body>
</html>