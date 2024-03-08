package com.example.presentationcard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentationcard.ui.theme.PresentationCardTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PresentationCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.background)
                ) {
                    PresentationCard()
                }
            }
        }
    }
}

@Composable
fun PresentationCard(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        MainInformation(
            name = stringResource(id = R.string.name),
            charge = stringResource(id = R.string.title)
        )
        ContactInformation(
            phone = "+52 (272) 155 65 77",
            github = "iGusky",
            email = "gustavohernandez.dev@gmail.com"
        )
    }
}

@Composable
fun MainInformation(name: String, charge: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)

    Column(
        modifier = modifier
            .fillMaxHeight(.5F)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .width(120.dp)
                .background(color = colorResource(id = R.color.stroke))
                .padding(10.dp)
        )
        Text(
            text = name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier,
            color = colorResource(id = R.color.headline)
        )
        Text(
            text = charge,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.button)
        )
    }
}

@Composable
fun ContactInformation(phone: String, github: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight(1F)
            .padding(bottom = 45.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            ContactInfoRow(
                text = phone,
                icon = Icons.Rounded.Phone,
                iconDescription = stringResource(R.string.phone)
            )
            ContactInfoRow(
                text = github,
                icon = Icons.Rounded.Home,
                iconDescription = stringResource(R.string.github)
            )
            ContactInfoRow(
                text = email,
                icon = Icons.Rounded.Email,
                iconDescription = stringResource(R.string.email)
            )
        }
    }
}

@Composable
fun ContactInfoRow(text: String, icon: ImageVector, iconDescription: String) {
    Row(
        modifier = Modifier
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            contentDescription = iconDescription,
            modifier = Modifier.padding(end = 16.dp),
            tint = colorResource(id = R.color.tertiary)

        )
        Text(text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.secondary)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PresentationCardTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.background)
        ) {
            PresentationCard()
        }
    }
}