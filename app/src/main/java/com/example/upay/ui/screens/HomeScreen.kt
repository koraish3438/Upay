package com.example.upay.ui.screens

import androidx.compose.foundation.Image
import com.example.upay.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.GroupAdd
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Train
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

// Colors
val UpayYello = Color(0xFFFFCC00)
val UpayDarkBlue = Color(0xFF0D47A1)
val UpayLightGray = Color(0xFFF5F5F5)
val UpayYellow30Percent = Color(0xFFFFFDD0)

// Data class
data class ServiceItem(
    val name: String,
    val icon: ImageVector,
    val iconTint: Color = UpayLightGray,
)

// Service demo list
val mainServices = listOf(
    ServiceItem("সেন্ড মানি", Icons.AutoMirrored.Default.Send),
    ServiceItem("মোবাইল রিচার্জ", Icons.Default.PhoneAndroid),
    ServiceItem("ক্যাশ আউট", Icons.Default.MonetizationOn),
    ServiceItem("পেমেন্ট", Icons.Default.ShoppingCart),
    ServiceItem("ট্রাফিক ফাইন", Icons.Default.DirectionsCar),
    ServiceItem("ইউটিলিটি বিল", Icons.Default.Lightbulb),
    ServiceItem("পে বিল", Icons.Default.Receipt),
    ServiceItem("আরো", Icons.Default.MoreHoriz),
)

val otherServices = listOf(
    ServiceItem("পেওনিয়ার", Icons.Default.AccountBalanceWallet),
    ServiceItem("রেফার ও আর্ন", Icons.Default.GroupAdd),
    ServiceItem("ইন্সুরেন্স", Icons.Default.Security),
    ServiceItem("ডোনেশন", Icons.Default.VolunteerActivism),
    ServiceItem("বিমান টিকেট", Icons.Default.Flight),
    ServiceItem("রেল টিকেট", Icons.Default.Train),
    ServiceItem("ফিস", Icons.Default.AttachMoney),
    ServiceItem("অন্যান্য", Icons.Default.AddCircleOutline),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(

        topBar = {
            //Top section
            TopSection()
        },

        bottomBar = {
            UpayBottomNavigationBar()
        }

    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                //Main services
                MainServicesSection(services = mainServices)
            }

            item {
                //Banner Section
                BannerSection()
            }

            item {
                OtherServicesSection(services = otherServices)
            }

            item {
                PrepaidCardBanner()
                Spacer(modifier = Modifier.height(30.dp))
            }


        }
    }
}

@Composable
fun TopSection() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = false

    SideEffect {
        systemUiController.setStatusBarColor(
            color = UpayYello,
            darkIcons = useDarkIcons
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(UpayYello)
            .statusBarsPadding()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .weight(2f)
                .size(70.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            modifier = Modifier
                .weight(5.5f)
                .padding(8.dp)
        ){
            Text(
                text = "MD KAJAM-ALL KORAISH",
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "01934983451",
                fontSize = 12.sp,
                color = Color.DarkGray
            )
        }

        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = UpayDarkBlue
            ),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp),
            modifier = Modifier
                .weight(2.5f)
                .padding(2.dp)
        ) {
            Text(
                text = "ব্যালেন্স",
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Composable
fun MainServicesSection(services: List<ServiceItem>) {
    //Here is main services

}

@Composable
fun BannerSection() {
    //Here is banner section
}

@Composable
fun OtherServicesSection(services: List<ServiceItem>) {

}

@Composable
fun PrepaidCardBanner() {

}


@Composable
fun UpayBottomNavigationBar() {
    val items = listOf(
        "হোম" to Icons.Default.Home,
        "হিস্টরি" to Icons.Default.History,
        "অ্যাকাউন্ট" to Icons.Default.AccountBalanceWallet,
        "ইনবক্স" to Icons.Default.Inbox,
        "আরো" to Icons.Default.MoreHoriz
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(UpayYellow30Percent)
            .padding(vertical = 8.dp)
            .navigationBarsPadding(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { (label, icon) ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .clickable { /* Handle click here */ }
                    .padding(vertical = 4.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = UpayDarkBlue,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = label,
                    fontSize = 12.sp,
                    color = UpayDarkBlue
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}