echo {
for instrument in {0..127..1}
do
    mkdir -p ./bank0/$instrument/
    echo Instrument $instrument
    for octave in {1..10..2}
    do
	echo Octave $octave
	java -jar ./NoteGen.jar $instrument $octave ./tmp.mid
	timidity -OvM -s 44100 -id -o ./bank0/$instrument/g$octave.ogg ./tmp.mid
    done
done
echo }