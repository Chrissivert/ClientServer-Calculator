#include<iostream>
using namespace std;

void waitingTime(int processes[], int n, int bt[], int wt[]) //function to find the waitingtime
{
	wt[0] = 0;
	for (int i = 1; i < n ; i++ )
		wt[i] = bt[i-1] + wt[i-1] ;
}


void turnAroundTime( int processes[], int n, int bt[], int wt[], int tat[]) //function to find the waitingtime
{

	for (int i = 0; i < n ; i++)
		tat[i] = bt[i] + wt[i];
}


void avgTime( int processes[], int n, int bt[]) //function to find the average waiting time
{
	int wt[n], tat[n], total_wt = 0, total_tat = 0;
	waitingTime(processes, n, bt, wt);
	turnAroundTime(processes, n, bt, wt, tat);

	cout << "Processes "<< " Burst time "
		<< " Waiting time " << " Turn around time\n";

	for (int i=0; i<n; i++)
	{
		total_wt = total_wt + wt[i];
		total_tat = total_tat + tat[i];
		cout << " " << i+1 << "\t\t" << bt[i] <<"\t "
			<< wt[i] <<"\t\t " << tat[i] <<endl;
	}

	cout << "Average waiting time = "
		<< (float)total_wt / (float)n;
	cout << "\nAverage turn around time = "
		<< (float)total_tat / (float)n;
}


int main()
{
	int processes[] = { 1, 2, 3};
	int n = sizeof processes / sizeof processes[0];
	int burst_time[] = {7, 5, 6};
	avgTime(processes, n, burst_time);
	return 0;
}
