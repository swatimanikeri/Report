
//Entering from our html page and creating new html for taking input 
function addDynamicField() {
        const container = document.getElementById('dynamicFieldsContainer');
        const fieldDiv = document.createElement('div');
        fieldDiv.innerHTML = `
            <label>Field Name: <input type="text" class="field-name" placeholder="Field Name" required></label>
           
            <button type="button" onclick="applyDynamicField(this)">Add to Form</button>
            <button type="button" onclick="removeField(this)">Remove</button>
            <br>
        `;
        container.appendChild(fieldDiv);
    }
//for removing button 
    function removeField(button) {
        button.parentElement.remove();
    }

	
	
	//while we enter Add to form it render here and 
    function applyDynamicField(button) {
        const fieldContainer = button.parentElement;
        const nameInput = fieldContainer.querySelector('.field-name');
        const fieldName = nameInput.value.trim();

        if (!fieldName) return alert("Field Name is required!");

        // Prevent duplicate fields
        if (document.getElementById('field_' + fieldName)) {
            return alert("This field already exists.");
        }
		
		

        // Create a proper input in the form like Activity Details displying like lable input form 
        const extraFields = document.getElementById('extraDynamicFields');
        const newField = document.createElement('div');
        newField.setAttribute("id", "field_" + fieldName);
        newField.innerHTML = `
            <label>${fieldName}: <input type="text" name="${fieldName}" required></label><br>
        `;
        extraFields.appendChild(newField);
    }
	
	
// i dont know what it does 
    function collectDynamicFields() {
        const extraInputs = document.querySelectorAll('#extraDynamicFields input');
        const dynamicData = {};

        extraInputs.forEach(input => {
            dynamicData[input.name] = input.value;
        });

        document.getElementById('dynamicFields').value = JSON.stringify(dynamicData);
    }