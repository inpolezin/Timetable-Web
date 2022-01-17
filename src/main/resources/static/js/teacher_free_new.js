document.getElementsByName("teacherId").forEach(function (selection) {
    selection.onchange = changeListener;
})

function changeListener() {
    if(this.value === "782") {
        this.parentNode.childNodes[9].value = "781";
    } else if (this.parentNode.childNodes[9].value === "781") {
        this.parentNode.childNodes[9].value = "";
    }

    let button = document.getElementById("submit-button");
    let select = this;
    let children = this.parentNode.childNodes;
    let teacherId = this.value;
    let day = children[3].value;
    let lesson = children[5].value;
    let timetableId = '0';

    let body = 'id=' + timetableId +
        '&day=' + day +
        '&lesson=' + lesson +
        '&teacherId=' + teacherId;

    let request = new XMLHttpRequest();

    request.open('POST', '/timetables/checkTeacher');
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    request.responseType = 'json';
    request.send(body)

    request.onload = function() {
        let json = request.response;
        if(json == false) {
            button.disabled = true;
            select.style.color = 'red';


            alert("Преподаватель занят на эту пару, выберите, пожалуйста, другого преподавателя");
        } else {
            select.style.color = 'black';
            button.disabled = false;
        }
    };
}
