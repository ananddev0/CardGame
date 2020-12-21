#CardGame

## API
### POST /games -> game-id
Creates a new game and returns a game identifier

### DELETE /games/{game-id}
Deletes the game with the provided game identifier.

### POST /games/{game-id}/decks
Adds a new deck to the game deck AKA Shoe

### POST /games/{game-id}/players -> player-id
Adds a new player to the game with the provided game identifier and returns a player identifier

### DELETE /games/{game-id}/players/{player-id}
Deletes a player with the player identifier from the game with the game identifier

### PUT /games/{game-id}/players/{player-id}/deal/{hand}
Deals hand from shoe to player with the player-id within the game with the game-id

### GET /games/{game-id}/players/{player-id}/cards
Gets the list of cards for a player

### GET /games/{game-id}/players?value=face&sort=descending
List players with their card values in descending order

### GET /games/{game-id}/decks/{aggregate}?groupby={suit,card}
Perform and aggregate operation on the cards in the game deck AKA shoe. Obviously the cards remaining in the shoe are undealt. Can group by suit or card. Currently only the count aggregate operation is supported.

### PUT /games/{game-id}/decks
Shuffles the game deck AKA shoe. REMEMBER: Donot use the collection.shuffle() operation.