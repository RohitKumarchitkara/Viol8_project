<!DOCTYPE html>
<html lang="en">
<?php
        session_start();
    ?>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>reset password</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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
                                         $password = $confirmpassword = "";
                                         $get_number = $_SESSION['mobile_number'];
                                        // echo $get_number;
									    if(isset($_POST[ 'submit1' ]))
									    {
                                           
									        $password = $_POST['new_pass'];
                                            $confirmpassword = $_POST['confirm_pass'];
                                            if($password === $confirmpassword)
                                            {
                                                $headers  = [
                                                    'Content-Type: application/json;charset=UTF-8'
                                                ];
                                                $post = [
                                                    'password' => $password,
                                                    
                                                ];

                                                //$user_id= $_POST["user_id"];
                                               // echo $user_id;

                                            


                                                $url = 'stgvclocalapi.vl8.in/reset_password/'.$get_number;
                                                $ch = curl_init();
                                                curl_setopt($ch, CURLOPT_URL,$url);
                                                curl_setopt($ch, CURLOPT_RETURNTRANSFER,1);//check
                                                curl_setopt($ch, CURLOPT_POST, 1);
                                                curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($post));
                                                curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
                                                $response = curl_exec($ch);

                                                $statusCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
                                                if($statusCode !== 200){
                                                    header("Location: Reset_password.php");
                                                }
                                            
                                                else{
                                                    
                                                    $data = json_decode($response);
                                                    print_r($response);
    
                                                    //echo '<br>';
                                                    //echo $data->message ;
                                                    //echo '<br>';
    
                                                   
                                                        // $user_id= $data->user_id;
                                                        // echo $user_id;
                                                        // echo '<script>swal("Successfull", "Password Updated Successfull!", "success");</script>';
                                                        // header("Location: login.php");
                                                        echo ("<script LANGUAGE='JavaScript'>
                    
                                                        swal({
                                                            title: 'Successfull',
                                                            text: 'Your Password Updated Successfully.',
                                                            icon: 'success',
                                                          });
                                                      window.setTimeout(function() {
                                                          window.location.href = 'login.php';
                                                      }, 2000);
                                                     </script>");
                                                
                                                    }

										curl_close($ch);
									}
                                }
								?> 


    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="POST">  
    <div class = "inputBox">
               
              <div class="inputBox" >
              <span>New Password</span>
             <input name ="new_pass" placeholder="********" type="password" required>
             </div>  
             <div class="inputBox" >
              <span>Confirm password </span>
             <input name ="confirm_pass" placeholder="********" type="password" required>
             </div>  
            <div class="inputBox">
            <input type="submit"  name="submit1"  value="Submit">
             </div>   
              
           </div>
    </form> 
    <?php
        // $password = "";
        // $confirmpassword = "";
        // if ($_SERVER["REQUEST_METHOD"] == "POST") {
        //     if ($_POST["new_pass"]) {
        //         $password = test_input($_POST["new_pass"]);
        //        }
        //       if ($_POST["confirm_pass"]) {
        //           $confirmpassword = test_input($_POST["confirm_pass"]);
                   
        //        }
               
        //     }




            if($password !== $confirmpassword)
                        {
                            //echo '<script>alert("Password Miss Match ")</script>';
                            echo '<script>swal("Error", "Password Miss Match!", "error");</script>';
                        }



    ?>

    
    
</body>
</html>