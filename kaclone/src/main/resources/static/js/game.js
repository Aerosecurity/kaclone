function init() {
    buildCity(userId, "Hello World")
}

window.onload = init;

function makeCall(method, url, body, callback) {
    console.log(method)
    console.log(url)
    console.log(body)
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            callback(JSON.parse(this.responseText));
        }
    };

    xhttp.open(method, url, true);
    xhttp.setRequestHeader("Accept", "application/json")
    if (body === null || body === undefined) {
        xhttp.send();
    } else {
        xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
        xhttp.send(JSON.stringify(body))
    }
}

function getListOfCities(ownerId) {
    makeCall("GET", "/city?ownerId="+ownerId, null, getListOfCitiesCallback)
}

function getListOfCitiesCallback(responseText) {
    console.log(responseText)
}

function buildCity(ownerId, name) {
    var body = {
        "ownerId": ownerId,
        "cityName": name
    }
    makeCall("POST", "/city", body, buildCityCallback)
}

function buildCityCallback(responseText) {
    console.log(responseText)
}
