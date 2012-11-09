function clearLocation(txtBox)
{
    if(txtBox.value == 'Enter Location')
    {
        txtBox.value = '';
        txtBox.style.fontStyle = 'normal';
    }
}

function repopulateLocation(txtBox)
{
    if(txtBox.value == '')
    {
        txtBox.style.fontStyle = 'italic';
        txtBox.value = 'Enter Location';
    }
}