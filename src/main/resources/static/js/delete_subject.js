document.getElementsByName("form").forEach(function (selection) {
    selection.elements.button.onclick = deleteSubject;
})

function deleteSubject() {
    let subjectId = this.parentNode.childNodes[1].value;
    console.log(subjectId);

    $.ajax({
        type: 'DELETE',
        url: '/subjects/' + subjectId,
        success: function( response ) {
            if (response === "/subjects") {
                window.location.href = response;
            } else {
                alert(response);
            }
        }
    });
}