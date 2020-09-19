package a2;

import java.util.List;
import java.util.ArrayList;

public class ManagerMemberCard {
    private List<MemberCard> memberCards;

    private static ManagerMemberCard instance;
    public static ManagerMemberCard getInstance(){
        if(instance == null) {
            instance = new ManagerMemberCard();
        }
        return instance;
    }
    public ManagerMemberCard(){
        memberCards = new ArrayList<>();
    }
    public void add(MemberCard memberCard){
        this.memberCards.add(memberCard);
    }
    public boolean del(int id){
        return memberCards.removeIf(t->t.getId()==id);
    }
    public void printList(){
        for(MemberCard a: memberCards){
            a.print();
        }
    }






}
