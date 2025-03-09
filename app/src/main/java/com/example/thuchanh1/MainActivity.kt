package com.example.thuchanh1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thuchanh1.ui.theme.ThucHanh1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThucHanh1Theme {
                AgeCheckerScreen()
            }
        }
    }
}

@Composable
fun AgeCheckerScreen(){
    var name by remember {
        mutableStateOf("")
    }
    var ageI by remember {
        mutableStateOf("")
    }
    var kq by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    )
    {
        Text(text = "THUC HANH O1", fontSize = 24.sp, color = Color.Black, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = { Text("Ho va Ten")},
            placeholder = { Text("name")},
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = ageI,
            onValueChange = {ageI = it},
            label = { Text("Tuoi")},
            placeholder = { Text("age")},
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
           var age = 0
            age = ageI.toInt()
            kq = when{
                age>65 -> "$name la Nguoi gia"
                age in 6..65->"$name la Nguoi lon"
                age in 2..6->"$name la Tre em"
                age>=0->"$name la Em be"
                else -> {"Tuoi khong hop le!"}
            }

        }, modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kiem tra")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = kq, fontSize = 18.sp, color = Color.Red)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ThucHanh1Theme {
    AgeCheckerScreen()
    }
}