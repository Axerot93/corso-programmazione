/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
console.log("script start ok...");
let txtUsr = document.getElementById("usr");
let txtUsr = document.getElementById("pwd");
let txtUsr = document.getElementById("invia");

btnLogin.addEventiListenear("click",v =>{
    v.preventDefault();
    const credential= {
        usr:txtUsr.value,
        pwd:txtPwd.value
    };
    console.log(JSON.strimgify(credential));
});

