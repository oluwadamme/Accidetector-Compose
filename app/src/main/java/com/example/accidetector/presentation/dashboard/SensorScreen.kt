package com.example.accidetector.presentation.dashboard

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SensorScreen() {
    var sensorManager: SensorManager
    var mLight: Sensor? = null
    var deviceSensors: List<Sensor> = emptyList()
    val context = LocalContext.current
    sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL)
    val sensorStatus = remember {
        mutableStateOf("")
    }
    val proximitySensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

    val proximitySensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
            // method to check accuracy changed in sensor.
        }

        // on below line we are creating a sensor on sensor changed
        override fun onSensorChanged(event: SensorEvent) {
            // check if the sensor type is proximity sensor.
            if (event.sensor.type == Sensor.TYPE_PROXIMITY) {
                // on below line we are checking if the
                // object is near or away from the sensor.
                sensorStatus.value=event.values[0].toString()

            }
        }
    }
    sensorManager.registerListener(
        // on below line we are passing
        // proximity sensor event listener
        proximitySensorEventListener,

        // on below line we are
        // setting proximity sensor.
        proximitySensor,

        // on below line we are specifying
        // sensor manager as delay normal
        SensorManager.SENSOR_DELAY_NORMAL
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()
            // on below line we are
            // adding padding for our column
            .padding(5.dp),
        // on below line we are specifying horizontal
        // and vertical alignment for our column
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {


        Text(text = "This is sensor screen")
        Text(
            text = sensorStatus.value,
            // on below line we are setting color for our text
            color = Color.Black,

            // on below line we are setting font weight as bold
            fontWeight = FontWeight.Bold,

            // on below line we are setting font family


            // on below line we are setting font family and padding
            fontSize = 30.sp, modifier = Modifier.padding(5.dp)
        )
        LazyColumn() {
            items(deviceSensors) { sensor ->

                Text(
                    text = sensor.name.toString() + ": " + sensor.power.toString(),
                    color = Color.Black,
                    fontSize = 20.sp, modifier = Modifier.padding(5.dp),
                            // on below line we are specifying font weight
                    fontWeight = FontWeight.Bold,
                )

            }
        }
    }

}