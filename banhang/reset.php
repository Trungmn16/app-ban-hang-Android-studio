<?php
include "connect.php";
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

require 'PHPMailer/src/Exception.php';
require 'PHPMailer/src/PHPMailer.php';
require 'PHPMailer/src/SMTP.php';
  
  
  $email =   $_POST['email'];
 
  $query = 'SELECT * FROM `user` WHERE `email` = "'.$email.'" ';
$data = mysqli_query($conn, $query);
$result = array();
while ($row = mysqli_fetch_assoc($data)){
    $result[] = ($row);
}
  if(empty($result)){
    $arr=[
        'success'=>false,
        'message'=>"Email không chính xác",
        'result'=>$result
        
    ];
     
  }else{
      //send mail
    
      $email=($result[0]["email"]);
      $pass=($result[0]["pass"]);
      $link="<a href='http://192.168.1.9/banhang/reset_pass.php?key=".$email."&reset=".$pass."'>Click To Reset password</a>";
      $mail = new PHPMailer();
      $mail->CharSet =  "utf-8";
      $mail->IsSMTP();
      // enable SMTP authentication
      $mail->SMTPAuth = true;
                  
      // GMAIL username
      $mail->Username = "maitrungmnt01@gmail.com";
      // GMAIL password
      $mail->Password = "Lol@.01686726436@.";
      $mail->SMTPSecure = "ssl";  
                    
      // sets GMAIL as the SMTP server
      $mail->Host = "smtp.gmail.com";
      // set the SMTP port for the GMAIL server
      $mail->Port = "465";
      $mail->From="maitrungmnt01@gmail.com"; // mail nguoi nhan
      $mail->FromName='App ban hang';
      $mail->AddAddress($email, 'reciever_name');
      $mail->Subject  =  'Reset Password';
                 
      $mail->IsHTML(true);
      $mail->Body= $link;
     
    
      if($mail->Send())
      {
       // echo" check mail";
        $arr=[
            'success'=>true,
            'message'=>"Mật khẩu của bạn đã được đổi ... vui lòng kiểm tra lại email",
            'result'=>$result
            
        ];
      }
      else
      {
        $arr=[
            'success'=>false,
            'message'=>"Đổi mật khẩu thất bại",
            'result'=>$result
            
        ];
      }
    

    }

    print_r(json_encode($arr));
?> 