package com.david.example;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CostofTrip {

    private   String filepath = "d:/interchanges.json";
    private static final double price = 0.25;
    private final Map<String, String> name2pointMap = new HashMap<>();
    private Map<String, LocationElement> routesMap;

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    public CostofTrip() throws IOException {

        convertDataToHashMap();
    }
    public CostofTrip(String filepath) throws IOException {
        if(filepath!=null) {
            this.filepath = filepath;
        }
        convertDataToHashMap();
    }

    private  LocationObj loadLocationObjFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(this.filepath), LocationObj.class);
    }

    private void convertDataToHashMap() throws IOException {
        routesMap = loadLocationObjFromFile().getLocations();
        for (Map.Entry<String, LocationElement> entry : routesMap.entrySet()) {
            name2pointMap.put(entry.getValue().getName(), entry.getKey());
        }
    }

    public double caculateDistance(String startPointName, String endPointName) {

        double result = 0;
        String startToldId = name2pointMap.get(startPointName);
        int startPoint = Integer.parseInt(startToldId);
        String endToldId = name2pointMap.get(endPointName);
        int endPoint = Integer.parseInt(endToldId);

        if (endPoint < startPoint) {
            int temp = startPoint;
            startPoint = endPoint;
            endPoint = temp;
            String tempName = startPointName;
            startPointName = endPointName;
            endPointName = tempName;
        }

        boolean startCaculateFlag = false;
        BigDecimal totalDis = new BigDecimal(0.0);
        double totalDistance = 0.0;

        for (Map.Entry<String, LocationElement> entry : routesMap.entrySet()) {

            int currentToldId = Integer.parseInt(entry.getKey());
            LocationElement locationElement = entry.getValue();
            if (startCaculateFlag && entry.getValue().getName().equals(endPointName)) {
                break;
            }

            if (!startCaculateFlag && locationElement.getName().equals(startPointName)) {
                startCaculateFlag = true;
            }
            if (startCaculateFlag) {
                List<Route> routes = locationElement.getRoutes();
                for (Route route : routes) {
                    if (route.getToId() > currentToldId) {
                        totalDis = totalDis.add(new BigDecimal(route.getDistance()));
                    }
                }
            }

        }
        result = totalDis.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();

        return result;

    }

    public double caculateCost(String startPointName, String endPointName) {

        double totalDis = caculateDistance(startPointName, endPointName);
        BigDecimal totalAmount = new BigDecimal(totalDis).multiply(new BigDecimal(price));
        double result = totalAmount.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }


}
