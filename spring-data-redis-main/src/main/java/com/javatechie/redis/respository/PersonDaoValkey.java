package com.javatechie.redis.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoValkey {

    public static final String HASH_KEY = "Person";
    
    @Autowired
    private RedisTemplate template;

    public Object save(Object person){
        template.opsForHash().put(HASH_KEY,((Person) person).getId(),person);
        return person;
    }

    public List<Object> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Object findPersonById(int id){
        return template.opsForHash().get(HASH_KEY,id);
    }

    public String deletePerson(int id){
         template.opsForHash().delete(HASH_KEY,id);
        return "Person removed !!";
    }
}

class Person {
    private int id;
    private String name;
    private int age;

    public Person() {}

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}