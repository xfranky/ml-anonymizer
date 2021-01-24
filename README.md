# ml-anonymizer

A multi-level anonymizer for hierarchical data.
Very much in early stages, but functionally working.

Compile main package:

`compile-lib` ...which is really a shortcut for
`javac -d bin/ src/it/xfnet/mlanon/*.java`


Compile tests:

`compile-test` which is a shorcut for
`javac -d bin/test/ -cp bin/ test/it/xfnet/mlanon/*.java`


Run test loading the included test records:

`java -cp bin/:bin/test/ it.xfnet.mlanon.MLResultLoaderTest testfiles/test.csv <min_results>`

If omitted, `<min_results>` defaults to 2.

To regenerate the docs for the library:

`update-docs`, or
`javadoc -d docs/ src/it/xfnet/mlanon/*.java`
