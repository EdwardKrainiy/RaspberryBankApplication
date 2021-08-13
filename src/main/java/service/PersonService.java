package service;

import dao.PersonDAO;
import model.Person;

import java.util.List;

public class PersonService {
    private final PersonDAO personDAO  = new PersonDAO();

    public PersonService(){};

    public Person findPerson(int id){
        return personDAO.findById(id);
    }

    public List<Person> findAllPersons(){
        return personDAO.findAll();
    }

    public void savePerson(Person person){
        personDAO.save(person);
    }

    public void updatePerson(Person person){
        personDAO.update(person);
    }

    public void deletePerson(Person person){
        personDAO.delete(person);
    }
}
