for i in 0 `seq 190`
do
	for j in 2016 
	do
		for k in `seq 12`
		do
			echo R.raw.x$i'_'$j'_'$k,
		done
	done
done
