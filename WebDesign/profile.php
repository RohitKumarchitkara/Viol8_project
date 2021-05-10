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
    <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" /> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    
    <title>Profile</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <style>

            p {
                margin-top: 0;
                margin-bottom: 5PX;
            }

                    .info .profile_info .account_info {
            border: 2px solid #fff;
            border-radius: 10px;
            color: #fff;
            padding: 5px;
            margin-bottom: 10px;
            display: flex;
            align-items: center;
        }

    

    </style>
</head>
<body>
                   <?php       
                            
                                

                                $token = $_SESSION['token'];
                                $user_id= $_SESSION['user_id'];
                                //echo $user_id;
                                $profile_id = $_GET['profile_id'];
                                //echo $agent_id;  

                                $url = 'http://stgvclocalapi.vl8.in/profile_detail/'.$profile_id;
                                $options = array('http' => array( 
                                    'method'  => 'GET',
                                    'header' => 'Authorization: Bearer '.$token
                                ));
                                $context  = stream_context_create($options);
                                $dashboard = file_get_contents($url, false, $context);
                                $json = json_decode($dashboard, true);

                                $arr1 = (array)$json;
                                $av1 = array_values($arr1);
                            

                                 ?>
                   
                   
            
     <div class="navbar">
        <ul class="navbar-nav">
            
            <li class="nav-item">
                <a href="landing_page.html">
                    <img src="assets/img/logo.png" class="logo">
                </a>
            </li>
        </ul>
        <ul class="navbar-nav nav-right">
            <li class="nav-item">
                <!-- <a class="nav-link" href='logout.php'>  -->
                <button class="nav-btn" type="button" name="logout" value="Logga ut" id="logout1">Logout</button>
                 <!-- </a>  -->
            </li>
        </ul>
    </div> 

    <div class="container-prfl">
        <div class="card-prfl">
            <div class="prflBackground">
                <div class="profile_img">
                    <img src="assets/img/user-14.jpg">
                </div> 
            </div>

            

            
             <div class="info">
                <div class="profile_info">
                    <div class="account_info">
                    <?php
                    
                      echo  "<p>Username: </p><p> $av1[1] </p>";
                      echo "</div>";
                      echo "<div class='account_info'>";
                    echo "<p>Gender: </p><p> $av1[5]</p>";
                     echo "</div>";
                    echo "<div class='account_info'>";
                     echo    "<p>Age: </p><p> $av1[4] </p>";
                    echo "</div>";
                    ?>
                    <button type="button" name ="callme" class="btn btn-outline-success">Call Me Now</button>
                </div>    
            </div> 
        </div>
    </div>

    <?php
         if(isset($_POST[ 'callme' ]))
         {
             //session_start();
            //$token = $_SESSION["token"];
            $headers  = [
            'Content-Type: application/json;charset=UTF-8',
            'header' => 'Authorization: Bearer '.$token
           ];
          $post = [
                    'userId' =>   $user_id,
                    'agentId' =>  $agent_id,
​                 ];
         $url = 'http://stgvcapi.vl8.in/app/lead';
         $ch = curl_init();
         curl_setopt($ch, CURLOPT_URL,$url);
         curl_setopt($ch, CURLOPT_RETURNTRANSFER,true);//check
         curl_setopt($ch, CURLOPT_POST, true);
         curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($post));
         curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
         $response = curl_exec($ch);
         curl_close($ch);
        }
    ?>
</body>
<script>
$("#logout1").on("click", function() {
    swal({title:'Logout', 
                        text:'Do you want to logout this Account?', 
                        icon:'warning', 
                        buttons: true, 
                        dangerMode: true
                    })
                    .then((willOUT) => {
                            if (willOUT) {
                                  window.location.href = 'logout.php', {
                                  icon: 'success',
                                }
                              }
                    });
});
</script>



</html>