#CardGame

ASSUMPTION: Once a deck is added to a shoe, it cannot be removed. Once cards are added to the shoe there is not way to separate out the decks without sorting out the whole shoe. My understanding of what a shoe is in poker is from this video https://www.youtube.com/watch?v=-P_8VwVXwVk. So we only shuffle the cards in the shoe as a whole and not individual decks.

**NOTE: Have not been able to get to the following because of lack of time.**
 1. Synchronisation/Thread safety verification and issues
 2. JUNIT tests
 3. More testing

## API
For Details of usage import **CardGame/CardGame/CardGame.Postman_collection.json** into postman.

### POST {{url}}/games
Creates a new game and returns a game identifier

### DELETE {{url}}/games/{{gameid}}
Deletes the game with the provided game identifier.

### POST {{url}}/games/{{gameid}}/decks
Adds a new deck to the game deck AKA Shoe

### POST {{url}}/games/{{gameid}}/players
Adds a new player to the game with the provided game identifier and returns a player identifier

### DELETE {{url}}/games/{{gameid}}/players/{{playerid}}
Deletes a player with the player identifier from the game with the game identifier

### PUT {{url}}/games/{{gameid}}/players/{{playerid}}/deal/{count}
Deals hand from shoe to player with the player-id within the game with the game-id

### GET {{url}}/games/{{gameid}}/players/{{playerid}}/cards
Gets the list of cards for a player

### GET {{url}}/games/{{gameid}}/players
List players with their card values in descending order

### GET {{url}}/games/{{gameid}}/decks/count/{suits,cards}
Perform and aggregate operation on the cards in the game deck AKA shoe. Obviously the cards remaining in the shoe are undealt. Can group by suit or card. Currently only the count aggregate operation is supported.

### PUT {{url}}/games/{{gameid}}/decks/shuffle
Shuffles the game deck AKA shoe. REMEMBER: Donot use the collection.shuffle() operation.
