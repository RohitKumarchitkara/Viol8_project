<!DOCTYPE html>
<html lang="en">
<?php
        session_start();
//         if (($_SESSION['login']))
// {
    ?>

      
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Landing Page</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <style>
           .nav-btn {
                        padding: 5px 20px;
                        margin-top: 20px;
                        outline: none;
                        font-weight: 600;
                        letter-spacing: 1px;
                        border-radius: 30px;
                        background: #fff;
                        color: #ea3c53;
                        outline: none;
                        border: none;
                        cursor: pointer;
                    }
    </style>
</head>

<body>
    <div class="navbar">
        <ul class="navbar-nav">
            
            <li class="nav-item">
                <img src="assets/img/logo.png" class="logo">
            </li>
        </ul>
        <ul class="navbar-nav nav-right">
            <li class="nav-item">
                <!-- <a href='logout.php' class="nav-link"> -->
                    <button class="nav-btn" type="button" name="logout" value="Logga ut" id="logout">Logout</button>
                <!-- </a> -->
            </li>
        </ul>
    </div>
    <main>
        <?php 
               

                $token = $_SESSION['token'];
                $user_id= $_SESSION['user_id'];
                $i = 78;
                $url2 = 'http://stgvclocalapi.vl8.in/profilerecom/'.$user_id;
                $options = array('http' => array(
                    'method'  => 'GET',
                    'header' => 'Authorization: Bearer '.$token
                ));
                $context2  = stream_context_create($options);
                $dashboard2 = file_get_contents($url2, false, $context2);
                $jsonData2 = json_decode($dashboard2,true);
                $arr2 = (array)$jsonData2;
                $av2 = array_values($arr2);
                

        ?>

        
    
        <h2 class="dash-title">Recommended</h2>
        <div class="dash-cards">
            <?php
                            $x=0;
                            $y=1;
                            
                            for($x==0;$x<sizeof($arr2);$x++)
                            {
                                $name2 = (string)$av2[$x][$y];
                                $age = (string)$av2[$x][5];
                                $profile_id = (string)$av2[$x][0];
                                //$_SESSION['agent_id'] = $agent_id;
                echo "<div class='card-single'>";
                    echo"<div class='card-body'>";
                    echo "<div>"; 
                            echo "<a href='profile.php?profile_id=$profile_id'>
                                <img class='prfl_img' src='assets/img/user-14.jpg'>
                                <h4>$name2 , $age </h4>
                                
                            </a>";
                        echo "</div>";
                    echo "</div>";
                    echo "</div>";
                            }
            ?>    




           
        </div>

         <?php
            $url = 'http://stgvclocalapi.vl8.in/profilesrecent';
            $token = $_SESSION['token'];
           // echo $token;
            $options1 = array('http' => array(
                             'method'  => 'GET',
                             'header' => 'Authorization: Bearer '.$token
                      ));
            $context  = stream_context_create($options);
            $dashboard = file_get_contents($url, false, $context);
            $jsonData = json_decode($dashboard,true);
            $arr = (array)$jsonData;
            $av = array_values($arr);
       ?>
        <h2 class="dash-title">Recently Called</h2>
        <div class="dash-cards">
         <?php
                         $i=0;
                         $j=1;
                         for($i==0;$i<sizeof($arr);$i++)
                         {
                            $name = (string)$av[$i][$j];
                            $age1 = (string)$av[$i][5];
                            $profile_id = (string)$av[$i][0];
                           // $_SESSION['agent_id'] = $agent_id;
            echo "<div class='card-single'>";
                  echo"<div class='card-body'>";
                   echo "<div>"; 
                           echo "<a href='profile.php?profile_id=$profile_id'>
                            <img class='prfl_img' src='assets/img/user-14.jpg'>
                            <h4>$name , $age1 </h4>
                        </a>";
                    echo "</div>";
                  echo "</div>";
                echo "</div>";
                         } 
        ?>

        </div>
            
            
        </div>

        <?php
            $url1 = 'http://stgvclocalapi.vl8.in/allprofiles';
            $token = $_SESSION['token'];
           // echo $token;
            $options1 = array('http' => array(
                             'method'  => 'GET',
                             'header' => 'Authorization: Bearer '.$token
                      ));
            $context1  = stream_context_create($options1);
            $dashboard1 = file_get_contents($url1, false, $context1);
            $jsonData1 = json_decode($dashboard1,true);
            $arr1 = (array)$jsonData1;
            $av1 = array_values($arr1);

        ?>
        <h2 class="dash-title">General</h2>
        <div class="dash-cards">
            <?php
                            $k=0;
                            $l=1;
                            for($k==0;$k<sizeof($arr1);$k++)
                            {
                                $name1 = (string)$av1[$k][$l];
                                $age2 = (string)$av1[$k][5];
                                $profile_id = (string)$av1[$k][0];
                               //  $_SESSION['agent_id'] = $agent_id;
                echo "<div class='card-single'>";
                    echo"<div class='card-body'>";
                    echo "<div>"; 
                            echo "<a href='profile.php?profile_id=$profile_id'>
                                <img class='prfl_img' src='assets/img/user-14.jpg'>
                                <h4>$name1 , $age2 </h4>
                            </a>";
                        echo "</div>";
                    echo "</div>"; 
                    echo "</div>";
                            }
            ?>
        </div>
           
    </main>   



</body>
<script>
$("#logout").on("click", function() {
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
