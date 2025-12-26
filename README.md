# Transformer Algorithm

## Installation

To use the Transformer algorithm, follow these steps:

1. Clone the repository:
```
git clone https://github.com/your-username/transformer-algorithm.git
```
2. Navigate to the project directory:
```
cd transformer-algorithm
```
3. Compile the Java files:
```
javac Transformer/*.java
```

## Usage

To run the Transformer algorithm, execute the following command:

```
java Transformer.Main
```

This will start the application and prompt you to enter a word to complete.

## API

The main classes and their functions are:

1. `App.java`:
   - `start()`: Starts the application and handles user input.
   - `checkInput(String word)`: Checks if the input word is valid (not empty and contains only letters).

2. `Tokenizer.java`:
   - `parseWord(String input)`: Converts a word into an array of tokens.
   - `parseToken(int[] tokens)`: Converts an array of tokens back into a word.

3. `Input.java`:
   - `Input(String input)`: Wraps the input word and provides access to its different representations (string, char array, token array).

4. `Manager.java`:
   - `getTokenizer()`: Returns the Tokenizer instance.
   - `getDataset()`: Returns the Dataset instance.

## Contributing

Contributions to the Transformer algorithm project are welcome. To contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your changes to your forked repository.
5. Submit a pull request to the original repository.

## License

This project is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

## Testing

To run the tests for the Transformer algorithm, execute the following command:

```
javac Transformer/Test/*.java
java Transformer.Test.TestRunner
```

This will run the test suite and display the results.
