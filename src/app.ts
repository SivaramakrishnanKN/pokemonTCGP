import axios from 'axios';

// Interface for Move
interface Move {
  name: string;
  damage: string;
}

// Interface for Card
interface Card {
  name: string;
  type: string;
  hp: number;
  moves: Move[];
  basic: boolean;
  ex: boolean;
}

// Get form elements
const form = document.getElementById('card-form') as HTMLFormElement;
const moveContainer = document.getElementById('move-container') as HTMLDivElement;
const addMoveButton = document.getElementById('add-move') as HTMLButtonElement;

// Moves storage
const moves: Move[] = [];

// Event listener to dynamically add Move input fields
addMoveButton.addEventListener('click', () => {
  const moveIndex = moves.length;

  const moveDiv = document.createElement('div');
  moveDiv.classList.add('move-input');

  moveDiv.innerHTML = `
    <label for="move-name-${moveIndex}">Move Name:</label>
    <input type="text" id="move-name-${moveIndex}" required />

    <label for="move-damage-${moveIndex}">Damage:</label>
    <input type="text" id="move-damage-${moveIndex}" required />
    <br />
  `;
  moveContainer.appendChild(moveDiv);
});

// Form submission handler
form.addEventListener('submit', async (event) => {
  event.preventDefault();

  // Collect card data
  const name = (document.getElementById('name') as HTMLInputElement).value;
  const type = (document.getElementById('type') as HTMLSelectElement).value;
  const hp = parseInt((document.getElementById('hp') as HTMLInputElement).value);
  const basic = (document.getElementById('basic') as HTMLInputElement).checked;
  const ex = (document.getElementById('ex') as HTMLInputElement).checked;

  // Collect moves data
  const moveElements = document.querySelectorAll('.move-input');
  const moves: Move[] = [];

  moveElements.forEach((element, index) => {
    const moveName = (document.getElementById(`move-name-${index}`) as HTMLInputElement).value;
    const moveDamage = (document.getElementById(`move-damage-${index}`) as HTMLInputElement).value;
    moves.push({ name: moveName, damage: moveDamage });
  });

  // Create Card object
  const card: Card = {
    name: name,
    type: type,
    hp: hp,
    moves: moves,
    basic: basic,
    ex: ex,
  };

  try {
    // Send POST request to the backend
    const response = await axios.post('http://localhost:8080/cards', card);
    console.log('Card added:', response.data);

    alert('Card added successfully!');
    form.reset(); // Clear the form
    moveContainer.innerHTML = ''; // Clear the move inputs
  } catch (error) {
    console.error('Error adding card:', error);
    alert('Failed to add card.');
  }
});
