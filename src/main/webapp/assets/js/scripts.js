function focusFix(input) {
    input.focus();
    var tmpStr = input.val();
    input.val('');
    input.val(tmpStr);

}
