package com.example.translatorapp

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.text.Editable
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.translatorapp.ui.theme.TranslatorAppTheme
import com.mobiledevpro.ui.component.AppTopBar
import java.util.*

class MainActivity : ComponentActivity() {

    var outPutText by mutableStateOf("Click button for Speech text")
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TranslatorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   Column(modifier = Modifier.fillMaxWidth()) {
                       AppTopBar(title = "My Translator App")

                       Spacer(modifier = Modifier.padding(vertical = 8.dp))

                       GetTextFromSpeech(outPutText = outPutText, activityResultLauncher = activityResultLauncher)

                   }
                }
            }
        }


        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result: ActivityResult->

            if ( result.resultCode == Activity.RESULT_OK && result.data!=null) {

                val speechText = result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)

                outPutText = speechText?.get(0).toString()
            }

        }

    }


}





@Composable
fun GetTextFromSpeech(outPutText:String, activityResultLauncher: ActivityResultLauncher<Intent> ) {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {


        Text(text = "Speech to Text ",
        style = MaterialTheme.typography.h6,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp, pressedElevation = 0.dp, disabledElevation = 0.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            onClick = {getSpeechInput(context= context, activityResultLauncher)}) {
            
            Icon(painter = painterResource(id = R.drawable.baseline_mic_24),
                contentDescription = "Microphone",
                tint = MaterialTheme.colors.secondaryVariant,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .padding(5.dp)
            )

        }
        Spacer(modifier = Modifier.height(15.dp))


        Text(
            text = outPutText,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )



    }

}

fun getSpeechInput(context: Context, activityResultLauncher: ActivityResultLauncher<Intent>) {

    if (!SpeechRecognizer.isRecognitionAvailable(context)) {
        Toast.makeText(context, "Speech not Available", Toast.LENGTH_SHORT).show()
    } else {
        // on below line we are calling a speech recognizer intent
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

        // on the below line we are specifying language model as language web search
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH)

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak Something")

        try {
            activityResultLauncher.launch(intent)
        }catch (exp:ActivityNotFoundException){
            Toast.makeText(context, "Device Not Supported", Toast.LENGTH_SHORT).show()
        }

    }


}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TranslatorAppTheme {
        Greeting("Android")
    }
}