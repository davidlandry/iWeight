function clearExerciseName(txtBox)
{
    if(txtBox.value == 'Enter Exercise Name')
    {
        txtBox.value = '';
        txtBox.style.fontStyle = 'normal';
    }
}

function repopulateExerciseName(txtBox)
{
    if(txtBox.value == '')
    {
        txtBox.style.fontStyle = 'italic';
        txtBox.value = 'Enter Exercise Name';
    }
}

function clearCalories(txtBox)
{
    if(txtBox.value == 'Enter Calories Burned per Hour')
    {
        txtBox.value = '';
        txtBox.style.fontStyle = 'normal';
    }
}

function repopulateCalories(txtBox)
{
    if(txtBox.value == '')
    {
        txtBox.style.fontStyle = 'italic';
        txtBox.value = 'Enter Calories Burned per Hour';
    }
}
