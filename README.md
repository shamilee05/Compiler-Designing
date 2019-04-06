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

<br>

### 2) RDP or Recursive Descent Parser (a form of Top-Down Parser): ###
- Parsing forms a part of Syntax Analysis that comes after Lexical Analysis. 
- A Syntax Analyzer or Parser takes the input from a lexical analyzer in the form of token streams. The parser analyzes the source code (token stream) against a set of production rules to detect any errors in the code. The output of this phase is a **parse tree**.
- Recursive Descent Parser or RDP is a **top-down parsing technique** that **constructs the parse tree from the top** and the input is read from **left to right**.
- Here we have different procedures for each of the non-terminals and the input string is read character-by-character and correspondingly a procedure is chosen for the non-terminal encountered.
- The technique is **recursive** in the sense that if a certain procedure (with respect to a production rule) selected does not allow the string to be accepted, the control goes back to the parent procedure wherein a different production rule is chosen and the process continues until there are no more production rules left and the string will then be rejected completely as invalid.
- The program was written with respect to the following **left recursion-free grammar**:

        S->aAc|aAb
        A->bAb|ab|a
        
- Instances of how the program works are as shown below:
<p align="center">
  <img src="https://github.com/shamilee05/Compiler-Designing/blob/master/Recursive%20Descent%20Parser/RDP.png">
</p>

