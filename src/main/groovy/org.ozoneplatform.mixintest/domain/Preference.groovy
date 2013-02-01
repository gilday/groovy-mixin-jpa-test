package org.ozoneplatform.mixintest.domain

import javax.persistence.Embeddable

@Embeddable
class Preference {

    String key

    String value
}
