# Groovy Mixin persistent properties with JPA

This is a test project to demonstrate that a combination of technologies (hopefully) can work together

## Problem

I want to use Groovy Mixins in my Groovy domain model classes in order to share functionality and properties between domain models. I would like JPA to persist properties of a domain model which were mixed in.

## Test

I have a Mixin called "has preferences" which defines a JPA annotated collection of value objects of type Preference. I would like to Mixin the ability to have JPA persisted preferences in to several Groovy domain models like "Person". When I do this, JPA will not detect that the Person class has a collection called preferences.

## To Run

Run the unit test which defines the behavior I would like to have `mvn clean test`

The test works because Person has a collection of Preference. Remove this collection from the Person class and uncomment the Groovy Mixin annotated on the Person class declaration. Run test again and see that it fails