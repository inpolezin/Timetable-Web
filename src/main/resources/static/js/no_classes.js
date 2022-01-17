document.getElementsByName("subjectId").forEach(function (selection) {
    selection.onchange = changeListener;
})

function changeListener() {
    if(this.value === "781") {
        this.parentNode.childNodes[11].value = "782";
    } else if (this.parentNode.childNodes[11].value === "782") {
        this.parentNode.childNodes[11].value = "";
    }
}