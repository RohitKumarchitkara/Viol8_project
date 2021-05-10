<!DOCTYPE html>
<html lang="en">
<?php
        session_start();
    ?>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
    .form-control {
  display: block;
  width: 100%;
  padding: .375rem .75rem;
  font-size: 10px;
  font-weight: 400;
  line-height: 1.5;
  color: #212529;
  /* background-color: #ee625f; */
  color: #fff;
  background: transparent;
  border-radius: 30px;
  background-clip: padding-box;
  border: 2px solid #fff;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  border-radius: 30px;
  transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}

section .contentBox .formBox .inputBox input {
    width: 100%;
    padding: 5px 5px;
    outline: none;
    font-weight: 400;
    border: 2px solid #fff;
    font-size: 10px;
    letter-spacing: 1px;
    color: #fff;
    background: transparent;
    border-radius: 30px;
    margin-left :auto;
}

section .contentBox .formBox .remember {
    margin-bottom: 10px;
    color: #fff;
    font-weight: 400;
    font-size: 10px;
    display: flex;
    justify-content: space-between;
}
section .contentBox .formBox .inputBox {
    margin-bottom: 15px;
}

.errorColor 
{
    color : #fff;
}
    </style>
</head>
<body>

<?php 
        // define variables and set to empty values
        $usernameErr =  $passwordErr = $confirmpasswordErr = $nameErr = $emailErr = $numberErr = $ageErr = $genderErr = "";
        $username =  $password = $confirmpassword = $name = $email = $number ="";
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
           if (empty($_POST["username"])) {
              $usernameErr = "username is required";
           }else {
              $username = test_input($_POST["username"]);
           }

          if ($_POST["password"]) {
            $password = test_input($_POST["password"]);
           }
        //   if ($_POST["confirm_password"]) {
        //       $confirmpassword1 = test_input($_POST["confirm_password"]);
               
        //    }
           
        }
           if ($_SERVER["REQUEST_METHOD"] == "POST") {
            if (empty($_POST["name"])) {
              $nameErr = "Name is mandatory";
            } else {
              $name = test_input($_POST["name"]);
              // check if name only contains letters and whitespace
              if (!preg_match("/^[a-zA-Z-' ]*$/",$name)) {
                $nameErr = "Only letters allowed";
              }
            }}

            if ($_SERVER["REQUEST_METHOD"] == "POST") {
                if (empty($_POST["email"])) {
                 $emailErr = "Email is mandatory";
                }else {
                 $email = test_input($_POST["email"]);
                  // check if e-mail address is well-formed
                  if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
                     $emailErr = "Invalid email format"; 
                   }
                }
             }
         if (empty($_POST["number"])) {  
                $numberErr = "Mobile no is required";  
        } else {  
                $number = test_input($_POST["number"]);  
                // check if mobile no is well-formed  
                if (!preg_match ("/^[1-9][0-9]*$/", $number) ) {
                    echo '<script>swal("Error", "Mobile number contain only numeric value!", "error");</script>';  
                    //$mobilenoErr = "Only numeric value is allowed.";  
                }    
                else if (strlen($number) !== 10) { 
                   // echo '<script>alert("Mobile no must contain 10 digits.")</script>';
                   echo '<script>swal("Error", "Mobile number must contain 10 digits!", "error");</script>';
                //$mobilenoErr = "Mobile no must contain 10 digits.";  
                }  
        } 
            
        
        
        function test_input($data) {
           $data = trim($data);
           $data = stripslashes($data);
           $data = htmlspecialchars($data);
           return $data;
        }





          if(isset($_POST['submit']))
          {

              
	           $username = $_POST['username'];
               $password= $_POST['password'];
               $confirmpassword = $_POST['confirmpassword'];
               $name= $_POST['name'];
               $email = $_POST['email'];
	           $number= $_POST['number'];
               $age= $_POST['age'];
               //$gender= $_POST['gender'];
               $gender = $_POST['gender'];
   

            if(strlen($number) === 10 and $password === $confirmpassword and $age > 18)
            {

                $headers  = [

                            'Content-Type: application/json;charset=UTF-8'
                            ];
                            $post = [
                                'username' => $username,
                                'password' => $password,
                                'name' => $name,
                                'email' =>  $email,
                                'number' =>  $number,
                                'age' =>  $age,
                                'gender' => $gender,        
                            ];
                $ch = curl_init();
                curl_setopt($ch, CURLOPT_URL,'stgvclocalapi.vl8.in/register');
                curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
                curl_setopt($ch, CURLOPT_POST, true);
                curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($post));
                curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
                $response = curl_exec($ch);
                $statusCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
                
                $data= json_decode($response);
                
                if($statusCode == 200){

                    // print_r('<p style="color:green">'."Registration Successfull");
                    $user_reg_id=$data->user_id;
                    $_SESSION['user_reg_id'] = $user_reg_id;
                   // echo "<script>alert('Registration Successfull');</script>";
                    header("Location: registration_otp.php");
                }

                else{

                    // print_r('<p style="color:red">'."Please Check Details");
                    echo "<script>alert('Registration Not Successfull...');</script>";
                    header("Location: signup.php");

                }

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
                    <img style="width: 70px; height: 70px;" class="logo" src="assets/img/logo.png">
                </div>
                <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="POST">
                    <div class="inputBox"><?php echo  $usernameErr;?>
                      
                        <input  name="username" id="username" placeholder="Username" type="text" required>
                    </div>
                    <div class="inputBox"><?php echo  $passwordErr;?>
                        <input   id= "password" name="password" placeholder="password" type="password" required>
                    </div>
                     <div class="inputBox"><?php echo  $confirmpasswordErr;?>
                    
                        <input   id= "confirm_password" name="confirmpassword" placeholder="confirm password" type="password"required>
                    </div>
                    <div class="inputBox"><?php echo  $nameErr;?>
                        <input  name="name" id="name" placeholder="Name" type="text"required>
                    </div>

                    <div class="inputBox"><?php echo  $emailErr;?>
    
                        <input  id="email" name="email" placeholder="someone@mail.com" type="email"required>
                    </div>
                    <div class="inputBox">
                        <input  id="number" name="number" placeholder="Enter Mobile Number" type="contact"required >
                    </div>
                    
                    <div class="inputBox">
                       
                        <input id="age" name="age" placeholder="Age" type="number" min=18 required>
                    </div>
                    <div class="form-group" style = "font-size: 10px;">
                    
						<label class="control-label" for="user_gender" style="color:#fff" style = "font-size: 10px;"> Gender </label>
							<select class="form-control" name="gender">
                              <option value="M">M</option>
                              <option value="F">F</option>
                            </select>
					</div> <br> 
                     <div class="remember">
                        <div>
                            <input type="checkbox" id="c1" name="cb">
                            <label for="c1"> Read and accept application laws</label>
                        </div>
                    </div>
                    <div class="remember">
                        <div>
                            <input type="checkbox" id="c2" name="cb">
                            <label for="c2">Laws</label>
                        </div>
                    </div> 
                    <div class="inputBox">
                        <input type="submit" value="SignUp"  id ="submit" name="submit">
                    </div>
                </form>
                <?php
                         
                         
                        
                        if($password !== $confirmpassword)
                        {
                            echo '<script>swal("Error", "Password Miss Match!", "error");</script>';
                        }
                        
                        if(strlen($number) > 10)
                        {
                            //echo '<script>alert("Please Enter 10 digit mobile number")</script>';
                           echo '<script>swal("Error", "Please Enter 10 digit mobile number!", "error");</script>';
                        }
                      
                        ?> 


                          <?php
                                    if(isset($_POST['submit']))
                                    {
                                         $number1 = $number;
                          
                                         if (preg_match ("/^[1-9][0-9]*$/", $number)  and strlen($number) == 10)
                                         {
                                          
                                            $headers1  = [
                                        
                                                            'Content-Type: application/json;charset=UTF-8'
                                                        ];
                                                        $post1 = [
                                                            
                                                            'msisdn' =>  $number1,       
                                                        ];
                                            $ch1 = curl_init();
                                            curl_setopt($ch1, CURLOPT_URL,'stgvclocalapi.vl8.in/registration_otp');
                                            curl_setopt($ch1, CURLOPT_RETURNTRANSFER, true);
                                            curl_setopt($ch1, CURLOPT_POST, true);
                                            curl_setopt($ch1, CURLOPT_POSTFIELDS, json_encode($post1));
                                            curl_setopt($ch1, CURLOPT_HTTPHEADER, $headers1);
                                            $response1 = curl_exec($ch1);
                                            $statusCode1 = curl_getinfo($ch1, CURLINFO_HTTP_CODE);
                                            
                                            $data= json_decode($response1);
                                            $otp_user= $data->otp;
                                            $_SESSION['otp_user1'] = $otp_user;
                                            $_SESSION['user_mobile'] =$number1;
                            //   if($statusCode1 == 200){
                          
                            //       // print_r('<p style="color:green">'."Registration Successfull");
                            //       echo "<script>alert('Registration Successfull');</script>";
                            //       header("Location: registration_otp.php");
                          
                            //   }else{
                          
                            //       // print_r('<p style="color:red">'."Please Check Details");
                            //       echo "<script>alert('Registration Not Successfull...');</script>";
                            //       header("Location: signup.php");
                          
                            //   }
                          
                                    curl_close($ch1);


                                    $headers2  = [
                                
                                        'Content-Type: application/json;charset=UTF-8'
                                    ];
                                            $post2 = [
                                        
                                                            'msisdn' =>  $number1,
                                                            'sms_text' => $otp_user,     
                                                    ];
                                                $ch2 = curl_init();
                                                curl_setopt($ch2, CURLOPT_URL,'stgvclocalapi.vl8.in/add_sms_data');
                                                curl_setopt($ch2, CURLOPT_RETURNTRANSFER, true);
                                                curl_setopt($ch2, CURLOPT_POST, true);
                                                curl_setopt($ch2, CURLOPT_POSTFIELDS, json_encode($post2));
                                                curl_setopt($ch2, CURLOPT_HTTPHEADER, $headers2);
                                                $response2 = curl_exec($ch2);
                                                $statusCode2 = curl_getinfo($ch2, CURLINFO_HTTP_CODE);
                                                
                                                $data2= json_decode($response2);
                                                // $otp_user= $data->otp;
                                                // $_SESSION['otp_user1'] = $otp_user;
                                                // $_SESSION['user_mobile'] =$number1;  
                                    
                                                curl_close($ch2);
                                                
                                    }
                                }

                                  
                          
                          
                          
                          
                           ?>


                       
                          
            </div>
        </div>
    
    </section>    
</body>
</html>