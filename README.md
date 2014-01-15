# PGN-parser

A Portable Game Notation (PGN) ANTLR 4 grammar and parser.

The grammar can be found in 
[`src/main/antlr4/nl/bigo/pp`](https://github.com/bkiers/PGN-parser/tree/master/src/main/antlr4/nl/bigo/pp).

Seeing the generated parser in action can be done by building
a *fat* JAR of the project and then running it to parse a PGN
file. A couple PGN files reside in 
[`src/resources`](https://github.com/bkiers/PGN-parser/tree/master/src/resources).

# Get started

### 0. clone this repository

```bash
git clone https://github.com/bkiers/PGN-parser
cd PGN-parser
```

### 1. generate the lexer and parser classes

```bash
mvn clean antlr4:antlr4
```

### 2. build the *fat* JAR

```bash
mvn install package
```

### 3. parse a PGN file

```bash
java -jar target/pp-0.1.0.jar src/resources/Karpov.pgn
```
