/*
package com.example.translatorapp

import com.example.translatorapp.ui.theme.TranslatorAppTheme

package com.example.newcanaryproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import java.util.*

class MainActivity : ComponentActivity() {

    // on below line we are creating a variable
    // for our output of speech to text
    var outputTxt by mutableStateOf("Click button for Speech text ")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TranslatorAppTheme {
                // on below line we are specifying
                // background color for our application
                Surface(color = MaterialTheme.colors.background) {
                    // on below line we are
                    // specifying theme as scaffold
                    Scaffold(
                        // on below line we are
                        // specifying top bar as our action bar.
                        topBar = {
                            TopAppBar(
                                // on below line we are specifying title
                                // for our action bar as Speech to Text
                                title = {
                                    Text(
                                        text = "Speech to Text",

                                        // on below line we are specifying
                                        // width of our text
                                        modifier = Modifier.fillMaxWidth(),

                                        // on below line we are specifying
                                        // the text alignment for our text
                                        textAlign = TextAlign.Center
                                    )
                                })
                        }) {
                        // on below line we are calling
                        // speech to text method.
                        SpeechToText()
                    }
                }
            }
        }
    }

    // on below line we are creating
    // a speech to text function.
    @Composable
    fun SpeechToText() {
        // on below line we are creating
        // variable for the context
        val context = LocalContext.current
        // on below line we are creating ui
        // for our home screen in column
        Column(
            // on below line we are specifying
            // modifier as max size for our column
            modifier = Modifier.fillMaxSize(),

            // on below line we are specifying
            // horizontal and vertical arrangement
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // on the below line we are creating a simple
            // text for displaying the heading.
            Text(
                text = "Speech to Text Example",

                // for this text we are specifying
                // style on below line
                style = MaterialTheme.typography.h6,

                // on below line we are specifying the
                // modifier and padding for our text
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),

                // on below line we are
                // specifying the text alignment.
                textAlign = TextAlign.Center
            )
            // on below line we are specifying
            // the spacer between two views.
            Spacer(modifier = Modifier.height(30.dp))

            // on below line we are creating button for our mic
            Button(
                // on below line we are specifying
                // the elevation for our button.
                elevation = ButtonDefaults.elevation(
                    // we are specifying elevation for different state of buttons.
                    defaultElevation = 0.dp, pressedElevation = 0.dp, disabledElevation = 0.dp
                ),

                // on below line we are specifying the color for our button
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),

                // on below line we are specifying on click listener for our button
                onClick = { getSpeechInput(context = context) },
            ) {
                // on below line we are specifying
                // the icon for our button,
                Icon(
                    // in this we are specifying
                    // the icon as mic icon.
                    imageVector = Icons.Filled.Mic,

                    // on below line we are specifying
                    // content description as mic.
                    contentDescription = "Mic",

                    // on below line we are specifying
                    // tint color for our icon
                    tint = greenColor,

                    // on below line we are specifying padding,
                    // height and width for our icon
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .padding(5.dp)
                )
            }
            // again we are adding a spacer between two views.
            Spacer(modifier = Modifier.height(30.dp))
            // on below line we are creating a text
            // for displaying the speech to text output.
            Text(
                // on below line we are setting
                // output text in our text view
                text = outputTxt,

                // on below line we are specifying
                // the style for our text.
                style = MaterialTheme.typography.h6,

                // on below line we are adding
                // padding for our text
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                // on below line we are specifying
                // alignment for our text
                textAlign = TextAlign.Center
            )
        }
    }

    // on below line we are creating a method
    // to get the speech input from user.
    private fun getSpeechInput(context: Context) {
        // on below line we are checking if speech
        // recognizer intent is present or not.
        if (!SpeechRecognizer.isRecognitionAvailable(context)) {
            // if the intent is not present we are simply displaying a toast message.
            Toast.makeText(context, "Speech not Available", Toast.LENGTH_SHORT).show()
        } else {
            // on below line we are calling a speech recognizer intent
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

            // on the below line we are specifying language model as language web search
            intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH
            )

            // on below line we are specifying extra language as default english language
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

            // on below line we are specifying prompt as Speak something
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak Something")

            // at last we are calling start activity
            // for result to start our activity.
            startActivityForResult(intent, 101)
        }
    }

    // on below line we are calling our on activity result method to get the output.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // on below line we are checking if the request
        // code is same and result code is ok
        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
            // if the condition is satisfied we are getting
            // the data from our string array list in our result.
            val result = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            // on below line we are setting result
            // in our output text method.
            outputTxt = result?.get(0).toString()
        }
    }
}
*/
