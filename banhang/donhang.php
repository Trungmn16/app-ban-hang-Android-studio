<?php
include "connect.php";

$sdt = $_POST['sdt'];
$email = $_POST['email'];
$tongtien = $_POST['tongtien'];
$iduser = $_POST['iduser'];
$diachi = $_POST['diachi'];
$soluong = $_POST['soluong'];

$query = ' INSERT INTO 'donhang'('iduser', 'diachi', 'sdt', 'email', 'soluong', 'tongtien') VALUES('.$iduser.' , "'.$diachi.'","'.$sdt.'","'.$email.'",'.$soluong.',"'.$tongtien.'")';
echo $query;
$data = mysqli_query($conn, $query);
if($data == true) {
    $query = 'SELECT LAST_INSERT_ID()'; 
    $data = mysqli_query($conn, $query);
    while($row = mysqli_fetch_assoc($data)){
        $result[] = ($row);
    }
    print_r ($result);
}else{
    $arr=[
        'success'=>false,
        'message'=>"no complete",
        
        
    ];

}

die();
print_r(json_encode($arr));
?>