package com.moulik.businessassistant.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sadman
 */
@Component
@Getter
@Setter
public class DataUtil {
    private List<String> colorList = Arrays.asList("#CB4335", "#884EA0","#2E86C1","#17A589","#28B463","#D4AC0D","#CA6F1E","#A6ACAF","#273746","#273746");

    public List<String> getColorListByNumber(int n){
        return colorList.stream().limit(n).collect(Collectors.toList());
    }
}
