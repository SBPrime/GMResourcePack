mkdir -p ./ds/
echo Drums
for note in {1..127..1}
do
    echo Note $note
    java -jar ./NoteGen-0.2.0.jar D $note 127 ./tmp.mid
    timidity --noise-shaping=1 -OvM -s 44100 -id -o ./ds/d$note.ogg ./tmp.mid
done


for instrument in {0..127..1}
do
    mkdir -p ./bank0/$instrument/
    echo Instrument $instrument
    for octave in {1..10..2}
    do
	echo Octave $octave
	java -jar ./NoteGen-0.2.0.jar $instrument $octave 127 ./tmp.mid
	timidity --noise-shaping=1 -OvM -s 44100 -id -o ./bank0/$instrument/g$octave.ogg ./tmp.mid
    done
done
