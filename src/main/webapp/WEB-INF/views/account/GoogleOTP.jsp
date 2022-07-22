<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./login.css">
</head>
<body>
<div class="wrap">
    <div class="login">
        <h2>Goolge OTP</h2>
        <c:if test="${otpYn eq 'N'}">
            <div class="otp-img">
                <img src="">
            </div>
            <div class="otp-key">
                <label>${otp_key}</label>
            </div>
        </c:if>
        <div class="otp-desc">
            <label>인증코드(6자리) 입력하시오.</label>
        </div>
        <div class="otp-input">
            <input type="text" id="otpKey">
        </div>
        <div class="submit">
            <input type="submit" value="submit">
        </div>
    </div>
</div>
</div>
</body>
</html>