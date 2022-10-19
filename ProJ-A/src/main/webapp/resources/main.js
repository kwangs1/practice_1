/**
 * 
 */




function cookieRemove() {

    // 변수를 선언한다.
    var date = new Date();
    date.setDate(date.getDate() - 1);

    var willCookie = "";
    willCookie += "CookieName=Value;";
    willCookie += "Expires=" + date.toUTCString();

    // 쿠키를 집어넣는다.
    document.cookie = willCookie;
    window.location.reload();
   }