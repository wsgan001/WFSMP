package edu.spbstu.wfsmp.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;
import edu.spbstu.wfsmp.ApplicationContext;
import edu.spbstu.wfsmp.ApplicationProperties;
import edu.spbstu.wfsmp.activity.handlers.ForwardListener;
import edu.spbstu.wfsmp.sensor.DeviceController;
import edu.spbstu.wfsmp.sensor.MeasurementResult;
import edu.spbstu.wfsmp.sensor.SensorException;

import java.util.ArrayList;
import java.util.List;

/**
 * User: artegz
 * Date: 14.10.12
 * Time: 15:05
 */
public class ViewResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_results);

        final TextView textView = (TextView) findViewById(R.id.statusRow);
        textView.setText("Loading results...");

        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                final DeviceController deviceController = (DeviceController) ApplicationContext.getInstance().get(ApplicationProperties.DEVICE_CONTROLLER);
                assert deviceController != null;

                try {
                    final List<MeasurementResult> allMeasurements = deviceController.getAllMeasurements();

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            final TableLayout table = (TableLayout) findViewById(R.id.resultsTable);
                            final View headerRow = findViewById(R.id.resultsHeaderRow);

                            table.removeAllViewsInLayout();

                            table.addView(headerRow);

                            for (MeasurementResult measurementResult : allMeasurements) {
                                final TableRow newDataRow = new TableRow(table.getContext());

                                newDataRow.addView(createCell(measurementResult.getMeasNo(), newDataRow.getContext()));

                                newDataRow.addView(createCell(measurementResult.getDistance(), newDataRow.getContext()));
                                newDataRow.addView(createCell(measurementResult.getDepth(), newDataRow.getContext()));
                                newDataRow.addView(createCell(measurementResult.getEstimatedSteed(), newDataRow.getContext()));
                                newDataRow.addView(createCell(measurementResult.getMeasuredFrequency(), newDataRow.getContext()));
                                newDataRow.addView(createCell(measurementResult.getTurns(), newDataRow.getContext()));
                                newDataRow.addView(createCell(measurementResult.getTime(), newDataRow.getContext()));
                                newDataRow.addView(createCell(measurementResult.getType(), newDataRow.getContext()));
                                newDataRow.addView(createCell(measurementResult.getTimestamp(), newDataRow.getContext()));

                                table.addView(newDataRow);
                            }
                        }
                    });
                } catch (SensorException e) {
                    final String message = e.getMessage();

                    ApplicationContext.handleException(getClass(), e);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            final TextView textView = (TextView) findViewById(R.id.statusRow);
                            textView.setText(message);
                        }
                    });
                }
            }
        }).start();


        /*final ListView view = (ListView) findViewById(R.id.resultsTable);

        // set adapter which provide device list
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                results);

        view.setAdapter(arrayAdapter);*/
    }

    private TextView createCell(Object value, Context context) {
        final TextView cell = new TextView(context);
        cell.setPadding(5, 5, 5, 5);
        cell.setText(String.valueOf(value));
        return cell;
    }

    @Override
    public void onBackPressed() {
        new ForwardListener(MenuActivity.class, this).onClick(null);
    }
}
