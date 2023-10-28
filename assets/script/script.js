const container = document.querySelector('.main');
const addButton = document.querySelector('#addButton');
const addCardForm = document.querySelector('#addCardForm');
const formTerm = document.querySelector('#formTerm');
const formDefinition = document.querySelector('#formDefinition');
const saveButton = document.querySelector('#saveButton');
let card = document.querySelector('#card');
const title = document.querySelector('#title');
const definition = document.querySelector('#definition');
const previousButton = document.querySelector('#previous');
const nextButton = document.querySelector('#next');

let cardsArray = [];
let currentCard;

document.addEventListener("DOMContentLoaded", function(event) {
    fetch('https://560f-2a01-5a8-306-24ab-a5c4-424f-ac04-1018.ngrok-free.app/questions')
        .then((res) => res.json())
        .then((data) => {
            cardsArray = data;
            for (let i = 0; i < cardsArray.length; i++) {
                card = currentCard;
                title.textContent = cardsArray[i].title;
                definition.textContent = cardsArray[i].definition;
            }
            console.log(cardsArray);
        })
        .catch((err) => {
            console.error('Ошибка: ' + err);
        });
});    
    
/*function createCard(obj) {
        const { term, definition } = obj;
        const card = `<h3>${term}</h3><button>Проверить</button>`;
        return card;
}
    
function addCard(card) {
        const cardElement = document.createElement('div');
        cardElement.innerHTML = card;
        container.append(cardElement);
}*/

function showForm() {
    addCardForm.classList.remove('hidden');
}

addButton.addEventListener('click', showForm);

function addCustomCard() {
    fetch(`https://560f-2a01-5a8-306-24ab-a5c4-424f-ac04-1018.ngrok-free.app/create?title=` + formTerm.value + `&definition=` + formDefinition.value, {
        method: 'POST',
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        }
      })
      .then(response => response.json())
      .then(response => {   
            /*if(!formTerm.value.trim() || !formDefinition.value.trim()) {
                alert("Пожалуйста, заполни все поля!");
                return;
            } */
            console.log(response);
            cardsArray.push(response);
            console.log(cardsArray);

            formTerm.value = '';
            formDefinition.value = '';
      })
      .catch(error => {
        console.error("Произошла ошибка: ", error);
        alert("Произошла ошибка при добавлении карточки. Попробуйте еще раз.");
      });
}

saveButton.addEventListener('click', addCustomCard);