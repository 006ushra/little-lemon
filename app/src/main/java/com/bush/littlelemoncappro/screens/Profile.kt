package com.bush.littlelemoncappro.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bush.littlelemoncappro.componants.AppHeader
import com.bush.littlelemoncappro.navigation.Home
import com.bush.littlelemoncappro.ui.theme.LittleLemonColors.charcoal
import com.bush.littlelemoncappro.ui.theme.LittleLemonColors.yellow

@Composable
fun ProfileScreen(navHostController: NavHostController) {
    val sharedPreferences =
        LocalContext.current.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE)
    Column {
        AppHeader()
        Column(
            Modifier
                .weight(1f)
                .padding(horizontal = 20.dp)
        ) {

            Text(
                text = "Personal Information",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 50.dp, bottom = 30.dp)
            )
            Column(verticalArrangement = Arrangement.SpaceAround) {
                Text(text = "First Name:")
                OutlinedTextField(
                    value = sharedPreferences.getString("firstName", "first name").toString(),
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "Last Name:", modifier = Modifier.padding(top = 20.dp))
                OutlinedTextField(
                    value = sharedPreferences.getString("lastName", "last name").toString(),
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "Email:", modifier = Modifier.padding(top = 20.dp))
                OutlinedTextField(
                    value = sharedPreferences.getString("emailAddress", "email address").toString(),
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Button(
            onClick = {
                sharedPreferences.edit()
                    .remove("firstName")
                    .remove("lastName")
                    .remove("emailAddress")
                    .putBoolean("isLoggedIn", false)
                    .apply()
                navHostController.navigate(Home.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = yellow,
                contentColor = charcoal
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 20.dp)
        ) {
            Text(text = "Log Out")
        }
    }
}