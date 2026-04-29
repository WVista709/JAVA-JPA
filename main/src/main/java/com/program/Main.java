package com.program;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

import com.dominio.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, "Carlos da silva", "CarlosSilva@gmail.com");
        Pessoa p2 = new Pessoa(null, "Davi silva", "DaviSilva@gmail.com");
        Pessoa p3 = new Pessoa(null, "Gustavo da silva", "GustavoSilva@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();


        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);

        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        
        emf.close();
        em.close();
    }
}