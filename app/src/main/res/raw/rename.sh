echo "Start Rename"


for i in 0 `seq 190`
do 
	echo $i
	for j in 2016 2017 2018 2019 2020 2021 2022 2023 2024 2025 2026
	do
		echo $j	
		for k in 1 2 3 4 5 6 7 8 9 10 11 12
		do
			echo $k
			export Test1=$i'_'$j'_'$k'.csv'
			export Test2=x$i'_'$j'_'$k'.csv'
			mv $Test1 $Test2
		done
	done
done

echo "Finish"
