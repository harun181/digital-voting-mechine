import java.util.HashMap;
import java.util.Scanner;
class votes{
    public String voter_name;
    public int voter_id;

    public int getvoter_id() {

        return voter_id;
    }
    public votes(int voter_id)
    {
        this.voter_id = voter_id;
    }
    public votes(String voter_name)
    {
        this.voter_name = voter_name;
    }
    public void setvoter_id(int voter_id)
    {
        this.voter_id = voter_id;
    }

    public void setvoter_name(String voter_name)
    {
        this.voter_name = voter_name;
    }

    public String getvoter_name() {
        return voter_name;
    }

    public void printdetails(){
        System.out.println("user has voted with voter id "+voter_id);
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

class nominee{
    public String nominee_name;
    public int nominee_id;

    public int getNominee_id() {
        return nominee_id;
    }
    public nominee( int nominee_id) {
        this.nominee_id = nominee_id;
    }
    public nominee(String nominee_name){

        this.nominee_name = nominee_name;
    }
    public void setNominee_id(int nominee_id) {
        this.nominee_id = nominee_id;
    }

    public void setNominee_name(String nominee_name) {
        this.nominee_name = nominee_name;
    }

    public String getNominee_name() {
        return nominee_name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
public class digital_voting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<nominee,nominee> NomineeDetails = new HashMap<nominee, nominee>();
        HashMap<votes,Integer> VoterDetails = new HashMap<votes, Integer>();
        HashMap<votes,votes> UserDetails = new HashMap<votes,votes>();
        NomineeDetails.put(new nominee(1),new nominee("Bangladesh Awami League"));
        NomineeDetails.put(new nominee(2),new nominee("Bangladesh National Party"));
        NomineeDetails.put(new nominee(3),new nominee("Bangladesh Jamate Islami"));
        NomineeDetails.put(new nominee(4),new nominee("Jatiya Party"));
        System.out.println("*** Welcome to virtual voting ***");
        System.out.println("Pls enter no of voters:");
        int voters = sc.nextInt();
        while (voters != 0) {
            System.out.println("Enter last 3 digits of your NID: ");
            int VoterId = sc.nextInt();
            System.out.println("Enter voter name: ");
            String VoterName = sc.next();
            System.out.println("\n\n ### Please choose your Candidate ####\n\n");
            System.out.println("1. Bangladesh Awami League");
            System.out.println("2. Bangladesh National Party");
            System.out.println("3. Bangladesh Jamate Islami");
            System.out.println("4. Jatiya Party");
            System.out.println("Input your choice(1 - 4): ");
            int NomineeId = sc.nextInt();
            votes v = new votes(VoterId);
            if(VoterDetails.keySet().contains(v)) {
                System.out.println("You have already voted");
            }
            else{
                VoterDetails.put(new votes(VoterId), NomineeId);
                UserDetails.put(new votes(VoterId),new votes(VoterName));
            }
            voters--;
        }
        int winners = 0;
        int BalVotes,BnpVotes,JamatVotes,JatiyaVotes;
        BalVotes=BnpVotes=JamatVotes=JatiyaVotes=0;
        System.out.println("Displaying Bangladesh Awami League voters: ");
        for (votes key : VoterDetails.keySet()) {
            if (VoterDetails.get(key).equals(1)) {
                key.printdetails();
                BalVotes++;
            }
        }
        System.out.println("Displaying Bangladesh National Party voters: ");
        for (votes key : VoterDetails.keySet()) {
            if (VoterDetails.get(key).equals(2)) {
                key.printdetails();
                BnpVotes++;
            }
        }
        System.out.println("Displaying Bangladesh Jamate Islami voters: ");
        for (votes key : VoterDetails.keySet()) {
            if (VoterDetails.get(key).equals(3)) {
                key.printdetails();
                JamatVotes++;
            }
        }
        System.out.println("Displaying Jatiya Party voters: ");
        for (votes key : VoterDetails.keySet()) {
            if (VoterDetails.get(key).equals(4)) {
                key.printdetails();
                JatiyaVotes++;
            }
        }
        int max = (Math.max(BalVotes,Math.max(BnpVotes,Math.max(JamatVotes,JatiyaVotes))));
        if(BalVotes == max){
            System.out.println("Bangladesh Awami League has max votes");
            winners++;
        }
        if(BnpVotes == max){
            System.out.println("Bangladesh National Party has max votes");
            winners++;
        }
        if(JamatVotes == max){
            System.out.println("Bangladesh Jamate Islami has max votes");
            winners++;
        }
        if(JatiyaVotes == max){
            System.out.println("Jatiya Party has max votes");
            winners++;
        }
        if(winners>1){
            System.out.println("Hence it is draw");
        }
    }
}