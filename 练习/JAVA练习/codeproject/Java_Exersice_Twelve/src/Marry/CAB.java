package Marry;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class CAB {
    public boolean canMarry(Person person, Person person2) {
        boolean canMarry = false;

        if (!person.getMarry() && !person2.getMarry()) {
            boolean person1IsEligible = person.getGender().equals('F') && person.getAge() >= 22;
            boolean person2IsEligible = person2.getGender().equals('F') && person2.getAge() >= 20;
            boolean person2IsEligibleAlt = person2.getGender().equals('M') && person2.getAge() >= 22;
            boolean person1IsEligibleAlt = person.getGender().equals('M') && person.getAge() >= 20;
            if ((person1IsEligible && person2IsEligibleAlt) || (person2IsEligible && person1IsEligibleAlt)) {
                canMarry = true;
            }
        }
        return canMarry;
    }


}
