echo {
for instrument in {1..127..1}
do
    echo "  \"org.primesoft.gm.ds.i$instrument\": {"
    echo "    \"category\": \"record\","
    echo "    \"sounds\": ["
    echo "      {"
    echo "        \"name\": \"org/primesoft/gm/ds/d$instrument\""
    echo "      }"
    echo "    ]"
    echo "  },"
done
echo }
