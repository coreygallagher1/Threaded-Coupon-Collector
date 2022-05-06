#! /bin/bash
for i in 1 2 4 8 16 32 64 128
do
	java SynchronizedCollector $i > sync-$i.txt
	java IndependentCollector $i > ind-$i.txt
done
