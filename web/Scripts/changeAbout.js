function clearTextArea(txtBox)
{
    if(txtBox.value == 'Enter some information about yourself..')
    {
        txtBox.value = '';
        txtBox.style.fontStyle = 'normal';
    }
}

function repopulateTextArea(txtBox)
{
    if(txtBox.value == '')
    {
        txtBox.style.fontStyle = 'italic';
        txtBox.value = 'Enter some information about yourself..';
    }
}