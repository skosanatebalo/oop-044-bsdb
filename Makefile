.PHONY: compile test package clean

compile:
	mvn compile

test:
	mvn test

# The test suite has already run in its own stage by this point,
# so packaging does not run it again.
package:
	mvn package -DskipTests

clean:
	mvn clean
