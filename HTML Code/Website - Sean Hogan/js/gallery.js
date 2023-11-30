function swap(picNum){
    document.querySelector('#mainImg').src = "images/gal"+picNum+".png";
}
imgNum = 1;
function next(){
    if(imgNum==4){
        imgNum = 1;
    }else imgNum++;

    swap(imgNum);

}

function previous(){
    if(imgNum==1){
        imgNum = 4;
    }else imgNum--;
    
    swap(imgNum);

}

 /* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
 function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    }         
    else {
    x.className = "topnav";
    }
    }