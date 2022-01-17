document.getElementById("timetable_selector").onchange = changeListener;

function changeListener(){
    let value = this.value;
    let request = new XMLHttpRequest();

    request.open('GET', '/timetables/' + value + '/checkTimetable');
    request.responseType = 'json';
    request.send()

    request.onload = function() {
        let json = request.response;
        let allGroupInputs = document.getElementsByName('groupId');
        allGroupInputs.forEach(function (groupInput) {
            groupInput.value = json['id'];
        })

        if (json['empty'] === false) {
            window.location.href = '/timetables/' + json['id'] + '/edit';
        } else {
            document.cookie = "groupId=" + value + "; path=/timetables";
            console.log(document.cookie);
            window.location.href = '/timetables/new';
        }
    };


}