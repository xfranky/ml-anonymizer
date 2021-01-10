# ml-anonimizer

A multi-level anonymiser for hierarchical data.
Very much in early stages, but functionally working.

Compile main package:

`javac -d bin/ src/it/xfnet/mlanon/*.java`


Compile tests:

`javac -d bin/test/ -cp bin/ test/it/xfnet/mlanon/*.java`


Run test loading the included test records:

`java -cp bin/:bin/test/ it.xfnet.mlanon.MLResultLoaderTest testfiles/test.csv <min_results>`

If omitted, `<min_results>` defaults to 2.
