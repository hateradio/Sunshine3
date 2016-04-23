package com.example.theory.sunshine3;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    String jsonStr = ""; //{\"city\":{\"id\":2643743,\"name\":\"London\",\"coord\":{\"lon\":-0.12574,\"lat\":51.50853},\"country\":\"GB\",\"population\":0},\"cod\":\"200\",\"message\":0.0107,\"cnt\":7,\"list\":[{\"dt\":1461322800,\"temp\":{\"day\":6.15,\"min\":4.73,\"max\":6.15,\"night\":4.73,\"eve\":6.15,\"morn\":6.15},\"pressure\":1028.01,\"humidity\":65,\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"speed\":5.22,\"deg\":41,\"clouds\":88},{\"dt\":1461409200,\"temp\":{\"day\":8.19,\"min\":2.61,\"max\":8.19,\"night\":2.61,\"eve\":7.47,\"morn\":4.94},\"pressure\":1027.38,\"humidity\":73,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":6.11,\"deg\":357,\"clouds\":64,\"rain\":0.85},{\"dt\":1461495600,\"temp\":{\"day\":9.05,\"min\":2.21,\"max\":9.05,\"night\":3.95,\"eve\":7.97,\"morn\":2.21},\"pressure\":1028.25,\"humidity\":70,\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"speed\":6.36,\"deg\":335,\"clouds\":20},{\"dt\":1461582000,\"temp\":{\"day\":10.85,\"min\":2.61,\"max\":11.58,\"night\":3.87,\"eve\":8.4,\"morn\":2.61},\"pressure\":1018.73,\"humidity\":70,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":7.52,\"deg\":289,\"clouds\":64,\"rain\":1.69},{\"dt\":1461668400,\"temp\":{\"day\":6.71,\"min\":2.12,\"max\":6.71,\"night\":3.16,\"eve\":6.65,\"morn\":2.12},\"pressure\":1017.8,\"humidity\":81,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":9.62,\"deg\":354,\"clouds\":0,\"rain\":2.51},{\"dt\":1461754800,\"temp\":{\"day\":10.1,\"min\":5.68,\"max\":10.12,\"night\":7.08,\"eve\":10.12,\"morn\":5.68},\"pressure\":1019.86,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":8.12,\"deg\":303,\"clouds\":23,\"rain\":1.15},{\"dt\":1461841200,\"temp\":{\"day\":11.21,\"min\":5.74,\"max\":11.21,\"night\":6.55,\"eve\":9.96,\"morn\":5.74},\"pressure\":1025.78,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":6.27,\"deg\":310,\"clouds\":28,\"rain\":1.73}]}";

    public void runTests() {
        double testValue = 0;

        try {
            testValue = getMaxTemperatureForDay(jsonStr, 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println("one");

        Log.v("TEST_1", Double.toString(testValue));

        assertEquals(testValue, 6.15, 0.01);
    }

    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex) throws JSONException {

        JSONObject w = new JSONObject(weatherJsonStr);
        JSONArray list = w.getJSONArray("list");
        JSONObject dayWeather = list.getJSONObject(dayIndex);
        JSONObject temp = dayWeather.getJSONObject("temp");
        double max = temp.getDouble("max");

        return max;
    }
}