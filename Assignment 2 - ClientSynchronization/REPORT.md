# Observations
After running the code the first time the output didn't return what we expected.
The output was the following:
```
Hi,Andreas : 10 : Seats available for Troll
Hi,Xiangming : 10 : Seats available for Troll
Hi,Sam : 10 : Seats available for Troll
Hi,Ilaria : 10 : Seats available for Troll
Congratulations, Andreas : Booked 4 seats for Troll
Congratulations, Xiangming : Booked 3 seats for Troll
Congratulations, Sam : Booked 3 seats for Troll
Sorry, Ilaria : No seats available for Troll
```
The problem is that it doesn't print out the correct amount of seats available for the movie. This is because
each thread executes simultaneously and the server doesn't have time to update the amount of seats available before 
the next thread executes. To fix this we need to synchronize the threads so that only one thread can execute at a time.
We can fix this by making the bookTicket method synchronized.
``` 
public synchronized void bookTicket(String customerName, int numberOfSeats)
```

Now when the bookTicket() is run, it prevents multiple threads from booking seats simultaneously.

```
Hi,Xiangming : 10 : Seats available for Troll
Congratulations, Xiangming : Booked 3 seats for Troll
Hi,Ilaria : 7 : Seats available for Troll
Congratulations, Ilaria : Booked 2 seats for Troll
Hi,Sam : 5 : Seats available for Troll
Congratulations, Sam : Booked 3 seats for Troll
Hi,Andreas : 2 : Seats available for Troll
Sorry, Andreas : No seats available for Troll
```

The drawback of using synchronization is that it slows down the program, since each thread has to wait for 
one another to finish.