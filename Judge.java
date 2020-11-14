// Can use Arraylist but others can be used as well

//If they are trusted by everyone in the elements but don't trust anyone
public class Judge {
    
public int findJudge(int N, int[] trust)
{
    if (trust.length < N - 1) {
        return -1;
    }
    
    int[] indegrees = new int[N + 1];
    int[] outdegrees = new int[N + 1];

    for (int[] relation : trust) {
        outdegrees[relation[0]]++;
        indegrees[relation[1]]++; 
    }

    for (int i = 1; i <= N; i++) {
        if (indegrees[i] == N - 1 && outdegrees[i] == 0) {
            return i;
        }
    }
    return -1;

}

}

// Parameters: N: int = number of people in the town
// Trust int[][] = the trust array, in the form provided above
// and returns the ID of the judge or -1 if no judge is found

// Note that:
// - Number of people in the town is always between 1 and 1000
// - Number of entries in trust is always less than 10,000
// - Each item in the trust array is unique and different

// If the judge exists:
// - The judge trusts nobody
// - Everybody (except for the town judge) trusts the town judge
// - There is exactly one person that satisfies properties 1 and 2