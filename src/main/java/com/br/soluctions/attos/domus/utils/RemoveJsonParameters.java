package com.br.soluctions.attos.domus.utils;

import org.springframework.stereotype.Service;

@Service
public class RemoveJsonParameters {
    public String removeParameters(String data, String dataName) {
        data = data.replaceAll("[{}]", "");

        data = data.replaceAll("\"", "");

        data = data.replaceAll(":", "");

        data = data.replaceAll("Bearer", "");

        data = data.replaceAll(dataName, "");

        return data;
    }
}
