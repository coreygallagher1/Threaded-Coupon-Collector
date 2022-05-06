#! /bin/bash
for i in 1 2 4 8 16 32 64 128
do
	java ./src/SynchronizedCollector.java $i > sync-$i.txt
	java ./src/IndependentCollector.java $i > ind-$i.txt
done
