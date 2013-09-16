import me.burson.imemorizedataservice.domain.Fact

class BootStrap {

    def init = { servletContext ->

       new Fact(question:"Am I alive?",
                answer:"Cogito Ergo Sum.").save(failOnError:true)
        // "Number 5 is alive!"
    }
    def destroy = {
    }
}
