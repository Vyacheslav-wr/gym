package by.salei.gym.dao.filter;

import lombok.Data;

@Data
public class CoachSearch {
    private Long id;
    private String name;
    private Double efficiency;
    private String order;

    public static boolean isDesc(String check){
        return check.equals("DESC");
    }
}
