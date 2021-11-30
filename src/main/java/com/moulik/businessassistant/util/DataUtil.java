package com.moulik.businessassistant.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sadman
 */
@Component
@Getter
@Setter
public class DataUtil {
    private List<String> colorList = Arrays.asList("#f56954", "#00a65a", "#f39c12", "#00c0ef", "#3c8dbc", "#d2d6de", "#00a65a");

    public List<String> getColorListByNumber(int n){
        return colorList.stream().limit(n).collect(Collectors.toList());
    }

    public static Map<String, Double> convertMapToMap(List<Map<String, Long>> mapList) {
        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < mapList.size(); i++) {
            Collection<Long> mapValue = mapList.get(i).values();
            String medicine = null;
            Double number = null;
            Iterator itr = mapValue.iterator();
            while (itr.hasNext()) {
                medicine = itr.next().toString();
                number = (Double) itr.next();
            }
            map.put(medicine, number);
        }
        return map;
    }
}
