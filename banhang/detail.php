<?php
include "connect.php";

$page =$_POST['page'];
$total =5 ;
$pos = ($page-1)*$total;
$type = $_POST['type'];

$query = 'SELECT * FROM `sanphammoi` WHERE `type` = '.$type.' LIMIT '.$pos.','.$total.'';
$data = mysqli_query($conn, $query);
$result = array();
while ($row = mysqli_fetch_assoc($data)){
    $result[] = ($row);
}
if(!empty($result)){
    $arr=[
        'success'=>true,
        'message'=>"complete",
        'result'=>$result
        
    ];
}else{
    $arr=[
        'success'=>false,
        'message'=>"no complete",
        'result'=>$result
        
    ];

}
print_r(json_encode($arr));
?>