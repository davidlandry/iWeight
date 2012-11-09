

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

function clearUsername(txtBox)
{
    if(txtBox.value == 'Enter a requested username')
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
        txtBox.value = 'Enter a requested username';
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

function clearFirst(txtBox)
{
    if(txtBox.value == 'Enter First Name')
    {
        txtBox.value = '';
        txtBox.style.fontStyle = 'normal';
    }
}

function repopulateFirst(txtBox)
{
    if(txtBox.value == '')
    {
        
        txtBox.style.fontStyle = 'italic';
        txtBox.value = 'Enter First Name';
    }
}

function clearLast(txtBox)
{
    if(txtBox.value == 'Enter Last Name')
    {
        txtBox.value = '';
        txtBox.style.fontStyle = 'normal';
    }
}

function repopulateLast(txtBox)
{
    if(txtBox.value == '')
    {
        
        txtBox.style.fontStyle = 'italic';
        txtBox.value = 'Enter Last Name';
    }
}

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

function clearWeight(txtBox)
{
    if(txtBox.value == '000')
    {
        txtBox.value = '';
        txtBox.style.fontStyle = 'normal';
    }
}

function repopulateWeight(txtBox)
{
    if(txtBox.value == '')
    {
        
        txtBox.style.fontStyle = 'italic';
        txtBox.value = '000';
    }
}