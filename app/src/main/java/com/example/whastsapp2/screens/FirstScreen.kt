package com.example.whastsapp2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whastsapp2.navigation.AppScreen
import com.example.whastsapp2.utils.Utils.chats
import com.example.whastsapp2.utils.Utils.hora
import com.example.whatsapp.ui.theme.WhatsAppBackgroundGray
import com.example.whatsapp.ui.theme.WhatsAppDarkGray
import com.example.whatsapp.ui.theme.WhatsAppGreen
import kotlin.random.Random

@Composable
fun FirstScreen(navController: NavController, modifier: Modifier) {
    FirstBody(navController, modifier)
}

@Composable
fun FirstBody(navController: NavController, modifier: Modifier) {
    val appName = "WhatsApp"
    val names = listOf("Manuel", "Fernando", "Sofia", "Manuela", "Javier Mecanico", "Manuel", "Fernando", "Sofia", "Manuela", "Javier Mecanico")

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Header(appName)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(WhatsAppBackgroundGray),
            verticalArrangement = Arrangement.Top
        ) {
            items(chats) { name ->
                Contacto(name = name.first, navController)
            }
        }
        Footer()
    }
}

@Composable
fun Header(appName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(WhatsAppDarkGray)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = appName,
            color = WhatsAppGreen,
            fontSize = 25.sp,
            modifier = Modifier.weight(1f)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Call Icon",
                modifier = Modifier.size(25.dp),
                tint = WhatsAppGreen
            )
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                modifier = Modifier.size(25.dp),
                tint = WhatsAppGreen
            )
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "MoreVert Icon",
                modifier = Modifier.size(25.dp),
                tint = WhatsAppGreen
            )
        }
    }
}

@Composable
fun Footer() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(WhatsAppDarkGray)
                .padding(start = 30.dp, end = 30.dp, top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Call Icon",
                modifier = Modifier.size(25.dp),
                tint = WhatsAppGreen
            )
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Search Icon",
                modifier = Modifier.size(25.dp),
                tint = WhatsAppGreen
            )
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "MoreVert Icon",
                modifier = Modifier.size(25.dp),
                tint = WhatsAppGreen
            )
        }

}

@Composable
fun Contacto(name: String, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(top = 2.dp)
            .clickable(onClick = { navController.navigate(route = AppScreen.SecondScreen.route + "/$name") }),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Contact icon",
            modifier = Modifier.size(40.dp),
            tint = WhatsAppDarkGray
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = name,
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                text = "Chat Privado",
                color = Color.Black,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = hora(),
            color = Color.Black,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.width(16.dp))
    }
}

