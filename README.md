# Pong


The classic pong game, very simple to create, biggest problem was making the two player controls
i solved the issue with a copyOnWriteArrayList which is not ideal but as its just a simple pong game i though it will suffice, the controls for each player are added to the array list, removes if same button used twice because of weird bouncing effect of the paddle, also removes to stop paddle moving beyond the bounds of the board, the arraylist is constantly looped through to read the current control and move the paddles acoordingly, this arraylist is in the controls class and is accessed through a singleton method.

Controls for left side player:

W: up
S: down

Controls for right side player:

P: up
L: down

both players :

if going paddle is moving up press down to stop paddle press down again to go down and vice versa.

	
Game:

game starts with two players with the ball in the middle, prompting to press space bar to play
the ball will be released, move the paddles to hit the ball, player scores when the ball passes the players paddle, first to 10 wins
