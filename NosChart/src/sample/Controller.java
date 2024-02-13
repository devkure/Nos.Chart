package sample;


import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public LineChart lineChart;
    public CategoryAxis x;
    public NumberAxis y;
    public Button updateButton;
    public Button evaluateButton;
    public Label evalLabel;
    public ComboBox comboBox;
    public Label maxLabel;
    public Label minLabel;

    LoadJson loadJson = new LoadJson();

    File[] filetab = {new File("src\\JSONfiles\\feathers.json"), new File("src\\JSONfiles\\fullmoons.json"), new File("src\\JSONfiles\\iceicebaby.json")};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setComboBox();


    }


    void readData(List<Object> list1, List<Object> list2) {

        lineChart.setAnimated(false);
        XYChart.Series series = new XYChart.Series();

        int index = 0;

        for (Object price : list1) {

            series.getData().add(new XYChart.Data(String.valueOf(list2.get(index)), price));

            index++;

        }

        lineChart.getData().addAll(series);
    }

    public void setItem1(ActionEvent a) {


        String itemType = (String) comboBox.getValue();


        if (itemType == "Feathers") {
            lineChart.getData().clear();
            loadJson.readJson(filetab[0]);
            readData(loadJson.getPrices(), loadJson.getDate());
            System.out.println("Feathers");

        }
        if (itemType == "Fullmoons") {
            lineChart.getData().clear();
            loadJson.readJson(filetab[1]);
            readData(loadJson.getPrices(), loadJson.getDate());
            System.out.println("Fullmoons");

        }
        if (itemType == "Ice") {
            lineChart.getData().clear();
            loadJson.readJson(filetab[2]);
            readData(loadJson.getPrices(), loadJson.getDate());
            System.out.println("Ice");

        }


    }


    void setComboBox() {
        comboBox.getItems().addAll("Feathers", "Fullmoons", "Ice");
    }


    public void setUpdateButton(ActionEvent a) {
        System.out.println("uPdate pierszy");
    }

    public void setEvaluate(ActionEvent a) {

        evalLabel.setText("Average price: " + countAverage(loadJson.getPrices()) + "k");
        maxLabel.setText(getHighest(loadJson.getPrices(), loadJson.getDate()));
        minLabel.setText(getLowest(loadJson.getPrices(), loadJson.getDate()));

    }

    int countAverage(List<Object> list) {
        int avg = 0;
        for (Object price : list) {
            avg += Integer.parseInt(String.valueOf(price));
        }
        return avg / list.size();
    }

    String getHighest(List<Object> list1, List<Object> list2) {
        int highest = Integer.parseInt((String.valueOf(Collections.max(list1, null))));
        int indexOf = list1.indexOf(Collections.max(list1, null));
        String date = String.valueOf(list2.get(indexOf));
        String highestDate = "Max: " + Integer.toString(highest) + "k" + " " + date;

        return highestDate;
    }

    String getLowest(List<Object> list1, List<Object> list2) {
        int lowest = Integer.parseInt((String.valueOf(Collections.min(list1, null))));
        int indexOf = list1.indexOf(Collections.min(list1, null));
        String date = String.valueOf(list2.get(indexOf));
        String lowestDate = "Min: " + Integer.toString(lowest) + "k" + " " + date;

        return lowestDate;
    }


}
