import java.util.*;

class ThroneInheritance {
    class Person {
        private String name;
        public boolean death = false;
        public List<Person> children = new ArrayList<>();

        Person(String name) {
            this.name = name;
        }
    }

    private final Person king;
    private final Map<String, Person> map = new HashMap<>();

    public ThroneInheritance(String kingName) {
        king = new Person(kingName);
        map.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Person person = new Person(childName);
        map.put(childName, person);
        map.get(parentName).children.add(person);
    }

    public void death(String name) {
        map.get(name).death = true;
    }

    public List<String> getInheritanceOrder() {
        return preorder(king);
    }

    private List<String> preorder(Person person) {
        List<String> list = new ArrayList<>();
        if (!person.death) {
            list.add(person.name);
        }
        for (Person child : person.children) {
            list.addAll(preorder(child));
        }
        return list;
    }
}