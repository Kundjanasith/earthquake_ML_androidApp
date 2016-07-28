package com.example.exceed.earthquake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by exceed on 7/28/16 AD.
 */
public class CSVReader {
    InputStream inputStream;
    public CSVReader( InputStream is ){
        this.inputStream = is;
    }

    public List<String[]> read(){
        List<String[]> resultList = new ArrayList<String[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try{
            String csvLine;
            while(  (csvLine=reader.readLine()) != null ){
                String[] row = csvLine.split(",");
                resultList.add(row);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file" + ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e){
                throw new RuntimeException("Error while closing input array"+e);
            }
        }
        return resultList;
    }

}