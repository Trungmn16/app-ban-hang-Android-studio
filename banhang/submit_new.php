<?php
include "connect.php";
if(isset($_POST['submit_password']) && $_POST['email'])
{
  $email=$_POST['email'];
  $pass=$_POST['password'];
     
  $query = "update user set pass='$pass' where email='$email'";

  $data = mysqli_query($conn, $query);
  if($data == true){
?>

       <div style="text-align:center;">
        <H1>Đổi mật khẩu thành công!</H1> 
	</div>
  <?php
  }

}
?>