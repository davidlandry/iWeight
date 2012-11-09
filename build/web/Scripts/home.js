function clearUsername(txtBox)
{
    if(txtBox.value == 'Your username')
    {
        txtBox.value = '';
        txtBox.style.fontStyle = 'normal';
    }
}

function repopulateUsername(txtBox)
{
    if(txtBox.value == '')
    {
        txtBox.style.fontStyle = 'italic';
        txtBox.value = 'Your username';
    }
}

function clearPass(txtBox)
{
    if(txtBox.value == '        ')
    {
        txtBox.value = '';
        txtBox.style.fontStyle = 'normal';
    }
}

function repopulatePass(txtBox)
{
    if(txtBox.value == '')
    {
        txtBox.style.fontStyle = 'italic';
        txtBox.value = '        ';
    }
}