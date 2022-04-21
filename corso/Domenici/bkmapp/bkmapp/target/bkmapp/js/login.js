/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
console.log("script start ok");

let txtUsr = document.getElementById("usr");
let txtPwd = document.getElementById("pwd");
let btnLogin = document.getElementById("btnLogin");

console.log(btnLogin);

btnLogin.addEventListener("click", v => {
    v.preventDefault();
    console.log("Click OK");
    console.log(txtUsr.value);
    console.log(txtPwd.value);
    
    const credential = {
        usr:txtUsr.value,
        pwd:txtPwd.value
    };
    
    console.log(JSON.stringify(credential)); /*stampare una string Json*/
    
    fetch('http://localhost:8080/bkmapp/resources/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(credential)
    }).then(response => response.json())
      /*.then(data => console.log(data))*/
      .then(data => {
          window.localStorage.setItem("jwt", data.jwt);
          window.localStorage.setItem("user", data.user);
          visualizzaUsers();
      });  
});

const visualizzaUsers = () => {
    fetch('http://localhost:8080/bkmapp/resources/users', {
        method: 'GET',
        headers: {
           /* 'Content-Type': 'application/json'*/
           'Authorization': 'Bearer ' + window.localStorage.getItem("jwt")
            }
        })
        .then (response => {
            if(response.ok === false){
                console.log("caricamento utenti non riuscito");
                console.log(response);
            } else {
                console.log("Risposta OK");
                return response.json();
            }
            
        })
        /*.then(data => data.forEach(v => console.log(v)));*/
        .then(data => data.map(v => renderUser(v)).forEach(v => users.appendChild(v))
         );
        
    };

const renderUser = (v) => {
    const liElement = document.createElement("li");
    liElement.innerHTML = v.last_name;
    return liElement;
}


