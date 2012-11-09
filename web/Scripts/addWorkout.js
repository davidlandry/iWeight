function clearLength(txtBox)
{
    if(txtBox.value == '000')
    {
        txtBox.value = '';
        txtBox.style.fontStyle = 'normal';
    }
}

function repopulateLength(txtBox)
{
    if(txtBox.value == '')
    {
        txtBox.style.fontStyle = 'italic';
        txtBox.value = '000';
    }
}