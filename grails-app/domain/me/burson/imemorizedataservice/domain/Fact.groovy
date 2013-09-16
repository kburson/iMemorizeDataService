package me.burson.imemorizedataservice.domain
import grails.rest.*

@Resource(uri='/fact', formats=['json', 'xml'])
class Fact {

    String id

    String question
    String answer

    Set<String> wrongAnswers

    Set<String> references

    Set<String> tags

    // deck, distribution, owner, public, private

    //static mapWith = "mongo"

    static constraints = {
        question blank: false, empty: false, nullable:false
    }

    static mapping = {
        id generator: 'uuid'
    }

    int compareTo(Fact fact) {
        this.question.compareTo(fact.question) ?: this.answer.compareTo(fact.answer)
    }
}
