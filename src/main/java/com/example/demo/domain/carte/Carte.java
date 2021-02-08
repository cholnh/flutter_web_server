package com.example.demo.domain.carte;

import com.example.demo.domain.carte.item.CarteItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carte implements Serializable {
    private Long idx;
    private LocalDateTime registerDate;
    private LocalDateTime modifyDate;
    private LocalDate date;
    private String mainImage;
    private String basicImage;
    private String standardImage;
    private String premiumImage;
    private List<CarteItem> carteItems;

    public String convertDateToString() {
        String stringDayOfWeek = "";
        DayOfWeek dayOfWeek = this.date.getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY: stringDayOfWeek = "월"; break;
            case TUESDAY: stringDayOfWeek = "화"; break;
            case WEDNESDAY: stringDayOfWeek = "수"; break;
            case THURSDAY: stringDayOfWeek = "목"; break;
            case FRIDAY: stringDayOfWeek = "금"; break;
            case SATURDAY: stringDayOfWeek = "토"; break;
            case SUNDAY: stringDayOfWeek = "일"; break;
        }
        return new SimpleDateFormat("MM월 dd일(" + stringDayOfWeek + ")").format(Date.valueOf(this.date));
    }

    public String convertItemToString() {
        String stringItems = "";
        for(CarteItem carteItem : carteItems) {
            stringItems += carteItem.getName() + System.lineSeparator();
        }
        return stringItems;
    }

    public String getImagePath() {
        return "https://poman.kr:9530/api/v1.2/" + this.mainImage;
    }
}
