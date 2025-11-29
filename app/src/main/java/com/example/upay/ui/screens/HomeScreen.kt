package com.example.upay.ui.screens

import androidx.compose.foundation.Image
import com.example.upay.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.GroupAdd
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Train
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

// Colors
val UpayYello = Color(0xFFFFCC00)
val UpayDarkBlue = Color(0xFF0D47A1)
val UpayLightGray = Color(0xFFF5F5F5)

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

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = { UpayBottomNavigationBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            //Top section
            TopSection()

            //Main services
            MainServicesSection(services = mainServices)

            //Banner Section
            BannerSection()

            //Other services
            Text(
                text = "অন্যান্য সার্ভিস",
                fontSize = 20.sp,
                color = UpayDarkBlue,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp, top = 24.dp, bottom = 8.dp)
            )
            OtherServicesSection(services = otherServices)

            PrepaidCardBanner()

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun TopSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(UpayYello)
            .padding(16.dp),
        horizontalAlignment = 
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun MainServicesSection(services: List<ServiceItem>) {

}

@Composable
fun BannerSection() {

}

@Composable
fun OtherServicesSection(services: List<ServiceItem>) {

}

@Composable
fun PrepaidCardBanner() {

}

@Composable
fun UpayBottomNavigationBar() {

}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}