# ClientServerCalculator
This is a simple client-server calculator. You can use either a single threaded server or a multithreaded
server. The difference between the two is that the latter can handle multiple clients at the same time.
In the ArithmeticClient class, you choose how many threads to run. Each thread will run a random calculation that 
the server executes and returns to the client.