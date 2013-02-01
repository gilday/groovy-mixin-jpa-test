package org.ozoneplatform.mixintest.domain

import javax.persistence.*

@Entity
//@Mixin(HasPreferences)
class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id

    String name

    /**
     *
     * TEST TEST TEST TEST TEST
     *
     *
     * SWAP THIS PROPERTY DEFINITION WITH THE MIXIN TO BREAK
     * THE PERSISTENCE TEST
     *
     */
    @ElementCollection
    final Collection<Preference> preferences = []
}
