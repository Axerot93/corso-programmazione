
function caricadati() {
    let objnotizia = document.getElementById("spnome");
    objnotizia.innerHTML = "iniziato corso html5";
    let objtit = document.getElementById("titolo");
    objtit.innerHTML = "AVVVIO HTML5!!!";
    let file = "https://catfact.ninja/fact";

    fetch(file)
            .then(x => {
                let res = x.json();
                return res
            }
            )

            .then(y => objnotizia.innerHTML = y.fact + y.lenght);
}


