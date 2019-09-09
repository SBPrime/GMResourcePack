echo "#ProgramID | Sound patch | Base volume"
echo "D	block.note_block.basedrum			100%"
echo "#Default mapping"
for instrument in {1..127..1}
do
    echo "$instrument	org.primesoft.gm.ds.i$instrument	100%"
done
