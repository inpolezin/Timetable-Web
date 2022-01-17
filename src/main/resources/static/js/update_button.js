$('#button').click(function(){
    let groupId = document.getElementById('groupId');
    let subjectIds = document.getElementsByName('subjectId');
    let teacherIds = document.getElementsByName('teacherId');
    let timetableIds = document.getElementsByName('timetableId');

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
        test("MONDAY", 0, groupId, subjectIds, teacherIds, timetableIds);
        test("TUESDAY", 5, groupId, subjectIds, teacherIds, timetableIds);
        test("WEDNESDAY", 10, groupId, subjectIds, teacherIds, timetableIds);
        test("THURSDAY", 15, groupId, subjectIds, teacherIds, timetableIds);
        test("FRIDAY", 20, groupId, subjectIds, teacherIds, timetableIds);
        test("SATURDAY", 25, groupId, subjectIds, teacherIds, timetableIds);

        alert("Сохранено!")
    } else {
        alert("Заполните все поля!")
    }


});

function test(day, j, groupId, subjectIds, teacherIds, timetableIds) {
    for (let i = 1; i < 6; i++) {

        $.ajax({
            type: "PATCH",
            url: '/timetables/' + timetableIds[j].value,
            data: {
                groupId: groupId.value,
                day: day,
                lesson: i,
                subjectId: subjectIds[j].value,
                teacherId: teacherIds[j].value,
            },
            success: function() {
            }
        });
        j++;
    }
}