package AssignmentPart2.comparator;

import AssignmentPart2.entities.Candidate;

import java.util.Comparator;


public class CandidateComparator implements Comparator<Candidate> {

    @Override
    public int compare(Candidate c1, Candidate c2) {
        if(Integer.compare(c1.getCandidateType(), c2.getCandidateType())==1){
            return Integer.compare(c1.getCandidateType(), c2.getCandidateType());
        }
        else{
            return (Integer.compare(c1.getBirthDay().getYear(), c2.getBirthDay().getYear()));
        }
    }

}
