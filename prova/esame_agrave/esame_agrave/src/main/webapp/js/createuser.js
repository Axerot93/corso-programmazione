/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

console.log("script start ok");

let txtNome = document.getElementById("name");
let txtCognome = document.getElementById("lastname");
let txtUsr = document.getElementById("usr");
let txtPwd = document.getElementById("pwd");
let btnNew = document.getElementById("btnNewUser");
let txtRoleuser = document.getElementById("roleuser");
let txtUrsc = document.getElementById("usrc");

console.log(btnNew);

btnNewUser.addEventListener("click", v => {
    v.preventDefault();
    console.log("Click OK");
    console.log(txtNome.value);
    console.log(txtCognome.value);
    console.log(txtUsr.value);
    console.log(txtPwd.value);
    
    const User = {
        first_name:txtNome.value,
        last_name:txtCognome.value,
        email:txtUsr.value,
        pwd:txtPwd.value,
        roleuser:txtRoleuser.value
    };
    
    console.log(JSON.stringify(User)); /*stampare una string Json*/
    
    fetch('http://localhost:8080/esame_agrave/resources/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(User)
    }).then(response => {
            response.json();
            visualizzaUsers();
        })
      .catch(error => console.log(error));
 });
 
const visualizzaUsers = () => {
    fetch('http://localhost:8080/esame_agrave/resources/users/allslice', {
        method: 'GET',
        headers: {
           'Content-Type': 'application/json'
           /*'Authorization': 'Bearer ' + window.localStorage.getItem("token")*/
            }
        })
        .then (response => {
            if(response.ok === false){
                console.log("caricamento utenti non riuscito");
                console.log(response);
            } else {
                console.log("Risposta OK visualiza");
                console.log(response);
                return response.json();
            }
            
        })
        .then(data => {
            data.forEach(v => console.log(v));
            data.map(v => renderUser(v)).forEach(v => users.appendChild(v));
        });
        
    };

const renderUser = (v) => {
    const liElement = document.createElement("li");
    liElement.innerHTML = v.first_name;
    return liElement;
}

btnCancellaUser.addEventListener("click", v => {
    v.preventDefault();
    console.log("Click OK");
    
    fetch('http://localhost:8080/esame_agrave/resources/users/' + txtUrsc.value, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => console.log(response));  
})