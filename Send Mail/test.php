<?php
$to       = 'saknurekranti@gmail.com';
$subject  = 'Testing sendmail.exe';
$rnd = rand (  1111, 9999 );

$message  = 'Your OTP ' .$rnd;
$headers  = 'From: theyumbite@gmail.com' . "\r\n" .
            'MIME-Version: 1.0' . "\r\n" .
            'Content-type: text/html; charset=utf-8';
if(mail($to, $subject, $message, $headers))
    echo "Email sent" .$to;
else
    echo "Email sending failed";
?>