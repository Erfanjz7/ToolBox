package com.company.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DateConverterController {

    private Stage DateConverter;

    @FXML
    private Label DateLBL;

    @FXML
    private Button DateconverterCalculateBTN;

    @FXML
    private Button DateconverterbackBTN;

    @FXML
    private TextField DayTXTFIeld;

    @FXML
    private TextField MonthTXTField;

    @FXML
    private TextField YearTXTField;

    @FXML
    private Label DateconvertererrorLBL;

    //dar in class tarikh miladi ra be shamsi tabdil mikonim va yek string barmigradanim

    public static class SolarCalendar {

        public String strWeekDay = "";
        public String strMonth = "";

        int date;
        int month;
        int year;

        public SolarCalendar(){}

        public SolarCalendar(Date MiladiDate) {
            calcSolarCalendar(MiladiDate);
        }

        public String calcSolarCalendar(Date MiladiDate) {

            int ld;

            int miladiYear = MiladiDate.getYear() + 1900;
            int miladiMonth = MiladiDate.getMonth() + 1;
            int miladiDate = MiladiDate.getDate();
            int WeekDay = MiladiDate.getDay();

            int[] buf1 = new int[12];
            int[] buf2 = new int[12];

            buf1[0] = 0;
            buf1[1] = 31;
            buf1[2] = 59;
            buf1[3] = 90;
            buf1[4] = 120;
            buf1[5] = 151;
            buf1[6] = 181;
            buf1[7] = 212;
            buf1[8] = 243;
            buf1[9] = 273;
            buf1[10] = 304;
            buf1[11] = 334;

            buf2[0] = 0;
            buf2[1] = 31;
            buf2[2] = 60;
            buf2[3] = 91;
            buf2[4] = 121;
            buf2[5] = 152;
            buf2[6] = 182;
            buf2[7] = 213;
            buf2[8] = 244;
            buf2[9] = 274;
            buf2[10] = 305;
            buf2[11] = 335;

            if ((miladiYear % 4) != 0) {
                date = buf1[miladiMonth - 1] + miladiDate;

                if (date > 79) {
                    date = date - 79;
                    if (date <= 186) {
                        switch (date % 31) {
                            case 0:
                                month = date / 31;
                                date = 31;
                                break;
                            default:
                                month = (date / 31) + 1;
                                date = (date % 31);
                                break;
                        }
                        year = miladiYear - 621;
                    } else {
                        date = date - 186;

                        switch (date % 30) {
                            case 0:
                                month = (date / 30) + 6;
                                date = 30;
                                break;
                            default:
                                month = (date / 30) + 7;
                                date = (date % 30);
                                break;
                        }
                        year = miladiYear - 621;
                    }
                } else {
                    if ((miladiYear > 1996) && (miladiYear % 4) == 1) {
                        ld = 11;
                    } else {
                        ld = 10;
                    }
                    date = date + ld;

                    switch (date % 30) {
                        case 0:
                            month = (date / 30) + 9;
                            date = 30;
                            break;
                        default:
                            month = (date / 30) + 10;
                            date = (date % 30);
                            break;
                    }
                    year = miladiYear - 622;
                }
            } else {
                date = buf2[miladiMonth - 1] + miladiDate;

                if (miladiYear >= 1996) {
                    ld = 79;
                } else {
                    ld = 80;
                }
                if (date > ld) {
                    date = date - ld;

                    if (date <= 186) {
                        switch (date % 31) {
                            case 0:
                                month = (date / 31);
                                date = 31;
                                break;
                            default:
                                month = (date / 31) + 1;
                                date = (date % 31);
                                break;
                        }
                        year = miladiYear - 621;
                    } else {
                        date = date - 186;

                        switch (date % 30) {
                            case 0:
                                month = (date / 30) + 6;
                                date = 30;
                                break;
                            default:
                                month = (date / 30) + 7;
                                date = (date % 30);
                                break;
                        }
                        year = miladiYear - 621;
                    }
                } else {
                    date = date + 10;

                    switch (date % 30) {
                        case 0:
                            month = (date / 30) + 9;
                            date = 30;
                            break;
                        default:
                            month = (date / 30) + 10;
                            date = (date % 30);
                            break;
                    }
                    year = miladiYear - 622;
                }

            }

            switch (month) {
                case 1:
                    strMonth = "فروردين";
                    break;
                case 2:
                    strMonth = "ارديبهشت";
                    break;
                case 3:
                    strMonth = "خرداد";
                    break;
                case 4:
                    strMonth = "تير";
                    break;
                case 5:
                    strMonth = "مرداد";
                    break;
                case 6:
                    strMonth = "شهريور";
                    break;
                case 7:
                    strMonth = "مهر";
                    break;
                case 8:
                    strMonth = "آبان";
                    break;
                case 9:
                    strMonth = "آذر";
                    break;
                case 10:
                    strMonth = "دي";
                    break;
                case 11:
                    strMonth = "بهمن";
                    break;
                case 12:
                    strMonth = "اسفند";
                    break;
            }

            switch (WeekDay) {

                case 0:
                    strWeekDay = "يکشنبه";
                    break;
                case 1:
                    strWeekDay = "دوشنبه";
                    break;
                case 2:
                    strWeekDay = "سه شنبه";
                    break;
                case 3:
                    strWeekDay = "چهارشنبه";
                    break;
                case 4:
                    strWeekDay = "پنج شنبه";
                    break;
                case 5:
                    strWeekDay = "جمعه";
                    break;
                case 6:
                    strWeekDay = "شنبه";
                    break;
            }

            String DATE = year + " " + strMonth + " " +  date + " " + strWeekDay;
            return DATE;


        }

    }

    //passkari stage ha
    public void initFunction6(Stage DateConverter){
        this.DateConverter = DateConverter;
    }

    //dar in tabe ebteda ba regex format vorodi ra check mikonim sepas be ezai vorrodi dade shode tarikh shamsi ra be namayesh dar miavarim
    @FXML
    private void DateConverterCalculateHandler(ActionEvent event) throws ParseException {
        String str = MonthTXTField.getText();
        boolean check = Pattern.matches("[0-9]{1,2}" , str);
        String str2 = DayTXTFIeld.getText();
        boolean check2 = Pattern.matches("[0-9]{1,2}" , str2);
        String str3 = YearTXTField.getText();
        boolean check3 = Pattern.matches("[0-9]{4,4}" , str3);
        if(check && check2 && check3){
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse( MonthTXTField.getText() + "-" + DayTXTFIeld.getText() + "-" + YearTXTField.getText());
        SolarCalendar scw = new SolarCalendar();
        DateLBL.setText(scw.calcSolarCalendar(date));}
        else
        {
            DateconvertererrorLBL.setText("Wrong Input Format");
        }

    }

    //return to main menu
    @FXML
    private void DateConverterBackHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\MainPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MainPageController controller = loader.getController();
        controller.initFunction(DateConverter);

        DateConverter.setScene(new Scene(loader.getRoot()));
    }

}
