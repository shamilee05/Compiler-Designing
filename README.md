# Compiler Designing
Java programs implementing different concepts of compiler designing like lexical analysis, parsing, etc.

### 1) Lexical Analysis: ###
- In this phase of compilation, the source code is broken down into a series of lexemes and corresponding to each valid lexeme, a token is generated, removing any whitespace or comments in the source code.
- The validity of a lexeme is decided by certain grammar rules.
- Tokens are generated for each of the keywords, functions, headers, operators and special symbols.
- The lexical analyser also recognizes symbols (or identifiers) and literals (or constants) and generates tokens for them as well. 
- If the lexical analyzer finds a token invalid, it generates an error. For example, in this program, an error will be generated for each invalid symbol declaration.
- An instance of how the program works is as shown below:

