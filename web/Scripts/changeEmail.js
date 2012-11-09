function clearEmail(txtBox)
{
    if(txtBox.value == 'Enter email address')
    {
        txtBox.value = '';
        txtBox.style.fontStyle = 'normal';
    }
}

function repopulateEmail(txtBox)
{
    if(txtBox.value == '')
    {
        
        txtBox.style.fontStyle = 'italic';
        txtBox.value = 'Enter email address';
    }
}