#
# make build && make run_enc
#

# Class name
CLASSNAME= AwesomeLockerTest


# Build java test file
build:
	javac $(CLASSNAME).java

# Encrypt a file
run_enc:
	java $(CLASSNAME) e XOR testinput my_password

# Decrypt a file
# After encrypting, the encrypted file will have an extension of .enc
run_dec:
	java $(CLASSNAME) d XOR testinput.enc my_password

# Clean all class files
clean:
	rm *.class
