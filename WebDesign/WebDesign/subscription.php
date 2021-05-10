<!DOCTYPE html>
<html lang="en">

<?php
        session_start();
    ?>     
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Subscription Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <style>
    .btn-primary {
    color: #fff;
    background-color: #11305f;
    border-color: #11305f;
}
.btn-primary:hover 
{
    color: #fff;
    background-color: #11305f;
    border-color: #11305f;
}

.btn-primary:visited
{
    color: #fff;
    background-color: #11305f;
    border-color: #11305f;
}
.btn-primary:active
{
    color: #fff;
    background-color: #11305f;
    border-color: #11305f;
}
.packB 
{
    border-bottom: 3px solid white;
    margin-bottom: 1rem;
}
.sym 
{
    font-size: 30px;
}
    </style>
</head>

<body>
<?php 
echo '<script>swal("", "Please recharge your Account!", "warning");</script>';
?>
    <div class="navbar">
        <ul class="navbar-nav">
            
            <li class="nav-item">
                <img src="assets/img/logo.png" class="logo">
            </li>
        </ul>
        <!-- <ul class="navbar-nav nav-right">
            <li class="nav-item">
                <a href='logout.php' class="nav-link">
                    <button class="nav-btn">Logout</button>
                </a>
            </li>
        </ul> -->
    </div>

    <main>
          
    <?php 
               
               $user_reg_id2= $_SESSION['user_reg_id2'];
               $rec = $_SESSION['recharge_false'];
               $url2 = 'http://stgvclocalapi.vl8.in/allpack';
               $options = array('http' => array(
                   'method'  => 'GET',
               ));
               $context2  = stream_context_create($options);
               $dashboard2 = file_get_contents($url2, false, $context2);
               $jsonData2 = json_decode($dashboard2,true);
               $arr2 = (array)$jsonData2;
               $av2 = array_values($arr2);
            //    $str = (string)$av2[0]["pack_name"];
            //    echo ($str);

       ?>


       <?php 
        //    if($rec === 1)
        //    {
        //     echo '<script>alert("Please recharge your account !")</script>';
        //    }
     
      ?>
   





         <center><h2 class="dash-title">Subscription Packs</h2></center>
        <div class="dash-cards">

        <?php
                            $k=0;
                            $l=1;
                            for($k==0;$k<sizeof($arr2);$k++)
                            {
                                $packName = (string)$av2[$k]["pack_name"];
                                $packPrice = (string)$av2[$k]["pack_price"];
                                $id = (string)$av2[$k]["id"];
                                $packId = (string)$av2[$k]["pack_id"];
                                $credits = (string)$av2[$k]["credits"];
                                   echo  "<div class='card-single'>";
                                   echo     "<div class='card-body'>";
                                    echo         "<div>";
                                                        
                                                            
                                    echo                 "<div class='packB'><h4>$packName</h4><br></div>";
                                    echo                 "<h4><span class='sym'>&#x20B9; $packPrice/-</span></h4><br>";
                                    echo                 "<h4><b>Credits : $credits</b></h4><br>";
                                    echo                 "<form action='subscription.php?packId1=$packId' method='POST'>";
                                    //echo "<a href='subscription.php?packId1=$packId'>";
                                    echo                       "<input class='btn btn-primary' name ='getPack' type='submit' value='Purchase'>";
                                    //echo "</a>";
                                    echo                 "</form>";
                                    echo          "</div>";
                                    echo      "</div>";
                                    echo "</div>";
                            }
                    ?>
                    </div>
                    </main>   

             <?php 
                
                if(isset($_POST[ 'getPack' ]))
                {
                    $packId2 = $_GET['packId1'];
                    //echo '<script>alert("'.$packId2.'")</script>';
                            
                            $headers  = [

                                'Content-Type: application/json;charset=UTF-8'
                            ];
                            $post = [
                                'pack_id' => $packId2,
                                'user_id' =>  $user_reg_id2,

                            ];
                            $url = 'stgvclocalapi.vl8.in/addPaymentDetails';
                            $ch = curl_init();
                            curl_setopt($ch, CURLOPT_URL,$url);
                            curl_setopt($ch, CURLOPT_RETURNTRANSFER,true);//check
                            curl_setopt($ch, CURLOPT_POST, true);
                            curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($post));
                            curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
                            $response = curl_exec($ch);
                            $statusCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
                            if($statusCode == 200)
                            {
                                //$check = 1;
                            //     echo '<script>alert("Your Payment is Underprocess .")';
                            //    // echo 'window.location = "login.php";';
                            //     echo '</script>';
                            //     header("Location: login.php");

                                            echo ("<script LANGUAGE='JavaScript'>
                                    
                                            swal({
                                                title: 'Successfull',
                                                text: 'Your Payment Under Process.',
                                                icon: 'success',
                                            });
                                        window.setTimeout(function() {
                                            window.location.href = 'login.php';
                                        }, 2500);
                                        </script>");
                            }
                            else
                            {
                                $check = 0;
                            }
                            // if($check ===1)
                            // {
                            //     echo '<script>alert("Your Payment is Underprocess .")</script>';
                            // }
                            curl_close($ch);

        
                }


             ?>

</body>
</html>