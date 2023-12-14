package com.example.dataanalysergrpcmicroservice.service;

import com.example.dataanalysergrpcmicroservice.model.Data;

public interface DataService {

    void handle(Data data);

}
