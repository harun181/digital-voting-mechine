import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class DigitalVotingSystem {
    static class Nominee {
        private String name;
        private int votes;

        public Nominee(String name) {
            this.name = name;
            this.votes = 0;
        }

        public String getName() {
            return name;
        }

        public int getVotes() {
            return votes;
        }

        public void incrementVotes() {
            votes++;
        }
    }

    static class Voter {
        private int voterId;
        private String voterName;
        private boolean hasVoted;

        public Voter(int voterId, String voterName) {
            this.voterId = voterId;
            this.voterName = voterName;
            this.hasVoted = false;
        }

        public int getVoterId() {
            return voterId;
        }

        public boolean hasVoted() {
            return hasVoted;
        }

        public void castVote() {
            hasVoted = true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Nominee> nominees = new ArrayList<>();
        nominees.add(new Nominee("Bangladesh Awami League"));
        nominees.add(new Nominee("Bangladesh National Party"));
        nominees.add(new Nominee("Bangladesh Jamate Islami"));
        nominees.add(new Nominee("Jatiya Party"));

        ArrayList<Voter> voters = new ArrayList<>();

        System.out.println("*** Welcome to virtual voting ***");
        System.out.print("Enter the number of voters: ");
        int totalVoters = scanner.nextInt();

        for (int i = 1; i <= totalVoters; i++) {
            System.out.print("Enter last 3 digits of your NID: ");
            int voterId = scanner.nextInt();
            System.out.print("Enter voter name: ");
            String voterName = scanner.next();

            Voter newVoter = new Voter(voterId, voterName);
            voters.add(newVoter);

            System.out.println("\n### Please choose your Candidate ###");
            for (int j = 0; j < nominees.size(); j++) {
                System.out.println((j + 1) + ". " + nominees.get(j).getName());
            }

            System.out.print("Input your choice (1 - " + nominees.size() + "): ");
            int nomineeChoice = scanner.nextInt();

            if (nomineeChoice >= 1 && nomineeChoice <= nominees.size()) {
                if (!voters.get(i - 1).hasVoted()) {
                    nominees.get(nomineeChoice - 1).incrementVotes();
                    voters.get(i - 1).castVote();
                    System.out.println("Vote cast successfully!");
                } else {
                    System.out.println("You have already voted!");
                }
            } else {
                System.out.println("Invalid choice!");
            }
        }

        int maxVotes = 0;
        Nominee winner = null;

        for (Nominee nominee : nominees) {
            if (nominee.getVotes() > maxVotes) {
                maxVotes = nominee.getVotes();
                winner = nominee;
            }
        }

        if (winner != null) {
            System.out.println("The winner is: " + winner.getName() + " with " + maxVotes + " votes!");
        } else {
            System.out.println("No winner!");
        }
    }
}
