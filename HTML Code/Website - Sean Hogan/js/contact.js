
function validateForm(){

    var name_val = document.getElementById('name').value;

    if(name_val==null || name_val==""){
        alert("Please enter a name");
        return false;
    }

    var email1_val = document.getElementById('email1').value;

    if(email1_val==null || email1_val==""){
        alert("Please enter an email");
        return false;
    }

    var email2_val = document.getElementById('email2').value;

    if(email2_val==null || email2_val==""){
        alert("Please retype your email in the second box");
        return false;
    }

    if(email1_val != email2_val){
        alert("Email fields need to be the same");
        return false;
    }


    var mob_val = document.getElementById('mobile').value;
    
    if(validatePhoneNumber(mob_val)==false){
        alert("Invalid Mobile");
        return false;
        }
    



    return true;
}
function validatePhoneNumber(numberValue) {

    var mobilePattern = /^\s*((\(?(0)\s?8[567]\)?\s?\d{3}\s?\d{4}))\s*$/;
    
    return mobilePattern.test(numberValue);
}
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    }         
    else {
    x.className = "topnav";
    }
}


