echo "#ProgramID | Sound patch | Base volume | Octaves"
echo "D	block.note_block.harp			100%	0-1	2-3	4-5	6-7	8-9	10"
echo "#Default mapping"
for instrument in {0..127..1}
do
    for octave in {1..10..2}
    do
	echo "$instrument	org.primesoft.gm.b0.p$instrument.o$octave	100%	0-$octave"
    done
done
