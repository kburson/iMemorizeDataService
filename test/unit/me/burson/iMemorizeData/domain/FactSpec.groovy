package me.burson.iMemorizeData.domain

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import me.burson.iMemorizeData.domain.Fact
import spock.lang.Specification
import com.rallydev.rest.RallyRestJsonApiHelpers
import com.rallydev.rest.HttpMethod



/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(Fact)
class FactSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}


    def "Fact can be instantiated"() {
        given:
        Fact m = new Fact();

        expect:
        m != null
    }

    def "Fact accepts a string"() {
        given:
        def question = "Hello dude!"
        Fact fact = new Fact(question:question);

        expect:
        fact.question.equals(question);
    }

    def "Fact cannot save if content is null"() {
        given:
        Fact fact = new Fact()

        expect:
        !fact.validate()
    }

    def "Fact cannot save if content is empty"() {
        given:
        Fact fact = new Fact(question:"   ")

        expect:
        !fact.validate()
    }

    def "Fact JSON path is 'fact'"() {
        expect:
        RallyRestJsonApiHelpers.path(Fact) == "fact"
    }

    def "Fact supports only GET HTTP method operation"() {
        expect: 'Facts are read only'
        RallyRestJsonApiHelpers.allowed(Fact) == [HttpMethod.GET]
    }

}