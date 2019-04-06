# Compiler Designing
Java programs implementing different concepts of compiler designing like lexical analysis, parsing, etc.

### 1) Lexical Analysis: ###
- In this phase of compilation, the source code is broken down into a series of **lexemes** and corresponding to each valid lexeme, a **token** is generated, removing any whitespace or comments in the source code.
- The validity of a lexeme is decided by certain grammar rules.
- Tokens are generated for each of the **keywords, functions, headers, operators and special symbols.**
- The lexical analyser also recognizes **symbols (or identifiers) and literals (or constants**) and generates tokens for them as well. 
- If the lexical analyzer finds a token invalid, it generates an **error**. For example, in this program, an error will be generated for each **invalid symbol declaration**.
- An instance of how the program works is as shown below:

Tokens are generated for each of the valid lexemes present in the C program in the file 'test.txt' and further all the different tables are shown as well:

<p align="center">
  <img src="https://github.com/shamilee05/Compiler-Designing/blob/master/Lexical%20Analyzer/test.png">
</p>

<p align="center">
  <img src="https://github.com/shamilee05/Compiler-Designing/blob/master/Lexical%20Analyzer/Lexical_1.png">
</p>

Here an error gets generated as an incorrect symbol declaration is made as '2i' as seen in 'test.txt':
<p align="center">
  <img src="https://github.com/shamilee05/Compiler-Designing/blob/master/Lexical%20Analyzer/Lexical_2.png">
</p>
