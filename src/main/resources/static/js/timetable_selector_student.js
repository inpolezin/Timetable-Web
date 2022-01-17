document.getElementById("timetable_selector").onchange = changeListener;

function changeListener(){
    let value = this.value;

    window.location.href = '/timetables/' + value + '/student';

}