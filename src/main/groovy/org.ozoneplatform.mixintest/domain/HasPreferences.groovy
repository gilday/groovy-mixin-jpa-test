package org.ozoneplatform.mixintest.domain

import javax.persistence.ElementCollection

@Category(Person) class HasPreferences {

    @ElementCollection
    final Collection<Preference> preferences = []

}
