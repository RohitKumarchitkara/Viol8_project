<!DOCTYPE html>
<html lang="en"> 
<?php
        session_start();
    ?>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>verifyOTP</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<?php
                                $get_otp = $_SESSION['otp'];
                                if(isset($_POST[ 'submit' ]))
                                {
                                    $otp = $_POST['otp'];

                                    $headers  = [
                                        'Content-Type: application/json;charset=UTF-8'
                                    ];
                                    $post = [
                                        'otp' => $otp,
                                    ];
                                    $url = 'http://stgvclocalapi.vl8.in/verify_otp';
                                    $ch = curl_init();
                                    curl_setopt($ch, CURLOPT_URL,$url);
                                    curl_setopt($ch, CURLOPT_RETURNTRANSFER,1);//check
                                    curl_setopt($ch, CURLOPT_POST, 1);
                                    curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($post));
                                    curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
                                    $response = curl_exec($ch);

                                    $statusCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
                                    if($statusCode == 404){
                                        echo '<script>swal("Error", "Please enter correct number!", "error");</script>';
                                        //header("Location: verify_otp.php");
                                   
                                    }
                                    
                                    else{
                                            //echo "<script>alert('Please enter correct number');</script>";
                                            $data = json_decode($response);
                                            print_r($response);
                                            
                                            echo '<br>';
                                            echo $data->otp ;
                                            echo '<br>';
        
                                            
                                               // $otp= $data->otp;
                                               // $_SESSION['otp'] = $otp;
                                               // echo $user_id;
                                                 header("Location:Reset_password.php");
                                         }

                                curl_close($ch);
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
                                <form action="" method="POST">
                                <div class="form-row">		
                            </div>


                            <div class="form-row">
                                <input type="text" name = "otp"  class="form-input" placeholder="Enter OTP" required>		
                            </div><br><br>
                            <div class="inputBox">
                            <input type="submit" name="submit" class="btnSubmit" value="Verify OTP">
                            <?php
                            //echo $otp; 
                            ?>
                            </div>
                            </form>
  </div>
            </div>
        </div>
    </section>
</body>
</html>