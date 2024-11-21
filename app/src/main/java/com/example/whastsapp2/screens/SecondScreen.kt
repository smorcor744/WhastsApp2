package com.example.whastsapp2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whatsapp.ui.theme.WhatsAppBackgroundGray
import com.example.whatsapp.ui.theme.WhatsAppDarkGray
import com.example.whatsapp.ui.theme.WhatsAppGreen
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.whastsapp2.utils.Utils.addMessage
import com.example.whastsapp2.utils.Utils.findChat


@Composable
fun SecondScreen(navController: NavController, texto: String?, modifier: Modifier) {
    SecondBody(navController, texto ?: "666666666", modifier)
}


@Composable
fun SecondBody(navController: NavController, name: String, modifier: Modifier) {
    val message = remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Header2(name, navController)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(WhatsAppBackgroundGray),
            verticalArrangement = Arrangement.Top
        ) {
            items(findChat(name)) { message ->
                ChatBubble(message,name = name)
            }
        }

        Footer2(name,message)

    }
}


@Composable
fun Header2(name: String, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(WhatsAppDarkGray)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back Icon",
            modifier = Modifier
                .size(25.dp)
                .clickable(onClick = { navController.popBackStack() }),
            tint = WhatsAppGreen
        )

        Text(
            text = name,
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
fun ChatBubble(message: String,name: String) {
    val (sender, text) = message.split(": ", limit = 2)
    val isSender = sender == name

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = if (isSender) Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSender) WhatsAppGreen else Color.White)
                .padding(8.dp)
        ) {
            Text(
                text = text,
                color = if (isSender) Color.White else Color.Black,
                fontSize = 14.sp
            )

        }
    }
}


@Composable
fun Footer2(name : String, message: MutableState<String>) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(WhatsAppDarkGray)
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = message.value,
            onValueChange = { message.value = it },
            placeholder = { Text("Escribe un mensaje") },
            modifier = Modifier
                .weight(1f)
                .border(1.dp, Color.LightGray, RoundedCornerShape(50)),
            shape = RoundedCornerShape(50),
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            imageVector = Icons.Default.Send,
            contentDescription = "Send Icon",
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    addMessage(name,message.value)
                    message.value = ""
                },
            tint = WhatsAppGreen
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            imageVector = Icons.Default.Phone,
            contentDescription = "Send Icon",
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    addMessage(name,message.value)
                    message.value = ""
                },
            tint = WhatsAppGreen
        )
    }
}

