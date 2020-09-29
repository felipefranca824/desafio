var score = document.getElementById("score");
var message = document.getElementById("message");
var form = document.getElementById("form");

function validator() {
    console.log("VAlor" + form.score.value);
    console.log("Entrou");
    if(!form.score.value == ''){
        console.log("Aquiii");
        if(isNumber(form.score.value)){
            console.log("Entrou if");
            
            form.submit();
        }else{
            message.innerText = "Digite apenas números";
            //message.style.display = block;
        }
    }else{
        message.innerText = "Campo Obrigatorio";
        //message.style.display = block;
    }
    
    
}

function isNumber(score) {
    return !isNaN(parseInt(score) && isFinite(score));
}
