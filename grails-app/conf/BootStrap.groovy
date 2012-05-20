import co.freeside.*
import org.joda.time.*

class BootStrap {

    def init = { servletContext ->
    	if (User.count() == 0) {
    		new User(username: 'blackbeard', password: 'yarr!!!!', enabled: true, accountExpired: false, accountLocked: false, passwordExpired: false, dateOfBirth: new LocalDate(1680, 10, 2)).save(failOnError: true)
    	}
    }

    def destroy = {
    }
}
