package org.example;

import org.example.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

            // transaction 끝
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }
}
