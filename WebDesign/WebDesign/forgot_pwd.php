<!DOCTYPE html>
<html lang="en">
    <?php
        session_start();
    ?>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <style>
    section .contentBox .formBox .inputBox input {
    width: 100%;
    padding: 10px 20px;
    outline: none;
    font-weight: 400;
    border: 2px solid #fff;
    font-size: 10px;
    letter-spacing: 1px;
    color: #fff;
    background: transparent;
    border-radius: 30px;
    margin-left: auto;
}
    </style>
</head>
<body>
 <section>
        <div class="imgBox">
            <img src="assets/img/img.jpg">
        </div>
        <div class="contentBox">
            <div class="formBox">
                <div class="img">
                    <img class="logo" src="assets/img/logo.png">
                </div>

            <?php
               $numberErr = $number ="";

               if ($_SERVER["REQUEST_METHOD"] == "POST") {
                if (empty($_POST["number"])) {  
                    $numberErr = "Mobile no is required";  
            } else {  
                    $number = test_input($_POST["number"]);  
                    // check if mobile no is well-formed  
                    if (!preg_match ("/^[1-9][0-9]*$/", $number) ) {
                        //echo '<script>alert("Mobile number contain only numeric.")</script>';  
                        echo '<script>swal("Error", "Mobile number contain only numeric value!", "error");</script>';
                        //$mobilenoErr = "Only numeric value is allowed.";  
                    }    
                    else if (strlen ($number) !== 10) { 
                       // echo '<script>alert("Mobile no must contain 10 digits.")</script>';
                       echo '<script>swal("Error", "Mobile number must contain 10 digits!", "error");</script>';
                    //$mobilenoErr = "Mobile no must contain 10 digits.";  
                    }  
            } 

               } 
               function test_input($data) {
                $data = trim($data);
                $data = stripslashes($data);
                $data = htmlspecialchars($data);
                return $data;
             }
            ?>


                <div class = "inputBox">
                                <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="POST">
                                    <div class="inputBox" > 
                                        
                                        <input  id ="number" name ="number" placeholder="Enter Mobile Number" type="contact" required >
                                    </div>
                                    <div class="inputBox">
                                        <input type="submit"  name="submit" id= "submit" value=" Generate OTP">
                                    </div>
                                    

                                   
                                </form>
                                 <?php
                                  if(strlen($number) > 10)
                                  {
                                      //echo '<script>alert("Please Enter 10 digit mobile number")</script>';
                                      echo '<script>swal("Error", "Please Enter 10 digit mobile number!", "error");</script>';
                                  }
                                  ?>
                        </div>
            </div>
        </div>
    </section>
    <?php
									    if(isset($_POST[ 'submit' ]))
									    {
                                            
									        $mobile = $_POST['number'];

                                            if(strlen($number) === 10)
                                            {
									        $headers  = [
									            'Content-Type: application/json;charset=UTF-8'
									        ];
									        $post = [
												'msisdn' => $mobile,
											];
									        $url = 'http://stgvclocalapi.vl8.in/addOtpData';
									        $ch = curl_init();
											curl_setopt($ch, CURLOPT_URL,$url);
											curl_setopt($ch, CURLOPT_RETURNTRANSFER,1);//check
											curl_setopt($ch, CURLOPT_POST, 1);
											curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($post));
											curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
									        $response = curl_exec($ch);

											$statusCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
									        $data = json_decode($response);
											print_r($response);
                                            
									        echo '<br>';
											echo $data->otp ;
											echo '<br>';

									        if($statusCode == 200){
                                                $otp= $data->otp;
                                                $_SESSION['otp'] = $otp;
                                                $_SESSION['mobile_number'] = $mobile;
                                                echo $user_id;
										 		header("Location: verify_otp.php");
                                           
											}
									        else{
                                                   // echo "<script>alert('Please enter correct number');</script>";
                                                   echo '<script>swal("Error", "Please enter correct number!", "error");</script>';
											 		//header("Location: forgot_pwd.php");
											 	}

										curl_close($ch);

                                        $headers3  = [
                          
                                            'Content-Type: application/json;charset=UTF-8'
                                          ];
                                                $post3 = [
                                             
                                                                'msisdn' =>  $mobile,
                                                                'sms_text' => $otp,     
                                                         ];
                                                    $ch3 = curl_init();
                                                    curl_setopt($ch3, CURLOPT_URL,'stgvclocalapi.vl8.in/add_sms_data');
                                                    curl_setopt($ch3, CURLOPT_RETURNTRANSFER, true);
                                                    curl_setopt($ch3, CURLOPT_POST, true);
                                                    curl_setopt($ch3, CURLOPT_POSTFIELDS, json_encode($post3));
                                                    curl_setopt($ch3, CURLOPT_HTTPHEADER, $headers3);
                                                    $response3 = curl_exec($ch3);
                                                    $statusCode3 = curl_getinfo($ch3, CURLINFO_HTTP_CODE);
                                                    
                                                    $data3= json_decode($response3);
                                                    // $otp_user= $data->otp;
                                                    // $_SESSION['otp_user1'] = $otp_user;
                                                    // $_SESSION['user_mobile'] =$number1;  
                                        
                                                    curl_close($ch3);
									}
                                }
								?>
</body>
</html>