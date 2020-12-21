#CardGame

## API
### POST /games -> game-id
Creates a new game and returns a game identifier

### DELETE /games/{game-id}
Deletes the game with the provided game identifier.

### POST /games/{game-id}/decks
Adds a new deck to the game deck AKA Shoe

### POST /games/{game-id}/players -> id
Adds a new player to the game with the provided game identifier and returns a player identifier

### DELETE /games/{game-id}/players/{id}
Deletes a player with the player identifier from the game with the game identifier

