package org.example.practice;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Testing {

    public static void main(String[] args) {
//        System.out.println("skjdhns" + findDayEndRemainingMinute());

        findDuplicate();

    }

//    private static int findDayEndRemainingMinute() {
//        LocalDateTime now = LocalDateTime.now();
//        LocalTime endOfDay = LocalTime.of(23, 59);
//        LocalTime currentTime = now.toLocalTime();
//        Duration duration = Duration.between(currentTime, endOfDay);
//        return (int) duration.toMinutes();
//    }




    public static void findDuplicate() {
        List<String> list = new ArrayList<>();
        list.add("delhi");
        list.add("mumbai");
        list.add("delhi");
        list.add("kolkata");
        list.add("madurai");
        list.add("delhi");
        list.add("chennai");
        list.add("mumbai");


//        Map<String, Integer> ans = list.stream().collect(Collectors.groupingBy(), Collectors.counting());


        Map<String, Integer> ansMap = new HashMap<>();

        for (String str : list) {

            if (ansMap.containsKey(str)) {

                ansMap.put(str, ansMap.get(str) + 1);

            } else {
                ansMap.put(str, 1);
            }
        }
        System.out.println("ans Map" + ansMap);

//        List<String> distictList = list.stream().distinct().toList();




//        Employee {
//
//            name
//            employee ID
//            department
//                    address
//
//
//            List<Employee> listArr =
//
//                    List<Employee> ans = listArr.stream().filter(data -> data::getEmployeeId > 100).collect(Collecters.toList());
//
//
//
//            Map<String, List<Employee>> ans = listArr.stream().collect(Collectors.groupingBy(getDepartment));
//
//
//
//
//            String str = "racecar"
//
//
//            int left = 0;
//            int right = str.length() -1;
//
//            while (left <= right) {
//
//                if (str.chatAt(left) != str.charAt(right)) return false;
//                left++;
//                right--;
//            }
//            return true;
//        System.out.println("ans " + distictList);
    }


}
