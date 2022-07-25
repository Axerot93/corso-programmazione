/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

console.log("script start ok");

let txtDescrizione = document.getElementById("descrizione");
let txtLink = document.getElementById("link");
let txtCondiviso = document.getElementById("condiviso");

let txtBookid = document.getElementById("bookid");
let txtTags = document.getElementById("tags");
let txtCancellare = document.getElementById("cancellare");

let btnNew = document.getElementById("btnNewBook");


console.log(btnNewBook);

btnNewBook.addEventListener("click", v => {
    
    v.preventDefault();
    
    console.log("Click OK BookMark");
    console.log(txtDescrizione.value);
    console.log(txtLink.value);
    console.log(txtCondiviso.value);
    
    let condiviso = false;
    let status = "Nuovo";
    let motivorim = "";
    
    
    if(txtCondiviso.value === 1){
        condiviso = "true";
    }
    
    
    
    const book = {
        descrizione:txtDescrizione.value,
        link:txtLink.value,
        condiviso:condiviso,
        status:status
    };
    
    console.log(JSON.stringify(book)); /*stampare una string Json*/
    
    fetch('http://localhost:8080/esame_agrave/resources/segnalibri', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + window.localStorage.getItem("token")
        },
        body: JSON.stringify(book)
    }).then(response => {
                response.json();
                console.log(response);
        });
      /*.then(data => console.log(data))
      .then(visualizzaBooks()); */ 
});

btnleggeBook.addEventListener("click", e => {
    
    e.preventDefault();
    
    console.log("Click LeggeBook");
   
   visualizzaBooks();
        
});

const visualizzaBooks = () => {
    
    console.log("mettodo LeggeBook"); 
     
    fetch('http://localhost:8080/esame_agrave/resources/segnalibri', {
        method: 'GET',
        headers: {
           'Content-Type': 'application/json',
           'Authorization': 'Bearer ' + window.localStorage.getItem("token")
            }
        })
        .then (response => {
            if(response.ok === false){
                console.log("caricamento Books non riuscito");
                console.log(response);
            } else {
                console.log("Risposta OK per Get Books");
                console.log(response);
                return response.json();
            }
            
        })
        .then(data => {
            console.log("lavorando response Json");
            data.forEach(v => console.log(v));
            data.map(v => renderBook(v)).forEach(v => books.appendChild(v));
        });
    
}

const renderBook = (v) => {
    console.log("render Books ok");
    const liElement = document.createElement("li");
    liElement.innerHTML = v.idbkm +" " + v.descrizione + " - " + v.link + " " + v.utente + " " + v.condiviso  + " " + v.dtcreazione + " " + v.status + " " + v.dtaggiornamento + " " + v.utenteagg + " " + v.motivorim+ " " + v.Tags;
    return liElement;
}

btnAddTag.addEventListener("click", f => {
    
    f.preventDefault();
    
    console.log("Aggiunge Tags");
    
    const tgs = {
        idBook:txtBookid.value,
        Tags:txtTags.value
    };
    
    console.log(JSON.stringify(tgs)); /*stampare una string Json*/
    
    
    fetch('http://localhost:8080/esame_agrave/resources/segnalibri', {
        method: 'PATCH',
        headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json',
           'Authorization': 'Bearer ' + window.localStorage.getItem("token")
            },
           body: JSON.stringify(tgs)
        })
        .then (response => {
            if(response.ok === false){
                console.log("caricamento Books non riuscito");
                console.log(response);
            } else {
                console.log("Risposta OK per Get Books");
                console.log(response);
            }
            
        });
     
    visualizzaBooks();
        
});

btncancellaBook.addEventListener("click", a => {
    
    a.preventDefault();
    
    console.log("Cancella BookMark");
    
    const bk = {
        idBook:txtCancellare.value
    };
    
    console.log(JSON.stringify(bk)); /*stampare una string Json*/
    
    
    fetch('http://localhost:8080/esame_agrave/resources/segnalibri', {
        method: 'DELETE',
        headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json',
           'Authorization': 'Bearer ' + window.localStorage.getItem("token")
            },
           body: JSON.stringify(bk)
        })
        .then (response => {
            if(response.ok === false){
                console.log("cancellamento di Book non riuscito");
                console.log(response);
            } else {
                console.log("Risposta OK per cancellare Book");
                return response;
            }
            
        });
        
});

btnaggionaBook.addEventListener("click", a => {
    
    a.preventDefault();
    
    let txtAggionere = document.getElementById("aggionare");
    let condiviso = false;
   
    
    if(txtCondiviso.value === 1){
        condiviso = "true";
    }
    
    
    console.log("Aggiona BookMark");
    
    const bk = {
        id:txtAggionere.value,
        descrizione:txtDescrizione.value,
        link:txtLink.value,
        condiviso:condiviso,
        status:"Nuovo",
        motivorim:"test Motivo"
    
    };
    
    console.log(bk);
    
    console.log(JSON.stringify(bk)); /*stampare una string Json*/
    
    
    fetch('http://localhost:8080/esame_agrave/resources/segnalibri', {
        method: 'PUT',
        headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json',
           'Authorization': 'Bearer ' + window.localStorage.getItem("token")
            },
           body: JSON.stringify(bk)
        })
        .then (response => {
            if(response.ok === false){
                console.log("Aggionamento di Book non riuscito");
                console.log(response);
            } else {
                console.log("Aggionamento OK per Book");
                return response.json();
            }
            
        });
        
});