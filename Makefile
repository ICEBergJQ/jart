all: compile run

compile:
	@echo "Compiling..."
	javac *.java -d build

# Run the program
run:
	@echo "Running..."
	java -cp build Main

.PHONY: compile run
