<?php
include "connect.php";
if($_GET['key'] && $_GET['reset'])
{
  $email=$_GET['key'];
  $pass=$_GET['reset'];
  $query = "select email,pass from user where email='$email' and pass='$pass'";

  $data = mysqli_query($conn, $query);

  if($data==true)
  {
    ?>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
 <div class="form-gap" style= "padding-top: 70px"></div>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
              <div class="panel-body">
                <div class="text-center">
                  <h3><i class="fa fa-lock fa-4x"></i></h3>
                  <h2 class="text-center">ĐỔI MẬT KHẨU?</h2>
                  <p>Bạn có thể nhập mật khẩu mới tại đây.</p>
                  <div class="panel-body">

                    <form method="post" action="submit_new.php">
                    <input type="hidden" name="email" value="<?php echo $email;?>">
                      <div class="form-group">
                        <div class="input-group">
                          <span class="input-group-addon"></span>
                       
                          <input  name="password" placeholder="Nhập mật khẩu mới" class="form-control"  type="password">
                        </div>
                      </div>
                      
                      <div class="form-group">
                        <input name="submit_password" class="btn btn-lg btn-primary btn-block" value="Đổi mật khẩu" type="submit">
                      </div>
                      
                    </form>
    
                  </div>
                </div>
              </div>
            </div>
          </div>
	</div>
</div>
    <?php
  }
}
?>
