

// Function to fetch data from the backend
function getQuestions() {
    fetch('http://localhost:8080/questions', {
        method: 'GET', // Use the appropriate HTTP method (GET, POST, PUT, DELETE, etc.)
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            // You can add additional headers if needed
        },
        // You can add a request body for POST or PUT requests
    })
        .then((response) => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Parse the response JSON
        })
        .then((data) => {
            // Handle the data received from the backend
            console.log('Data from the backend:', data);
            // You can update your UI or perform other actions with the data here
        })
        .catch((error) => {
            console.error('Fetch error:', error);
        });
}

function addQuestion(title, definition) {
    fetch(`http://localhost:8080/create?title=${title}&definition=${definition}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            // You can add additional headers if needed
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Parse the response JSON
        })
        .then(data => {
            // Handle the response data here
            console.log('Response from the API:', data);
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
}

function deleteQuestion(id) {
    fetch('http://localhost:8080/questions/{id}', {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json' // Установите заголовок Content-Type при необходимости
        },
        body: JSON.stringify({id: id})
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            console.log('Successfully deleted the resource.');
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
}

function submitQuestion() {
    // Получите значения из инпутов
    const value1 = document.getElementById("input1").value;
    const value2 = document.getElementById("input2").value;

    // Вызовите вашу функцию, передавая ей значения из инпутов
    addQuestion(value1, value2);
}

function submitDelete() {
    deleteQuestion(document.getElementById("input3").value);
}
