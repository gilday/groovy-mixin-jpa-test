package org.ozoneplatform.mixintest.test

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.ozoneplatform.mixintest.domain.Person
import org.ozoneplatform.mixintest.domain.Preference

import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

class TestMixinPersistence {

    EntityManagerFactory entityManagerFactory

    @Before
    void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory('org.ozoneplatform.mixintest.domain')
    }

    @Test
    void canPersistPersonPreferencesThroughMixin() {
        def person = new Person(name:  "John")

        def em = entityManagerFactory.createEntityManager()
        em.getTransaction().begin()
        em.persist(person)
        em.getTransaction().commit()
        em.close()

        em = entityManagerFactory.createEntityManager()
        em.getTransaction().begin()
        def john = em.find(Person.class, person.id)
        def prefFavoriteFood = new Preference(key: "favfood", value: "jersey pizza")
        john.preferences.add(prefFavoriteFood)
        em.getTransaction().commit()
        em.close()

        assert john.name == "John"
        assert john.id != 0

        em = entityManagerFactory.createEntityManager()
        em.getTransaction().begin()
        john = em.find(Person.class, john.id)
        prefFavoriteFood = john.preferences.first()
        assert prefFavoriteFood.key == 'favfood'
        assert prefFavoriteFood.value == 'jersey pizza'
        em.getTransaction().commit()
        em.close()
    }

    @After
    void cleanup() {
        entityManagerFactory.close()
    }
}
