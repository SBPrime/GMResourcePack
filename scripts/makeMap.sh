for instrument in {0..127..1}
do
    for octave in {1..10..2}
    do
	echo "$instrument	org.primesoft.gm.b0.p$instrument.o$octave	100%	0-$octave"
    done
done
