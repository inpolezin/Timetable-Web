$('#button').click(function(){
    let groupId = document.getElementById('timetable_selector');
    let subjectIds = document.getElementsByName('subjectId');
    let teacherIds = document.getElementsByName('teacherId');

    console.log(groupId.value);
    console.log(subjectIds);
    console.log(teacherIds);

    let groupIsExist = true;
    let subjectsIsExists = true;
    let teachersIsExists = true;

    if (groupId.value === "") {
        groupIsExist = false;
    }

    subjectIds.forEach(function (subjectId) {
        if (subjectId.value === "") {
            subjectsIsExists = false;
        }
    })

    teacherIds.forEach(function (teacherId) {
        if (teacherId.value === "" || teacherId.style.color === 'red') {
            teachersIsExists = false;
        }
    })

    if (subjectsIsExists && teachersIsExists && groupIsExist) {
        test("MONDAY", 0, groupId, subjectIds, teacherIds);
        test("TUESDAY", 5, groupId, subjectIds, teacherIds);
        test("WEDNESDAY", 10, groupId, subjectIds, teacherIds);
        test("THURSDAY", 15, groupId, subjectIds, teacherIds);
        test("FRIDAY", 20, groupId, subjectIds, teacherIds);
        test("SATURDAY", 25, groupId, subjectIds, teacherIds);

    } else {
        alert("Заполните все поля!")
    }


});

function test(day, j, groupId, subjectIds, teacherIds) {
    for (let i = 1; i < 6; i++) {

        $.ajax({
            type: "POST",
            url: '/timetables',
            data: {
                groupId: groupId.value,
                day: day,
                lesson: i,
                subjectId: subjectIds[j].value,
                teacherId: teacherIds[j].value,
            },
            success: function( response ) {
                console.log()
            }
        });
        j++;
    }
}