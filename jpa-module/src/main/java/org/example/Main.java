package org.example;

import org.example.model.User;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Entity Manager Factory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("playground");

        // 실제 EntityManager 생성
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 획득
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            // transaction 시작
            logic(em);
            // transaction 끝
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception 으로 인한 Rollback");
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(EntityManager em) {
        User user = User.builder()
                .id(1L)
                .username("jang")
                .password("pwd123")
                .build();

        em.persist(user);
        System.out.println("savedUser = " + user);

        user.setUsername("jangwonik");
        em.persist(user);

        User foundUser = em.find(User.class, 1L);
        System.out.println("foundUser = " + foundUser);

        TypedQuery<User> query = em.createQuery("select u from User u", User.class);

        List<User> resultList = query.getResultList();

        for (User user1 : resultList) {
            System.out.println("user1 = " + user1);
        }

        em.remove(user);
    }
}
