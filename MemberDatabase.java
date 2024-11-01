package lab4;

public class MemberDatabase extends Database<Member> {

    
    public MemberDatabase(String filename) {
        super(filename);
        
    }

    @Override
    public Member createRecordFrom(String line) {

        String[] temp = line.split(",");
        Member member = new Member(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
        return member;

    }
}
