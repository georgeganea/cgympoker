# Introduction #

Client program structure.


# Details #

The client connects to the server using RMI. If the data supplied is correct(login name and password, or when it creates an account if the name is not already taken), he will receive a Login object which is used to access the Server View. This means he can view the open tournaments, he can join a tournament. When he joins a tournament, the status bar he sees is  updated to notify him that he is joined. When the administer starts the tournament, he will be notified and a new application window will open. He will see all the other players and he will receive two cards for start. All the background work is done using the Observer and Observable pattern.