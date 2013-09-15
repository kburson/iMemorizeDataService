package me.burson.imemorizedataservice.domain

@Resource(uri='/fact')
class Fact {

    String id

    String question
    Set<String> possibleAnswers
    String correctAnswer

    Set<String> references

    Set<String> tags

    // deck, distribution, owner, public, private

    static constraints = {
        question blank: false, empty: false, nullable:false
    }
}
