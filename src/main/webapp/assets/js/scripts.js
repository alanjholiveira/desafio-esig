function focusFix(input) {
    input.focus();
    var tmpStr = input.val();
    input.val('');
    input.val(tmpStr);

    function cancelEditListener() {

        cancelEdit();

        $(this).unbind('keydown', cancelEditListener)
        return false;
    }

    input.bind('keydown', 'esc', cancelEditListener);
}
