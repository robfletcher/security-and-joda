package co.freeside

import org.joda.time.*

class User {

	transient springSecurityService

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	LocalDate dateOfBirth

	static constraints = {
		username blank: false, unique: true
		password blank: false
		dateOfBirth nullable: true
	}

	static mapping = {
		table name: '`user`'
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
