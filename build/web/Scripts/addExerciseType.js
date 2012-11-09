function clearType(txtBox)
{
    if(txtBox.value == 'Enter Exercise Type')
    {
        txtBox.value = '';
        txtBox.style.fontStyle = 'normal';
    }
}

function repopulateType(txtBox)
{
    if(txtBox.value == '')
    {
        txtBox.style.fontStyle = 'italic';
        txtBox.value = 'Enter Exercise Type';
    }
}