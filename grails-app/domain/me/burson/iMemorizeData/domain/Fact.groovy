package me.burson.iMemorizeData.domain

import com.rallydev.rest.AccessWithRallyRestJsonApi
import com.rallydev.rest.HttpMethod

@AccessWithRallyRestJsonApi(allowed = HttpMethod.GET)
class Fact {

    static mapWith = "mongo"

    String id
    String question
    List<String> possibleAnswers
    int correctAnswer


    static constraints = {
        question blank:false, nullable:false;
    }

    static mapping = {
        id generator: 'uuid'
    }

}
