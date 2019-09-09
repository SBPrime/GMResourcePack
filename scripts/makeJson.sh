echo {
for instrument in {0..127..1}
do
    for octave in {1..10..2}
    do
	echo "  \"org.primesoft.gm.b0.p$instrument.o$octave\": {"
	echo "    \"category\": \"record\","
	echo "    \"sounds\": ["
	echo "      {"
	echo "        \"name\": \"org/primesoft/gm/bank0/$instrument/g$octave\""
	echo "      }"
	echo "    ]"
	echo "  },"
    done
done
echo }
